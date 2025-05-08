## API de sistema de gastos e receitas

### Sobre o projeto
- APi de ajuda financeira, para cadastro de Receitas e gastos mensais.
- Feita com Java (Spring Boot) e PostgreSQL.
  
- A aplicação possui as funcionalidades de:
   - Cadastrar uma receita.
     ![{C9C35390-5967-4204-8634-BA038EC26FFB}](https://github.com/user-attachments/assets/707e6ac9-036b-4e08-a43c-e8e5abf2d4bb)
   - Total de receita de mês específico.
     ![{BAF0516B-25A3-4190-940B-3CB3D3E05F81}](https://github.com/user-attachments/assets/e53ec2e1-e08f-4962-9138-c1289b8f4f78)
   - Buscar receita por origem (TRABALHO, FREELANCER, VENDA).
     ![{EFC84981-F03E-4075-BC16-67851F0B6DCA}](https://github.com/user-attachments/assets/39eda76a-fa63-482a-a33f-a0f944be8532)
   - Deletar uma receita.
     ![{514F44F2-0847-42A7-951A-6C234025096D}](https://github.com/user-attachments/assets/8ba91445-3f37-40e5-9a1e-529d4df556bf)
   - Cadastrar despesa.
     ![{8643475C-42DC-4A96-9B71-D6DFF372CA38}](https://github.com/user-attachments/assets/06a0a336-da4f-4f18-aa11-cc868a288e44)
   - Total de despesas de mês específico.
     ![{E21E9875-119F-4E96-8A64-BF98379BBFFE}](https://github.com/user-attachments/assets/701845f5-f19a-485b-a54f-88f445baf0a5)
   - Buscar despesa por categoria (ALIMENTACAO, TRANSPORTE, LAZER, CASA, ENTRETENIMENTO).
     ![{ACEF4C17-28E3-4F52-B361-FBDC312CB55A}](https://github.com/user-attachments/assets/d0195a6e-ed40-49a5-b209-c7566ecdad86)
   - Deletar uma despesa.
     ![{A1E5099E-66C5-4837-A9D0-D0650C04B02E}](https://github.com/user-attachments/assets/960b9863-9c78-40bf-ba2a-540b8fa1fb96)
   - Listar todoas as transações feitas(Receitas e Despesas).
     ![{44DE967B-5921-4FD3-834A-74F7D0BDC603}](https://github.com/user-attachments/assets/0f5c2743-7367-46cb-858e-47a32fd2693a)
   - Saldo total de mês específico.
     ![{EA51185B-2A7A-47E1-A656-735A8293E287}](https://github.com/user-attachments/assets/18c56ac3-fd08-44f2-ac40-3a546a464adb)

- Técnico
  - Projeto feito em Spring Boot, separado por camadas de responsabilidade:
    - Models -> camada com as representações das entidades do sistema e das tabelas do banco de dados, Receita, Despesa.
    - Repository -> camada com interfaces que herdam da JpaRepository, para operações com banco de dados.
    - Services -> camada responsável pela lógica de negócio da aplicação, funcionalidades básicas de cada classe.
    - Controller -> camada que representá os endpoints da API.
    - DTO -> Estrutura de dados otimizada para transferência entre camadas, para evitar expor as entidades.
  - Banco de dados utilizado -> PostgreSQL
 
## Autor
- Matheus Manoel Souza da Silva
- https://www.linkedin.com/in/matheus-manoel-92b578220/
