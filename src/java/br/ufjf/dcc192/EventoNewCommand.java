
package br.ufjf.dcc192;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EventoNewCommand implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/novoevento.jsp");
        List<Evento> eventos = EventoDAO.getInstance().listAllEventos();
        request.setAttribute("titulo", "Novo Evento");
        dispacher.forward(request, response);
    }
    
} 