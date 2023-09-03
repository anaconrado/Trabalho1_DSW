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
	
	//insercao
    public void insert(Locacao locacao) {

        String sql = "INSERT INTO Locacao (id, status, data, val, cnpj, cpf, bike_id) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);;

            statement = conn.prepareStatement(sql);
            statement.setString(1, locacao.getId());
            statement.setString(3, locacao.getData());
            statement.setString(4, locacao.getVal());
            statement.setString(5, locacao.getLocadora().getCnpj());
            statement.setString(6, locacao.getCliente().getCpf());
            statement.setLong(7, locacao.getBicicleta().getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //update
    public void update(Locacao locacao) {
        String sql = "UPDATE Locacao SET data = ? WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(2, locacao.getId());
            statement.setString(1, locacao.getData());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    // pega por ID
    public Locacao getbyId(String thisid) {

        String sql = "SELECT * from Locacao l where l.ID = ?";
        Locacao locacao = null;

        try {
        	Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, thisid);
            ResultSet resultSet = statement.executeQuery();          
            while (resultSet.next()){
            System.out.println("dentro do while");
            String id = resultSet.getString("id");
            String status = resultSet.getString("status");
            String data = resultSet.getString("data");
            String val = resultSet.getString("val");
            String cnpj = resultSet.getString("cnpj");
            String cpf = resultSet.getString("cpf");
            Long bike_id = resultSet.getLong("bike_id");
            Cliente cliente = new ClienteDAO().getbyCpf(cpf);
            Bicicleta bicicleta = new BicicletaDAO().get(bike_id);  
            Locadora locadora = new LocadoraDAO().getbyCnpj(cnpj);          
            locacao = new Locacao(id, data, val, locadora, cliente, bicicleta);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return locacao;
    }
    
    //listagens por locacoes e clientes
    public List<Locacao> getAllLocacoes(Usuario usuario) {
    
        List<Locacao> listaLocacoes = new ArrayList<>();

        String sql = "SELECT * from Locacao l where l.CNPJ = ? order by l.ID";

        try {
        	Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, usuario.getCodigo());
            ResultSet resultSet = statement.executeQuery();          
            while (resultSet.next()){
                System.out.println("dentro do while");
                String id = resultSet.getString("id");
                String data = resultSet.getString("data");
                String val = resultSet.getString("val");
                String cnpj = resultSet.getString("cnpj");
                String cpf = resultSet.getString("cpf");
                Long bike_id = resultSet.getLong("bike_id");
                Cliente cliente = new ClienteDAO().getbyCpf(cpf);
                Bicicleta bicicleta = new BicicletaDAO().get(bike_id);  
                Locadora locadora = new LocadoraDAO().getbyCnpj(cnpj);          
                Locacao locacao = new Locacao(id, data, val, locadora, cliente, bicicleta);
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
            	String id = resultSet.getString("id");
                String data = resultSet.getString("data");
                String val = resultSet.getString("val");
                String cnpj = resultSet.getString("cnpj");
                String cpf = resultSet.getString("cpf");
                Long bike_id = resultSet.getLong("bike_id");
                Locadora locadora = new LocadoraDAO().getbyCnpj(cnpj);
                Bicicleta bicicleta = new BicicletaDAO().get(bike_id);   
                Cliente cliente = new ClienteDAO().getbyCpf(cpf);         
                Locacao locacao = new Locacao(id, data, val, locadora, cliente, bicicleta);
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
    
    //verificador de locacoes
    public boolean verifyLocacao(Locacao locacao) {
    
        List<Locacao> listaLocacoes = new ArrayList<>();

        String sql = "SELECT * from Locacao l where (l.CNPJ = ? or l.CPF = ?) and data = ?";

        try {
        	Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, locacao.getLocadora().getCnpj());
            statement.setString(2, locacao.getCliente().getCpf());
            statement.setString(3, locacao.getData());
            
            ResultSet resultSet = statement.executeQuery();          
            while (resultSet.next()){
                System.out.println("dentro do while");
                String id = resultSet.getString("id");
                String data = resultSet.getString("data");
                String val = resultSet.getString("val");
                String cnpj = resultSet.getString("cnpj");
                String cpf = resultSet.getString("cpf");
                Long bike_id = resultSet.getLong("bike_id");
                Cliente cliente = new ClienteDAO().getbyCpf(cpf);
                Bicicleta bicicleta = new BicicletaDAO().get(bike_id);  
                Locadora locadora = new LocadoraDAO().getbyCnpj(cnpj);    
                
                Locacao newlocacao = new Locacao(id, data, val, locadora, cliente, bicicleta);
                listaLocacoes.add(newlocacao);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaLocacoes == null;
    }

}