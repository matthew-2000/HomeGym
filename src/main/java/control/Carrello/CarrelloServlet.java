package control.Carrello;

import model.Carrello;
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

        String cancellaIdSring = request.getParameter("cancellaProdotto");
        if (cancellaIdSring != null) {
            int idProdotto = Integer.parseInt(cancellaIdSring);
            HttpSession session = request.getSession();
            Carrello carrello = (Carrello) session.getAttribute("carrello");
            carrello.removeProdotto(idProdotto);
        }

        HttpSession session = request.getSession();
        Carrello carrello = (Carrello) session.getAttribute("carrello");
        if(carrello == null) {
            carrello = new Carrello();
            session.setAttribute("carrello", carrello);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/carrello.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
