package control.Admin;

import model.Gruppo;
import model.GruppoDAO;
import model.Prodotto;
import model.ProdottoDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ModificaProdottoServlet", value = "/ModificaProdottoServlet")
public class ModificaProdottoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String azione = request.getParameter("azione");
        String address = "";

        switch (azione) {

            case "aggiungi":
                boolean b = false;

                String nome = request.getParameter("nomeProdotto");
                double prezzo = Double.parseDouble(request.getParameter("prezzoProdotto"));
                String descrizione = request.getParameter("descrizioneProdotto");
                int quantita = Integer.parseInt(request.getParameter("quantitaProdotto"));
                double voto = Double.parseDouble(request.getParameter("votoProdotto"));
                int idGruppo = Integer.parseInt(request.getParameter("idGruppo"));

                List<Gruppo> gruppi = GruppoDAO.doRetrieveAll();
                for(Gruppo g : gruppi) {
                    if (g.getId() == idGruppo) {
                        b = true;
                        break;
                    }
                }
                if(!b) {
                    String message = "Id gruppo Sbagliato";
                    request.setAttribute("message", message);
                    address = "/WEB-INF/jsp/error.jsp";
                }
                else {
                    Prodotto p = new Prodotto();
                    p.setNome(nome);
                    p.setPrezzo(prezzo);
                    p.setDescrizione(descrizione);
                    p.setQuantita(quantita);
                    p.setVoto(voto);
                    p.setIdGruppo(idGruppo);
                    ProdottoDAO.doSave(p);
                    address = "/ModProdottiServlet";
                }
                break;
            case "modifica" :
                int id = Integer.parseInt(request.getParameter("id"));
                Prodotto product = ProdottoDAO.doRetrieveById(id);
                request.setAttribute("prodotto", product);
                address = "/WEB-INF/jsp/modificaProdotto.jsp";
                break;
            case "elimina" :
                int idDelete = Integer.parseInt(request.getParameter("id"));
                ProdottoDAO.doDelete(idDelete);
                address = "/ModProdottiServlet";
                break;
            default :
                String error = "Errore durante il caricamento della pagina";
                request.setAttribute("message", error);
                address = "/WEB-INF/jsp/error.jsp";
                break;
        }



        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }
}
