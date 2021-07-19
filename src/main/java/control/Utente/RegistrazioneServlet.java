package control.Utente;

import java.util.List;
import model.RequestValidator;
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
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestValidator requestValidator = new RequestValidator(request);
        boolean emailResult = requestValidator.assertEmail("email", "Email non valida");
        boolean passwordResult = requestValidator.assertPassword("password", "Password non valida");
        boolean capResult = requestValidator.assertInt("cap", "Cap non valido");
        boolean numeroResult = requestValidator.assertInt("numero", "Numero non valido");

        if (emailResult && passwordResult && capResult && numeroResult) {
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
            session.setAttribute("utente", utente);
            session.setAttribute("isLogged", true);

        } else {
            List<String> errors = requestValidator.getErrors();
            request.setAttribute("errors", errors);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
            dispatcher.forward(request, response);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/IndexServlet");
        dispatcher.forward(request, response);
    }
}
