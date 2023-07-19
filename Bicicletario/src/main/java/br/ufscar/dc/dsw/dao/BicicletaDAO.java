package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import br.ufscar.dc.dsw.domain.Bicicleta;

public class BicicletaDAO extends GenericDAO {

    public void insert(Bicicleta bicicleta) {

        String sql = "INSERT INTO Bicicleta (id) VALUES (?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);;

            statement = conn.prepareStatement(sql);
            statement.setLong(1, bicicleta.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Bicicleta get(Long id) {
    	Bicicleta bicicleta = null;

        String sql = "SELECT * from Bicicleta b where b.ID = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                bicicleta = new Bicicleta(id);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bicicleta;
    }

}