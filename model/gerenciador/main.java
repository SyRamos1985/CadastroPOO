package model.gerenciador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.entidades.Pessoa;
import model.entidades.PessoaFisica;
import model.entidades.PessoaJuridica;
import model.gerenciador.PessoaFisicaRepo;
import model.gerenciador.PessoaJuridicaRepo;
import model.gerenciador.Principal;
import model.gerenciador.outros.Intereger;
import model.gerenciador.outros.repoJuridica;

public class main {
  private static BufferedReader reader;
  private static String nome;
  private static Object cnpj;

  /**
   * @param args
   */
 public static void main(String[] args){
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String opcao = " ";
    PessoaFisicaRepo repoFisica = new PessoaFisicaRepo();
    PessoaJuridicaRepo repojuridica = new PessoaJuridicaRepo();

    while ( !"x".equalsIgnoreCase(opcao)){
      System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
      System.out.println("Selecione a opção desejada: ");
      System.out.println("01 - Inserir Pessoa");
      System.out.println("02 - Alterar Pessoa");
      System.out.println("03 - Excluir Pessoa");
      System.out.println("04 - Pesquisar Por ID");
      System.out.println("05 - Exibir Todos");
      System.out.println("06 - Persistir Dados");
      System.out.println("07 - Recuperar Dados");
      System.out.println("00 - Exit");
      System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
    }
      
      try{
        opcao = reader.readLine();
        switch (opcao){
          case "01": 
              System.out.println("1 - Pessoa Física / 2 - Pessoa Jurídica");
              String tipoPessoa = reader.readLine();
              switch (tipoPessoa){
                case "1":
                    PessoaFisica pf = lerDadosPessoaFisica(reader);
                    repoFisica.inserir(pf);
                    System.out.println(" Pessoa Fisica inserida com sucesso. ");
                    break;
                case "2":
                    PessoaJuridica pj = lerDadosPessoaJuridica(reader);
                    repojuridica.inserir(pj);
                    System.out.println(" Pessoa Jurídica inserida com sucesso. ");
                    break;
                default:
                    System.out.println("Ooops! Opcão inválida.Tente novamente"); 
                    break;
              } 
              
          case "02": 
              System.out.println("1 - Pessoa Física / 2 - Pessoa Jurídica");
              String tipoPessoaAlterar = reader.readLine();
              switch (tipoPessoaAlterar){
                case "1":
                    alterarPessoa(repoFisica, reader);
                    System.out.println(" Dados cadastrais, alterado com sucesso. ");
                    break;
                case "2":
                    alterarPessoa(repojuridica, reader);
                    System.out.println(" Dados cadastrais, alterado com sucesso.");
                    break;
                default:
                    System.out.println("Ooops! Opção inválida. Tente novamente!!!"); 
                    break;
          case "03": 
              System.out.println("1 - Pessoa Física / 2 - Pessoa Jurídica");
              String tipoPessoaExcluir = reader.readLine();
              switch (tipoPessoaExcluir){
                case "1":
                    excluirPessoa(repoFisica, reader);
                    System.out.println("Dados cadastrais, excluido com sucesso.");
                    break;
                case "2":
                    excluirPessoa(repojuridica, reader);
                    System.out.println(" Dados cadastrais, excluido com sucesso.");
                    break;
                default:
                    System.out.println("Ooops! Opção inválida.Tente novamente!!!"); 
                    break;          
              }   

          case "04": 
              System.out.println("1 - Pessoa Física / 2 - Pessoa Jurídica");
              String tipoPessoaPesquisar = reader.readLine();
              switch (tipoPessoaPesquisar){
                case "1":
                    pesquisarPessoa(repoFisica, reader);
                    System.out.println(" Pessoa Física encontrada com sucesso. ");
                    break;
                case "2":
                    pesquisarPessoa(repojuridica, reader);
                    System.out.println(" Empresa encontrada com sucesso.");
                    break;
                default:
                    System.out.println("Ooops! Opção inválida. Tente novamente!!!"); 
                    break;          
              }              
          
          case "05": 
              System.out.println("1 - Pessoa Física / 2 - Pessoa Jurídica");
              String tipoPessoaExibirTodos = reader.readLine();
              switch (tipoPessoaExibirTodos){
                case "1":
                    exibirTodasPessoas(repoFisica, reader);
                    System.out.println(" Exibição de todos os dados cadastrais, pessoas fisicas. ");
                    break;
                case "2":
                    exibirTodasPessoas(repojuridica, reader);
                    System.out.println(" Exibição de todos os dados cadastrais, pessoas juridicas.");
                    break;
                default:
                    System.out.println("Ooops! Opção inválida. Tente novamente!!!"); 
                    break; 
              }  

          case "06": 
              System.out.println("Informe o prefixo dos arquivos");
              String arquivoX = reader.readLine();
              try {
                repoFisica.persistir(arquivoX + ".fisica.bin");
                repoJuridica.persistir(arquivoX + ".juridica.bin");
                System.out.println("Dados cadastrais, salvos com sucesso.");
            }
            catch(IOException e){
                System.out.println( "[x] Erro ao salvar os dados cadastrais: "+ e.getMessage());
                break;
            }
          case "07":
              System.out.println("Informe o prefixo dos arquivos: ");
              String arquivoG = reader.readLine();
              try {
                repoFisica.recuperar(arquivoG + ".fisica.bin");
                repoJuridica.recuperar(arquivoG + ".juridica.bin");
                System.out.println("Dados cadastrais, recuperados com sucesso!");
                }
              catch(IOException|ClassNotFoundException e) {
                System.out.println( "[x] Erro ao recuperar os dados cadastrais: "+ e.getMessage());
                break;
              }

          case "00":
                System.out.println("Fechando o sistema, gentileza aguarde! ");
                break;

              default:
                  System.out.println("Ooops! Opção inválida. Tente novamente!!!"); 
                  break; 
             
              catch (IOException e){
              final Throwable eThrowable;
              System.out.println( "[x] Erro ao recuperar os dados cadastrais: "+ e.getMessage());
              }  
                 
        
          }  

              private static PessoaJuridica lerDadosPessoaJuridica(BufferedReader reader2) {
              return null;
              }


              private static PessoaFisica lerDadosPessoaFisica(BufferedReader reader ) throws IOException{
              System.out.println("Digite o nome completo do usuário: ");
              String nomeCompleto = reader.readLine();
              System.out.println("Digite o CPF do usuário: ");
              String cpf = reader.readLine();
              System.out.println("Digite a Idade do usuário: ");
              int idade = Intereger.parsenInt(reader.readLine());
              System.out.println("Digite o ID do usuário; ");
              int id = Intereger.parsenInt(reader.readLine());
              return new PessoaFisica(nome, cpf, id, idade);
             }


              private static PessoaJuridica lerDadosPessoaJuridica() throws IOException{
              System.out.println("Digite o nome completo da empresa: ");
              String nomeCompleto = reader.readLine();
              System.out.println("Digite o CNPJ do usuário: ");
              String cnpj = reader.readLine();
              System.out.println("Digite o ID da empresa; ");
              int id = Intereger.parsenInt(reader.readLine());   
              return new PessoaJuridica(nomeCompleto, id, cnpj);
              }

            private static void alterarPessoa(Object repo, BufferedReader reader) throws IOException {
              System.out.println("Digite o ID que deseja alterar: ");
              int id = Integer.parseInt(reader.readLine());
              if (repo instanceof PessoaFisicaRepo) {
               PessoaFisicaRepo pf = ((PessoaFisicaRepo) repo).obter(id);
               if(pf!=null){ 
                System.out.println("Digite o CPF antigo: " + pf.getCpf());
                System.out.println("Digite o novo CPF do usuário: ");
                pf.setCpf(reader.readLine());
                System.out.println("Digite a Idade antiga: " + pf.getIdade());
                System.out.println("Digite a nova Idade do usuário: ");
                pf.setIdade(Integer.parseInt(reader.readLine()));
                System.out.println("Digite o Nome Antigo: " + pf.getNome());
                System.out.println("Digite o novo Nome do usuário: ");
                pf.setNome(reader.readLine());
                ((PessoaFisicaRepo)repo).alterar(pf);
                System.out.println("Usuário alterado com sucesso.");  
                }else{ 
                  System.out.println("Desculpe.Usuário não encontrado.Tente novamente!!!");}
               }
               else if (repo instanceof PessoaJuridicaRepo){
                PessoaFisicaRepo pj = ((PessoaFisicaRepo)repo).obter(id);
                if(pj != null){
                System.out.println("CNPJ Antigo: " + pj.getCnpj());
                System.out.println("Digite o novo CNPJ do usuário: ");
                pj.setCnpj(reader.readLine());
                System.out.println("Digite o nome da empresa antiga" + pj.getNomeEmpresa());
                System.out.println("Digite o novo nome da empresa: ");
                pj.setNomeEmpresa(reader.readLine());
                ((PessoaJuridicaRepo)repo).alterar(pj);
                System.out.println("Usuário Empresa, foi alterado com sucesso.");
                }
                 else{
                  System.out.println("Desculpe. Usuário ou empresa não encontrada. Tente novamente!");
                }
                }           
            }

            private static void excluirPessoa(Object repo, BufferedReader reader) throws IOException {
              System.out.println(" Digite o Id do usuário que você deseja excluir:  ");
              int id = Integer.parseInt(reader.readLine());
              if (repo instanceof PessoaFisicaRepo) {
              ((PessoaFisicaRepo)repo).excluir(id);
              System.out.println("Usuário excluído com sucesso.");
              }
               else if(repo instanceof PessoaJuridicaRepo) {
               ((PessoaFisicaRepo)repo).excluir(id);
               System.out.println("Usuário Empresa foi excluído com sucesso.");
               }
            }

            private static void buscarPessoa(Object repo, BufferedReader reader) throws IOException {
              System.out.println(" Digite o Id para procurar o usuário: ");
              int id = Integer.parseInt(reader.readLine());
              if (repo instanceof PessoaFisicaRepo){
               PessoaFisicaRepo pf = ((PessoaFisicaRepo)repo).obter(id);
               if(pf != null){
              System.out.println("Id: " + pf.getId() );
              System.out.println("CPF: " + pf.getCpf());
              System.out.println("Idade: " + pf.getIdade());
              System.out.println("Nome: " + pf.getNome());        
              }
               else{System.out.println("Desculpe! Usuário não encontrado. Tente novamente.");}
              }
            }
               else if (repo instanceof PessoaJuridicaRepo){
                 int id;
                 PessoaJuridicaRepo repo;
                 PessoaJuridica pj = ((PessoaJuridicaRepo)repo).obter(id);
                 System.out.println("Id: " + pj.getId());
                 System.out.println("CNPJ: " + pj.getCnpj());
                 System.out.println("Nome: " + pj.getNome()); 
               } 
                else {
                System.out.println("Desculpe. Usuário Empresa não encontrado. Tente novamente.");
                }
            private static void exibirTodasPessoas(Object repo){
              if(repo instanceof PessoaFisicaRepo){
              for(PessoaFisicaRepo pf :((PessoaFisicaRepo)repo). obterTodos()){
              System.out.println("id: " + pf.getId());
              System.out.println("Nome: " + pf.getNome());
              System.out.println("CPF: " + pf.getCpf());
              }
              }
               else if(repo instanceof PessoaJuridicaRepo){
               for(PessoaJuridicaRepo pj : ((PessoaJuridicaRepo)repo).obterTodos()){
               System.out.println("id: " + pj.getId());
               System.out.println("Nome: " + pj.getNome());
               System.out.println("CNPJ: " + pj.getCnpj());
               }
               }
            }                

            private static void exibirTodasPessoas(PessoaJuridicaRepo repojuridica, BufferedReader reader)
            private static void exibirTodasPessoas(PessoaFisicaRepo repoFisica, BufferedReader reader) {}
            private static void pesquisarPessoa(PessoaJuridicaRepo repojuridica, BufferedReader reader) {}
            private static void pesquisarPessoa(PessoaFisicaRepo repoFisica, BufferedReader reader) {}
            private static void excluirPessoa(PessoaJuridicaRepo repojuridica, BufferedReader reader) {}
            private static void excluirPessoa(PessoaFisicaRepo repoFisica, BufferedReader reader) {}
            private static void alterarPessoa(PessoaJuridicaRepo repojuridica, BufferedReader reader) {}
            private static void alterarPessoa(PessoaFisicaRepo repoFisica, BufferedReader reader) {}
           
           
            public static BufferedReader getReader() {
            return reader;}
            public static void setReader(BufferedReader reader) {}
               main.reader = reader;
            public static String getNome() {
               return nome;}
            public static void setNome(String nome) {
               main.nome = nome;}
            public static Object getCnpj() {
              return cnpj;}
            public static void setCnpj(Object cnpj) {
              main.cnpj = cnpj;}
  
            @Override
              public String toString() {
              return "main []";
              }   
      }      
    }
  }
}              
              
 
 





    