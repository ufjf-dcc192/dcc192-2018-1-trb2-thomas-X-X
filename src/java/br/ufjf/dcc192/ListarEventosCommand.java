package br.ufjf.dcc192;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListarEventosCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/eventos/listevento.jsp");
        List<Evento> eventos = EventoDAO.getInstance().listAllEventos();
        request.setAttribute("titulos", "Lista de Eventos");
        request.setAttribute("eventos", eventos);
        dispacher.forward(request, response);
    }

}