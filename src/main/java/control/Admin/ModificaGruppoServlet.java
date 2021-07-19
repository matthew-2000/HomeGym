package control.Admin;

import model.Categoria;
import model.CategoriaDAO;
import model.Gruppo;
import model.GruppoDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import model.RequestValidator;

@WebServlet(name = "ModificaGruppoServlet", value = "/ModificaGruppoServlet")
public class ModificaGruppoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String azione = request.getParameter("azione");

        if (azione != null) {
            String address = "";
            RequestValidator requestValidator = new RequestValidator(request);

            switch (azione) {

                case "aggiungi" :
                    boolean b = false;
                    String nome = request.getParameter("nomeGruppo");
                    if (nome != null) {
                        boolean idResult = requestValidator.assertInt("idCategoria", "Id non valido!");
                        if (idResult) {
                            int idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
                            List<Categoria> categorie = CategoriaDAO.doRetrieveAll();
                            for(Categoria c : categorie) {
                                if (c.getId() == idCategoria) {
                                    b = true;
                                    break;
                                }
                            }
                            if(!b) {
                                String message = "Id categoria Sbagliato";
                                request.setAttribute("message", message);
                                address = "/WEB-INF/jsp/error.jsp";
                            }
                            else {
                                Gruppo g = new Gruppo();
                                g.setNome(nome);
                                g.setIdCategoria(idCategoria);
                                GruppoDAO.doSave(g);
                                address = "/ModGruppiServlet";
                            }
                        } else {
                            List<String> errors = requestValidator.getErrors();
                            request.setAttribute("errors", errors);
                            address = "/WEB-INF/jsp/error.jsp";
                        }
                    }

                    break;

                case "modifica" :
                    boolean idResult = requestValidator.assertInt("id", "Id non valido!");
                    if (idResult) {
                        int id = Integer.parseInt(request.getParameter("id"));
                        Gruppo group = GruppoDAO.doRetrieveById(id);
                        request.setAttribute("gruppo", group);
                        address = "/WEB-INF/jsp/modificaGruppo.jsp";
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
                        GruppoDAO.doDelete(idDelete);
                        address = "/ModGruppiServlet";
                    } else {
                        List<String> errors = requestValidator.getErrors();
                        request.setAttribute("errors", errors);
                        address = "/WEB-INF/jsp/error.jsp";
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
}
