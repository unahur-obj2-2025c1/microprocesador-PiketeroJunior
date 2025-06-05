package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class Swap implements Operable {
    private Integer acumA;
    private Integer acumB;
    private Integer pC;

    @Override
    public void execute(Programable micro) {
        acumA = micro.getAcumuladorA();
        acumB = micro.getAcumuladorB();
        pC = micro.getProgramCounter();

        micro.setAcumuladorA(acumB);
        micro.setAcumuladorB(acumA);
        micro.incProgramCounter();
    }

    @Override
    public void undo(Programable micro) {
        micro.setAcumuladorA(acumA);
        micro.setAcumuladorB(acumB);
        micro.setProgramCounter(pC);
    }
    
}
