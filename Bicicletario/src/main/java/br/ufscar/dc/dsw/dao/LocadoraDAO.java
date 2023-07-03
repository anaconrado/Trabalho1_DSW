package br.ufscar.dc.dsw.dao;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Locadora;

public class LocadoraDAO extends GenericDAO{
    
    //Metodo que pega todas as locadoras
    public List<Locadora> getAll(){
        List<Locadora> listLoc = new ArrayList<>();

        String sql = "SELECT * FROM Locadora l";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                
                String cnpj = resultSet.getString("cnpj");
                String desc = resultSet.getString("descricao");
                String cidade = resultSet.getString("cidade");
                Locadora loc = new Locadora(cnpj, desc, cidade);
                listLoc.add(loc);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listLoc;
    }

    public List<Locadora> listLocadorasPorCidade(String cid){
        List<Locadora> listLocC = new ArrayList<>();

        String sql = "SELECT * FROM Locadora WHERE cidade = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, cid);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                
                String cnpj = resultSet.getString("cnpj");
                String desc = resultSet.getString("descricao");
                Locadora loc = new Locadora(cnpj, desc, cid);
                listLocC.add(loc);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listLocC;
    }
}
