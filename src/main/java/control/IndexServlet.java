package control;

import model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "IndexServlet", urlPatterns = {"", "/IndexServlet"}, loadOnStartup = 1)
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Prodotto> listaProdotti = ProdottoDAO.doRetrieveAll();

        List<Prodotto> prodottiMigliori = new ArrayList<>();
        List<String> immaginiProdotti;
        for (Prodotto p : listaProdotti){
            if (p.getId() < 10){
                immaginiProdotti = ImmaginiProdottiDAO.doRetrieveByIdProduct(p.getId());
                p.setImmagini(immaginiProdotti);
                prodottiMigliori.add(p);

            }
        }

        request.setAttribute("venduti", prodottiMigliori);
        HttpSession session = request.getSession();
        synchronized (session){
            if (session.isNew()){
                session.setAttribute("isLogged", false);
            }
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
