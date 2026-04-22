

# 📦 API CRUD - Java Spring Boot

API REST desenvolvida com **Java + Spring Boot** para gerenciamento de produtos.

---

## 🚀 Tecnologias utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate
- Lombok
- Banco de dados H2

---

## 📌 Endpoints da API

### ➕ Criar produto

**POST /products**

#### Request
```json
{
  "name": "Produto Exemplo",
  "description": "Descrição do produto",
  "imageUrl": "https://imagem.com/produto.png",
  "category": "ELECTRONICS",
  "priceInCents": 150000
}
```

#### Response
```json
{
  "id": "uuid",
  "name": "Produto Exemplo",
  "description": "Descrição do produto",
  "imageUrl": "https://imagem.com/produto.png",
  "category": "ELECTRONICS",
  "priceInCents": 150000,
  "createdAt": "2026-04-09T10:00:00Z"
}
```

---

### 📋 Listar produtos

**GET /products**

#### Response
```json
{
  "items": [
    {
      "id": "e9ab1d09-d46d-464b-82a2-9509268b9c81",
      "name": "Caneca Java",
      "description": "Caneca clássica para dev Java.",
      "imageUrl": "https://imgs.extra.com.br/1561024386/2xg.jpg?imwidth=1000",
      "category": "mugs",
      "priceInCents": 4990
    },
    {
      "id": "65e892c2-9218-4dbe-9f26-4531265df9cf",
      "name": "Camisa Spring Boot",
      "description": "Caneca clássica para dev Java.",
      "imageUrl": "https://imgs.extra.com.br/1561024386/2xg.jpg?imwidth=1000",
      "category": "t-shirt",
      "priceInCents": 7998
    }
  ],
  "total": 2
}
```

---

### 🔍 Buscar produto por ID

**GET /products/{id}**

#### Response
```json
{
  "id": "e9ab1d09-d46d-464b-82a2-9509268b9c81",
  "name": "Caneca Java",
  "description": "Caneca clássica para dev Java.",
  "imageUrl": "https://imgs.extra.com.br/1561024386/2xg.jpg?imwidth=1000",
  "category": "mugs",
  "priceInCents": 4990
}
```

---

### ✏️ Atualizar produto

**PUT /products/{id}**

#### Request
```json
{
  "id": "e9ab1d09-d46d-464b-82a2-9509268b9c81",
  "name": "Produto Atualizado",
  "description": "Nova descrição",
  "imageUrl": "https://imagem.com/nova.png",
  "category": "BOOKS",
  "priceInCents": 200000
}
```

---

### ❌ Deletar produto

**DELETE /products/{id}**

---

## ▶️ Como rodar o projeto

```bash
# Clonar o repositório
git clone https://github.com/seu-usuario/api-crud-java-springboot.git

# Entrar na pasta
cd api-crud-java-springboot

# Rodar aplicação
./mvnw spring-boot:run
```

---

## 📌 Observações

- O ID é gerado automaticamente (UUID)
- O campo `createdAt` é preenchido automaticamente
- O preço é armazenado em centavos (`priceInCents`)

## 👨‍💻 Autor

Lucas Santana🚀
