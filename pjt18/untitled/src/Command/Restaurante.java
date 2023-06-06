package Command;

import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    private List<Tarefa> tarefas = new ArrayList<>();

    public void adicionarTarefa(Tarefa tarefa) {
        this.tarefas.add(tarefa);
    }

    public void executarTarefas() {
        for (Tarefa tarefa : tarefas) {
            tarefa.executar();
        }
        tarefas.clear();
    }

    public void cancelarTarefa(int indice) {
        if (indice >= 0 && indice < tarefas.size()) {
            Tarefa tarefa = tarefas.get(indice);
            tarefa.cancelar();
            tarefas.remove(indice);
        }
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }
}
