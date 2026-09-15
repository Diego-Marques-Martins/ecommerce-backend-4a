insert into categoria (nome, descricao) values ('Livros', 'Livros Técnicos');
insert into categoria (nome, descricao) values ('Eletrônicos', 'Equipamentos Eletrônicos');
insert into categoria (nome, descricao) values ('Escritório', 'Material de Escritório');
insert into categoria (nome, descricao) values ('Informática', 'Produtos de Informática');
insert into categoria (nome, descricao) values ('Acessórios', 'Acessórios Eletrônicos');


insert into produto (nome, descricao, preco, estoque, categoria_id) values ('Código Limpo', 'Livro do Autor Robert Martin', 73.44, 20, 1);
insert into produto (nome, descricao, preco, estoque, categoria_id) values ('Notebook', 'Notebook para uso profissional', 3500.00, 10, 4);
insert into produto (nome, descricao, preco, estoque, categoria_id) values ('Monitor', 'Monitor LED 24 polegadas', 1200.00, 15, 4);
insert into produto (nome, descricao, preco, estoque, categoria_id) values ('Caderno', 'Caderno para anotações', 25.90, 50, 3);
insert into produto (nome, descricao, preco, estoque, categoria_id) values ('Mouse', 'Mouse óptico USB', 80.00, 30, 5);


insert into cliente (nome, email, telefone) values ('Diego', 'diego@gmail.com', '43996718994');
insert into cliente (nome, email, telefone) values ('João', 'joao@gmail.com', '43996718995');
insert into cliente (nome, email, telefone) values ('Maria', 'maria@gmail.com', '43996718996');
insert into cliente (nome, email, telefone) values ('Pedro', 'pedro@gmail.com', '43996718997');
insert into cliente (nome, email, telefone) values ('Ana', 'ana@gmail.com', '43996718998');


insert into pedido (data, status, valor_total, cliente_id) values ('2026-09-01 10:30:00', 'Pago', 3500.00, 1);
insert into pedido (data, status, valor_total, cliente_id) values ('2026-09-02 11:00:00', 'Pago', 1200.00, 2);
insert into pedido (data, status, valor_total, cliente_id) values ('2026-09-03 14:30:00', 'Pendente', 73.44, 3);
insert into pedido (data, status, valor_total, cliente_id) values ('2026-09-04 15:00:00', 'Pago', 25.90, 4);
insert into pedido (data, status, valor_total, cliente_id) values ('2026-09-05 16:30:00', 'Pendente', 80.00, 5);


insert into item_pedido (quantidade, valor_unitario, pedido_id, produto_id) values (1, 3500.00, 1, 2);
insert into item_pedido (quantidade, valor_unitario, pedido_id, produto_id) values (1, 1200.00, 2, 3);
insert into item_pedido (quantidade, valor_unitario, pedido_id, produto_id) values (1, 73.44, 3, 1);
insert into item_pedido (quantidade, valor_unitario, pedido_id, produto_id) values (1, 25.90, 4, 4);
insert into item_pedido (quantidade, valor_unitario, pedido_id, produto_id) values (1, 80.00, 5, 5);


insert into pagamento (valor, data, status, tipo, pedido_id) values (3500.00, '2026-09-01 10:30:00', 'Aprovado', 'Pix', 1);
insert into pagamento (valor, data, status, tipo, pedido_id) values (1200.00, '2026-09-02 11:00:00', 'Aprovado', 'Cartao', 2);
insert into pagamento (valor, data, status, tipo, pedido_id) values (73.44, '2026-09-03 14:30:00', 'Pendente', 'Boleto', 3);
insert into pagamento (valor, data, status, tipo, pedido_id) values (25.90, '2026-09-04 15:00:00', 'Aprovado', 'Pix', 4);
insert into pagamento (valor, data, status, tipo, pedido_id) values (80.00, '2026-09-05 16:30:00', 'Pendente', 'Cartao', 5);