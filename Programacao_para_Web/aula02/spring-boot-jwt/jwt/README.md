# Como testar a aplicação

## Pré-requisitos

- Java 11 ou superior
- Maven

## Executando a aplicação

1. Clone o repositório
2. Navegue até a pasta do projeto
3. Execute o seguinte comando para iniciar a aplicação:

```bash
mvn spring-boot:run
```

## Testando as rotas

### 1. Obter um token JWT

Para acessar as rotas protegidas, você primeiro precisa obter um token JWT. Para fazer isso, envie uma requisição POST para a rota `/login` com o nome de usuário e senha corretos.

```bash
curl -X POST http://localhost:8080/login \
-H 'Content-Type: application/json' \
-d '{
    "username": "admin",
    "password": "123"
}'
```

A resposta será um token JWT. Copie este token para usar na próxima etapa.

### 2. Acessar uma rota protegida

Agora você pode usar o token JWT para acessar qualquer rota protegida. Envie uma requisição GET para a rota `/hello`, incluindo o token no cabeçalho `Authorization`.

Substitua `SEU_TOKEN_JWT` pelo token que você recebeu na etapa anterior.

```bash
curl -X GET http://localhost:8080/hello \
-H 'Authorization: Bearer SEU_TOKEN_JWT'
```

Se o token for válido, você receberá a seguinte resposta:

```
Rota protegida!
```
