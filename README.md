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
