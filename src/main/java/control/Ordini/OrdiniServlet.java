package control.Ordini;

import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import model.Ordine;
import model.OrdineDAO;
import model.ProdottoCarrello;
import model.Utente;

@WebServlet(name = "OrdiniServlet", value = "/OrdiniServlet")
public class OrdiniServlet extends HttpServlet {
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
    String address = "";

    if (u == null) {
      address = "/LogServlet";
    } else {
      ArrayList<Ordine> ordiniList = OrdineDAO.doRetrieveAllByIdUtente(u.getId());

      request.setAttribute("ordini", ordiniList);
      address = "WEB-INF/jsp/ordini.jsp";
    }

    RequestDispatcher dispatcher = request.getRequestDispatcher(address);
    dispatcher.forward(request, response);

  }
}
