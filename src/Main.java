public class Main {
    public static void main(String[] args) {
        UserProfile targetUser = new UserProfile(101, "Joana Silva", "joana@empresa.com", 90000);

        // TESTE 1: ADMIN
        UserAccessProxy admin = new UserAccessProxy(targetUser, "ADMIN", 999);
        System.out.println("\n--- TESTE 1: ADMIN ---");
        System.out.println(admin.getSalary());
        System.out.println(admin.updateEmail("joana.nova@empresa.com"));

        // TESTE 2: USER
        UserAccessProxy user = new UserAccessProxy(targetUser, "USER", 202);
        System.out.println("\n--- TESTE 2: USER ---");
        System.out.println(user.getSalary());
        System.out.println(user.updateEmail("joana.outra@empresa.com"));

        // TESTE 3: OWNER
        UserAccessProxy owner = new UserAccessProxy(targetUser, "USER", 101);
        System.out.println("\n--- TESTE 3: OWNER ---");
        System.out.println(owner.getSalary());
        System.out.println(owner.updateEmail("joana.final@empresa.com"));
}
}
