package com.races.api.repository;

import com.races.api.model.Passageiro;
import com.races.api.model.Sexo;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PassageiroRepository {

    private final String url = "jdbc:mysql://localhost:3306/corridas_db";
    private final String user = "root";
    private final String password = "20060227";

    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public Passageiro save(Passageiro passageiro) throws SQLException {
        String sql = "INSERT INTO passageiro (nome, data_nascimento, cpf, sexo) VALUES (?, ?, ?, ?)";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, passageiro.getNome());
            stmt.setDate(2, Date.valueOf(passageiro.getDataNascimento()));
            stmt.setString(3, passageiro.getCpf());
            stmt.setString(4, passageiro.getSexo().name()); 
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                passageiro.setId(rs.getLong(1));
            }

            return passageiro;
        }
    }

    public List<Passageiro> findAll() throws SQLException {
        List<Passageiro> lista = new ArrayList<>();
        String sql = "SELECT * FROM passageiro";

        try (Connection conn = conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(mapear(rs));
            }
        }
        return lista;
    }

    public Passageiro findByCpf(String cpf) throws SQLException {
        String sql = "SELECT * FROM passageiro WHERE cpf = ?";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapear(rs);
            }
        }
        return null;
    }

    private Passageiro mapear(ResultSet rs) throws SQLException {
        Passageiro p = new Passageiro();
        p.setId(rs.getLong("id"));
        p.setNome(rs.getString("nome"));
        p.setCpf(rs.getString("cpf"));
        p.setSexo(Sexo.valueOf(rs.getString("sexo"))); 
        p.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
        return p;
    }
}
