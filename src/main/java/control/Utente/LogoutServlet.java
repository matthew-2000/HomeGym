package control.Utente;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LogoutServlet", value = "/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();;
        session.removeAttribute("utente");
        session.removeAttribute("idProdottiCarrello");
        session.removeAttribute("prodottiCarrello");
        session.removeAttribute("carrello");
        session.setAttribute("isLogged", false);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/IndexServlet");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
