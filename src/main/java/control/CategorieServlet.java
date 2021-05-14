package control;

import model.Categoria;
import model.CategoriaDAO;

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

        HttpSession session = request.getSession(true);
        synchronized (session){
            List<Categoria> listaCategorie = (List<Categoria>) session.getAttribute("categorie");
            if(listaCategorie == null){
                listaCategorie = new ArrayList<>();
                listaCategorie = CategoriaDAO.doRetrieveAll();
                session.setAttribute("categorie", listaCategorie);
            }
        }


        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/categorie.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
