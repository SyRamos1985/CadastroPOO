package model.entidades;

import java.io.Serializable;
import java.time.LocalDate;

public class PessoaFisica extends Pessoa implements Serializable {
  private String cpf;
  private int idade;

  public PessoaFisica() {
  }

  public PessoaFisica(String nome, String cpf, int idade, int id) {
    super(nome, id);
    this.idade = idade;
    this.cpf = cpf;
  }

  public PessoaFisica(String string, String string2, LocalDate localDate) {
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public int getIdade() {
    return idade;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }

  @Override
  public void exibir() {
    System.out.println("***Pessoa Física***");
    System.out.println("ID: " + getId());
    System.out.println("Nome: " + getNome());
    System.out.println("CPF: " + getCpf());
    System.out.println("Idade: " + getIdade());
  }
}