package br.ufjf.dcc192;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EventoDAO {

    private static Connection conexao;
    private static EventoDAO instancia;

    public static EventoDAO getInstance() {
        if (instancia == null) {
            instancia = new EventoDAO();
        }
        return instancia;
    }

    public EventoDAO() {
        try {
            if (conexao == null) {
                conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/dcc192-2018-1-trb2-thomas-X-X", "usuario", "senha");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Evento> listAllEventos() {
        List<Evento> eventos = new ArrayList<>();
        try {
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery("SELECT codigo, titulo, minimo, dataInicio, dataSorteio from USUARIO.EVENTO");
            while (resultado.next()) {
                Evento evento = new Evento();
                evento.setTitulo(resultado.getString("titulo"));
                evento.setCodigo(resultado.getInt("codigo"));
                evento.setMinimo(resultado.getDouble("minimo"));
                evento.setData(resultado.getDate("dataInicio"));
                evento.setSorteio(resultado.getDate("dataSorteio"));
                eventos.add(evento);

            }
            resultado.close();
            comando.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return eventos;
    }

    void createEvento(String titulo, double minimo,Date dataInicio,Date dataSorteio) {
        try {
            
            String sql = "INSERT INTO USUARIO.EVENTO" + " (titulo, minimo, dataInicio, dataSorteio)" + " VALUES (?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            Date dataIni = dataInicio;
            Date dataSort = dataSorteio;
            Calendar calendario = Calendar.getInstance();
            calendario.setTime(dataIni);
            calendario.setTime(dataSort);   
            Timestamp dataSqlInicio = new Timestamp(dataIni.getTime());
            Timestamp dataSqlSorteio = new Timestamp(dataSort.getTime());
            
            comando.clearParameters();          
            comando.setString(1, titulo);
            comando.setDouble(2, minimo);
            comando.setTimestamp(3, dataSqlInicio);
            comando.setTimestamp(4, dataSqlSorteio);
            
            comando.execute();
            comando.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void deleteEvento(int codigo){
        try {
            Statement comando = conexao.createStatement();
            comando.executeUpdate(String.format("DELETE FROM USUARIO.EVENTO WHERE codigo=%d", codigo));
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
} 
