package control;

import model.Categoria;
import model.CategoriaDAO;
import model.Gruppo;
import model.GruppoDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ModificaGruppoServlet", value = "/ModificaGruppoServlet")
public class ModificaGruppoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Gruppo group = GruppoDAO.doRetrieveById(id);
        HttpSession session = request.getSession();
        session.setAttribute("gruppo", group);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/modificaGruppo.jsp");
        dispatcher.forward(request, response);
    }
}
