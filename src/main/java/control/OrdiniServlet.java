package control;

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
    ArrayList<Ordine> ordiniList = OrdineDAO.doRetrieveAllByIdUtente(u.getId());

    for (Ordine o : ordiniList) {
      System.out.println(o.getDataOrdine());
      for (ProdottoCarrello p : o.getProdotti()) {
        System.out.println(p.getQuantita());
        System.out.println(p.getProdotto().getNome());
      }
    }

    request.setAttribute("ordini", ordiniList);
    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/ordini.jsp");
    dispatcher.forward(request, response);

  }
}
