package control;

import model.Categoria;
import model.CategoriaDAO;
import model.Gruppo;
import model.GruppoDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CategorieServlet", value = "/CategorieServlet")
public class CategorieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Categoria> listaCategorie = CategoriaDAO.doRetrieveAll();
        for (Categoria c : listaCategorie) {
            c.setListaGruppi((ArrayList<Gruppo>) GruppoDAO.doRetrieveByIdCategoria(c.getId()));
        }

        request.setAttribute("categorie", listaCategorie);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/categorie.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
