package com.myservlet.command;

import com.myservlet.CommandsEnum;
import com.myservlet.PagesPathEnum;
import com.myservlet.RequestParamsEnum;
import com.myservlet.exceptions.CommandException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

import static com.myservlet.RequestParamsEnum.*;

public class RemoveProductFromCartCommand implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String productID = request.getParameter(PRODUCT_ID.getValue());
        HttpSession session = request.getSession();
        if (Optional.ofNullable(productID).isPresent()) {

            CartPageCommandImpl.removeProduct(productID);
            session.setAttribute("count", CartPageCommandImpl.getProducts().size());
            session.setAttribute("total_price", CartPageCommandImpl.getTotalPrice());
        }
        return PagesPathEnum.CART_PAGE.getPath();
    }
}
