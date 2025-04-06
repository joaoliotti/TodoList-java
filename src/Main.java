import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> tarefas = new ArrayList<>();

        System.out.println("Bem vindo ao Sistema de Tarefas");
        System.out.println("Digite Suas tarefas ou 'sair' para fechar o sisteman\n");

        while(true){
            System.out.println("Digite sua tarefa: ");
            String tarefa = scanner.nextLine();

            if(tarefa.equalsIgnoreCase("sair")){
                break;
            }

            if (tarefa.isEmpty()) {
                System.out.println("Campo não pode ser vazio");
                continue;
            }

            tarefas.add(tarefa);
        }
        System.out.println("\nLista de tarefas");
        for (String t : tarefas){
            System.out.println("- " + t);
        }

        if (tarefas.isEmpty()) {
            System.out.println("Opss...Lista vazia, preecha para focar mais nos seus objetivos !!!");
        }else{
            System.out.println("\nShoww de bola, você está focando nos seus objetivos");
        }
        scanner.close();
    }
}