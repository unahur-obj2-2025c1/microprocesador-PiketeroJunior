package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class Nop implements Operable {
    private Integer pC;

    @Override
    public void execute(Programable micro) {
        pC = micro.getProgramCounter();
        micro.incProgramCounter();
    }

    @Override
    public void undo(Programable micro) {
        micro.setProgramCounter(pC);
    }
    
}
