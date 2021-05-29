package Prova;

import java.util.ArrayList;

public class Funcionario extends Pessoa {
    private int CRM, COREN;
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();
    public Funcionario(){}

    public Funcionario(int CRM, int COREN) {
        this.CRM = CRM;
        this.COREN = COREN;
    }


    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public ArrayList<Funcionario> pegarFuncionario() {
        return this.funcionarios;
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
    }

    public Funcionario procurarFuncionario(String buscacpf) {
        for (Funcionario f : funcionarios) {
            if (f.getCpf().equals(buscacpf)) {
                return f;
            }
        }
        return null;
    }
    public int getCRM() {
        return CRM;
    }

    public void setCRM(int CRM) {
        this.CRM = CRM;
    }

    public int getCOREN() {
        return COREN;
    }

    public void setCOREN(int COREN) {
        this.COREN = COREN;
    }
}
