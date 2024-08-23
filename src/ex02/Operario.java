package ex02;

public class Operario {
    private int idOperario;
    private String nome;
    private String cargo;

    public Operario(int idOperario, String nome, String cargo) {
        this.idOperario = idOperario;
        this.nome = nome;
        this.cargo = cargo;
    }


    public int getIdOperario() {
        return idOperario;
    }

    public void setIdOperario(int idOperario) {
        this.idOperario = idOperario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
