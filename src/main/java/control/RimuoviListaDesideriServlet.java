package control;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import model.Utente;
import model.UtenteDAO;

@WebServlet(name = "RimuoviListaDesideriServlet", value = "/RimuoviListaDesideriServlet")
public class RimuoviListaDesideriServlet extends HttpServlet {
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

      int idProdotto = Integer.parseInt(request.getParameter("idProdotto"));
      UtenteDAO.doDeleteListaDesideri(u.getId(), idProdotto);

      RequestDispatcher dispatcher = request.getRequestDispatcher("/ListaDesideriServlet");
      dispatcher.forward(request, response);
  }
}
