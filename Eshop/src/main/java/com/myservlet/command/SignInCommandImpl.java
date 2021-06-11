package com.myservlet.command;

import com.myservlet.PagesPathEnum;
import com.myservlet.RequestParamsEnum;
import com.myservlet.exceptions.CommandException;
import com.myservlet.exceptions.RequestParamNullException;
import com.myservlet.model.Category;
import com.myservlet.model.Product;
import com.myservlet.model.User;
import com.myservlet.utils.HttpRequestParamValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.myservlet.RequestParamsEnum.*;
import static com.myservlet.utils.HttpRequestParamValidator.validateParamNotNull;

public class SignInCommandImpl implements BaseCommand {
    private static final String ADMIN_LOGIN = "admin";
    private static final String ADMIN_PASSWORD = "admin";

    @Override
    public String execute(HttpServletRequest request) throws CommandException {

        User user = getUser();
        return checkReceivedUser(user, request);
    }

    private User getUser() {
        return new User(ADMIN_LOGIN, ADMIN_PASSWORD);
    }

    private String checkReceivedUser(User user, HttpServletRequest request) throws RequestParamNullException {

        String login = request.getParameter(LOGIN.getValue());
        String password = request.getParameter(PASSWORD.getValue());
        validateParamNotNull(login);
        validateParamNotNull(password);

        if (user != null && login.equals(ADMIN_LOGIN) && password.equals(ADMIN_PASSWORD)) {
            HttpSession session = request.getSession();
            Integer count = (Integer) session.getAttribute("count");
            if (!Optional.ofNullable(count).isPresent()) {
                count = 0;
                session.setAttribute("count", count);
                session.setAttribute("total_price", "0.00");
            }
            List<Category> categories = new ArrayList<>();
            Category mobilePhones = new Category("Mobile phones", "mobile.jpg");
            Category laptops = new Category("Laptops", "laptops.jpg");
            Category fridge = new Category("Fridges", "fridge1.jpg");
            Category cameras = new Category("Cameras", "cameras1.jpg");
            Category gpsNavigators = new Category("GPS Navigators", "navigators.jpg");
            Category cars = new Category("Cars", "cars1.jpg");
            categories.addAll(Arrays.asList(mobilePhones, laptops, fridge, cameras, gpsNavigators, cars));
            request.setAttribute(CATEGORY.getValue(), categories);

            return PagesPathEnum.HOME_PAGE.getPath();
        } else {
            return PagesPathEnum.SIGN_IN_PAGE.getPath();
        }
    }
}
