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

@WebServlet(name = "AggiungiGruppoServlet", value = "/AggiungiGruppoServlet")
public class AggiungiGruppoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean b = false;
        String address;
        String nome = request.getParameter("nomeGruppo");
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

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }
}
