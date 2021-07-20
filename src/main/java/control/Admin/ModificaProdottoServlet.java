package control.Admin;

import control.MyException;
import model.Gruppo;
import model.GruppoDAO;
import model.Prodotto;
import model.ProdottoDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import model.RequestValidator;

@WebServlet(name = "ModificaProdottoServlet", value = "/ModificaProdottoServlet")
public class ModificaProdottoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MyException.checkAdmin(request);

        String azione = request.getParameter("azione");
        if (azione != null) {
            String address = "";
            RequestValidator requestValidator = new RequestValidator(request);

            switch (azione) {

                case "aggiungi":

                    boolean idGruppoResult = requestValidator.assertInt("idGruppo", "Id non valido!");
                    boolean prezzoResult = requestValidator.assertDouble("prezzoProdotto", "Prezzo prodotto non valido");

                    if (idGruppoResult && prezzoResult) {
                        String nome = request.getParameter("nomeProdotto");
                        String descrizione = request.getParameter("descrizioneProdotto");
                        if (nome != null && descrizione != null && !nome.equals("") && !descrizione.equals("")){
                            double prezzo = Double.parseDouble(request.getParameter("prezzoProdotto"));
                            int idGruppo = Integer.parseInt(request.getParameter("idGruppo"));

                            List<Gruppo> gruppi = GruppoDAO.doRetrieveAll();
                            boolean b = false;
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
                                p.setIdGruppo(idGruppo);
                                ProdottoDAO.doSave(p);
                                address = "/ModProdottiServlet";
                            }
                        } else {
                            String error = "Errore durante il caricamento della pagina";
                            request.setAttribute("message", error);
                            address = "/WEB-INF/jsp/error.jsp";
                        }
                    } else {
                        List<String> errors = requestValidator.getErrors();
                        request.setAttribute("errors", errors);
                        address = "/WEB-INF/jsp/error.jsp";
                    }
                    break;

                case "modifica" :
                    boolean idResult = requestValidator.assertInt("id", "Id non valido!");
                    if (idResult) {
                        int id = Integer.parseInt(request.getParameter("id"));
                        Prodotto product = ProdottoDAO.doRetrieveById(id);
                        request.setAttribute("prodotto", product);
                        address = "/WEB-INF/jsp/modificaProdotto.jsp";
                    } else {
                        List<String> errors = requestValidator.getErrors();
                        request.setAttribute("errors", errors);
                        address = "/WEB-INF/jsp/error.jsp";
                    }
                    break;

                case "elimina" :
                    boolean idResult2 = requestValidator.assertInt("id", "Id non valido!");
                    if (idResult2) {
                        int idDelete = Integer.parseInt(request.getParameter("id"));
                        ProdottoDAO.doDelete(idDelete);
                        address = "/ModProdottiServlet";
                    } else {
                        List<String> errors = requestValidator.getErrors();
                        request.setAttribute("errors", errors);
                        address = "/WEB-INF/jsp/error.jsp";
                    }

                    break;

                default :
                    String error = "Errore durante il caricamento della pagina";
                    request.setAttribute("message", error);
                    address = "/WEB-INF/jsp/error.jsp";
                    break;

            }

            RequestDispatcher dispatcher = request.getRequestDispatcher(address);
            dispatcher.forward(request, response);

        } else {
            String error = "Errore durante il caricamento della pagina";
            request.setAttribute("message", error);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
            dispatcher.forward(request, response);
        }

    }

}
