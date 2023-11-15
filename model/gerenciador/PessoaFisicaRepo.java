package model.gerenciador;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import model.entidades.PessoaFisica;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PessoaFisicaRepo {
  private List<PessoaFisicaRepo> pessoasFisicasLista = new ArrayList<>();
  public PessoaFisicaRepo pessoasFisicas;

  public void inserir(PessoaFisica pf) {
    getPessoasFisicasLista().add(pf);
  }

  public List<PessoaFisicaRepo> getPessoasFisicasLista() {
    return pessoasFisicasLista;
  }

  public void setPessoasFisicasLista(List<PessoaFisicaRepo> list) {
    this.pessoasFisicasLista = list;
  }

  public void alterar(PessoaFisicaRepo pessoaFisicaExcluir) {
    int index = getPessoasFisicasLista().indexOf(pessoaFisicaExcluir);
    if (index != -1) {
      getPessoasFisicasLista().set(index, pessoaFisicaExcluir);
    }
  }
  /**
   * @param id
   */
  public void excluir(int id) {
    getPessoasFisicasLista().removeIf(pessoa -> pessoa.getId() == id);
  }

  int getId() {
    return 0;
  }

  public PessoaFisicaRepo obter(int id) {
    for (PessoaFisicaRepo pessoa : getPessoasFisicasLista()) {
      if (pessoa.getId() == id) {
        return pessoa;
      }
    }
    return null;
  }

  public List<PessoaFisicaRepo> obterTodos() {
    return this.getPessoasFisicasLista();
  }

  public void persistir(String nameArquivo) throws IOException {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nameArquivo))) {
      oos.writeObject(getPessoasFisicasLista());
    }
  }
  /**
   * @param nameArquivo
   * @throws IOException
   * @throws ClassNotFoundException
   */
  public void recuperar(String nameArquivo) throws IOException, ClassNotFoundException {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nameArquivo))) {
      setPessoasFisicasLista((List<PessoaFisicaRepo>) ois.readObject());
    }
  }
  public void setIdade(int parseInt) {}
  public void setCpf(String readLine) {}
  public String getIdade() {
    return null;}
  public String getNome() {
    return null; }
  public void setNome(String readLine) {}
  public String getCnpj() {
    return null;}
  public void setCnpj(String readLine) {}
  public String getNomeEmpresa() {
    return null;}
  public void setNomeEmpresa(String readLine) {}
  public PessoaFisica[] obterTodos(int i) {
    return null;}
  public String getCpf() {
    return null;}
}
