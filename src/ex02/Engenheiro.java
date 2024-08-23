package ex02;

public class Engenheiro {
    private int idEngenheiro;
    private String nome;
    private String especialidade;

    public Engenheiro(int idEngenheiro, String nome, String especialidade) {
        this.idEngenheiro = idEngenheiro;
        this.nome = nome;
        this.especialidade = especialidade;
    }

    // Getters and Setters
    public int getIdEngenheiro() {
        return idEngenheiro;
    }

    public void setIdEngenheiro(int idEngenheiro) {
        this.idEngenheiro = idEngenheiro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
