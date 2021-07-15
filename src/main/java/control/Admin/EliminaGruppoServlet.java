package control.Admin;

import model.CategoriaDAO;
import model.GruppoDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EliminaGruppoServlet", value = "/EliminaGruppoServlet")
public class EliminaGruppoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        GruppoDAO.doDelete(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ModGruppiServlet");
        dispatcher.forward(request, response);
    }
}
