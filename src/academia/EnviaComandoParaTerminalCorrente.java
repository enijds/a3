package academia;

import java.io.IOException;

public class EnviaComandoParaTerminalCorrente {

    // O método executarComando recebe um array de strings como parâmetro
    // onde o primeiro elemento é o comando a ser executado e os demais são os argumentos
    public void executarComando(String[] comando) {

        // Usa try-catch para lidar com exceções de IO e interrupção
        // O bloco try-catch é usado para capturar exceções que podem ocorrer durante a execução do comando    
        try {
                // Cria um ProcessBuilder com o comando fornecido
                // O comando deve ser um array de strings, onde o primeiro elemento é o comando e os demais são os argumentos
                ProcessBuilder processBuilder = new ProcessBuilder(comando);
                // Redireciona a saída para o terminal atual
                processBuilder.inheritIO();
                // Inicia o processo
                // O método start() do ProcessBuilder inicia o processo com o comando especificado
                Process process = processBuilder.start();
                // Aguarda o processo terminar
                // O método waitFor() bloqueia a thread atual até que o processo termine
                process.waitFor();
                } 
            // Captura exceções de IO e interrupção
            // Se ocorrer uma IOException ou InterruptedException, imprime a mensagem de erro no console    
            catch (IOException | InterruptedException e) {
                // Imprime a mensagem de erro no console
                // O método getMessage() retorna a mensagem de erro associada à exceção
                System.err.println("Erro: " + e.getMessage());
                }
        } // public static void executarComando(String[] comando) {

    



    // Método para testar frases com acentuação
    // Este método imprime frases com acentuação para verificar se o terminal está configurado corretamente
    // e se os caracteres acentuados são exibidos corretamente
    public void frasesTeste() {
        // Método para testar frases com acentuação
        System.out.println("-- Inicio do teste --");
        System.out.println("Teste de acentuação:");
        System.out.println("São Paulo, Café, Pão de queijo, Açúcar, Órgão");
        System.out.println("Acentuações em português: ç, ã, õ, â, ê, î, ô, û");
        System.out.println("Também: à, á, é, í, ó, ú, ü");
        System.out.println("O pão de queijo é delicioso.");
        System.out.println("Imprimindo tabela com BoxCaracter:");
        System.out.println("┌─────────────┐");
        System.out.println("│ Exemplo de  │");
        System.out.println("│ tabela com  │");
        System.out.println("│ BoxCaracter │");
        System.out.println("└─────────────┘");  
        System.out.println("Uma tabela com tres colunas, 5 linhas, cabelho e rodapé:");
        System.out.println("┌─────────┬─────────┬─────────┐");  
        System.out.println("│ Coluna 1│ Coluna 2│ Coluna 3│");  
        System.out.println("├─────────┼─────────┼─────────┤");  
        System.out.println("│ Linha 1 │ Linha 2 │ Linha 3 │");  
        System.out.println("├─────────┼─────────┼─────────┤");  
        System.out.println("│ Linha 4 │ Linha 5 │ Linha 6 │");  
        System.out.println("└─────────┴─────────┴─────────┘");
        System.out.println("---- Fim do teste ----");
    } // public void frasesTeste() {






    // Método para mudar a code page do terminal para UTF-8
    // Isso é necessário para garantir que os caracteres acentuados sejam exibidos corretamente
    public void codePageUTF8Terminal() {
        // Método para mudar a code page do terminal para UTF-8
        // Isso é necessário para garantir que os caracteres acentuados sejam exibidos corretamente
        String[] comando = {"cmd", "/c", "chcp", "65001"};
        // Importante: executarComando está sendo executado diretamente sem instanciar a classe
        // Isso é possível porque o método executarComando e codePageUTF8Terminal são métodos de instância
        executarComando(comando);
    } // public void codePageUTF8Terminal() {





    public int obterLarguraTerminalCMD() {
        // Método para obter a largura do terminal CMD
        // Este método executa o comando "mode con" e captura a saída para determinar a largura do terminal
        String[] comando = {"cmd", "/c", "mode con"};
        
        // Executa o comando e captura a saída
        executarComando(comando);
        
        // A lógica para capturar e processar a saída do comando pode ser implementada aqui
        // Por exemplo, você pode usar um BufferedReader para ler a saída do processo
        // e extrair a largura do terminal a partir dela.
        
        return 80; // Retorna um valor padrão de 80 colunas (pode ser ajustado conforme necessário)
    } // public void int obterLarguraTerminalCMD() {





    // Método para limpar o terminal
    // Este método executa o comando "cls" para limpar o terminal
    public void limparTerminal() {
        // Método para limpar o terminal
        // Este método executa o comando "cls" para limpar o terminal
        String[] comando = {"cmd", "/c", "cls"};

        executarComando(comando);
    }// public void limparTerminal() {






    // Testa a classe dentro da classe
    public static void main(String[] args) {
        
        // Cria uma instância da classe EnviaComandoParaTerminalCorrente
        // que contém o método para enviar comandos para o terminal
        // É preciso instanciar pois a classe está com o modificador static
        // Isso significa que não posso chamar o método diretamente na classe, preciso criar uma instância
        EnviaComandoParaTerminalCorrente terminal = new EnviaComandoParaTerminalCorrente();

        // define uma string do tipo array com o comando que será executado
        // String[] comando = {"cmd", "/c", "chcp", "65001"};
        String[] comando;

        // Chama o método para mudar a code page do terminal para UTF-8
        // Isso é necessário para garantir que os caracteres acentuados sejam exibidos corretamente
        terminal.codePageUTF8Terminal();
        
        // Chama o método para limpar o terminal
        // Isso é necessário para limpar o terminal antes de imprimir as frases de teste
        terminal.limparTerminal();

        // Chama o método para testar frases com acentuação
        terminal.frasesTeste();

    } // public static void main(String[] args) {






} // public class EnviaComandoParaTerminalCorrente {