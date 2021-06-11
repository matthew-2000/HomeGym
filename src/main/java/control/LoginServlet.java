package control;

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
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Utente utente = UtenteDAO.doRetrieveByEmailPassword(email, password);
        System.out.println("ERRORE 1");
        if(utente != null){
            System.out.println("ERRORE " + utente.toString());

            HttpSession session = request.getSession();
            session.setAttribute("utente", utente);
            boolean isLogged = (boolean) session.getAttribute("isLogged");
            if(!isLogged){
                session.setAttribute("isLogged", true);
            }
        }//inserire errore
        else{
            System.out.println("ERRORE UTENTE" );
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
