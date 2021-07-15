package control.Admin;

import model.GruppoDAO;
import model.ProdottoDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EliminaProdottoServlet", value = "/EliminaProdottoServlet")
public class EliminaProdottoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        ProdottoDAO.doDelete(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ModProdottiServlet");
        dispatcher.forward(request, response);
    }
}
