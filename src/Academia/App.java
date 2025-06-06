/* Convenções de nomenclatura em Java (nomes de variáveis, métodos, classes, constantes, pacotes e arquivos):
Variáveis locais e parâmetros (camelCase)             : int totalPreco; String nomeUsuario; float mediaNotas; boolean pedidoConfirmado;
Variáveis de instância (camelCase)                    : private long idTransacao; protected double saldoAtual;
Métodos (camelCase, verbos descritivos)               : void calcularTotal() {...} String buscarCliente(int id) {...} int gerarRelatorioAnual() {...} void atualizarEstoque(Produto item) {...}
Classes/Interfaces/Enums (PascalCase)                 : class PedidoVenda {...} interface ClienteDAO {...} enum StatusPedido {...} class GestorFinanceiro {...}
Exceções (PascalCase, terminam em "Exception")        : class DadosInvalidosException {...} class RedeIndisponivelException {...}
Constantes (SCREAMING_SNAKE_CASE)                     : public static final int MAX_RETRY_COUNT = 5; public static final String API_KEY = "xyz123"; public static final double GRAVIDADE_TERRA = 9.81;
Pacotes (lowercase, sem underscore)                   : package com.empresa.produto.submodulo; package org.sistema.banco.servicos;
Arquivos de classe (PascalCase.java, idêntico à classe pública): PedidoVenda.java; ClienteDAO.java;
Classes de teste (PascalCase, terminam em "Test")     : class ValidadorCpfTest {...} class ProcessadorPagamentoTest {...}
Parâmetros de tipo genérico (uma letra, maiúscula)    : class Fila<T> {...} Map<K, V> mapearDados() {...}
*/

package Academia;

import java.util.Scanner;

/**
 *
 * @author enio
 */
public class App {

    // Classe principal do aplicativo, onde a execução começa.
    // Contém o método main, que é o ponto de entrada do programa.
    public static void main(String[] args) {

        // Scanner é a classe.
        // input o nome do objeto.
        // new Scanner(System.in) invoca o construtor da classe Scanner que aceita um InputStream (neste caso, System.in, que representa a entrada padrão, geralmente o teclado).
        // input é criado e pode ser usado para ler dados do console.
        Scanner scanner = new Scanner(System.in);

        

        
    }
    
}
