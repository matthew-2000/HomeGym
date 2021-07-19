package control.Admin;

import model.Categoria;
import model.CategoriaDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ModificaCategoriaServlet", value = "/ModificaCategoriaServlet")
public class ModificaCategoriaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String azione = request.getParameter("azione");
        System.out.println(azione);
        String address = "";
        switch (azione){

            case "aggiungi" : //Aggiungi
                String nome = request.getParameter("nomeCategoria");
                String descrizione = request.getParameter("descrizioneCategoria");
                Categoria categoria = new Categoria();
                categoria.setNome(nome);
                categoria.setDescrizione(descrizione);
                CategoriaDAO.doSave(categoria);
                address = "/ModCategorieServlet";
                break;

            case "modifica" : //Modifica
                int id = Integer.parseInt(request.getParameter("id"));
                Categoria cat = CategoriaDAO.doRetrieveById(id);
                request.setAttribute("categoria", cat);
                address = "/WEB-INF/jsp/modificaCategoria.jsp";
                break;

            case "elimina" : //Elimina
                int idDelete = Integer.parseInt(request.getParameter("id"));
                CategoriaDAO.doDelete(idDelete);
                address = "/ModCategorieServlet";
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
