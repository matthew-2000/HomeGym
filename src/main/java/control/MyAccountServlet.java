package control;

import model.Utente;
import model.UtenteDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MyAccountServlet", value = "/MyAccountServlet")
public class MyAccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        String indirizzo = request.getParameter("indirizzo");
        String cap = request.getParameter("cap");
        String paese = request.getParameter("paese");
        String telefono = request.getParameter("telefono");

        Utente utente1 = new Utente();

        utente1.setId(id);
        utente1.setEmail(email);
        utente1.setNome(nome);
        utente1.setCognome(cognome);
        utente1.setPasswordHash(password);
        utente1.setVia(indirizzo);
        utente1.setCap(cap);
        utente1.setPaese(paese);
        utente1.setNumero(telefono);

        HttpSession session = request.getSession();
        Utente u = (Utente) session.getAttribute("utente");
        if (!utente1.equals(u)) {
            UtenteDAO.doUpdate(utente1, id);
            session.setAttribute("utente", utente1);
            request.setAttribute("isChange", true);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/account.jsp");
        dispatcher.forward(request, response);
    }
}
