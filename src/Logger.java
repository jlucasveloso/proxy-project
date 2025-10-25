import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {



    public boolean checarValidade(Boolean validade){
        return  validade;
    }



    public void criarRegistro(UserProfile usuario, boolean validade) {

        String caminho = "Exemplo.txt";
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataAtual = agora.format(formato);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminho, true))) { // Modo append
            if (validade) {
                writer.write(String.format("%s chamado %s logou no sistema às %s",
                        usuario.getId(), usuario.getName(), dataAtual));
            } else {
                writer.write("Tentativa de log suspeita: ");
                writer.write(String.format("%s chamado %s logou no sistema às %s",
                        usuario.getId(), usuario.getName(), dataAtual));
            }
            writer.newLine(); // Adiciona quebra de linha
        } catch (IOException e) {
            throw new RuntimeException("Erro ao escrever no arquivo: " + e.getMessage(), e);
        }
    }

    public void lerRegistro() {
        String caminho = "Exemplo.txt";
        // Códigos ANSI para cores
        final String ANSI_RED = "\u001B[31m"; // Para logs suspeitos
        final String ANSI_GREEN = "\u001B[32m"; // Para logs válidos
        final String ANSI_RESET = "\u001B[0m";

        try (BufferedReader reader = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                // Verifica se a linha contém "Tentativa de log suspeita"
                String cor = linha.contains("Tentativa de log suspeita") ? ANSI_RED : ANSI_GREEN;
                System.out.println(cor + linha + ANSI_RESET);
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler o arquivo: " + e.getMessage(), e);
        }
    }

}
