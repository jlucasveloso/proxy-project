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
%% Diagrama de Arquitetura - Protection Proxy
graph TD
    %% Define os Atores Externos
    Cliente("fa:fa-user Cliente (main)")
    User("fa:fa-id-badge Usuário Logado (com Roles/ID)")

    %% Define o Sistema Interno (como a VPC no exemplo)
    subgraph "Sistema de Controle de Acesso"
        direction LR
        
        %% 1. Camada de Proteção (O "Porteiro")
        subgraph "Camada de Proteção"
            Proxy("fa:fa-shield-alt UserAccessProxy")
        end

        %% 2. Serviços Internos (Protegidos)
        subgraph "Serviços Internos"
            Real("fa:fa-database UserProfile (Serviço Real)")
            Log("fa:fa-file-alt Logger (Auditoria)")
        end
        
        %% Define as interações internas
        Proxy -- "4. [SE PERMITIDO] Encaminha Solicitação" --> Real
        Real -- "5. Retorna Dados Reais" --> Proxy
        Proxy -- "3. Registra Tentativa (Permitida/Negada)" --> Log
    end

    %% Define o Fluxo de Entrada e Saída
    Cliente -- "1. Solicitação (ex: getSalary())" --> Proxy
    User -- "2. Fornece Credenciais" --> Proxy
    Proxy -- "6. Resposta (Dados ou Erro de Acesso)" --> Cliente

    %% Estilização (opcional, mas ajuda)
    classDef externo fill:#D2FAD2,stroke:#333
    classDef interno fill:#D2D2FA,stroke:#333
    classDef proxy fill:#FAD2D2,stroke:#B00,stroke-width:2px
    class Cliente,User externo
    class Real,Log interno
    class Proxy proxy
## 🧩 Divisão de Tarefas

| Membro | Função | Tarefas de Desenvolvimento | Tarefas de Apresentação |
| :--- | :--- | :--- | :--- |
| **Membro A** | 1️⃣ Arquiteto e Testador | - Definir a arquitetura (estrutura) e relação entre classes <br>- Criar o diagrama UML <br>- Implementar o cliente (`main`) e fazer os testes no código <br>- Ajudar na integração dos componentes | - Preparar a demonstração final |
| **Membro B** | 2️⃣ Serviço Real (UserProfile) | - Implementar a classe base `UserProfile` com dados e métodos | (Responsabilidade do Membro E) |
| **Membro C** | 3️⃣ Proxy de Proteção | - Implementar a classe `UserAccessProxy` <br>- Realizar o controle de acesso (ADMIN, USER, OWNER) | (Responsabilidade do Membro E) |
| **Membro D** | 4️⃣ Logger/Auditoria | - Implementar a classe `Logger` <br>- Registrar ações (logs, acessos permitidos/negados) <br>- Integrar o Logger ao Proxy | (Responsabilidade do Membro E) |
| **Membro E** | 5️⃣ Apresentação | - (Apoio na documentação, se necessário) | - Criar todos os slides da apresentação (Introdução, Serviço Real, Proxy, Logger, Testes e Conclusão) |

---
