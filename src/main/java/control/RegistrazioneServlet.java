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
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        String via = request.getParameter("via");
        int cap = Integer.parseInt(request.getParameter("cap"));
        String paese = request.getParameter("pause");
        int numero = Integer.parseInt(request.getParameter("numero"));

        Utente utente = new Utente();
        utente.setEmail(email);
        utente.setPasswordHash(password);
        utente.setNome(nome);
        utente.setCognome(cognome);
        utente.setVia(via);
        utente.setCap(cap);
        utente.setPaese(paese);
        utente.setNumero(numero);

        UtenteDAO.doSave(utente);

        HttpSession session = request.getSession();

        synchronized (session){
            Utente u = (Utente) session.getAttribute("utente");
            boolean isLogged = (boolean) session.getAttribute("isLogged");
            if(u == null){
                session.setAttribute("utente", utente);
                isLogged = true;
                session.setAttribute("isLogged", isLogged);
            }
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
