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
