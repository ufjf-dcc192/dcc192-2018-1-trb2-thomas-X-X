package br.ufjf.dcc192;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastroCommand implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
            RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/cadastrar.jsp");
            request.setAttribute("titulo","Novo Usuario");
            request.setAttribute("codigoUsuario", request.getParameter("codigoUsuario"));
            dispacher.forward(request, response);
            
    }
}

    
