package control.Ricerca;

import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import model.Prodotto;
import model.ProdottoDAO;
import org.json.JSONArray;

@WebServlet(name = "RicercaAjaxServlet", value = "/RicercaAjaxServlet")
public class RicercaAjaxServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

      JSONArray prodJson = new JSONArray();
      String query = request.getParameter("search");
      if (query != null) {
          List<Prodotto> prodotti = ProdottoDAO.doRetrieveByNome(query + "*", 0, 10);
          for (Prodotto p : prodotti) {
            prodJson.put(p.getNome());
          }
      }
      response.setContentType("application/json");
      response.getWriter().append(prodJson.toString());

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      doGet(request, response);
  }
}
