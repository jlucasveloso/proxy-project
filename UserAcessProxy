public class UserAccessProxy {
    private UserProfile profile;
    private String role;
    private int requesterId;

    public UserAccessProxy(UserProfile profile, String role, int requesterId) {
        this.profile = profile;
        this.role = role;
        this.requesterId = requesterId;
    }

    public String getName() {
        return profile.getName();
    }

    public String getSalary() {
        if (role.equals("ADMIN")) {
            return "Salário: " + profile.getSalary();
        } else {
            return "ERRO: Acesso negado. Permissão de administrador requerida.";
        }
    }

    public String updateEmail(String newEmail) {
        if (requesterId == profile.getId()) {
            return profile.updateEmail(newEmail);
        } else {
            return "ERRO: Acesso negado. Apenas o proprietário pode alterar o email.";
        }
    }
}
