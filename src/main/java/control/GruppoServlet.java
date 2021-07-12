package control;

import model.Gruppo;
import model.GruppoDAO;
import model.ImmaginiProdottiDAO;
import model.Prodotto;
import model.ProdottoDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GruppoServlet", value = "/GruppoServlet")
public class GruppoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idGruppo = Integer.parseInt(request.getParameter("gruppoId"));

        List<Prodotto> listaProdotti = ProdottoDAO.doRetrieveByIdGruppo(idGruppo);

        Gruppo g = GruppoDAO.doRetrieveById(idGruppo);

        for (Prodotto p : listaProdotti) {
            p.setImmagini(ImmaginiProdottiDAO.doRetrieveByIdProduct(p.getId()));
        }

        request.setAttribute("prodotti", listaProdotti);
        request.setAttribute("gruppo", g);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/prodotti.jsp");
        dispatcher.forward(request, response);
    }
}
