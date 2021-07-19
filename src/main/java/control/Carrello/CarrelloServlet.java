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
import model.RequestValidator;

@WebServlet(name = "CarrelloServlet", value = "/CarrelloServlet")
public class CarrelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //per cancellare un prodotto dal carrello
        String cancellaIdSring = request.getParameter("cancellaProdotto");
        if (cancellaIdSring != null) {
            RequestValidator requestValidator = new RequestValidator(request);
            boolean idResult = requestValidator.assertInt("cancellaProdotto", "Id prodotto non valido");

            if (idResult) {
                int idProdotto = Integer.parseInt(cancellaIdSring);
                HttpSession session = request.getSession();

                Carrello carrello = (Carrello) session.getAttribute("carrello");
                if (carrello != null)
                    carrello.removeProdotto(idProdotto);

            } else {
                List<String> errors = requestValidator.getErrors();
                request.setAttribute("errors", errors);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
                dispatcher.forward(request, response);
            }

        }

        //caricare il carrello
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
