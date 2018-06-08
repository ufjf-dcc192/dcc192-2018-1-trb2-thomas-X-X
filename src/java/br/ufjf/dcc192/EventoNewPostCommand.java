package br.ufjf.dcc192;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EventoNewPostCommand implements Comando{
        @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titulo = request.getParameter("titulo");
        EventoDAO.getInstance().create(titulo);
        response.sendRedirect("tarefas.html");
    }
}
