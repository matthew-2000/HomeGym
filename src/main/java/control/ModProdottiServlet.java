package control;

import model.Gruppo;
import model.GruppoDAO;
import model.Prodotto;
import model.ProdottoDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ModProdottiServlet", value = "/ModProdottiServlet")
public class ModProdottiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Prodotto> prodotti = ProdottoDAO.doRetrieveAll();
        HttpSession session = request.getSession();

        session.setAttribute("prodotti", prodotti);



        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/adminProdotti.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
