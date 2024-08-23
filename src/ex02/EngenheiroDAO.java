package ex02;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EngenheiroDAO {
    private Connection conexao;

    public EngenheiroDAO() {
        this.conexao = ConexaoBD.getInstancia().getConexao();
    }

    public void inserir(Engenheiro engenheiro) throws SQLException {
        String sql = "INSERT INTO Engenheiro (ID_Engenheiro, Nome_Engenheiro, Especialidade) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, engenheiro.getIdEngenheiro());
            stmt.setString(2, engenheiro.getNome());
            stmt.setString(3, engenheiro.getEspecialidade());
            stmt.executeUpdate();
        }
    }

    public void atualizar(Engenheiro engenheiro) throws SQLException {
        String sql = "UPDATE Engenheiro SET Nome_Engenheiro = ?, Especialidade = ? WHERE ID_Engenheiro = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, engenheiro.getNome());
            stmt.setString(2, engenheiro.getEspecialidade());
            stmt.setInt(3, engenheiro.getIdEngenheiro());
            stmt.executeUpdate();
        }
    }

    public void excluir(int idEngenheiro) throws SQLException {
        String sql = "DELETE FROM Engenheiro WHERE ID_Engenheiro = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idEngenheiro);
            stmt.executeUpdate();
        }
    }

    public Engenheiro buscarPorId(int idEngenheiro) throws SQLException {
        String sql = "SELECT * FROM Engenheiro WHERE ID_Engenheiro = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idEngenheiro);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Engenheiro(
                        rs.getInt("ID_Engenheiro"),
                        rs.getString("Nome_Engenheiro"),
                        rs.getString("Especialidade")
                );
            }
            return null;
        }
    }

    public List<Engenheiro> listar() throws SQLException {
        List<Engenheiro> engenheiros = new ArrayList<>();
        String sql = "SELECT * FROM Engenheiro";
        try (Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                engenheiros.add(new Engenheiro(
                        rs.getInt("ID_Engenheiro"),
                        rs.getString("Nome_Engenheiro"),
                        rs.getString("Especialidade")
                ));
            }
        }
        return engenheiros;
    }
}
