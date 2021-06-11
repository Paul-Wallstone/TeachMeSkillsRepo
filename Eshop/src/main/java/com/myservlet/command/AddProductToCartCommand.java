package com.myservlet.command;

import com.myservlet.CommandsEnum;
import com.myservlet.PagesPathEnum;
import com.myservlet.RequestParamsEnum;
import com.myservlet.exceptions.CommandException;
import com.myservlet.model.Product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

import static com.myservlet.PagesPathEnum.*;
import static com.myservlet.RequestParamsEnum.*;

public class AddProductToCartCommand implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String IdProduct = request.getParameter(PRODUCT_ID.getValue());
        HttpSession session = request.getSession();
        Integer count = (Integer) session.getAttribute("count");

        if (!Optional.ofNullable(count).isPresent()) {
            count = 0;
            session.setAttribute("count", count);
            session.setAttribute("total_price", "0.00");
        }
        if (Optional.ofNullable(IdProduct).isPresent()) {
            for (Product p : ProductPageCommandImpl.getProducts()) {
                if (String.valueOf(p.getId()).equals(IdProduct)) {
                    CartPageCommandImpl.getProducts().add(p);
                    CartPageCommandImpl.setLastType(p.getType());
                }
            }
            session.setAttribute("count", CartPageCommandImpl.getProducts().size());
            session.setAttribute("total_price", CartPageCommandImpl.getTotalPrice());
        }
        return PRODUCT_PAGE.getPath();
    }
}
