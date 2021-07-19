package control.VisualizzaProdotti;

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
import model.RequestValidator;

@WebServlet(name = "GruppoServlet", value = "/GruppoServlet")
public class GruppoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestValidator requestValidator = new RequestValidator(request);
        boolean idResult = requestValidator.assertInt("gruppoId", "Id gruppo non valido");

        if (idResult) {
            int idGruppo = Integer.parseInt(request.getParameter("gruppoId"));

            List<Prodotto> listaProdotti = ProdottoDAO.doRetrieveByIdGruppo(idGruppo);
            String address;

            if (listaProdotti != null) {
                Gruppo g = GruppoDAO.doRetrieveById(idGruppo);

                for (Prodotto p : listaProdotti) {
                    p.setImmagini(ImmaginiProdottiDAO.doRetrieveByIdProduct(p.getId()));
                }

                request.setAttribute("prodotti", listaProdotti);
                request.setAttribute("gruppo", g);

                address = "/WEB-INF/jsp/prodotti.jsp";
            } else {

                request.setAttribute("message", "Non ci sono ancora prodotti nel gruppo selezionato! Stiamo lavorando per caricarli :) ");
                address = "/WEB-INF/jsp/error.jsp";

            }

            RequestDispatcher dispatcher = request.getRequestDispatcher(address);
            dispatcher.forward(request, response);
        } else {
            List<String> errors = requestValidator.getErrors();
            request.setAttribute("errors", errors);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
            dispatcher.forward(request, response);
        }

    }

}
