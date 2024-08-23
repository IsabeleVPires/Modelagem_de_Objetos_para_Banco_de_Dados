package ex02;

public class Equipamento {
    private int idEquipamento;
    private String nome;
    private String tipo;

    public Equipamento(int idEquipamento, String nome, String tipo) {
        this.idEquipamento = idEquipamento;
        this.nome = nome;
        this.tipo = tipo;
    }

    // Getters and Setters
    public int getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(int idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
