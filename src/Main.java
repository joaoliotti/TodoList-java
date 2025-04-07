import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Tarefa> tarefas = new ArrayList<>();

        System.out.println("Bem vindo ao Sistema de Tarefas");
        System.out.println("Digite Suas tarefas ou 'sair' para fechar o sisteman\n");

        while(true) {
            System.out.println("\n==== MENU ====");
            System.out.println("1 - Adicionar Tarefa");
            System.out.println("2 - Listar Tarefas");
            System.out.println("3 - Remover uma tarefa");
            System.out.println("4 - Marcar como concluída");
            System.out.println("5 - Salvar em um arquivo as tarefas");
            System.out.println("6 - Sair");
            String opcao = scanner.nextLine();

            switch (opcao){

                case "1":
                    System.out.println("Digite uma tarefa: ");
                    String titulo = scanner.nextLine().trim();
                    LocalDateTime criadaEm = (LocalDateTime.now());
                    DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

                    if (titulo.isEmpty()) {
                        System.out.println("O campo não pode ser vazio");
                    }else{
                        tarefas.add(new Tarefa(titulo));
                        System.out.println("Tarefa adicionada com sucesso em " + criadaEm.format(dataFormatada));
                        System.out.println(titulo);
                    }
                    break;

                case "2":
                    if (tarefas.isEmpty()) {
                        System.out.println("Nenhuma tarefa adicionada");
                    }else{
                        System.out.println("Lista de tarefas");
                        for (int i = 0; i < tarefas.size(); i++){
                            System.out.println((i + 1) + " - " + tarefas.get(i));
                        }
                    }
                    break;

                case "3" :
                    if (tarefas.isEmpty()) {
                        System.out.println("Não há tarefas para remover");
                        break;
                    }
                    System.out.println("\nTarefas");
                    for(int i = 0; i < tarefas.size(); i++){
                        System.out.println((i + 1) + " - " + tarefas.get(i));
                }
                    System.out.println("Digite o numero da tarefa que deseja remover: ");
                try {
                    int indice = Integer.parseInt(scanner.nextLine());

                    if (indice < 1 || indice > tarefas.size()) {
                        System.out.println("Número inválido.");
                    } else {
                        Tarefa removida = tarefas.remove(indice - 1);
                        System.out.println("Tarefa removida: " + removida);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Digite um número.");
                }
                break;

                case "4" :
                    if (tarefas.isEmpty()) {
                        System.out.println("Não há tarefas");
                        break;
                    }

                    System.out.println("\nTarefas");
                    for (int i = 0; i < tarefas.size(); i++){
                        Tarefa t = tarefas.get(i);
                        String status = t.concluida ? "🟢" : "[ ]";
                        System.out.println((i + 1) + " - " + status + " " + t.titulo);
                    }

                    System.out.println("Digite o numero da tarefa concluída: ");
                    try{
                        int indice = Integer.parseInt(scanner.nextLine());
                        if (indice < 1 || indice > tarefas.size()){
                            System.out.println("Número inválido");
                        }else{
                            tarefas.get(indice - 1).concluida = true;
                            System.out.println("Tarefa marcada como concluída ");
                        }
                    } catch (NumberFormatException e){
                        System.out.println("Entrada inválida. Digite um número");
                    }
                    break;

                case "5" :
                    if (tarefas.isEmpty()) {
                        System.out.println("Não há tarefas para salvar");
                        break;
                    }
                    try{
                        FileWriter writer = new FileWriter("tarefas.txt");
                        for(Tarefa tarefa : tarefas){
                            String status = tarefa.concluida ? "Concluida" : "Pendente";
                            writer.write(tarefa.titulo + " - " + status +"\n");
                        }
                        System.out.println("Tarefas salvas com sucesso no arquivo tarefas.txt");
                        writer.close();
                    }catch (IOException e){
                        System.out.println("Erro ao salvar arquivo" + e.getMessage());
                    }
                    break;

                case "6" :
                    System.out.println("Saindo... Até mais !!! ");
                    scanner.close();
                    return;

                default :
                    System.out.println("Opção Inválida, Tente novamente");
                    break;
            }
        }
    }
}