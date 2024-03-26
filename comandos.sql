--Primeiro, exclua a restrição de chave estrangeira existente
ALTER TABLE dependentes
DROP CONSTRAINT fk_cliente_id;


-- Em seguida, adicione a restrição de chave estrangeira com ON DELETE CASCADE
-- Esse srcipt foi necessário para adicionar a correta exclusão em cascata dos dependentes.
ALTER TABLE dependentes
ADD CONSTRAINT fk_cliente_id
FOREIGN KEY (cliente_id)
REFERENCES clientes(id)
ON DELETE CASCADE;

--Essa cláusula foi necessária para alimetar a tabela HTML com os dados pertinentes : Valor Total do Pedido e Imposto de Renda.
SELECT data_pedido,forma_pagamento,quantidade,valor_unitario,cliente_id,produto_id,(quantidade*valor_unitario) as valor_total,
((quantidade * valor_unitario) * 0.3575) as imposto
FROM pedidos

-- Comentário: campo calculado não se coloca no BD, se coloca no código ou numa stored procedure.

