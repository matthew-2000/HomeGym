package control;

import model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "IndexServlet", value = "/IndexServlet")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Categoria> listaCategorie = CategoriaDAO.doRetrieveAll();
        List<Gruppo> listaGruppi = GruppoDAO.doRetrieveAll();
        List<Prodotto> listaProdotti = ProdottoDAO.doRetrieveAll();
        List<ImmaginiProdotti> listaImmagini = ImmaginiProdottiDAO.doRetrieveAll();
        boolean isLogged = false;

        List<Prodotto> prodottiMigliori = new ArrayList<>();
        /*List<ImmaginiProdotti> immaginiMigliori = new ArrayList<>();*/
        for (Prodotto li : listaProdotti){
            if (li.getVoto() > 4.75){
                prodottiMigliori.add(li);
                /*for(ImmaginiProdotti lis : listaImmagini){
                    if(lis.getIdProdotto() == li.getId())
                        immaginiMigliori.add(lis);
                }*/
            }
        }



        request.setAttribute("venduti", prodottiMigliori);
        /*request.setAttribute("immaginiMigliori", immaginiMigliori);*/
        HttpSession session = request.getSession();
        synchronized (session){
            if (session.isNew()){
                session.setAttribute("isLogged", isLogged);
                /*session.setAttribute("categorie", listaCategorie);*/
                /*session.setAttribute("gruppi", listaGruppi);*/
                session.setAttribute("prodotti", listaProdotti);
                session.setAttribute("immagini", listaImmagini);
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
