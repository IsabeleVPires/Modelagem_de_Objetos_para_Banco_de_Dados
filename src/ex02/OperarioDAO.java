package ex02;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OperarioDAO {
    private Connection conexao;

    public OperarioDAO() {
        this.conexao = ConexaoBD.getInstancia().getConexao();
    }

    public void inserir(Operario operario) throws SQLException {
        String sql = "INSERT INTO Operario (ID_Operario, Nome_Operario, Funcao) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, operario.getIdOperario());
            stmt.setString(2, operario.getNome());
            stmt.setString(3, operario.getCargo());
            stmt.executeUpdate();
        }
    }

    public void atualizar(Operario operario) throws SQLException {
        String sql = "UPDATE Operario SET Nome_Operario = ?, Funcao = ? WHERE ID_Operario = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, operario.getNome());
            stmt.setString(2, operario.getCargo());
            stmt.setInt(3, operario.getIdOperario());
            stmt.executeUpdate();
        }
    }

    public void excluir(int idOperario) throws SQLException {
        String sql = "DELETE FROM Operario WHERE ID_Operario = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idOperario);
            stmt.executeUpdate();
        }
    }

    public Operario buscarPorId(int idOperario) throws SQLException {
        String sql = "SELECT * FROM Operario WHERE ID_Operario = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idOperario);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Operario(
                        rs.getInt("ID_Operario"),
                        rs.getString("Nome_Operario"),
                        rs.getString("Funcao")
                );
            }
            return null;
        }
    }

    public List<Operario> listar() throws SQLException {
        List<Operario> operarios = new ArrayList<>();
        String sql = "SELECT * FROM Operario";
        try (Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                operarios.add(new Operario(
                        rs.getInt("ID_Operario"),
                        rs.getString("Nome_Operario"),
                        rs.getString("Funcao")
                ));
            }
        }
        return operarios;
    }
}
