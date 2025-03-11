CREATE TABLE users (
    id SERIAL PRIMARY KEY,  -- SERIAL é equivalente a auto-incremento no PostgreSQL
    name VARCHAR(255) NOT NULL,  -- Nome do usuário, com tamanho máximo de 255 caracteres
    cpf VARCHAR(14) UNIQUE NOT NULL,  -- CPF do usuário, com tamanho fixo de 14 caracteres (incluindo pontuações)
    email VARCHAR(255) UNIQUE NOT NULL,  -- Email do usuário, com tamanho máximo de 255 caracteres
    group_id INT NOT NULL,  -- Chave estrangeira para a tabela groups
    password VARCHAR(255) NOT NULL,  -- Senha do usuário, com tamanho máximo de 255 caracteres
    status BOOLEAN NOT NULL DEFAULT TRUE,  -- Status do usuário, com valor padrão TRUE (ativo)
    FOREIGN KEY (group_id) REFERENCES groups(id)  -- Relacionamento com a tabela groups
);

