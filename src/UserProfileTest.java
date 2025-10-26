public class UserProfileTest {
    
    public void runTests() {
        System.out.println("\n=== Iniciando Testes de Acesso ===\n");
        
        // Cenário de teste do administrador
        UserProfile targetUser = new UserProfile(101, "Joana Silva", "joana@empresa.com", 90000);
        UserAccessProxy admin = new UserAccessProxy(targetUser, "ADMIN", 999);
        System.out.println("Teste Admin:");
        System.out.println("- Acesso ao salário: " + admin.getSalary());
        
        // Cenário de teste do usuário comum
        UserAccessProxy regularUser = new UserAccessProxy(targetUser, "USER", 102);
        System.out.println("\nTeste Usuário Comum:");
        System.out.println("- Acesso ao salário: " + regularUser.getSalary());
        
        // Cenário de teste do próprio usuário
        UserAccessProxy owner = new UserAccessProxy(targetUser, "USER", 101);
        System.out.println("\nTeste Proprietário:");
        System.out.println("- Acesso ao salário: " + owner.getSalary());
        
        System.out.println("\n=== Testes Concluídos ===");
    }

}