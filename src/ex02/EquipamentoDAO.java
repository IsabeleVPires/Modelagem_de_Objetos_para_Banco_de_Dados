package ex02;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquipamentoDAO {
    private Connection conexao;

    public EquipamentoDAO() {
        this.conexao = ConexaoBD.getInstancia().getConexao();
    }

    public void inserir(Equipamento equipamento) throws SQLException {
        String sql = "INSERT INTO Equipamento (ID_Equipamento, Nome_Equipamento, Tipo) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, equipamento.getIdEquipamento());
            stmt.setString(2, equipamento.getNome());
            stmt.setString(3, equipamento.getTipo());
            stmt.executeUpdate();
        }
    }

    public void atualizar(Equipamento equipamento) throws SQLException {
        String sql = "UPDATE Equipamento SET Nome_Equipamento = ?, Tipo = ? WHERE ID_Equipamento = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, equipamento.getNome());
            stmt.setString(2, equipamento.getTipo());
            stmt.setInt(3, equipamento.getIdEquipamento());
            stmt.executeUpdate();
        }
    }

    public void excluir(int idEquipamento) throws SQLException {
        String sql = "DELETE FROM Equipamento WHERE ID_Equipamento = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idEquipamento);
            stmt.executeUpdate();
        }
    }

    public Equipamento buscarPorId(int idEquipamento) throws SQLException {
        String sql = "SELECT * FROM Equipamento WHERE ID_Equipamento = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idEquipamento);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Equipamento(
                        rs.getInt("ID_Equipamento"),
                        rs.getString("Nome_Equipamento"),
                        rs.getString("Tipo")
                );
            }
            return null;
        }
    }

    public List<Equipamento> listar() throws SQLException {
        List<Equipamento> equipamentos = new ArrayList<>();
        String sql = "SELECT * FROM Equipamento";
        try (Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                equipamentos.add(new Equipamento(
                        rs.getInt("ID_Equipamento"),
                        rs.getString("Nome_Equipamento"),
                        rs.getString("Tipo")
                ));
            }
        }
        return equipamentos;
    }
}
