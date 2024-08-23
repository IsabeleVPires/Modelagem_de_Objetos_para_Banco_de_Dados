package ex02;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import seu.pacote.Material;

public class MaterialDAO {
    private Connection conexao;

    public MaterialDAO() {
        this.conexao = ConexaoBD.getInstancia().getConexao();
    }

    public void inserir(ex02.Material material) throws SQLException {
        String sql = "INSERT INTO Material (ID_Material, Nome_Material, Quantidade) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, material.getIdMaterial());
            stmt.setString(2, material.getIdMaterial());
            stmt.setBigDecimal(3, material.getQuantidade());
            stmt.executeUpdate();
        }
    }

    public void atualizar(Material material) throws SQLException {
        String sql = "UPDATE Material SET Nome_Material = ?, Quantidade = ? WHERE ID_Material = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, material.getNome());
            stmt.setBigDecimal(2, material.getQuantidade());
            stmt.setInt(3, material.getIdMaterial());
            stmt.executeUpdate();
        }
    }

    public void excluir(int idMaterial) throws SQLException {
        String sql = "DELETE FROM Material WHERE ID_Material = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idMaterial);
            stmt.executeUpdate();
        }
    }

    public Material buscarPorId(int idMaterial) throws SQLException {
        String sql = "SELECT * FROM Material WHERE ID_Material = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idMaterial);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Material(
                        rs.getInt("ID_Material"),
                        rs.getString("Nome_Material"),
                        rs.getBigDecimal("Quantidade")
                );
            }
            return null;
        }
    }

    public List<Material> listar() throws SQLException {
        List<Material> materiais = new ArrayList<>();
        String sql = "SELECT * FROM Material";
        try (Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                materiais.add(new Material(
                        rs.getInt("ID_Material"),
                        rs.getString("Nome_Material"),
                        rs.getBigDecimal("Quantidade")
                ));
            }
        }
        return materiais;
    }
}
