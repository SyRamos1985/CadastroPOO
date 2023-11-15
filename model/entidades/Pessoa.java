package model.entidades;

import java.io.Serializable;

public abstract class Pessoa implements Serializable {
  private String nome;
  private int id;

  public Pessoa() {
  }

  public Pessoa(String nome, int id) {
    this.nome = nome;
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void exibir() throws Exception {
    System.out.println("Nome: " + nome);
    System.out.println("ID: " + id);
  }
}
