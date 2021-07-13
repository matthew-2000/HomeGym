package control;

import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import model.Prodotto;
import model.ProdottoDAO;

@WebServlet(name = "RicercaServlet", value = "/RicercaServlet")
public class RicercaServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      String query = request.getParameter("search");
      List<Prodotto> prodotti = ProdottoDAO.doRetrieveByNome(query + "*", 0, 10);

      for (Prodotto p : prodotti) {
          System.out.println(p.getNome());
      }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      doGet(request, response);
  }
}
