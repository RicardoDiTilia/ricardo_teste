package com.races.api.repository;

import com.races.api.model.Motorista;
import com.races.api.model.StatusMotorista;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MotoristaRepository {

    private final String url = "jdbc:mysql://localhost:3306/corridas_db";
    private final String user = "root";
    private final String password = "20060227";

    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public Motorista salvar(Motorista motorista) throws SQLException {
        String sql = "INSERT INTO motorista (nome, data_nascimento, cpf, modelo_carro, status) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, motorista.getNome());
            stmt.setDate(2, Date.valueOf(motorista.getDataNascimento()));
            stmt.setString(3, motorista.getCpf());
            stmt.setString(4, motorista.getModeloCarro());
            stmt.setString(5, motorista.getStatus().name());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                motorista.setId(rs.getLong(1));
            }
            return motorista;
        }
    }

    public List<Motorista> findAll() throws SQLException {
        List<Motorista> lista = new ArrayList<>();
        String sql = "SELECT * FROM motorista";
        try (Connection conn = conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(mapear(rs));
            }
        }
        return lista;
    }

    public Optional<Motorista> findById(Long id) throws SQLException {
        String sql = "SELECT * FROM motorista WHERE id = ?";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return Optional.of(mapear(rs));
            }
        }
        return Optional.empty();
    }

    public boolean existsByCpf(String cpf) throws SQLException {
        String sql = "SELECT COUNT(*) FROM motorista WHERE cpf = ?";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        }
        return false;
    }

    public boolean existsById(Long id) throws SQLException {
        String sql = "SELECT COUNT(*) FROM motorista WHERE id = ?";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            return rs.next() && rs.getInt(1) > 0;
        }
    }

    public void deleteById(Long id) throws SQLException {
        String sql = "DELETE FROM motorista WHERE id = ?";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

    public Motorista atualizarStatus(Long id, StatusMotorista status) throws SQLException {
        String sql = "UPDATE motorista SET status = ? WHERE id = ?";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, status.name());
            stmt.setLong(2, id);
            stmt.executeUpdate();
        }
        return findById(id).orElse(null);
    }

    public List<Motorista> findByStatus(StatusMotorista status) throws SQLException {
        List<Motorista> lista = new ArrayList<>();
        String sql = "SELECT * FROM motorista WHERE status = ?";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, status.name());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                lista.add(mapear(rs));
            }
        }
        return lista;
    }

    private Motorista mapear(ResultSet rs) throws SQLException {
        Motorista m = new Motorista();
        m.setId(rs.getLong("id"));
        m.setNome(rs.getString("nome"));
        m.setCpf(rs.getString("cpf"));
        m.setModeloCarro(rs.getString("modelo_carro"));
        m.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
        m.setStatus(StatusMotorista.valueOf(rs.getString("status")));
        return m;
    }
}
