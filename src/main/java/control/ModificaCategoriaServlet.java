package control;

import model.Categoria;
import model.CategoriaDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ModificaCategoriaServlet", value = "/ModificaCategoriaServlet")
public class ModificaCategoriaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Categoria cat = CategoriaDAO.doRetrieveById(id);
        HttpSession session = request.getSession();
        session.setAttribute("categoria", cat);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/modifica.jsp");
        dispatcher.forward(request, response);
    }
}
