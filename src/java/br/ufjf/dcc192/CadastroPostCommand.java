package br.ufjf.dcc192;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastroPostCommand implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
                Participante p = new Participante();
                String nome =request.getParameter("nome");
                String email = request.getParameter("email");
                String senha = request.getParameter("senha");
                ParticipanteDAO.getInstace().createParticipante(nome, email, senha);
                response.sendRedirect("index.html");
    }
}

    
