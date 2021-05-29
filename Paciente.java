package Prova;

import javax.swing.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Paciente extends Pessoa implements Serializable {
    private String problemaSaude, funcionarioresp, numSUS, triagem, horaSaida, horaEntrada, corGuiche;
    private float altura, peso;
    private ArrayList<Paciente> pacientes = new ArrayList<>();
    private int senhaGuiche;

    public Paciente() {
    }

    public Paciente(String problemaSaude, String funcionarioresp, String numSUS, String triagem, String horaSaida, String horaEntrada, String corGuiche, int senhaGuiche, float altura, float peso) {
        this.problemaSaude = problemaSaude;
        this.funcionarioresp = funcionarioresp;
        this.numSUS = numSUS;
        this.triagem = triagem;
        this.horaSaida = horaSaida;
        this.horaEntrada = horaEntrada;
        this.corGuiche = corGuiche;
        this.senhaGuiche = senhaGuiche;
        this.altura = altura;
        this.peso = peso;

    }




    public ArrayList<Paciente> getPaciente() {
        return this.pacientes;
    }

    public void adicionarPaciente(Paciente paciente) {
        this.pacientes.add(paciente);
    }

    public Paciente procurarPaciente(String buscacpf) {
        for (Paciente p : pacientes) {
            if (p.getCpf().equals(buscacpf)) {
                return p;
            }
        }
        return null;
    }
    public Paciente pegaPaciente(){
        for(Paciente p: pacientes){
            return p;
        }
        return null;
    }
    public Paciente recadastroPaciente(String buscacpf) {
        int i =0;
        for (Paciente p : pacientes) {
            i++;
            if (p.getCpf().equals(buscacpf)) {
                return p;
            }
            pacientes.remove(i);
        }
        return null;
    }

    public String getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getCorGuiche() {
        return corGuiche;
    }

    public void setCorGuiche(String corGuiche) {
        this.corGuiche = corGuiche;
    }

    public int getSenhaGuiche() {
        return senhaGuiche;
    }

    public void setSenhaGuiche(int senhaGuiche) {
        this.senhaGuiche = senhaGuiche;
    }

    public String getProblemaSaude() {
        return problemaSaude;
    }

    public void setProblemaSaude(String problemaSaude) {
        this.problemaSaude = problemaSaude;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getFuncionarioresp() {
        return funcionarioresp;
    }

    public void setFuncionarioresp(String funcionarioresp) {
        this.funcionarioresp = funcionarioresp;
    }

    public String getNumSUS() {
        return numSUS;
    }

    public void setNumSUS(String numSUS) {
        this.numSUS = numSUS;
    }

    public String getTriagem() {
        return triagem;
    }

    public void setTriagem(String triagem) {
        this.triagem = triagem;
    }

    public void setPacientes(ArrayList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public int getLastSenha(){
        int i =0;
        while(i<pacientes.size()){
            i++;
        }
        return i;

    }

    public Paciente proximoGuiche(Paciente p) {
        //ate agora prioridade é o paciente que foi recebido primeiro na lista
        Paciente prioridade = p;
        for (Paciente p1 : pacientes) {
            if (p1.getCorGuiche() == "Vermelho") {
                JOptionPane.showMessageDialog(null, "Atendimento imediato");
                p1.getSenhaGuiche();
                if (prioridade.getSenhaGuiche() < p1.getSenhaGuiche()) {
                    prioridade = p1;
                    continue;
                } else if (p1.getCorGuiche() == "Amarelo") {
                    JOptionPane.showMessageDialog(null, "Atendimento deve ocorrer em até 60 minutos");
                    p1.getSenhaGuiche();
                    if (prioridade.getSenhaGuiche() < p1.getSenhaGuiche()) {
                        prioridade = p1;
                        continue;
                    }
                } else if (p1.getCorGuiche() == "Verde") {
                    JOptionPane.showMessageDialog(null, "Atendimento deve ocorrer em até 2 horas");
                    p1.getSenhaGuiche();
                    if (prioridade.getSenhaGuiche() < p1.getSenhaGuiche()) {
                        prioridade = p1;
                        continue;
                    }
                } else if (p1.getCorGuiche() == "Azul") {
                    JOptionPane.showMessageDialog(null, "Atendimento pode ocorrer em até 4 horas");
                    p1.getSenhaGuiche();
                    if (prioridade.getSenhaGuiche() < p1.getSenhaGuiche()) {
                        prioridade = p1;
                        continue;
                    }
                }
            }
        }
        return prioridade;
    }

    public void gravarDados(){
        for(Paciente p: pacientes){
            try{
                FileOutputStream recebe = new FileOutputStream("Pacientes.txt");
                ObjectOutputStream grava = new ObjectOutputStream(recebe);
                grava.writeObject(p);
                grava.flush();
                grava.close();
                recebe.flush();
                recebe.close();
                JOptionPane.showMessageDialog(null, "Arquivo gravado");

            }
            catch(Exception e){
                System.out.println("Algo deu errado ao gravar arquivo");
            }

        }
    }
    public Paciente lerDados() {
        Paciente p = new Paciente();
        try {
                FileInputStream recebe = new FileInputStream("Pacientes.txt");
                ObjectInputStream exibe = new ObjectInputStream(recebe);
                p = (Paciente)exibe.readObject();
                JOptionPane.showMessageDialog(null, "Arquivo Lido");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Arquivo nao encontrado");
            }
        return p;
    }

    @Override
    public String toString() {
        return "Paciente{" + "nome: " +getNome() +
                "cpf: " + getCpf()+
                "problemaSaude='" + problemaSaude + '\'' +
                ", funcionarioresp='" + funcionarioresp + '\'' +
                ", numSUS='" + numSUS + '\'' +
                ", triagem='" + triagem + '\'' +
                ", horaSaida='" + horaSaida + '\'' +
                ", horaEntrada='" + horaEntrada + '\'' +
                ", corGuiche='" + corGuiche + '\'' +
                ", altura=" + altura +
                ", peso=" + peso +
                ", pacientes=" + pacientes +
                ", senhaGuiche=" + senhaGuiche +
                '}';
    }
}