package control.Admin;

import java.util.List;
import model.Categoria;
import model.CategoriaDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import model.RequestValidator;

@WebServlet(name = "ModificaCategoriaServlet", value = "/ModificaCategoriaServlet")
public class ModificaCategoriaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String azione = request.getParameter("azione");

        if (azione != null) {
            String address = "";
            RequestValidator requestValidator = new RequestValidator(request);

            switch (azione){

                case "aggiungi" : //Aggiungi
                    String nome = request.getParameter("nomeCategoria");
                    String descrizione = request.getParameter("descrizioneCategoria");
                    if (nome != null && descrizione != null) {
                        Categoria categoria = new Categoria();
                        categoria.setNome(nome);
                        categoria.setDescrizione(descrizione);
                        CategoriaDAO.doSave(categoria);
                        address = "/ModCategorieServlet";
                    } else {
                        String error = "Errore durante il caricamento della pagina";
                        request.setAttribute("message", error);
                        address = "/WEB-INF/jsp/error.jsp";
                    }
                    break;

                case "modifica" : //Modifica
                    boolean idResult = requestValidator.assertInt("id", "Id non valido!");
                    if (idResult) {
                        int id = Integer.parseInt(request.getParameter("id"));
                        Categoria cat = CategoriaDAO.doRetrieveById(id);
                        request.setAttribute("categoria", cat);
                        address = "/WEB-INF/jsp/modificaCategoria.jsp";
                    } else {
                        List<String> errors = requestValidator.getErrors();
                        request.setAttribute("errors", errors);
                        address = "/WEB-INF/jsp/error.jsp";
                    }
                    break;

                case "elimina" : //Elimina
                    boolean idResult2 = requestValidator.assertInt("id", "Id non valido!");
                    if (idResult2) {
                        int idDelete = Integer.parseInt(request.getParameter("id"));
                        CategoriaDAO.doDelete(idDelete);
                        address = "/ModCategorieServlet";
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
        } else {
            String error = "Errore durante il caricamento della pagina";
            request.setAttribute("message", error);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
            dispatcher.forward(request, response);
        }

    }
}
