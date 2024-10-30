package clinica;

import java.util.Date;

public class Consulta {
    private Paciente paciente;
    private Medico medico;
    private Date dataConsulta;
    private String horario;

    public Consulta(Paciente paciente, Medico medico, Date dataConsulta, String horario) {
        this.paciente = paciente;
        this.medico = medico;
        this.dataConsulta = dataConsulta;
        this.horario = horario;
    }


    public Consulta(Paciente pacienteSelecionado, Medico medicoSelecionado, Date dataConsulta2) {
        //TODO Auto-generated constructor stub
    }


    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public String getHorario() {
        return horario;
    }


    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }


    public void add(Consulta consulta) {
        throw    new UnsupportedOperationException("Unimplemented method 'add'");
    }
}
