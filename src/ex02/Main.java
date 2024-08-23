package ex02;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {

            MaterialDAO materialDAO = new MaterialDAO();


            Material novoMaterial = new Material(0, "Cimento", 50);
            materialDAO.inserir(novoMaterial);
            System.out.println("Material inserido com sucesso!");


            novoMaterial.setQuantidade(75);
            materialDAO.atualizar(novoMaterial);
            System.out.println("Material atualizado com sucesso!");


            List<Material> materiais = materialDAO.listarMateriais();
            System.out.println("Lista de Materiais:");
            for (Material material : materiais) {
                System.out.println(material);
            }


            materialDAO.excluirMaterial(novoMaterial.getIdMaterial());
            System.out.println("Material excluído com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao acessar o banco de dados: " + e.getMessage());
        }
    }
}
