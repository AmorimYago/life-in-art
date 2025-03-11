CREATE TABLE product (
    id SERIAL PRIMARY KEY,  -- ID único do produto (auto-incremento)
    name VARCHAR(200) NOT NULL,  -- Nome do produto (máximo de 200 caracteres)
    rating NUMERIC(2,1) CHECK (rating BETWEEN 1 AND 5),  -- Avaliação (de 1 a 5, variando de 0.5 em 0.5)
    description TEXT,  -- Descrição detalhada (até 2000 caracteres)
    price NUMERIC(10,2) NOT NULL,  -- Preço do produto (valor monetário com 2 casas decimais)
    stock_quantity INT CHECK (stock_quantity >= 0)  -- Quantidade em estoque (valor inteiro não negativo, pode ser nulo)
);