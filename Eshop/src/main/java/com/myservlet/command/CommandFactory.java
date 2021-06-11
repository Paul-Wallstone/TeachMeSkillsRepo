package com.myservlet.command;

import com.myservlet.CommandsEnum;
import com.myservlet.RequestParamsEnum;
import com.myservlet.exceptions.CommandException;
import com.myservlet.model.Product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.myservlet.CommandsEnum.*;

public class CommandFactory {
    private static final Map<String, BaseCommand> COMMAND_LIST = new HashMap<>();

    static {
        COMMAND_LIST.put(HOME_PAGE_COMMAND.getCommand(), new HomePageCommandImpl());
        COMMAND_LIST.put(SIGN_IN_COMMAND.getCommand(), new SignInCommandImpl());
        COMMAND_LIST.put(PRODUCT_PAGE_COMMAND.getCommand(), new ProductPageCommandImpl());
        COMMAND_LIST.put(CART_PAGE_COMMAND.getCommand(), new CartPageCommandImpl());
        COMMAND_LIST.put(ADD_PRODUCT_TO_CART.getCommand(), new AddProductToCartCommand());
        COMMAND_LIST.put(REMOVE_PRODUCT_FROM_CART.getCommand(), new RemoveProductFromCartCommand());
    }

    public static BaseCommand defineCommand(HttpServletRequest request) throws CommandException {

        String commandKey = request.getParameter(RequestParamsEnum.COMMAND.getValue());

        if (commandKey == null || commandKey.isEmpty()) {
            commandKey = SIGN_IN_COMMAND.getCommand();
        }

//        return COMMAND_LIST.get(commandKey);
        if (commandKey.equals(REMOVE_PRODUCT_FROM_CART.getCommand())) {
            BaseCommand requestCommand = COMMAND_LIST.get(commandKey);
            requestCommand.execute(request);
            return COMMAND_LIST.get(CART_PAGE_COMMAND.getCommand());
        } else if (commandKey.equals(ADD_PRODUCT_TO_CART.getCommand())) {
            BaseCommand requestCommand = COMMAND_LIST.get(commandKey);
            requestCommand.execute(request);
            return COMMAND_LIST.get(PRODUCT_PAGE_COMMAND.getCommand());
        } else {
            return COMMAND_LIST.get(commandKey);
        }
    }

//    public static String AddCommandToCart(HttpServletRequest request) {
//
//        String commandAddCart = request.getParameter(RequestParamsEnum.CART.getValue());
//        HttpSession session = request.getSession();
//        Integer count = (Integer) session.getAttribute("count");
//
//
//        if (!Optional.ofNullable(count).isPresent()) {
//            count = 0;
//            session.setAttribute("count", count);
//            session.setAttribute("total_price", "0.00");
//        }
//        if (Optional.ofNullable(commandAddCart).isPresent()) {
//            ProductPageCommandImpl productPageCommand = (ProductPageCommandImpl) COMMAND_LIST.get(CommandsEnum.PRODUCT_PAGE_COMMAND.getCommand());
//            CartPageCommandImpl cartPageCommand = (CartPageCommandImpl) COMMAND_LIST.get(CommandsEnum.CART_PAGE_COMMAND.getCommand());
//            for (Product p : productPageCommand.getProducts()) {
//                if (String.valueOf(p.getId()).equals(commandAddCart)) {
//                    cartPageCommand.getProducts().add(p);
//                    CartPageCommandImpl.setLastType(p.getType());
//                }
//            }
//            session.setAttribute("count", cartPageCommand.getProducts().size());
//            session.setAttribute("total_price", cartPageCommand.getTotalPrice());
//            return "add";
//        }
//        return "not add";
//    }

//    public static String RemoveCommandFromCart(HttpServletRequest request) {
//        String commandRemoveCart = request.getParameter(RequestParamsEnum.CARTS_REMOVE.getValue());
//        HttpSession session = request.getSession();
//        if (Optional.ofNullable(commandRemoveCart).isPresent()) {
//            CartPageCommandImpl cartPageCommand = (CartPageCommandImpl) COMMAND_LIST.get(CommandsEnum.CART_PAGE_COMMAND.getCommand());
//            cartPageCommand.removeProduct(commandRemoveCart);
//            session.setAttribute("count", cartPageCommand.getProducts().size());
//            session.setAttribute("total_price", cartPageCommand.getTotalPrice());
//            return "remove";
//        }
//        return "not remove";
//    }
}


