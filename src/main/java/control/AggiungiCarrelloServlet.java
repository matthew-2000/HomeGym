package control;


import model.Carrello;
import model.ImmaginiProdottiDAO;
import model.Prodotto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.ProdottoCarrello;
import model.ProdottoDAO;

@WebServlet(name = "AggiungiCarrelloServlet", value = "/AggiungiCarrelloServlet")
public class AggiungiCarrelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idProdotto"));
        String quantitaString = request.getParameter("quantita");

        if (quantitaString.equals("")) {
            String message = "Quantità prodotto non inserita!";
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
            dispatcher.forward(request, response);
        } else {
            int quantita = Integer.parseInt(quantitaString);

            HttpSession session = request.getSession();
            Carrello carrello = (Carrello) session.getAttribute("carrello");
            if(carrello == null) {
                carrello = new Carrello();
            }

            Prodotto prodotto = ProdottoDAO.doRetrieveById(id);
            prodotto.setImmagini(ImmaginiProdottiDAO.doRetrieveByIdProduct(prodotto.getId()));
            carrello.addProdotto(new ProdottoCarrello(prodotto, quantita));

            session.setAttribute("carrello", carrello);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/CarrelloServlet");
            dispatcher.forward(request, response);
        }

    }
}
