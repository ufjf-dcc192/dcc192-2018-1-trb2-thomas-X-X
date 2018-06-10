
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

public class ParticipanteDAO {

    private static ParticipanteDAO instancia;
    private static Connection conexao;

    public static ParticipanteDAO getInstace() {
        if (instancia == null) {
            instancia = new ParticipanteDAO();
        }
        return instancia;
    }

    public ParticipanteDAO() {
        try {
            if (conexao == null) {
                conexao = DriverManager.
                        getConnection("jdbc:derby://localhost:1527/dcc-192-2018-1",
                                "usuario", "usuario");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ParticipanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void createParticipante(String nome, String email, String senha ){
        try {
            Statement comando = conexao.createStatement();
            comando.executeUpdate(String.format("INSERT INTO USUARIO.PARTICIPANTE(nome, email, senha) VALUES('%s','%s','%s')", nome, email, senha));
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void deleteParticipante(int codigo){
        try {
            Statement comando = conexao.createStatement();
            comando.executeUpdate(String.format("DELETE FROM USUARIO.PARTICIPANTE where codigo=%d", codigo));
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public List<Participante> listAllParticipantes(){
            List<Participante> participantes = new ArrayList<>();
            try {
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery("SELECT codigo, titulo, email, senha from USUARIO.PARTICIPANTE");
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

