package br.ufjf.dcc192;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
                conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/dcc19220181", "usuario", "senha");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Evento> listAllEventos() {
        List<Evento> eventos = new ArrayList<>();
        try {
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery("SELECT titulo, codigo, minimo, data Inicio, dataSorteio from EVENTO");
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

    void createEvento(String titulo) {
        try {
            Statement comando = conexao.createStatement();
            comando.executeUpdate(String.format("INSERT INTO evento(titulo) VALUES('%s')", titulo));
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void deleteEvento(int codigo){
        try {
            Statement comando = conexao.createStatement();
            comando.executeUpdate(String.format("DELETE FROM evento WHERE codigo=%d", codigo));
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void createParticipante(){
        
    }
    
    void deleteParticipante(){
        
    }
        public List<Participante> listAllParticipantes(){
            List<Participante> participantes = new ArrayList<>();
            try {
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery("SELECT titulo,codigo,email,senha from EVENTO");
            while (resultado.next()) {
                Participante participante = new Participante();
                
                participante.setNome(resultado.getString("titulo"));
                participante.setCodigo(resultado.getInt("codigo"));
                participante.setEmail(resultado.getString("email"));
                participante.setSenha(resultado.getString("senha"));
                
                participantes.add(participante);

            }
            resultado.close();
            comando.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return participantes;
        }         
        
} 
