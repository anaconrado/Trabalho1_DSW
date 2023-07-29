
package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import br.ufscar.dc.dsw.domain.Locadora;

public class LocadoraDAO extends GenericDAO {
    public void insert(Locadora locadora) {

        String sql = "INSERT INTO Locadora (cnpj, cidade) VALUES (?, ?)";
        
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement = conn.prepareStatement(sql);
            statement.setString(1, locadora.getCnpj());
            statement.setString(2, locadora.getCidade());
            
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Locadora> getAll() {

        List<Locadora> listaLocadoras = new ArrayList<>();

        //String sql = "SELECT * from Locadora c";
        String sql = "select cnpj, cidade, email, senha, papel, nome FROM Locadora JOIN Usuario ON Locadora.cnpj = Usuario.codigo;";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String cnpj		= resultSet.getString("cnpj");
                String cidade	= resultSet.getString("cidade");
                String email 	= resultSet.getString("email");
                String senha 	= resultSet.getString("senha");
                String papel 	= resultSet.getString("papel");
                String nome		= resultSet.getString("nome");
                
                //String cpf, String telefone, String sexo, String nascimento, String nome, String email, String senha, String papel)
                Locadora locadora = new Locadora(cnpj, cidade, email, senha, papel, nome);
                listaLocadoras.add(locadora);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaLocadoras;
        
    }

    public List<Locadora> getLocadoras() {

        List<Locadora> listaLocadoras = new ArrayList<>();

        //String sql = "SELECT * from Locadora c";
        String sql = "select cnpj, cidade, email, nome FROM Locadora JOIN Usuario ON Locadora.cnpj = Usuario.codigo;";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String cnpj		= resultSet.getString("cnpj");
                String cidade	= resultSet.getString("cidade");
                String email 	= resultSet.getString("email");
                //String senha 	= resultSet.getString("senha");
                //String papel 	= resultSet.getString("papel");
                String nome		= resultSet.getString("nome");
                
                //String cpf, String telefone, String sexo, String nascimento, String nome, String email, String senha, String papel)
                Locadora locadora = new Locadora(cnpj, cidade, email, "Locadoras", nome);
                listaLocadoras.add(locadora);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaLocadoras;
        
    }

    public List<Locadora> getByCidade(String cidade){
        List<Locadora> listaLocadoras = new ArrayList<>();

        //String sql = "SELECT * from Locadora c";
        //String sql = "select cnpj, email, senha, papel, nome FROM Locadora JOIN Usuario ON Locadora.cnpj = Usuario.codigo;";
        String sql = "SELECT codigo, nome, email, cidade FROM Usuario JOIN Locadora ON Usuario.codigo = Locadora.cnpj WHERE Usuario.papel = 'LOCADORA' AND cidade = ?;";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, cidade);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String cnpj		= resultSet.getString("cnpj");
                //String cidade	= resultSet.getString("cidade");
                String email 	= resultSet.getString("email");
                //String senha 	= resultSet.getString("senha");
                //String papel 	= resultSet.getString("papel");
                String nome		= resultSet.getString("nome");
                
                //String cpf, String telefone, String sexo, String nascimento, String nome, String email, String senha, String papel)
                Locadora locadora = new Locadora(cnpj, cidade, email, "Locadora", nome);
                listaLocadoras.add(locadora);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaLocadoras;
    } 

    public void delete(Locadora locadora) {
        String sql = "DELETE FROM Locadora where cnpj = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, locadora.getCnpj());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
        }
    }

    public void update(Locadora locadora) {
        String sql = "UPDATE Locadora SET cidade = ? WHERE cnpj = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, locadora.getCidade());
            statement.setString(2, locadora.getCnpj());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Locadora getbyCnpj(String cnpj) {
        Locadora locadora = null;

        String sql = "SELECT * from Locadora JOIN Usuario ON Locadora.cnpj = Usuario.codigo WHERE cnpj = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, cnpj);
            ResultSet resultSet = statement.executeQuery();
            

            if (resultSet.next()) {
                String cidade	= 	resultSet.getString("cidade");
                String nome 	= resultSet.getString("nome");
                String email 	= resultSet.getString("email");
                String senha 	= resultSet.getString("senha");
                String papel 	= resultSet.getString("papel");
                
                //String cpf, String telefone, String sexo, String nascimento, String nome, String email, String senha, String papel)
                locadora = new Locadora(cnpj, cidade, email, senha, papel, nome);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return locadora;
    }
    
}