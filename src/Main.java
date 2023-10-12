import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        ArrayList<Livro> listaLivro = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        String nomeUsuario;
        int opcao;

        System.out.println("----------------------------------------------------------------");
        System.out.println("Bem-vindo usuario ! Qual seu nome ?");
        nomeUsuario = scanner.next();
        System.out.println(" ");

        do {
            System.out.println("----------------------------------------------------------------");
            System.out.println(nomeUsuario.toUpperCase(Locale.ROOT) + " Escolha uma opção:");
            System.out.println("1 - Cadastrar um novo livro ao sistema");
            System.out.println("2 - Listar os livros cadastrados");
            System.out.println("3 - Sair");
            opcao = scanner.nextInt();
            System.out.println("----------------------------------------------------------------");
            System.out.println(" ");

            switch (opcao) {
                case 1:
                    Livro novoLivro = new Livro();
                    Autor novoAutor = new Autor();

                    System.out.println("----------------------------------------------------------------");
                    System.out.println(nomeUsuario.toUpperCase(Locale.ROOT) + " o livro que deseja cadastrar foi lançado a +5 anos ? [S/N]" );
                    String tempoLancamentoLivro = scanner.next();

                    if (tempoLancamentoLivro.equalsIgnoreCase("S")){
                        System.out.println("Qual titulos do livro que gostaria de cadastrar ? ");
                        novoLivro.titulo = scanner.next();

                        System.out.println("Qual preço do livro ?");
                        novoLivro.preco = scanner.nextInt();
                        ///

                        System.out.println("Qual data de lançamento do livro ?");
                        LocalDate dateLivro = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        Period periodo = Period.between(dateLivro, LocalDate.now());
                        novoLivro.date = dateLivro;
                        ///

                        System.out.println("Qual nome do autor ?");
                        novoAutor.nomeAutor = scanner.next();

                        System.out.println("Qual local de nascimento do autor ?");
                        novoAutor.localNasc = scanner.next();

                        if (periodo.getYears() >= 5 ) {
                            novoLivro.autor = novoAutor;
                            listaLivro.add(novoLivro);

                            System.out.println("Cadastro Realizado com Sucesso !");
                            System.out.println(" ");
                            break;
                        }else{
                            System.out.println("Voçê mentiu, ele livro não foi lançado a +5anos !");
                            System.out.println(" ");
                            break;
                        }

                    }else {
                        System.out.println("Esse não permiter o cadastro de livros com menos de 5 anos de lançamento");
                       break;
                    }
                    ///////////////// fim case 1

                case 2:

                    if (listaLivro.size() > 0 ){
                        for (Livro cadaLivro : listaLivro){
                            System.out.println("Nome: " + cadaLivro.titulo);
                            System.out.println("Preço: R$" + cadaLivro.preco);
                            System.out.println("Data de lançamento: " + cadaLivro.date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                            System.out.println("Autor: " + cadaLivro.autor.nomeAutor);
                            System.out.println("...");
                        }
                    }else {
                        System.out.println(nomeUsuario.toUpperCase(Locale.ROOT) + " lista vazia !");
                    }
                break;

                case 3:
                    System.out.println("Saindo ...");
                    opcao = 0;
                break;

                default:
                    System.out.println("Opção inválida, por favor digite uma opção válida!");
                break;
            }
        }while (opcao != 0);
    }
}