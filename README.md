UserStory 1 Manter e exibir informações de um cliente (1,0 ponto)
- Adicione um novo cliente ao sistema. Manter as seguintes informações: código (único, autogerado), nome
completo, gênero (masculino, feminino, não informado), rua, bairro, número, cidade, e-Mail e número de
telefone com DDD. Tudo num CRUD: Create, Read, Update, Delete.

Contemplada via : Cliente.java/ClienteRepository/ClienteController.

UserStory 2 Manter e exibir informações de produtos (1,5 ponto)
- Adicione um novo produto ao sistema. Manter as seguintes informações: código (único, autogerado), nome
do produto, marca, tipo de tecido (máximo 5 alternativas), preço de compra, preço de venda ao cliente e
data de cadastro (automática). Tudo num CRUD: Create, Read, Update, Delete.

Contemplada via : Produto.java/ProdutoRepository/ProdutoController.

UserStory 3 Manter e exibir informação de dependentes de clientes (0,5 ponto)
- Adicione um novo dependente de um cliente ao sistema. Após o cadastro do cliente, será possível vincular
filho(s)/dependente(s). Manter as seguintes informações: código (único, autogerado), nome completo, data
de nascimento, gênero (masculino, feminino, não informado). Tudo num CRUD: Create, Read, Update,
Delete. Ao excluir um cliente, os dependentes são excluídos em cascata

Contemplado via : Dependente.java/DependenteRepositoy/DependenteController/COMMANDS SQL

UserStory 4 Manter e exibir informação de pedidos (2,0 pontos)
- Ao realizar um pedido, todos os produtos cadastrados são exibidos em uma listagem, ordenados
alfabeticamente pelo nome. O cliente deve selecionar os itens com a quantidade desejada. Ao cadastrar o
pedido, o cliente deve selecionar a forma de pagamento (dinheiro, cartão de crédito ou chave pix por tipo).
Guarde os dados pertinentes para a forma de pagamento (número do cartão ou valor pago).
- Ao cadastrar o pedido, os seguintes dados devem ser guardados: data do pedido, os itens que foram
pedidos (quantidade de produtos e valor unitário). Não há controle de estoque, a quantidade de produtos
disponível é infinita.
- Ao listar os pedidos, será possível visualizar o nome do cliente, o nome do produto, a quantidade
comprada, o valor unitário, o valor total dos produtos, o total do pedido, produtos com os valores e
quantidades, o cálculo de imposto (fixo em 35,75%) e a forma de pagamento.
- Ao excluir o pedido, o registro de produtos e de clientes não é afetado.
- Ao atualizar o pedido, é um caos.
- Tudo num CRUD: Create, Read, Update, Delete.
Contemplado, parcialmente, devido dificuldades encontradas via : Pedido.java/PedidoRepository/PedidoController/ListagemController/pedidos.musctache/COMMANDS SQL

Sobre os desafios lançados foram contemplados os :
Utilizar Bootstrap ✓.
Utilizar outra template engine diferente do thymeleaf  ✓.(Mustache Utilizado)
Utilizar o SGBD PostgreSQL ao invés do H2 ✓.
Validar o campo de telefone com javascript( Foi validado mas utilizando anotação @Pattern e Regex).
