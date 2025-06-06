package ar.edu.unahur.obj2.command.comandos;

import java.util.List;

import ar.edu.unahur.obj2.command.Programable;

public class Whnz implements Operable {
    private final List<Operable> operaciones;

    public Whnz (List<Operable> operaciones){
        this.operaciones = operaciones;
    }
    @Override
    public void execute(Programable micro) {
        while (micro.getAcumuladorA() != 0) {
            for (Operable operacion : operaciones) {
                operacion.execute(micro);
            }
        }
        micro.incProgramCounter();
    }

    @Override
    public void undo(Programable micro) {}
    
}
