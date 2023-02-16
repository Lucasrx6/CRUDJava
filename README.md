# Aplicação CRUD
## Objetivo
O objetivo dessa aplicação é realizar operações CRUD (Create, Read, Update e Delete) em uma lista de clientes, permitindo ao usuário cadastrar, listar, buscar, atualizar e excluir clientes.

## Funcionalidades
- `Funcionalidade 1`: Cadastro de cliente com validação de dados (nome, telefone e email);

- `Funcionalidade 2`: Listagem dos clientes cadastrados;

- `Funcionalidade 3`: Busca de um cliente pelo ID;

- `Funcionalidade 4`: Atualização dos dados de um cliente existente;

- `Funcionalidade 5`: Exclusão de um cliente existente.

- `Observação`: O executável deste programa está disponível na pasta raiz do repositório GitHub. Você pode baixar a pasta ou clonar o repositório para acessar o executável e utilizá-lo em seu sistema. Lembre-se de verificar os requisitos do sistema e seguir as instruções do README para garantir que o programa seja executado corretamente. Se você tiver dúvidas ou encontrar algum problema, por favor, abra uma issue no GitHub para que eu possa ajudá-lo.

### Em funcionamento
1 - O programa possui validação de entrada para garantir que o usuário insira apenas valores numéricos válidos. Se o usuário digitar um valor inválido, o programa irá exibir uma mensagem de erro e solicitará que o usuário tente novamente.

2 - O programa também inclui verificações de erro para garantir que as entradas do usuário sejam válidas para as operações específicas que ele está realizando. Por exemplo, se o usuário tentar realizar uma divisão por zero, o programa irá exibir uma mensagem de erro informando que a operação não é válida.

3 - O programa possui suporte para as quatro operações matemáticas básicas: adição, subtração, multiplicação e divisão. O usuário pode escolher qual operação deseja realizar a partir do menu principal.

4 - O programa inclui um recurso que permite ao usuário realizar múltiplas operações sem precisar reiniciar o programa. Depois que uma operação é concluída, o programa perguntará ao usuário se ele deseja continuar ou sair.

5 - Se o usuário tentar realizar uma operação que não está listada no menu principal, o programa exibirá uma mensagem de erro informando que a operação não é reconhecida.

6 - O programa também inclui uma opção para o usuário visualizar o histórico de operações. Isso permitirá que o usuário visualize as operações que ele realizou anteriormente, bem como os resultados correspondentes.

## Tecnologias utilizadas
Java (versão 8)
IDE Eclipse
## Como instalar e usar
1- Faça o download dos arquivos da aplicação ou clone o repositório para o seu computador;

2 - Abra o projeto na IDE Eclipse ou em outra IDE de sua preferência;

3 - Compile e execute a classe Principal para iniciar a aplicação;

4 - Escolha uma das opções do menu para realizar a operação desejada:

5 - Para cadastrar um novo cliente, selecione a opção 1 e informe o nome, email e telefone do cliente;

6 - Para listar todos os clientes cadastrados, selecione a opção 2;

7 - Para buscar um cliente pelo ID, selecione a opção 3 e informe o ID do cliente;

8 - Para atualizar os dados de um cliente existente, selecione a opção 4 e informe o ID do cliente e os novos dados;

9 - Para excluir um cliente existente, selecione a opção 5 e informe o ID do cliente;

10 - Para sair da aplicação, selecione a opção 0.

### Observação: 
Essa aplicação não utiliza banco de dados, apenas armazena os dados em um array na memória. Caso o programa seja finalizado, os dados serão perdidos. Para persistir os dados, seria necessário utilizar um banco de dados ou outro tipo de armazenamento permanente.
