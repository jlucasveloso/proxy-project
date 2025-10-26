public class UserProfile {
    private int id;
    private String name;
    private String email;
    private double salary;

    public UserProfile(int id, String name, String email, double salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String updateEmail(String newEmail) {
        this.email = newEmail;
        return "[SUCESSO] Email atualizado para " + newEmail;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }
}
