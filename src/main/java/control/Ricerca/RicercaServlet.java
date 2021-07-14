package control.Ricerca;

import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import model.ImmaginiProdottiDAO;
import model.Prodotto;
import model.ProdottoDAO;

@WebServlet(name = "RicercaServlet", value = "/RicercaServlet")
public class RicercaServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      String query = request.getParameter("search");

      if (query.equals("")) {
        String message = "Non è stato inserito nessun parametro di ricerca!";
        request.setAttribute("message", message);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
        dispatcher.forward(request, response);
      }
      List<Prodotto> prodotti = ProdottoDAO.doRetrieveByNome(query + "*", 0, 10);

      for (Prodotto p : prodotti) {
        p.setImmagini(ImmaginiProdottiDAO.doRetrieveByIdProduct(p.getId()));
      }

      request.setAttribute("prodottiTrovati", prodotti);
      RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/ricerca.jsp");
      dispatcher.forward(request, response);

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      doGet(request, response);
  }
}
