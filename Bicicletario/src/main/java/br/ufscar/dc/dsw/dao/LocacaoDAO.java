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

public class LocacaoDAO extends GenericDAO {

    public void insert(Locacao locacao) {

        String sql = "INSERT INTO Locacao (id, status, data, val, cnpj, cpf, bike_id, usuario_id) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);;

            statement = conn.prepareStatement(sql);
            statement.setString(1, locacao.getStatus());
            statement.setString(2, locacao.getData());
            statement.setFloat(3, locacao.getVal());
            statement.setString(4, locacao.getCnpj());
            statement.setString(5, locacao.getCpf());
            statement.setLong(6, locacao.getBicicleta().getId());
            statement.setString(7, locacao.getUsuario().getCodigo());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Locacao> getAll(Usuario usuario) {

        List<Locacao> listaLocacoes = new ArrayList<>();

        String sql = "SELECT * from locacao l where l.USUARIO_CODIGO = ? order by l.CODIGO";

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
                Long livroId = resultSet.getLong("livro_id");
                Long bike_id = resultSet.getLong("bike_id");
                Bicicleta bicicleta = new BicicletaDAO().get(bike_id);            
                Locacao locacao = new Locacao(id, status, data, val, cnpj, cpf, bicicleta, usuario);
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