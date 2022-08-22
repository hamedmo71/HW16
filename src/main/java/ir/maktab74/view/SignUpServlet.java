package ir.maktab74.view;

import ir.maktab74.enums.Gender;
import ir.maktab74.model.User;
import ir.maktab74.util.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (name = "signup-servlet" , urlPatterns = "/signup-servlet")
public class SignUpServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        out.println("<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Login</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<fieldset style=\"alignment:center ;border: 1px black solid bord; border-radius: 20px; width: 300px\">\n" +
                "\n" +
                "\n" +
                "    <legend style=\"margin-left: 1em; padding: 0.2em 0.8em \">Personal Data</legend>\n" +
                "\n" +
                "    <form align=\"center\" method=\"post\">\n" +
                "\n" +
                "        <label for=\"lname\">Last Name<sup>*</sup></label><br>\n" +
                "        <input type=\"text\" id=\"lname\" name=\"lname\" required style=\"width:100%\"><br>\n" +
                "\n" +
                "\n" +
                "        <label for=\"fname\">First Name<sup>*</sup></label><br>\n" +
                "        <input type=\"text\" id=\"fname\" name=\"fname\" required style=\"width:100%\"><br>\n" +
                "\n" +
                "        <label width=\"50%\" for=\"username\">Username<sup>*</sup></label><br>\n" +
                "        <input type=\"text\" id=\"username\" name=\"username\" required style=\"width:100%\"><br>\n" +
                "\n" +
                "\n" +
                "        <label for=\"passwd\">Password<sup>*</sup></label><br>\n" +
                "        <input type=\"password\" id=\"passwd\" name=\"passwd\" required style=\"width:100%\"><br>\n" +
                "\n" +
                "\n" +
                "        <label for=\"mnum\">Mobile Number<sup>*</sup></label><br>\n" +
                "        <select name=\"gender\">\n" +
                "            <option>Male</option>\n" +
                "            <option>Female</option>\n" +
                "        </select>\n" +
                "        <input type=\"text\" id=\"mnum\" name=\"mobilenum\" required style=\"width:100%;\"><br><br>\n" +
                "\n" +
                "        <input type=\"submit\" value=\"Register\" align=\"center\">\n" +
                "\n" +
                "    </form>\n" +
                "</fieldset>\n" +
                "\n" +
                "</body>");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String lastName = req.getParameter("lname");
        String firstName = req.getParameter("fname");
        String username = req.getParameter("username");
        String password = req.getParameter("passwd");
        String mobileNum = req.getParameter("mobilenum");
        String gender = req.getParameter("gender");
        Gender userGender=Gender.valueOf(gender) ;
        User user=new User(firstName,lastName,username,password,userGender,mobileNum);
        ApplicationContext.getUserService().save(user);
        resp.sendRedirect("http://localhost:8082/HW16_war_exploded/login-servlet");

    }
}
