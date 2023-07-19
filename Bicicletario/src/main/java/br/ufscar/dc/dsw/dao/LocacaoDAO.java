package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Locacao;
import br.ufscar.dc.dsw.domain.Bicicleta;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.domain.Locadora;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.dao.LocadoraDAO;
import br.ufscar.dc.dsw.dao.ClienteDAO;

public class LocacaoDAO extends GenericDAO {

    public void insert(Locacao locacao) {

        String sql = "INSERT INTO Locacao (status, data, val, cnpj, cpf, bike_id) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);;

            statement = conn.prepareStatement(sql);
            statement.setString(1, locacao.getStatus());
            statement.setString(2, locacao.getData());
            statement.setFloat(3, locacao.getVal());
            statement.setString(4, locacao.getLocadora().getCnpj());
            statement.setString(5, locacao.getCliente().getCpf());
            statement.setLong(6, locacao.getBicicleta().getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Locacao> getAllLocadora(Usuario usuario) {
    
        List<Locacao> listaLocacoes = new ArrayList<>();

        String sql = "SELECT * from Locacao l where l.CNPJ = ? order by l.ID";

        try {
        	Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, usuario.getCodigo());
            ResultSet resultSet = statement.executeQuery();          
            while (resultSet.next()){
                System.out.println("dentro do while");
                Long id = resultSet.getLong("id");
                String status = resultSet.getString("status");
                String data = resultSet.getString("data");
                Float val = resultSet.getFloat("val");
                String cnpj = resultSet.getString("cnpj");
                String cpf = resultSet.getString("cpf");
                Long bike_id = resultSet.getLong("bike_id");
                Cliente cliente = new ClienteDAO().getbyCpf(cpf);
                Bicicleta bicicleta = new BicicletaDAO().get(bike_id);  
                Locadora locadora = new LocadoraDAO().getbyCnpj(cnpj);          
                Locacao locacao = new Locacao(id, status, data, val, locadora, cliente, bicicleta);
                listaLocacoes.add(locacao);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaLocacoes;
    }

    public List<Locacao> getAllCliente(Usuario usuario) {

        List<Locacao> listaLocacoes = new ArrayList<>();

        String sql = "SELECT * from Locacao l where l.CPF = ? order by l.ID";

        try {
        	Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, usuario.getCodigo());
            ResultSet resultSet = statement.executeQuery(); 
            
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String status = resultSet.getString("status");
                String data = resultSet.getString("data");
                Float val = resultSet.getFloat("val");
                String cnpj = resultSet.getString("cnpj");
                String cpf = resultSet.getString("cpf");
                Long bike_id = resultSet.getLong("bike_id");
                Locadora locadora = new LocadoraDAO().getbyCnpj(cnpj);
                Bicicleta bicicleta = new BicicletaDAO().get(bike_id);   
                Cliente cliente = new ClienteDAO().getbyCpf(cpf);         
                Locacao locacao = new Locacao(id, status, data, val, locadora, cliente, bicicleta);
                listaLocacoes.add(locacao);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaLocacoes;
    }
}