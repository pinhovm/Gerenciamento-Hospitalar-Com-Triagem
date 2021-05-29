package Prova;

public abstract class Pessoa {
    private String nome;
    private String sexo;
    private String cpf;
    private String idade;
    Contato contato= new Contato();
    Endereco endereco= new Endereco();

    public Pessoa(){};

    public Pessoa(String nome, String sexo, String cpf, String idade, Contato contato, Endereco endereco){
        this.nome = nome;
        this.sexo = sexo;
        this.cpf = cpf;
        this.idade = idade;
        this.contato = contato;
        this.endereco = endereco;
    }

    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome= nome;
    }
    public String getSexo(){
        return this.sexo;
    }
    public void setSexo(String sexo){
        this.sexo=sexo;
    }
    public String getCpf(){
        return this.cpf;
    }
    public void setCpf(String cpf){
        this.cpf=cpf;
    }
    public String getIdade(){
        return this.idade;
    }
    public void setIdade(String idade){
        this.idade=idade;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", sexo='" + sexo + '\'' +
                ", cpf='" + cpf + '\'' +
                ", idade='" + idade + '\'' +
                ", contato=" + contato +
                ", endereco=" + endereco +
                '}';
    }
}