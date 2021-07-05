package control;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import model.Utente;
import model.UtenteDAO;

@WebServlet(name = "AggiungiListaDesideriServlet", value = "/AggiungiListaDesideriServlet")
public class AggiungiListaDesideriServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      doPost(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      int id = Integer.parseInt(request.getParameter("idProdotto"));

      HttpSession session = request.getSession();
      Utente u = (Utente) session.getAttribute("utente");

      RequestDispatcher dispatcher;
      if (u == null) {
          //mandiamo al login
          dispatcher = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
      } else {
          UtenteDAO.doSaveListaDesideri(u, id);
          dispatcher = request.getRequestDispatcher("/ListaDesideriServlet");
      }

      dispatcher.forward(request, response);

  }
}
