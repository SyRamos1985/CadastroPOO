package model.entidades;

import java.io.Serializable;

public class PessoaJuridica extends Pessoa implements Serializable {
  private String cnpj;

  public PessoaJuridica() {
  }

  public PessoaJuridica(String nome, String cnpj, int id) {
    super(nome, id);
    this.cnpj = cnpj;
  }

  public PessoaJuridica(String nomeCompleto, int id, Object cnpj2) {
  }

  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  @Override
  public void exibir() {
    System.out.println("***Pessoa Jurídica***");
    System.out.println("ID: " + getId());
    System.out.println("Nome: " + getNome());
    System.out.println("CNPJ: " + getCnpj());
  }

}
