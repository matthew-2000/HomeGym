package control.ListaDesideri;

import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import model.RequestValidator;
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

    RequestValidator requestValidator = new RequestValidator(request);
    boolean idResult = requestValidator.assertInt("idProdotto", "Id prodotto non valido");

    if (idResult) {
      int id = Integer.parseInt(request.getParameter("idProdotto"));

      HttpSession session = request.getSession();
      Utente u = (Utente) session.getAttribute("utente");

      String address;
      if (u == null) {
        //mandiamo al login
        address = "WEB-INF/jsp/login.jsp";
      } else {
        UtenteDAO.doSaveListaDesideri(u, id);
        address = "/ListaDesideriServlet";
      }

      RequestDispatcher dispatcher = request.getRequestDispatcher(address);
      dispatcher.forward(request, response);
    } else {

      List<String> errors = requestValidator.getErrors();
      request.setAttribute("errors", errors);
      RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
      dispatcher.forward(request, response);

    }

  }
}
