package model.gerenciador;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import model.entidades.PessoaFisica;
import model.entidades.PessoaJuridica;

public class PessoaJuridicaRepo {
  private Map<Integer, PessoaJuridica> PessoaJuridicaMap;

  public PessoaJuridicaRepo() {
    PessoaJuridicaMap = new HashMap<>();
  }

  public void inserir(PessoaJuridica pj) {
    PessoaJuridicaMap.put(pj.getId(), pj);
  }

  public void alterar(PessoaJuridica pessoaJuridica) {
    this.PessoaJuridicaMap.put(pessoaJuridica.getId(), pessoaJuridica);
  }

  public void excluir(int id) {
    PessoaJuridicaMap.remove(id);
  }

  public PessoaJuridica obter(int id) {
    return PessoaJuridicaMap.get(id);
  }

  public void persistir(String arquivo) throws IOException {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
      oos.writeObject(PessoaJuridicaMap);
    }
  }

  public void recuperar(String arquivo) throws IOException, ClassNotFoundException {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
      PessoaJuridicaMap = (Map<Integer, PessoaJuridica>) ois.readObject();
    }
  }

  public void alterar(PessoaFisicaRepo pj) {
  }

  public String getId() {
    return null;
  }

  public String getNome() {
    return null;
  }

  public String getCnpj() {
    return null;
  }

  public PessoaJuridicaRepo[] obterTodos() {
    return null;
  }
}
