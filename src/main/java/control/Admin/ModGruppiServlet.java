package control.Admin;

import control.MyException;
import model.Categoria;
import model.CategoriaDAO;
import model.Gruppo;
import model.GruppoDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ModGruppiServlet", value = "/ModGruppiServlet")
public class ModGruppiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MyException.checkAdmin(request);

        List<Gruppo> gruppi = GruppoDAO.doRetrieveAll();

        request.setAttribute("gruppi", gruppi);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/adminGruppi.jsp");
        dispatcher.forward(request, response);
    }
}
