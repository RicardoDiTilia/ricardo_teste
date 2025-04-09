package com.races.api.repository;

import com.races.api.model.Corrida;
import com.races.api.model.Motorista;
import com.races.api.model.Passageiro;
import com.races.api.model.StatusCorrida;
import com.races.api.model.StatusMotorista;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CorridaRepository {

    private final String url = "jdbc:mysql://localhost:3306/corridas_db";
    private final String user = "root";
    private final String password = "20060227";

    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public Corrida save(Corrida corrida) throws SQLException {
        String sql = "INSERT INTO corrida (motorista_id, passageiro_id, valor, data_hora, status) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setLong(1, corrida.getMotorista().getId());
            stmt.setLong(2, corrida.getPassageiro().getId());
            stmt.setDouble(3, corrida.getValor());
            stmt.setTimestamp(4, Timestamp.valueOf(corrida.getDataHora() != null ? corrida.getDataHora() : LocalDateTime.now()));
            stmt.setString(5, corrida.getStatus().name());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                corrida.setId(rs.getLong(1));
            }
            return corrida;
        }
    }

    public List<Corrida> findAll() throws SQLException {
        List<Corrida> lista = new ArrayList<>();
        String sql = "SELECT c.*, m.nome as nome_motorista, m.status as status_motorista, p.nome as nome_passageiro FROM corrida c\n" +
                     "JOIN motorista m ON c.motorista_id = m.id\n" +
                     "JOIN passageiro p ON c.passageiro_id = p.id";

        try (Connection conn = conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Corrida corrida = new Corrida();
                corrida.setId(rs.getLong("id"));
                corrida.setValor(rs.getDouble("valor"));
                corrida.setDataHora(rs.getTimestamp("data_hora").toLocalDateTime());
                corrida.setStatus(StatusCorrida.valueOf(rs.getString("status")));

                Motorista m = new Motorista();
                m.setId(rs.getLong("motorista_id"));
                m.setNome(rs.getString("nome_motorista"));
                m.setStatus(StatusMotorista.valueOf(rs.getString("status_motorista")));
                corrida.setMotorista(m);

                Passageiro p = new Passageiro();
                p.setId(rs.getLong("passageiro_id"));
                p.setNome(rs.getString("nome_passageiro"));
                corrida.setPassageiro(p);

                lista.add(corrida);
            }
        }
        return lista;
    }
}
