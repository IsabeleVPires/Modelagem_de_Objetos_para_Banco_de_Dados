package ex02;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjetoDAO {
    private Connection conexao;

    public ProjetoDAO() {
        this.conexao = ConexaoBD.getInstancia().getConexao();
    }

    public void inserir(Projeto projeto) throws SQLException {
        String sql = "INSERT INTO Projeto (ID_Projeto, Nome_Projeto, Local, Data_Inicio, Data_Termino) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, projeto.getIdProjeto());
            stmt.setString(2, projeto.getNome());
            stmt.setString(3, projeto.getLocal());
            stmt.setDate(4, Date.valueOf(projeto.getDataInicio()));
            stmt.setDate(5, Date.valueOf(projeto.getDataTermino()));
            stmt.executeUpdate();
        }
    }

    public void atualizar(Projeto projeto) throws SQLException {
        String sql = "UPDATE Projeto SET Nome_Projeto = ?, Local = ?, Data_Inicio = ?, Data_Termino = ? WHERE ID_Projeto = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, projeto.getNome());
            stmt.setString(2, projeto.getLocal());
            stmt.setDate(3, Date.valueOf(projeto.getDataInicio()));
            stmt.setDate(4, Date.valueOf(projeto.getDataTermino()));
            stmt.setInt(5, projeto.getIdProjeto());
            stmt.executeUpdate();
        }
    }

    public void excluir(int idProjeto) throws SQLException {
        String sql = "DELETE FROM Projeto WHERE ID_Projeto = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idProjeto);
            stmt.executeUpdate();
        }
    }

    public Projeto buscarPorId(int idProjeto) throws SQLException {
        String sql = "SELECT * FROM Projeto WHERE ID_Projeto = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idProjeto);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Projeto(
                        rs.getInt("ID_Projeto"),
                        rs.getString("Nome_Projeto"),
                        rs.getString("Local"),
                        rs.getDate("Data_Inicio").toLocalDate(),
                        rs.getDate("Data_Termino").toLocalDate()
                );
            }
            return null;
        }
    }

    public List<Projeto> listar() throws SQLException {
        List<Projeto> projetos = new ArrayList<>();
        String sql = "SELECT * FROM Projeto";
        try (Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                projetos.add(new Projeto(
                        rs.getInt("ID_Projeto"),
                        rs.getString("Nome_Projeto"),
                        rs.getString("Local"),
                        rs.getDate("Data_Inicio").toLocalDate(),
                        rs.getDate("Data_Termino").toLocalDate()
                ));
            }
        }
        return projetos;
    }
}
