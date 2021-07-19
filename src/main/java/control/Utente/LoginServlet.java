package control.Utente;

import java.util.ArrayList;
import java.util.List;
import model.RequestValidator;
import model.Utente;
import model.UtenteDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestValidator requestValidator = new RequestValidator(request);
        boolean emailResult = requestValidator.assertEmail("email", "Email non valida!");
        boolean passwordResult = requestValidator.assertPassword("password", "Password non valida!");

        if (emailResult && passwordResult) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            Utente utente = UtenteDAO.doRetrieveByEmailPassword(email, password);
            if(utente != null){

                HttpSession session = request.getSession();
                session.setAttribute("utente", utente);
                session.setAttribute("isLogged", true);

            } else {
                String message = "Nessun utente trovato!";
                request.setAttribute("message", message);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
                dispatcher.forward(request, response);
            }
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
