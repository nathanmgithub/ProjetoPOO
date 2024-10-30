package clinica;

public class Medico {
    private String nome;
    private String especialidade;
    private String crm;
    private boolean disponivel;

    public Medico(String nome, String especialidade, String crm, boolean disponivel) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.crm = crm;
        this.disponivel = disponivel;
    }

    public Medico(String nomeMedico, String especialidadeMedico, String crmMedico) {
   
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String getCrm() {
        return crm;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
