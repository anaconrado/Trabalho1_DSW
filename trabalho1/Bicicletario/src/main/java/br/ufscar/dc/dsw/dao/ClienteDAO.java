package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import br.ufscar.dc.dsw.domain.Cliente;

public class ClienteDAO extends GenericDAO {
    public void insert(Cliente cliente) {

        String sql = "INSERT INTO Cliente (cpf, telefone, sexo, nascimento) VALUES (?, ?, ?, ?)";
        
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement = conn.prepareStatement(sql);
            statement.setString(1, cliente.getCpf());
            statement.setString(2, cliente.getTelefone());
            statement.setString(3, cliente.getSexo());
            statement.setString(4, cliente.getNascimento());
            
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Cliente> getAll() {

        List<Cliente> listaClientes = new ArrayList<>();

        //String sql = "SELECT * from Cliente c";
        String sql = "select * FROM Cliente JOIN Usuario ON Cliente.cpf = Usuario.codigo;";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String cpf			= resultSet.getString("cpf");
                String telefone 	= resultSet.getString("telefone");
                String sexo			= resultSet.getString("sexo");
                String nascimento 	= resultSet.getString("nascimento");
                String nome 		= resultSet.getString("nome");
                String email 		= resultSet.getString("email");
                String senha 		= resultSet.getString("senha");
                String papel 		= resultSet.getString("papel");
                
                //String cpf, String telefone, String sexo, String nascimento, String nome, String email, String senha, String papel)
                Cliente cliente = new Cliente(cpf, telefone, sexo, nascimento, email, senha, papel, nome);
                listaClientes.add(cliente);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaClientes;
        
    }

    public void delete(Cliente cliente) {
        String sql = "DELETE FROM Cliente where cpf = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, cliente.getCpf());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
        }
    }

    public void update(Cliente cliente) {
        String sql = "UPDATE Cliente SET telefone = ?, sexo = ?, nascimento = ? WHERE cpf = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, cliente.getTelefone());
            statement.setString(2, cliente.getSexo());	
            statement.setString(3, cliente.getNascimento());
            statement.setString(4, cliente.getCpf());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Cliente getbyCpf(String cpf) {
        Cliente cliente = null;

        String sql = "SELECT * from Cliente JOIN Usuario ON Cliente.cpf = Usuario.codigo WHERE cpf = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, cpf);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String telefone 	= 	resultSet.getString("telefone");
                String sexo			= 	resultSet.getString("sexo");
                String nascimento   = 	resultSet.getString("nascimento");
                String nome         = resultSet.getString("nome");
                String email        = resultSet.getString("email");
                String senha        = resultSet.getString("senha");
                String papel        = resultSet.getString("papel");
                
                //String cpf, String telefone, String sexo, String nascimento, String nome, String email, String senha, String papel)
                cliente = new Cliente(cpf, telefone, sexo, nascimento, email, senha, papel, nome);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cliente;
    }
    
}