package control.Admin;

import model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ModificaProductServlet", value = "/ModificaProductServlet")
public class ModificaProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean b = false;
        String address = "";

        int id = Integer.parseInt(request.getParameter("id"));
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
            String message = "Id categoria Sbagliato";
            request.setAttribute("message", message);
            address = "/WEB-INF/jsp/error.jsp";
        } else {
            Prodotto p = new Prodotto();
            p.setId(id);
            p.setNome(nome);
            p.setPrezzo(prezzo);
            p.setDescrizione(descrizione);
            p.setQuantita(quantita);
            p.setVoto(voto);
            p.setIdGruppo(idGruppo);
            HttpSession session = request.getSession();
            Prodotto product = (Prodotto) session.getAttribute("prodotto");

            if(!p.equals(product)) {
                ProdottoDAO.doUpdate(p);
                session.setAttribute("prodotto", p);
            }
            address = "/ModProdottiServlet";
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
