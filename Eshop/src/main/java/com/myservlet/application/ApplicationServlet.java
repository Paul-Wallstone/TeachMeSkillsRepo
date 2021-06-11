package com.myservlet.application;

import com.myservlet.PagesPathEnum;
import com.myservlet.command.BaseCommand;
import com.myservlet.command.CommandFactory;
import com.myservlet.exceptions.CommandException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/eshop")
public class ApplicationServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {

        try {
            BaseCommand requestCommand = CommandFactory.defineCommand(request);
            String path;
            path = requestCommand.execute(request);
            RequestDispatcher dispatcher = request.getRequestDispatcher(path);
            dispatcher.forward(request, response);
        } catch (CommandException | ServletException | IOException e) {

            try {
                request.getRequestDispatcher(PagesPathEnum.SIGN_IN_PAGE.getPath()).forward(request, response);
            } catch (ServletException | IOException servletException) {
                servletException.printStackTrace();
            }
        }
    }
}
