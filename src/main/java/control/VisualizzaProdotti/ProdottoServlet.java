package control.VisualizzaProdotti;

import model.ImmaginiProdottiDAO;
import model.Prodotto;
import model.ProdottoDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProdottoServlet", value = "/ProdottoServlet")
public class ProdottoServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String idProdotto = request.getParameter("idProdotto");
    System.out.println("ID PRODOTTO = " + idProdotto);

    int id = Integer.parseInt(idProdotto);
    Prodotto p = ProdottoDAO.doRetrieveById(id);
    p.setImmagini(ImmaginiProdottiDAO.doRetrieveByIdProduct(p.getId()));

    request.setAttribute("prodotto", p);

    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/prodotto.jsp");
    dispatcher.forward(request, response);

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

      doGet(request, response);

  }
}
