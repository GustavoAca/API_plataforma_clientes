INSERT INTO usuarios
(foto, nome, senha, usuario)
VALUES(NULL, 'Gustavo', '$2a$10$BophUi6FRohFY6voaKkcIuW1e8YPlrLbOFB3xUerDwQN4W4JMYBQy', 'galasdalas@gmail.com');

INSERT INTO clientes
(contato, nome, usuario_id)
VALUES('11995671164', 'Geraldo', 1);

INSERT INTO clientes
(contato, nome, usuario_id)
VALUES('11995671165', 'Grimaldo', 1);

INSERT INTO clientes
(contato, nome, usuario_id)
VALUES('11995671166', 'Gabriel', 1);

INSERT INTO clientes
(contato, nome, usuario_id)
VALUES('11995671167', 'Grealdo', 1);


INSERT INTO bemprotege.veiculos
(mensalidade, nome, placa, tipos_veiculos, uber, vencimento_boleto, cliente_id)
VALUES(11.5, 'Fusca', 'abc-1234', 'CAMINHAO', NULL, '10', 1);

INSERT INTO bemprotege.veiculos
(mensalidade, nome, placa, tipos_veiculos, uber, vencimento_boleto, cliente_id)
VALUES(11.5, 'Fiorino', 'def-4567', 'CAMINHAO', NULL, '10', 2);

INSERT INTO bemprotege.veiculos
(mensalidade, nome, placa, tipos_veiculos, uber, vencimento_boleto, cliente_id)
VALUES(11.5, 'Punto', 'ghi-8901', 'CAMINHAO', NULL, '15', 3);

INSERT INTO bemprotege.veiculos
(mensalidade, nome, placa, tipos_veiculos, uber, vencimento_boleto, cliente_id)
VALUES(11.5, 'Gol', 'jkl-2345', 'CAMINHAO', NULL, '20', 4);
