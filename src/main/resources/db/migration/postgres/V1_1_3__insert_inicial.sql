INSERT INTO usuarios
(foto, nome, senha, usuario)
VALUES(NULL, 'Gustavo', '$2a$10$BophUi6FRohFY6voaKkcIuW1e8YPlrLbOFB3xUerDwQN4W4JMYBQy', 'galasdalas@gmail.com');

INSERT INTO clientes
(usuario_id,contato, nome)
VALUES(1,'11995671164', 'Geraldo');

INSERT INTO veiculos
(mensalidade, nome, placa, tipos_veiculos, uber, vencimento_boleto, cliente_id)
VALUES(11.5, 'Fusca', 'abc-1234', 'CAMINHAO', NULL, '10', 1);

INSERT INTO veiculos
(mensalidade, nome, placa, tipos_veiculos, uber, vencimento_boleto, cliente_id)
VALUES(11.5, 'Fiorino', 'def-4567', 'CAMINHAO', NULL, '10', 1);
