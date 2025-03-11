CREATE TABLE groups (
    id SERIAL PRIMARY KEY,          -- ID único do grupo
    name VARCHAR(50) NOT NULL UNIQUE  -- Nome do grupo (ex: "Estoquista", "Administrador")
);