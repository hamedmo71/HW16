package ir.maktab74.view;

import ir.maktab74.model.Travel;
import ir.maktab74.util.ApplicationContext;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "show-ticket", urlPatterns = "/show-ticket.system")
public class ShowTicketServlet extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String from = req.getParameter("origin");
        String to = req.getParameter("destination");
        String date = req.getParameter("date");
        Date travelDate = new SimpleDateFormat("yyyy-mm-dd").parse(date);
        List<Travel> allTravelsOfSpecifiedDate = ApplicationContext.getTravelService().findAllTravelsOfSpecifiedDate(from, to, travelDate);

        String travels="";

        for (Travel travel: allTravelsOfSpecifiedDate) {
            travels=travels.concat("<form action=\"http://localhost:8082/HW16_war_exploded/ticket-info.system\"><tr>" +
                    "<td style=\"border: 1px solid black\" name=\"id\">"+travel.getTravelId()+"</td>" +
                    "<td style=\"border: 1px solid black\" name=\"date\">"+travel.getTravelDate().getHours()+":"+travel.getTravelDate().getMinutes()+"</td>" +
                    "<td style=\"border: 1px solid black\"><input type=\"submit\" value=\"Buy\"></td>"+
                    "</tr></form>");
        }
        resp.setContentType("text/html");
        PrintWriter out= resp.getWriter();
        out.println("<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Ticket Booking System</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<table align=\"center\" style=\"border-collapse: collapse\">\n" +
                "    <thead>\n" +
                "    <tr>\n" +
                "        <th style=\"border: 1px solid black\" colspan=\"2\">"+from+"-"+to+"</th>\n" +
                "        <th style=\"border: 1px solid black\">Date: "+date+"</th>\n" +
                "    </tr>\n" +
                "    </thead>\n" +
                "<tbody>" +
                travels +
                "</tbody>" +
                "</table>\n" +
                "</body>\n" +
                "</html>");
        out.close();

    }
}
