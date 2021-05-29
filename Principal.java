package Prova;

import javax.swing.*;
import java.io.Serializable;


public class Principal implements Serializable {
    static Paciente pacientes = new Paciente();
    static Funcionario funcionarios = new Funcionario();
    public static void main(String args[]){
        menu();

    }
    public static void menu(){
        int sair = 1;
        //1 - Cadastrar Profissional
        //2 - Cadastrar Paciente
        //3 - Mostrar Paciente
        //4 - Mostrar Funcionario
        //5 - Mostrar Guiche
        //6 - Gravar Dados
        //7 - Ler Dados
        //9 - Sair
        while(sair != 0){
            int menu = Integer.parseInt(JOptionPane.showInputDialog("MENU " +
                    "\n1 - Cadastrar Profissional \n2 - Cadastrar Paciente \n3 - Mostrar Paciente  " +
                    "\n4 - Mostrar Profissional  \n5 - Proximo Guiche \n6 - Gravar Dados \n 7 - Ler Dados " +
                    "\n9 - Sair \nDigite a opcao desejada:  "));
            switch(menu){
                case 1:
                    funcionarios.adicionarFuncionario(cadastrarFuncionario());
                    break;
                case 2:
                    pacientes.adicionarPaciente(cadastrarPaciente());
                    break;
                case 3:
                    mostraPaciente();
                    break;
                case 4:
                    mostraFuncionario();
                    break;
                case 5:
                    mostraGuiche();
                    break;
                case 6:
                    gravarDados();
                    break;
                case 7:
                    lerDados();
                    break;
                case 9:
                    sair = 0;
                    break;
            }
        }
    }
    //cadastro recepcção antes da triagem
    private static Paciente cadastrarPaciente(){
        //pre cadastro
        Paciente paciente = new Paciente("1", "2", "3", "4", "5", "6", "7", 1, 1, 1);

        paciente.setNome(JOptionPane.showInputDialog("Nome: "));
        paciente.setSexo(JOptionPane.showInputDialog("Sexo: "));
        paciente.setCpf(JOptionPane.showInputDialog("CPF: "));
        paciente.setIdade(JOptionPane.showInputDialog("Idade: "));
        /*paciente.contato.setEmail(JOptionPane.showInputDialog("Email: "));
        paciente.contato.setTelefone(JOptionPane.showInputDialog("Telefone: "));
        paciente.endereco.setEstado(JOptionPane.showInputDialog("Estado: "));
        paciente.endereco.setCidade(JOptionPane.showInputDialog("Cidade: "));
        paciente.endereco.setBairro(JOptionPane.showInputDialog("Bairro: "));
        paciente.endereco.setRua(JOptionPane.showInputDialog("Rua: "));
        paciente.endereco.setNumero(JOptionPane.showInputDialog("Numero: "));*/
        return paciente;
    }
    private static Funcionario cadastrarFuncionario(){
        Funcionario profissional = new Funcionario();
        profissional.setNome(JOptionPane.showInputDialog("Nome: "));
        profissional.setSexo(JOptionPane.showInputDialog("Sexo: "));
        profissional.setCpf(JOptionPane.showInputDialog("CPF: "));
        profissional.setIdade(JOptionPane.showInputDialog("Idade: "));
        profissional.contato.setEmail(JOptionPane.showInputDialog("Email: "));
        profissional.contato.setTelefone(JOptionPane.showInputDialog("Telefone: "));
        profissional.endereco.setEstado(JOptionPane.showInputDialog("Estado: "));
        profissional.endereco.setCidade(JOptionPane.showInputDialog("Cidade: "));
        profissional.endereco.setBairro(JOptionPane.showInputDialog("Bairro: "));
        profissional.endereco.setRua(JOptionPane.showInputDialog("Rua: "));
        profissional.endereco.setNumero(JOptionPane.showInputDialog("Numero: "));
        profissional.setCOREN(Integer.parseInt(JOptionPane.showInputDialog("COREN \n (0 se for medico)")));
        profissional.setCRM(Integer.parseInt(JOptionPane.showInputDialog("CRM \n (0 se for enfermeiro)")));
        return profissional;
    }
    private static void mostraPaciente(){
        String cpf;
        int dados;
        Paciente p;
        cpf = JOptionPane.showInputDialog("CPF do paciente que deseja buscar: ");
        p = pacientes.procurarPaciente(cpf);
        dados = Integer.parseInt(JOptionPane.showInputDialog(" 1 - Dados do Paciente \n 2 - Prontuário Médico \n 3 - Finalizar Cadastro"));
        switch(dados){
            case 1:
                p.toString();
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "\nNome: "+ p.getNome() +
                        "\nCPF: " +p.getCpf()+
                        "\nIdade: "+p.getIdade()+
                        "\nTriagem: " +p.getTriagem() +
                        "\nProblema de Saúde: " +p.getProblemaSaude() +
                        "\nAtendido por: " +p.getFuncionarioresp() +
                        "\nHora de Entrada: "+ p.getHoraEntrada()+
                        "\nHora de Saida:" +p.getHoraSaida()+
                        "\nNumero do Cartão SUS: " +p.getNumSUS());
                break;
            case 3:
                pacientes.adicionarPaciente(finalizarCadastro());
                break;
        }
    }
    private static Paciente finalizarCadastro(){
        String cpf = JOptionPane.showInputDialog("CPF do paciente que deseja buscar: ");
        Paciente pf = pacientes.recadastroPaciente(cpf);
        //paciente finalizado
        if(pf.getHoraEntrada() == null) {
            pf.setProblemaSaude(JOptionPane.showInputDialog("Problema de Saude: "));
            pf.setAltura(Float.parseFloat(JOptionPane.showInputDialog("Altura:")));
            pf.setPeso(Float.parseFloat(JOptionPane.showInputDialog("Peso:")));
            pf.setFuncionarioresp(JOptionPane.showInputDialog("Profissional atendente: "));
            pf.setNumSUS(JOptionPane.showInputDialog("Cartao SUS: "));
            pf.setTriagem(JOptionPane.showInputDialog("Triagem: "));
            pf.setHoraEntrada(JOptionPane.showInputDialog("Hora da Entrada: "));
            pf.setCorGuiche(pf.getTriagem());
            pf.setSenhaGuiche(ultimoLista());
        }else{
            pf.setHoraSaida(JOptionPane.showInputDialog("Hora da Saída: "));
        }
        return pf;
    }
    //pega a ultima senha da lista tendo em vista que todo paciente recebe uma senha
    //se todo paciente recebe uma senha de uma letra e um numero, então o tanto de senha será a de pacientes.size
    //a letra(cor da triagem) que dará a preferencia
    private static int ultimoLista(){
        int i;
        i = pacientes.getLastSenha();
        return i;
    }

    private static void mostraGuiche(){
        Paciente p = pacientes.pegaPaciente();
        pacientes.proximoGuiche(p);
        JOptionPane.showMessageDialog(null, p.getNome() + p.getCorGuiche() + p.getSenhaGuiche());
    }
    private static void mostraFuncionario(){
        String cpf;
        Funcionario f = new Funcionario();
        cpf = JOptionPane.showInputDialog("CPF do profissional que deseja buscar: ");
        f = funcionarios.procurarFuncionario(cpf);
        JOptionPane.showMessageDialog(null, "Nome: "+ f.getNome() +
                "CPF: " +f.getCpf()+
                "Idade: "+f.getIdade()+
                "COREN: " +f.getCOREN() +
                "CRM: " +f.getCRM());
    }
    private static void gravarDados(){
        pacientes.gravarDados();
    }
    private static void lerDados(){
        pacientes.lerDados();
    }
}