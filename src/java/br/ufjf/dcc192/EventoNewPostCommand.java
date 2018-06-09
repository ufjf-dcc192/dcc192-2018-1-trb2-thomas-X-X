package br.ufjf.dcc192;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EventoNewPostCommand implements Comando{
        @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm");
        String titulo = request.getParameter("titulo");
        Double minimo = Double.parseDouble(request.getParameter("minimo"));
        Date dataSorteio = (Date)format.parse(request.getParameter("dataSorteio"));
        Date dataInicio = (Date)format.parse(request.getParameter("dataInicio"));
        
        EventoDAO.getInstance().createEvento(titulo, minimo, dataInicio,dataSorteio);
        response.sendRedirect("eventos.html");
        }catch(IOException | NumberFormatException | ParseException e){
            
        }
    }
}
