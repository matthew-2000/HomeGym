package control.ListaDesideri;

import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import model.RequestValidator;
import model.Utente;
import model.UtenteDAO;

@WebServlet(name = "RimuoviListaDesideriServlet", value = "/RimuoviListaDesideriServlet")
public class RimuoviListaDesideriServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      doPost(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

      HttpSession session = request.getSession();
      Utente u = (Utente) session.getAttribute("utente");

      if (u == null) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
        dispatcher.forward(request, response);
      } else {
        RequestValidator requestValidator = new RequestValidator(request);
        boolean idResult = requestValidator.assertInt("idProdotto", "Id prodotto non valido");

        if (idResult) {
          int id = Integer.parseInt(request.getParameter("idProdotto"));
          UtenteDAO.doDeleteListaDesideri(u.getId(), id);
        } else {
          List<String> errors = requestValidator.getErrors();
          request.setAttribute("errors", errors);
          RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
          dispatcher.forward(request, response);
        }

      }

      RequestDispatcher dispatcher = request.getRequestDispatcher("/ListaDesideriServlet");
      dispatcher.forward(request, response);
  }

}
