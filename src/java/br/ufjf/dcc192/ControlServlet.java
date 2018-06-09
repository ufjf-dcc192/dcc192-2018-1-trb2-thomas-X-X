package br.ufjf.dcc192;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControlServlet", urlPatterns = {"/index.html", "/control.html", "/eventos.html", "/novoevento.html", "/inscricao.html", "/amigo.html", "/inscritos.html"})
public class ControlServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> rotas = new HashMap<>();        
        rotas.put("/index.html", "br.ufjf.dcc192.IndexCommand");
        rotas.put("/eventos.html", "br.ufjf.dcc192.ListarEventosCommand");
        rotas.put("/novoevento.html", "br.ufjf.dcc192.EventoNewCommand");
        
        String clazzName = rotas.get(request.getServletPath());
        try {
            Comando comando = (Comando) Class.forName(clazzName).newInstance();
            comando.exec(request, response);
        } catch (ClassNotFoundException|IllegalAccessException|InstantiationException ex) {
            response.sendError(500, "Erro: "+ex);
            Logger.getLogger(ControlServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> rotas = new HashMap<>();
        rotas.put("/novoevento.html", "br.ufjf.dcc192.EventoNewPostCommand");
        rotas.put("/novoevento.html", "br.ufjf.dcc192.EventoDeletePostCommand");
        //rotas.put("/inscricao.html", "br.ufjf.dcc192.EventoDeletePostCommand");

        
        String clazzName = rotas.get(request.getServletPath());
        try {
            Comando comando = (Comando) Class.forName(clazzName).newInstance();
            comando.exec(request, response);
        } catch (ClassNotFoundException|IllegalAccessException|InstantiationException ex) {
            response.sendError(500, "Erro: "+ex);
            Logger.getLogger(ControlServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
