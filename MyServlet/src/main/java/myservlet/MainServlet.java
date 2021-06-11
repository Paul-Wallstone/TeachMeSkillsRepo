package myservlet;



import myservlet.object.Calculator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calc")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/calc.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String par = req.getParameter("action");
        String operator1 = req.getParameter("oper1");
        String operator2 = req.getParameter("oper2");
        Calculator calculator = new Calculator(Double.parseDouble(operator1), Double.parseDouble(operator2));
        double result = switch (par) {
            case "sum" -> calculator.sum();
            case "div" -> calculator.division();
            case "sub" -> calculator.subtraction();
            case "mult" -> calculator.multiply();
            default -> throw new IllegalArgumentException();
        };
        resp.setContentType("text/html");
        req.setAttribute("result", result);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/calc.jsp");
        dispatcher.forward(req, resp);
    }
}
