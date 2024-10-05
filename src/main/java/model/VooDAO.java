package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class VooDAO {
    private DataSource dataSource;

    public VooDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public ArrayList<Voo> consultarVoos(Voo voo) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<Voo> listaVoos = new ArrayList<>();
        try {
            connection = dataSource.getConnection();
            String sql = "SELECT * FROM voos WHERE origem=? AND destino=? AND data=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, voo.getOrigem());
            statement.setString(2, voo.getDestino());
            statement.setString(3, voo.getData());
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Voo adicionar = new Voo(resultSet.getString("origem"), resultSet.getString("destino"), resultSet.getString("data"), voo.getQtdPessoas());
                adicionar.setValor(resultSet.getDouble("valor"));
                adicionar.setHorario(resultSet.getString("horario"));
                listaVoos.add(adicionar);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(connection, statement, resultSet);
        }
        return listaVoos;
    }
    
    private void fecharConexao(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        try {
            if (connection != null) connection.close();
            if (statement != null) statement.close();
            if (resultSet != null) resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
