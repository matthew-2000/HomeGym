package control.ListaDesideri;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import model.ImmaginiProdottiDAO;
import model.Prodotto;
import model.ProdottoDAO;
import model.Utente;
import model.UtenteDAO;

@WebServlet(name = "ListaDesideriServlet", value = "/ListaDesideriServlet")
public class ListaDesideriServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      doPost(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

      String address;

      HttpSession session = request.getSession();
      Utente u = (Utente) session.getAttribute("utente");
      if (u == null) {
        address = "/LogServlet";
      } else {

        List<Integer> listaIdProdotti = UtenteDAO.doRetrieveIdListaDesideriById(u.getId());
        List<Prodotto> listaDesideri = new ArrayList<>();
        for (int id : listaIdProdotti) {
          listaDesideri.add(ProdottoDAO.doRetrieveById(id));
        }

        for (Prodotto p : listaDesideri) {
          p.setImmagini(ImmaginiProdottiDAO.doRetrieveByIdProduct(p.getId()));
        }

        request.setAttribute("desideri", listaDesideri);
        address = "WEB-INF/jsp/listaDesideri.jsp";

      }
      RequestDispatcher dispatcher = request.getRequestDispatcher(address);
      dispatcher.forward(request, response);

  }
}
