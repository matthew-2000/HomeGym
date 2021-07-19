package control.Ordini;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import model.Carrello;
import model.OrdineDAO;
import model.Utente;

@WebServlet(name = "EffettuaOrdineServlet", value = "/EffettuaOrdineServlet")
public class EffettuaOrdineServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      doPost(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

      HttpSession session = request.getSession();
      Carrello carrello = (Carrello) session.getAttribute("carrello");
      Utente u = (Utente) session.getAttribute("utente");

      if(carrello == null || u == null) {
          String message = "OPS! Errore sconosciuto.";
          request.setAttribute("message", message);
          RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
          dispatcher.forward(request, response);
      }

      OrdineDAO.doSave(carrello, u.getId());

      carrello = new Carrello();
      session.setAttribute("carrello", carrello);

      RequestDispatcher dispatcher = request.getRequestDispatcher("/OrdiniServlet");
      dispatcher.forward(request, response);

  }
}
