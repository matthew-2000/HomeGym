package control;

import model.Prodotto;
import model.ProdottoDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CarrelloServlet", value = "/CarrelloServlet")
public class CarrelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Integer> prodottiId;
        List<Prodotto> prodotti = new ArrayList<>();
        HttpSession session = request.getSession();
        prodottiId = (List<Integer>) session.getAttribute("idProdottiCarrello");
        if(prodottiId == null) {
            String message = "Il carrello è ancora vuoto";
            request.setAttribute("message", message);
        }
        else {
            for (int id : prodottiId) {
                Prodotto p = ProdottoDAO.doRetrieveById(id);
                prodotti.add(p);
            }
            session.setAttribute("prodottiCarrello", prodotti);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/carrello.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
