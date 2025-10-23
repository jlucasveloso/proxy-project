# 🛡️ Protection Proxy: Controle de Acesso a Dados do Usuário

Este projeto implementa o padrão de design estrutural **Protection Proxy** (Proxy de Proteção) para controlar e proteger o acesso a dados sensíveis de um perfil de usuário.  
O Proxy atua como intermediário entre o cliente e o objeto real, garantindo que apenas usuários com permissões adequadas possam acessar ou modificar informações restritas.

---

## 🎯 Objetivos

- **Implementar o Padrão Proxy:** Estruturar a aplicação com um objeto Real e um objeto Proxy com a mesma interface.  
- **Controle de Acesso:** Garantir que apenas usuários com as *roles* (`ADMIN`, `USER`) ou identificadores corretos (`OWNER`) possam acessar informações restritas.  
- **Simplicidade:** Toda a lógica é feita no Front-end (JavaScript), para fins didáticos e demonstração clara do padrão.

---

## 💻 Tecnologias Utilizadas

- **Java** → Implementação das classes e simulação no console.  
- **HTML (opcional)** → Pode ser utilizado para criar um ambiente de teste simples no navegador.  

---

## 🧩 Estrutura de Permissões

| Método | Tipo de Dado | Permissão Requerida |
| :--- | :--- | :--- |
| `getName()` | Público | `USER` (qualquer usuário logado) |
| `getSalary()` | Confidencial | `ADMIN` |
| `updateEmail()` | Restrito | `OWNER` (o próprio usuário) |

---

## 🛠️ Divisão de Tarefas

| Membro | Tarefa | Descrição |
| :--- | :--- | :--- |
| **Membro A: O Serviço Real** | **Implementar a classe `UserProfile`** | Criar a classe que contém os dados (`id`, `name`, `email`, `salary`). Os métodos apenas retornam ou modificam os dados, sem controle de acesso. |
| **Membro B: O Proxy de Proteção** | **Implementar a classe `UserAccessProxy`** | Criar a classe que envolve o `UserProfile`, aplicando a lógica de verificação de permissões antes de delegar chamadas. |
| **Membro C: O Cliente/Testes** | **Criar o ambiente de teste e cliente** | Criar o arquivo HTML (opcional) e o script de teste, instanciando diferentes perfis (ADMIN, USER, OWNER) para validar o funcionamento do Proxy. |

---
