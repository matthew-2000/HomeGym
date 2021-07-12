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

@WebServlet(name = "ModificaGroupServlet", value = "/ModificaGroupServlet")
public class ModificaGroupServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean b = false;
        String address = "";
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        int idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
        List<Categoria> categorie = CategoriaDAO.doRetrieveAll();


        for(Categoria c : categorie) {
            if(c.getId() == idCategoria) {
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
            g.setId(id);
            g.setNome(nome);
            g.setIdCategoria(idCategoria);
            HttpSession session = request.getSession();
            Gruppo group = (Gruppo) session.getAttribute("gruppo");

            if(!g.equals(group)) {
                GruppoDAO.doUpdate(g);
                session.setAttribute("gruppo", g);
            }
            address = "/ModGruppiServlet";
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
