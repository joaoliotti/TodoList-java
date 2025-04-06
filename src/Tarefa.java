import java.util.Date;

public class Tarefa{
    String titulo;
    boolean concluida;
    Date criadaEm;

    public Tarefa(String titulo){
        this.titulo = titulo;
        this.concluida = false;
        this.criadaEm = new Date();
    }

    public String toString(){
        return titulo;
    }
}

