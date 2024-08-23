package ex02;

import java.util.Set;

public class Projeto {
    private int idProjeto;
    private String nome;
    private String descricao;
    private Set<Engenheiro> engenheiros;
    private Set<Operario> operarios;
    private Set<Equipamento> equipamentos;
    private Set<Material> materiais;

    public Projeto(int idProjeto, String nome, String descricao) {
        this.idProjeto = idProjeto;
        this.nome = nome;
        this.descricao = descricao;
    }

    // Getters and Setters
    public int getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(int idProjeto) {
        this.idProjeto = idProjeto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set<Engenheiro> getEngenheiros() {
        return engenheiros;
    }

    public void setEngenheiros(Set<Engenheiro> engenheiros) {
        this.engenheiros = engenheiros;
    }

    public Set<Operario> getOperarios() {
        return operarios;
    }

    public void setOperarios(Set<Operario> operarios) {
        this.operarios = operarios;
    }

    public Set<Equipamento> getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(Set<Equipamento> equipamentos) {
        this.equipamentos = equipamentos;
    }

    public Set<Material> getMateriais() {
        return materiais;
    }

    public void setMateriais(Set<Material> materiais) {
        this.materiais = materiais;
    }
}
