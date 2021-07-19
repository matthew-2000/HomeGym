package control.Admin;

import model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SalvaModificheServlet", value = "/SalvaModificheServlet")
public class SalvaModificheServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String azione = request.getParameter("azione");
        String address = "";

        switch (azione) {

            case "categoria" :
                int id = Integer.parseInt(request.getParameter("id"));
                String nome = request.getParameter("nome");
                String descrizione = request.getParameter("descrizione");

                Categoria cat1 = new Categoria();

                cat1.setId(id);
                cat1.setNome(nome);
                cat1.setDescrizione(descrizione);

                HttpSession session = request.getSession();
                Categoria cat = (Categoria) session.getAttribute("categoria");

                if(!cat1.equals(cat)) {
                    CategoriaDAO.doUpdate(cat1);
                    session.setAttribute("categoria", cat1);
                }
                address = "/ModCategorieServlet";
                break;

            case "gruppo" :
                boolean b = false;
                int idGruppo = Integer.parseInt(request.getParameter("id"));
                String nomeGruppo = request.getParameter("nome");
                int idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
                List<Categoria> categorie = CategoriaDAO.doRetrieveAll();

                for(Categoria c : categorie) {
                    if(c.getId() == idCategoria) {
                        b = true;
                        break;
                    }
                }
                if(!b) {
                    String message = "Id categoria non valido!";
                    request.setAttribute("message", message);
                    address = "/WEB-INF/jsp/error.jsp";
                }
                else {
                    Gruppo g = new Gruppo();
                    g.setId(idGruppo);
                    g.setNome(nomeGruppo);
                    g.setIdCategoria(idCategoria);
                    HttpSession sessionGroup = request.getSession();
                    Gruppo group = (Gruppo) sessionGroup.getAttribute("gruppo");

                    if(!g.equals(group)) {
                        GruppoDAO.doUpdate(g);
                        sessionGroup.setAttribute("gruppo", g);
                    }
                    address = "/ModGruppiServlet";
                }
                break;

            case "prodotto" :
                boolean bProduct = false;

                int idProdotto = Integer.parseInt(request.getParameter("id"));
                String nomeProdotto = request.getParameter("nomeProdotto");
                double prezzo = Double.parseDouble(request.getParameter("prezzoProdotto"));
                String descrizioneProdotto = request.getParameter("descrizioneProdotto");
                int quantita = Integer.parseInt(request.getParameter("quantitaProdotto"));
                double voto = Double.parseDouble(request.getParameter("votoProdotto"));
                int idGroup = Integer.parseInt(request.getParameter("idGruppo"));

                List<Gruppo> gruppi = GruppoDAO.doRetrieveAll();

                for(Gruppo g : gruppi) {
                    if (g.getId() == idGroup) {
                        bProduct = true;
                        break;
                    }
                }

                if(!bProduct) {
                    String message = "Id gruppo non valido!";
                    request.setAttribute("message", message);
                    address = "/WEB-INF/jsp/error.jsp";
                } else {
                    Prodotto p = new Prodotto();
                    p.setId(idProdotto);
                    p.setNome(nomeProdotto);
                    p.setPrezzo(prezzo);
                    p.setDescrizione(descrizioneProdotto);
                    p.setQuantita(quantita);
                    p.setVoto(voto);
                    p.setIdGruppo(idGroup);
                    HttpSession sessionProduct = request.getSession();
                    Prodotto product = (Prodotto) sessionProduct.getAttribute("prodotto");

                    if(!p.equals(product)) {
                        ProdottoDAO.doUpdate(p);
                        sessionProduct.setAttribute("prodotto", p);
                    }
                    address = "/ModProdottiServlet";
                }
                break;

            default:
                String error = "Errore durante il caricamento della pagina";
                request.setAttribute("message", error);
                address = "/WEB-INF/jsp/error.jsp";
                break;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }
}
