package control.Admin;

import model.Categoria;
import model.CategoriaDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ModCategorieServlet", value = "/ModCategorieServlet")
public class ModCategorieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Categoria> cat = CategoriaDAO.doRetrieveAll();

        request.setAttribute("cat", cat);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/adminCategorie.jsp");
        dispatcher.forward(request, response);
    }
}
