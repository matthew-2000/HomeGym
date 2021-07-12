package control.Admin;

import model.Categoria;
import model.CategoriaDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AggiungiCategoriaServlet", value = "/AggiungiCategoriaServlet")
public class AggiungiCategoriaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      /*  doPost(request, response);*/
        String nome = request.getParameter("nomeCategoria");
        String descrizione = request.getParameter("descrizioneCategoria");

        Categoria categoria = new Categoria();
        categoria.setNome(nome);
        categoria.setDescrizione(descrizione);

        CategoriaDAO.doSave(categoria);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/ModCategorieServlet");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
