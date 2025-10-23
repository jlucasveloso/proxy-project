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
## 🧩 Divisão de Tarefas

| Membro                                                     | Função                               | Tarefas de Desenvolvimento                                                                                                                                                                            | Tarefas de Apresentação                                                                                            |
| :---------------------------------------------------------- | :----------------------------------- | :---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | :----------------------------------------------------------------------------------------------------------------- |
| **Membro A – Arquiteto do Sistema (Líder Técnico)**         | Responsável por estruturar o projeto | - Definir a arquitetura e relação entre classes (`UserProfile`, `UserAccessProxy`, `Logger`) <br>- Criar o diagrama UML simples (classes e interações) <br>- Ajudar nos testes de integração          | - Criar **1 slide introdutório** explicando o objetivo do projeto, o padrão Proxy e a motivação do problema        |
| **Membro B – Serviço Real (Classe Base)**                   | Desenvolvedor do modelo de dados     | - Implementar a classe `UserProfile` com atributos (`id`, `name`, `email`, `salary`) e métodos getters/setters <br>- Garantir encapsulamento e clareza no código                                      | - Criar **1 slide** mostrando o funcionamento do serviço real (sem Proxy) e por que ele precisa de controle        |
| **Membro C – Proxy de Proteção (Segurança)**                | Desenvolvedor da lógica de acesso    | - Implementar a classe `UserAccessProxy`, verificando permissões (ADMIN, USER, OWNER) antes de acessar ou modificar dados <br>- Delegar as operações ao `UserProfile` quando autorizado               | - Criar **2 slides** explicando a lógica de segurança e exemplos práticos (quem pode fazer o quê)                  |
| **Membro D – Logger/Auditoria (Controle e Monitoramento)**  | Desenvolvedor da camada de auditoria | - Criar classe `Logger` que salva ações com data/hora, tipo de usuário e resultado (permitido/negado) <br>- Integrar o `Logger` ao `UserAccessProxy` <br>- Implementar método `show_logs()` formatado | - Criar **1 slide** mostrando exemplos de logs e como o sistema melhora a rastreabilidade                          |
| **Membro E – Cliente/Testes (Integração e Demonstração)**   | Testador e apresentador final        | - Implementar o script `main` que cria perfis diferentes e executa operações (ADMIN, USER, OWNER) <br>- Validar todas as combinações de acesso e demonstrar logs no terminal                          | - Criar **2 slides** com resultados dos testes, prints do terminal e **conclusões** sobre segurança e uso do Proxy |


---
