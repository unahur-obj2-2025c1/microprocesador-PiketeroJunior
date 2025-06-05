package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class Lod implements Operable {
    private final Integer addr;
    private Integer acumA;
    private Integer pC;
    
    public Lod(Integer addr) {
        this.addr = addr;
    }

    @Override
    public void execute(Programable micro) {
        acumA = micro.getAcumuladorA();
        pC = micro.getProgramCounter();

        micro.setAcumuladorA(micro.getAddr(addr));
        micro.incProgramCounter();
    }

    @Override
    public void undo(Programable micro) {
        micro.setAcumuladorA(acumA);
        micro.setProgramCounter(pC);
    }
    
}
