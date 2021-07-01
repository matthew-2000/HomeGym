package control;


import model.Prodotto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AggiungiCarrelloServlet", value = "/AggiungiCarrelloServlet")
public class AggiungiCarrelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idProdotto"));
        List<Integer> prodotti;
        HttpSession session = request.getSession();
        prodotti = (List<Integer>) session.getAttribute("idProdottiCarrello");
        if(prodotti == null) {
            prodotti = new ArrayList<>();
            prodotti.add(id);
        }
        else {
            prodotti.add(id);
        }

        session.setAttribute("idProdottiCarrello", prodotti);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/CarrelloServlet");
        dispatcher.forward(request, response);
    }
}
