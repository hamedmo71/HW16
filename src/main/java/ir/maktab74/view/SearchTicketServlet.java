package ir.maktab74.view;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "search-ticket" , urlPatterns = "/search-ticket.system")
public class SearchTicketServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        out.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Search Ticket</title>\n" +
                "    <link rel=\"stylesheet\" href=\"style.css\">\n" +
                "</head>\n" +
                "<body id=\"search-ticket\">\n" +
                "\n" +
                "<div class=\"menu\">\n" +
                "    <table>\n" +
                "        <tr>\n" +
                "            <td class=\"top-border-of-search-page\"><a class=\"options\" href=\"\">Show My Tickets</a></td>\n" +
                "        </tr>\n" +
                "    </table>\n" +
                "</div>\n" +
                "<div class=\"menu1\">\n" +
                "    <table>\n" +
                "        <tr>\n" +
                "            <td class=\"top-border-of-search-page\"><a class=\"options\" href=\"\">Log out</a></td>\n" +
                "        </tr>\n" +
                "    </table>\n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "<div style=\"display:block; align-items: center;\">\n" +
                "\n" +
                "    <form action=\"./show-ticket.system\" style=\"background-color: gray; width: 100%; align-content: center\" >\n" +
                "\n" +
                "        <table>\n" +
                "            <tr>\n" +
                "                <td><label for=\"from\">From<sup>*</sup></label></td>\n" +
                "                <td><label for=\"to\">To<sup>*</sup></label></td>\n" +
                "                <td><label for=\"date\">Date<sup>*</sup></label></td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td><input type=\"text\" id=\"from\" name=\"origin\" placeholder=\"Enter the origin\" required style=\"width:95%\"></label></td>\n" +
                "                <td><input type=\"text\" id=\"to\" name=\"destination\" placeholder=\"Enter the destination\" required style=\"width:95%\"></td>\n" +
                "                <td><input type=\"date\" id=\"date\" name=\"date\" required style=\"width:95%;\"></td>\n" +
                "                <td><input type=\"submit\" value=\"Search\" class=\"search-button\"></td>\n" +
                "            </tr>\n" +
                "        </table>\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "    </form>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>");
        out.close();
    }
}
