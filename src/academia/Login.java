package academia;

import java.io.Console;

public class Login extends Academia{

    // Atributos da classe Login
    // isLoggedIn indica se o usuário está logado ou não
    private boolean isLoggedIn = false;
    
    // usuario e senha armazenam as credenciais do usuário
    private String usuario;
    private String senha;
    
    public boolean apresentarTelaLogin() {

        // Método para apresentar a tela de login
        // Aqui você pode implementar a lógica para exibir a tela de login, como solicitar nome de usuário e senha
        System.out.println("Bem-vindo ao sistema de login!");
        System.out.println("Por favor, insira suas credenciais para continuar.");

        // Solicita o nome de usuário
        System.out.print("Nome de usuário: ");
        usuario = scanner.nextLine();

        // Verifica se o console está disponível
        // O console é usado para ler a senha de forma segura, sem exibir os caracteres digitados
        Console console = System.console();
        if (console == null) {
            System.err.println("Nenhum console disponível. Rode o programa no terminal, não na IDE.");
            System.exit(1);
            } // if (console == null) {

        // System.out.println("console.charset(): " + console.charset());
        // Lê a senha sem mostrar no terminal
        char[] senhaChars = console.readPassword("Digite sua senha: ");
        senha = new String(senhaChars);

        // retorna o resultado do método logar, que verifica as credenciais
        // Se as credenciais forem válidas, o usuário será logado com sucesso
        return logar(); 

    } // public void apresentarTelaLogin() {

    public boolean logar() {
                
        // Simula a verificação de credenciais
        if (usuario.equals("admin") && senha.equals("senha123")) {
            System.out.println("Login bem-sucedido!");
            isLoggedIn = true; // Define o estado de login como verdadeiro
        } else {
            System.out.println("Credenciais inválidas. Tente novamente.");
            isLoggedIn = false; // Define o estado de login como falso
        }
        
        // Retorna o estado de login
        return isLoggedIn;

    } // public void logar() {














    

    // Método principal para fins de teste da classe Login
    // Este método é usado para testar a funcionalidade de login sem precisar de uma interface gráfica
    public static void main(String[] args) {

        // Método principal para iniciar o aplicativo
        Login login = new Login();

        // Apresenta a tela de login
        if (login.apresentarTelaLogin()) {
                System.out.println("Login bem-sucedido!");
                // instancia um objeto da classe MenuPrincipal
                // que contém o método exibirMenu para exibir o menu principal
                MenuPrincipal menuPrincipal = new MenuPrincipal();
                menuPrincipal.exibirMenu();
                }
            else {

                // Se o login falhar, exibe uma mensagem e encerra o aplicativo
                // Aqui você pode implementar a lógica para lidar com o login falho, como exibir uma mensagem de erro
                System.out.println("Login falhou. Encerrando o aplicativo.");
                System.exit(0);
                } // if (login.apresentarTelaLogin()) {

        // Fecha o Scanner para liberar os recursos
        login.fecharScanner();
        
    } // public static void main(String[] args) {
    
} // public class Login {
