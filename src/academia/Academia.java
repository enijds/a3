/*

Sincronicação com o GitHub:

Associando o GitHub no Visual Studio Code
https://www.youtube.com/watch?v=peGUkhXD3Vw


Convenções de nomenclatura em Java (nomes de variáveis, métodos, classes, constantes, pacotes e arquivos):
Booleanos (camelCase, prefixados com "is" ou "has")   : boolean isAtivo; boolean hasPermissao; boolean isConectado;
Classes de teste (PascalCase, terminam em "Test")     : class ValidadorCpfTest {...} class ProcessadorPagamentoTest {...}
Classes/Interfaces/Enums (PascalCase)                 : class PedidoVenda {...} interface ClienteDAO {...} enum StatusPedido {...} class GestorFinanceiro {...}
Constantes (SCREAMING_SNAKE_CASE)                     : public static final int MAX_RETRY_COUNT = 5; public static final String API_KEY = "xyz123"; public static final double GRAVIDADE_TERRA = 9.81;
Exceções (PascalCase, terminam em "Exception")        : class DadosInvalidosException {...} class RedeIndisponivelException {...}
Métodos (camelCase, verbos descritivos)               : void calcularTotal() {...} String buscarCliente(int id) {...} int gerarRelatorioAnual() {...} void atualizarEstoque(Produto item) {...}
Pacotes (lowercase, sem underscore)                   : package com.empresa.produto.submodulo; package org.sistema.banco.servicos;
Parâmetros de tipo genérico (uma letra, maiúscula)    : class Fila<T> {...} Map<K, V> mapearDados() {...}
Variáveis de instância (camelCase)                    : private long idTransacao; protected double saldoAtual;
Variáveis locais e parâmetros (camelCase)             : int totalPreco; String nomeUsuario; float mediaNotas; boolean pedidoConfirmado;

Arquivos de classe (PascalCase.java, idêntico à classe pública): PedidoVenda.java; ClienteDAO.java;
*/

package academia;

import java.util.Scanner;

// O nome do arquivo é Academia.java, então a classe também deve ser Academia.
public class Academia {


    // Instancia um objeto da classe Scanner para ler a entrada do usuário
    public Scanner scanner = new Scanner(System.in);
    // Cria uma instância da classe TerminalTexto
    public TerminalTexto terminal = new TerminalTexto();

    public void fecharScanner() {
        // Método para fechar o Scanner
        // É importante fechar o Scanner para liberar os recursos associados a ele
        if (scanner != null) {
            scanner.close();
        }
    } // public void fecharScanner() {

    // Classe principal do aplicativo, onde a execução começa.
    // Contém o método main, que é o ponto de entrada do programa.
    public static void main(String[] args) {

        // Cria uma instância da classe TerminalTexto
        TerminalTexto terminal = new TerminalTexto();
        terminal.codePageUTF8Console();
        terminal.LimpaConsole();

        // Cria uma instancia da classe Login
        // Chama o metodo apresentarTelaLogin
        Login login = new Login();

        // Apresenta a tela de login
        if (login.apresentarTelaLogin()) {
                // instancia um objeto da classe MenuPrincipal
                // que contém o método exibirMenu para exibir o menu principal
                MenuPrincipal menuPrincipal = new MenuPrincipal();
                menuPrincipal.controleMenu();
                }
            else {

                // Se o login falhar, exibe uma mensagem e encerra o aplicativo
                // Aqui você pode implementar a lógica para lidar com o login falho, como exibir uma mensagem de erro
                System.exit(0);
                } // if (login.apresentarTelaLogin()) {

        // Fecha o Scanner para liberar os recursos
        login.fecharScanner();

    } // public static void main(String[] args) {
    

} // public class Academia {
