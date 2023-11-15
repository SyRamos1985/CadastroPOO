package model.gerenciador.outros.System.out;

import model.entidades.PessoaFisica;
import model.entidades.PessoaJuridica;

public interface Repositorio<T> {

  void salvarEmArquivo(String string);


  void adicionar(PessoaFisica pessoaFisica);

  void recuperarArquivo(String string);

  PessoaJuridica[] obterTodos();

  void recuperarDeArquivo(String string);

  void adicionar(PessoaFisica pessoaFisica);

  void adicionar(PessoaJuridica pessoaJuridica);

}
