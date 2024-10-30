package clinica;

public class Paciente {
    private String nome;
    private String contato;
    private String cpf;
    private int idade;

    public Paciente(String nome, String contato, String cpf, int idade) {
        this.nome = nome;
        this.contato = contato;
        this.cpf = cpf;
        this.idade = idade;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getContato() {
        return contato;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
