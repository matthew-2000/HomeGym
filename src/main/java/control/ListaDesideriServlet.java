package control;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
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

      HttpSession session = request.getSession();
      Utente u = (Utente) session.getAttribute("utente");
      List<Integer> listaIdProdotti = UtenteDAO.doRetrieveIdListaDesideriById(u.getId());
      List<Prodotto> listaDesideri = new ArrayList<>();
      for (int id : listaIdProdotti) {
          listaDesideri.add(ProdottoDAO.doRetrieveById(id));
      }

      request.setAttribute("desideri", listaDesideri);
      RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/listaDesideri.jsp");
      dispatcher.forward(request, response);

  }
}
