package control.Admin;

import model.Gruppo;
import model.GruppoDAO;
import model.Prodotto;
import model.ProdottoDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ModificaProdottoServlet", value = "/ModificaProdottoServlet")
public class ModificaProdottoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Prodotto product = ProdottoDAO.doRetrieveById(id);
        HttpSession session = request.getSession();
        session.setAttribute("prodotto", product);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/modificaProdotto.jsp");
        dispatcher.forward(request, response);
    }
}
