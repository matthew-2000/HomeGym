package control.VisualizzaProdotti;

import java.util.List;
import model.ImmaginiProdottiDAO;
import model.Prodotto;
import model.ProdottoDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import model.RequestValidator;

@WebServlet(name = "ProdottoServlet", value = "/ProdottoServlet")
public class ProdottoServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    RequestValidator requestValidator = new RequestValidator(request);
    boolean idResult = requestValidator.assertInt("idProdotto", "Id prodotto non valido");

    if (idResult) {
      String idProdotto = request.getParameter("idProdotto");

      int id = Integer.parseInt(idProdotto);
      Prodotto p = ProdottoDAO.doRetrieveById(id);
      p.setImmagini(ImmaginiProdottiDAO.doRetrieveByIdProduct(p.getId()));

      request.setAttribute("prodotto", p);

      RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/prodotto.jsp");
      dispatcher.forward(request, response);
    } else {
      List<String> errors = requestValidator.getErrors();
      request.setAttribute("errors", errors);
      RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
      dispatcher.forward(request, response);
    }

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

      doGet(request, response);

  }
}
