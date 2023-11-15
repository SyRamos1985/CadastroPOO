package model.gerenciador;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.entidades.Pessoa;
import model.entidades.PessoaFisica;
import model.entidades.PessoaJuridica;
import model.gerenciador.PessoaFisicaRepo;
import model.gerenciador.PessoaJuridicaRepo;
import model.gerenciador.Principal;
import model.gerenciador.outros.System.out.Repositorio;

public class Principal{

  private static final String Repositorio = null;

  public static void main(String[] args) throws IOException{
    
    Repositorio<PessoaFisica> repo1 = new Repositorio <>(){

      @Override
      public void salvarEmArquivo(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'salvarEmArquivo'");
      }

      @Override
      public void adicionar(PessoaFisica pessoaFisica) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'adicionar'");
      }

      @Override
      public void recuperarArquivo(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'recuperarArquivo'");
      }

      @Override
      public PessoaJuridica[] obterTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obterTodos'");
      }

      @Override
      public void recuperarDeArquivo(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'recuperarDeArquivo'");
      }};
    Repositorio<PessoaFisica> repo2 = new Repositorio <>(){

      @Override
      public void salvarEmArquivo(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'salvarEmArquivo'");
      }

      @Override
      public void adicionar(PessoaFisica pessoaFisica) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'adicionar'");
      }

      @Override
      public void recuperarArquivo(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'recuperarArquivo'");
      }

      @Override
      public PessoaJuridica[] obterTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obterTodos'");
      }

      @Override
      public void recuperarDeArquivo(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'recuperarDeArquivo'");
      }}; 

    repo1.adicionar(new PessoaFisica("Simone", "01234", LocalDate.of(1985, 11, 18)));
    repo1.adicionar(new PessoaFisica("Paula", "98765", LocalDate.of(1987, 04, 15)));
    
    repo1.salvarEmArquivo("teste.fisica.bin");

    try{
      repo2.recuperarDeArquivo("teste.fisica.bin");
    }
    catch (IOException|ClassNotFoundException e){
      e.printStackTrace();
    }

    for (PessoaFisicaRepo pf : ((PessoaFisicaRepo) repo2).obterTodos()){
      System.out.println(pf);
    }

    Repositorio<PessoaJuridica> repo3 = new Repositorio<>() {

      @Override
      public void salvarEmArquivo(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'salvarEmArquivo'");
      }

      @Override
      public void adicionar(PessoaJuridica pessoaJuridica) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'adicionar'");
      }

      @Override
      public void recuperarArquivo(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'recuperarArquivo'");
      }

      @Override
      public PessoaJuridica[] obterTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obterTodos'");
      }

      @Override
      public void adicionar(PessoaFisica pessoaFisica) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'adicionar'");
      }

      @Override
      public void recuperarDeArquivo(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'recuperarDeArquivo'");
      }};
    Repositorio<PessoaJuridica> repo4 = new Repositorio<>() {

      @Override
      public void salvarEmArquivo(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'salvarEmArquivo'");
      }

      @Override
      public void adicionar(PessoaFisica pessoaFisica) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'adicionar'");
      }

      @Override
      public void recuperarArquivo(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'recuperarArquivo'");
      }

      @Override
      public PessoaJuridica[] obterTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obterTodos'");
      }

      @Override
      public void recuperarDeArquivo(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'recuperarDeArquivo'");
      }};
    
    repo3.adicionar(new PessoaJuridica("Empresa On", 9870, LocalDate.of(0, 0, 0)));
    repo4.adicionar(new PessoaJuridica("Empresa Off", 5678, LocalDate.of(0, 0, 0)));
  
    repo3.salvarEmArquivo("teste.juridica.bin");

    repo4.recuperarArquivo("teste.juridica.bin");
    
    for(PessoaJuridica pj : repo4.obterTodos()){
      System.out.println(pj);
    }
  }
}


