package eventos;

public class Participante {
    private String nome;
    private String contato;

    public Participante(String nome, String contato) {
        this.nome = nome;
        this.contato = contato;
    }

    
    public String getNome() {
        return nome;
    }

    public String getContato() {
        return contato;
    }

   
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
}
