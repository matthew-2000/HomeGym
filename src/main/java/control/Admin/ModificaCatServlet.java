package control.Admin;

import model.Categoria;
import model.CategoriaDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ModificaCatServlet", value = "/ModificaCatServlet")
public class ModificaCatServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String descrizione = request.getParameter("descrizione");

        Categoria cat1 = new Categoria();

        cat1.setId(id);
        cat1.setNome(nome);
        cat1.setDescrizione(descrizione);

        HttpSession session = request.getSession();
        Categoria cat = (Categoria) session.getAttribute("categoria");

        if(!cat1.equals(cat)) {
            CategoriaDAO.doUpdate(cat1);
            session.setAttribute("categoria", cat1);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/ModCategorieServlet");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
