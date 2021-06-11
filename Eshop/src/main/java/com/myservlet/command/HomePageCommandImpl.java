package com.myservlet.command;

import com.myservlet.PagesPathEnum;
import com.myservlet.exceptions.CommandException;
import com.myservlet.model.Category;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.myservlet.RequestParamsEnum.CATEGORY;

public class HomePageCommandImpl implements BaseCommand {
    List<Category> categories = new ArrayList<>();

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        if (categories.size() == 0) {
            Category mobilePhones = new Category("Mobile phones", "phone1.jpg");
            Category laptops = new Category("Laptops", "laptops.jpg");
            Category fridge = new Category("Fridges", "fridge1.jpg");
            Category cameras = new Category("Cameras", "cameras1.jpg");
            Category gpsNavigators = new Category("GPS Navigators", "navigators.jpg");
            Category cars = new Category("Cars", "cars1.jpg");
            categories.addAll(Arrays.asList(mobilePhones, laptops, fridge, cameras, gpsNavigators, cars));
        }
        request.setAttribute(CATEGORY.getValue(), categories);
        return PagesPathEnum.HOME_PAGE.getPath();
    }
}
