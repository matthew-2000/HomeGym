package control.Admin;

import model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AggiungiProdottoServlet", value = "/AggiungiProdottoServlet")
public class AggiungiProdottoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean b = false;
        String address = "";

        String nome = request.getParameter("nomeProdotto");
        double prezzo = Double.parseDouble(request.getParameter("prezzoProdotto"));
        String descrizione = request.getParameter("descrizioneProdotto");
        int quantita = Integer.parseInt(request.getParameter("quantitaProdotto"));
        double voto = Double.parseDouble(request.getParameter("votoProdotto"));
        int idGruppo = Integer.parseInt(request.getParameter("idGruppo"));

        List<Gruppo> gruppi = GruppoDAO.doRetrieveAll();
        for(Gruppo g : gruppi) {
            if(g.getId() == idGruppo)
                b = true;
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

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
