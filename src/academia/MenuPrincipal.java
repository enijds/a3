
package academia;

//import java.util.Scanner;



public class MenuPrincipal extends Academia {


    // cria um Scanner para ler a entrada do usuário
    // O Scanner é usado para ler a entrada do usuário no terminal
    // Scanner scanner = new Scanner(System.in);
    
   // Construtor da classe MenuPrincipal
    public MenuPrincipal() {}

    public void controleMenu() {

        // Método para controlar o menu principal
         MenuPrincipal menuPrincipal = new MenuPrincipal();

        // laço para repetir o menu principal
        // do-while para manter o menu ativo até que o usuário escolha sair
        do { 
                
                // Cria um objeto TerminalTexto e limpa o console
                terminal.LimpaConsole();
                        
                // Exibe o menu
                menuPrincipal.exibirMenu();
                
                //Aguarda a opção do usuário	
                int opcao = scanner.nextInt();

                // define a escolha do menu principal
                menuPrincipal.opcoes(opcao);
                
                // Verifica se a opção escolhida é 9 (Sair)
                // Se for, exibe uma mensagem de saída e encerra o loop
                if (opcao == 9) {
                        System.out.println("Saindo do programa...");
                        break;
                }
                
        } while (true);     

        
        } // public void controleMenu() {


        public void exibirMenu() {
                
                // Mensagens do menu principal
                System.out.println("Menu Principal"                     );
                System.out.println("0. Trabalhar pela interface Grafica");
                System.out.println("1. Cadastrar Aluno"                 );
                System.out.println("2. Listar Alunos"                   );
                System.out.println("3. Editar Aluno"                    );
                System.out.println("4. Excluir Aluno"                   );
                System.out.println("5. Cadastrar Treinos"               );
                System.out.println("6. Listar Treinos"                  );
                System.out.println("7. Editar Treinos"                  );
                System.out.println("8. Excluir Treinos"                 );
                System.out.println("9. Sair"                            );
                System.out.println("Escolha uma opção: "                );

                } // public void exibirMenu() {


    public void opcoes(int opcao) {

        // 3) Lê a opção escolhida pelo usuário   
        switch (opcao) {
                case 1 ->   // Listar Pessoas
                            System.out.println("Listando pessoas...");
                            // Chama o método de consulta para listar as pessoas
                            // consulta.Consulta();
                            // usando o scanner para pausar
                            // String pausa = scanner.nextLine();
                
                case 2 ->   // Adicionar Pessoa
                            System.out.println("Adicionando pessoa...");
                case 3 ->   // Editar Pessoa
                            System.out.println("Editando pessoa...");
                case 4 ->   // Excluir Pessoa
                            System.out.println("Excluindo pessoa...");
                case 5 ->   {
                            // Sair
                            System.out.println("Saindo do programa...");
                            System.exit(0);
                            }
                default ->  System.out.println("Opção inválida. Tente novamente.");
        } // switch (opcao) {
    } // public void opcoes(int opcao) {
    
} // public class MenuPrincipal {



    // CadastrarAluno
    // ListarAlunos
    // EditarAluno
    // ExcluirAluno
    // CadastrarTreinos
    // ListarTreinos
    // EditarTreinos
    // ExcluirTreinos