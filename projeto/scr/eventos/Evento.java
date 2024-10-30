package eventos;

import java.util.ArrayList;

public class Evento {
    private String nome;
    private String data; 
    private Local local; 
    private ArrayList<Participante> participantes;

    public Evento(String nome, String data, Local local) {
        this.nome = nome;
        this.data = data;
        this.local = local; 
        this.participantes = new ArrayList<>();
    }

 
    public String getNome() {
        return nome;
    }

    public String getData() {
        return data;
    }

    public Local getLocal() {
        return local;
    }

    public ArrayList<Participante> getParticipantes() {
        return participantes;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

   
    public boolean isLotado() {
        return participantes.size() >= local.getCapacidade(); 
    }

    
    public boolean adicionarParticipante(Participante participante) {
        if (!isLotado()) {
            participantes.add(participante);
            return true; 
        } else {
            return false;
        }
    }

   
    public void gerarRelatorioParticipantes() {
        System.out.println("Participantes do evento: " );
        for (Participante participante : participantes) {
            System.out.println("Nome: " + participante.getNome() + " | Contato: " + participante.getContato());
        }
    }
}
    
