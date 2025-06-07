-- ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- Convenções de nomenclatura para o SQL:
-- Colunas (snake_case)             : saldo_atual; data_criacao; nome_completo; preco_unitario; status_pedido;                                                                                       
-- Constantes (UPPER_SNAKE_CASE)    : MAX_RETRY_COUNT=5; API_KEY='xyz123'; GRAVIDADE_TERRA=9.81; TAXA_JUROS_ANUAL=0.05; LIMITE_USUARIOS=1000;                                                        
-- Constraints (sufixo _constraint) : check_dados_validos_constraint; check_rede_disponivel_constraint; check_saldo_positivo_constraint; check_email_unico_constraint; check_data_futura_constraint; 
-- Funções (snake_case, verbos)     : calcular_total(); buscar_cliente(); gerar_relatorio_anual(); atualizar_estoque(); validar_usuario();                                                           
-- Parâmetros (snake_case)          : id_transacao; valor_total; data_inicio; nome_usuario; codigo_produto;                                                                                          
-- Schemas (lowercase)              : empresa_produto; sistema_banco; gestao_vendas; controle_estoque; modulo_financeiro;                                                                            
-- Tabelas (snake_case, plural)     : pedidos_vendas.sql; clientes.sql; produtos_estoque.sql; usuarios_sistema.sql; vendas_anuais.sql;                                                               
-- Tabelas teste (sufixo _test)     : validador_cpf_test; processador_pagamento_test; calculadora_imposto_test; gerenciador_estoque_test; autenticador_usuario_test;                                 
-- Variáveis (snake_case)           : id_transacao; saldo_atual; total_calculado; ultima_data; codigo_gerado;                                                                                        
-- Views (prefixo vw_)              : vw_pedidos_vendas; vw_clientes_ativos; vw_produtos_disponiveis; vw_vendas_mensais; vw_usuarios_bloqueados;                                                     
-- 
-- Arquivos de criação de tabelas (snake_case, plural, .sql): pedidos_vendas.sql; clientes.sql; produtos_estoque.sql; usuarios_sistema.sql; vendas_anuais.sql;
-- 
-- ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- Tabela Comparativa de Charsets no MariaDB/MySQL:
-- +-----------------------+-------------------------------+------------------+--------------------------------+-----------------------------+
-- | Charset               | Descrição                     | Suporte Unicode  | Caso de Uso                    | Limitações                  |
-- +-----------------------+-------------------------------+------------------+--------------------------------+-----------------------------+
-- | utf8mb4               | Charset Unicode completo      | Sim (todos)      | Aplicações globais, emojis     | Usa mais espaço             |
-- | utf8mb4_uca1400_ai_ci | Collation avançada p/ utf8mb4 | Sim (todos)      | Ordenação linguística precisa  | Desempenho mais lento       |
-- | utf8 (utf8mb3)        | Charset Unicode limitado      | Sim (BMP)        | Dados legados, apps simples    | Não suporta emojis          |
-- | ascii                 | Charset básico (7 bits)       | Não              | Dados simples, apenas ASCII    | Muito limitado (127 chars)  |
-- | utf16                 | Charset Unicode (16 bits)     | Sim (todos)      | Dados Unicode, apps específicas| Usa mais espaço que utf8mb4 |
-- | cp65001               | Alias p/ UTF-8 (Windows)      | Sim (todos)      | Integração com sistemas Windows| Não nativo no MariaDB       |
-- | cp1252                | Charset Windows p/ pt_BR      | Não              | Texto em português brasileiro  | Sem suporte a Unicode       |
-- +-----------------------+-------------------------------+------------------+--------------------------------+-----------------------------+
-- ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- Script para criação do banco de dados "academia" e configuração de usuário
-- Criação do banco de dados, se existir remova-o e crie-o novamente
   DROP DATABASE IF EXISTS academia;
   CREATE DATABASE academia CHARACTER SET utf8mb4 COLLATE utf8mb4_uca1400_ai_ci;

-- Elimina usuario de acesso se existir
-- Cria usuario acesso que pode se conectar de qualquer host"%"
-- O usuário 'aplicacao' será usado para acessar o banco de dados pelo aplicativo do cliente. Neste projeto configurado em java
   DROP USER IF EXISTS 'aplicacao'@'%';
   CREATE USER 'aplicacao'@'%' IDENTIFIED BY '';

-- Consede privilégios totais ao banco de quanquer cliente de rede
-- O usuário 'aplicacao' terá acesso total ao banco de dados "academia"
   GRANT ALL ON academia.* TO 'aplicacao'@'%' IDENTIFIED BY '' ;

-- (Opcional) Define o usuário para não expirar a senha
   ALTER USER 'aplicacao'@'%' PASSWORD EXPIRE NEVER;

--  (Opcional) Define o usuário para não exigir autenticação de senha forte
   ALTER USER 'aplicacao'@'%' REQUIRE NONE; 

-- (Opcional) Exige SSL para conexões (se configurado no servidor)
-- ALTER USER 'aplicacao'@'' REQUIRE SSL;

-- Limita recursos do usuário
-- ALTER USER 'aplicacao'@'localhost' WITH 
--     MAX_CONNECTIONS_PER_HOUR 1000
--     MAX_QUERIES_PER_HOUR 5000
--     MAX_USER_CONNECTIONS 10;

-- Atualiza os privilégios
   FLUSH PRIVILEGES;

-- Apresenta os bancos de dados e verifica se o banco de dados foi criado
   SHOW DATABASES;

-- Mostra o usuário criado
   SELECT user, host FROM mysql.user WHERE user = 'aplicacao';

-- Define a code page e collation do banco de dados
   USE academia;   
-- SET NAMES utf8mb4 COLLATE utf8mb4_uca1400_ai_ci;
-- SET CHARACTER SET utf8mb4 COLLATE utf8mb4_uca1400_ai_ci;

-- verifica a configuração de charset do banco de dados
   SHOW VARIABLES LIKE 'character_set_database';
   SHOW VARIABLES LIKE 'collation_database';   
   SHOW VARIABLES LIKE 'character_set_server';    
   SHOW VARIABLES LIKE 'collation_server';