package servlet;

import dao.SondageDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "sondage", urlPatterns = "/sondage")
public class SondageInfo extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        out.printf("<html><body>");
        out.println("<table border=1 width=50% height=50%>");
        out.println("<tr><th>Id</th><th>Name</th><th>Location</th><tr>");
        for (domain.Sondage item : SondageDAO.getSondages()){
            out.printf("<tr><td>%d</td><td>%s</td><td>%s</td></tr>",
                    item.getId(), item.getTitre(), item.getLieu());
        }
        out.printf("</table>");
        out.printf("<a href=/form.html>Add a meeting</a>");
        out.printf("</html></body>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SondageDAO.rentrerNouvelleDonnees(request.getParameter("title"),
                request.getParameter("location"));
        doGet(request, response);
    }

}
