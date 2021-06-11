package control;

import model.Utente;
import model.UtenteDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegistrazioneServlet", value = "/RegistrazioneServlet")
public class RegistrazioneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        String via = request.getParameter("via");
        String cap = request.getParameter("cap");
        String paese = request.getParameter("paese");
        String numero = request.getParameter("numero");

        Utente utente = new Utente();
        utente.setEmail(email);
        utente.setPasswordHash(password);
        utente.setNome(nome);
        utente.setCognome(cognome);
        utente.setVia(via);
        utente.setCap(cap);
        utente.setPaese(paese);
        utente.setNumero(numero);
        utente.setAdmin(false);

        UtenteDAO.doSave(utente);

       HttpSession session = request.getSession();

        synchronized (session){
            Utente u = (Utente) session.getAttribute("utente");
            if(u == null){
                session.setAttribute("utente", utente);
                session.setAttribute("isLogged", true);
            }
        }
        System.out.println("MATTEO E GAY");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/IndexServlet");
        dispatcher.forward(request, response);
    }
}
