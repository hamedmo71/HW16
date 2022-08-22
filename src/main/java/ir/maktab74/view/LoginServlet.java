package ir.maktab74.view;

import ir.maktab74.model.User;
import ir.maktab74.util.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (name = "login-servlet" , urlPatterns = "/login-servlet")
public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<html lang=\"fa\"><head>" +
                "<link rel=\"styleSheet\" href=\"style.css\" type=\"text/css\"> " +
                "<meta charset=\"UTF-8\"></head>" +
                "<title>Ticket Booking System</title>"+
        "<body id=\"login-body\">\n" +
                "<div id=\"login-div\">\n" +
                "\n" +
                "    <form action=\"./login-servlet\" id=\"login-form\" method=\"post\">\n" +
                "        <h1 id=\"login-form-title\">Login</h1>\n" +
                "        <input type=\"text\" name=\"username\" placeholder=\"Username\" class=\"box\"><br>\n" +
                "        <input type=\"password\" name=\"password\" placeholder=\"Password\" class=\"box\"><br><br>\n" +
                "        <input type=\"submit\" value=\"Enter\" class=\"botton\"><br><br>\n" +
                "        <a href=\"http://localhost:8082/HW16_war_exploded/signup-servlet\" id=\"register\">Sign Up</a>\n" +
                "    </form>\n" +
                "\n" +
                "</div>\n" +
                "\n" +
                "</body>" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = ApplicationContext.getUserService().loginWithUsernameAndPassword(username, password);

        System.out.println(user);
        if (user != null) {
            HttpSession session=req.getSession();
            session.setAttribute("username",username);
            session.setAttribute("password",password);
            resp.sendRedirect("http://localhost:8082/HW16_war_exploded/search-ticket.system");
        }else {
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.println("<p align=\"center\" style=\"color: red\">Wrong username or password!!!</p>");
            doGet(req,resp);
        }
    }
}
