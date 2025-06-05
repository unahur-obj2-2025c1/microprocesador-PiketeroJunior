package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class Str implements Operable {
    private final Integer addr;
    private Integer valorPrevio;
    private Integer pC;

    public Str(Integer addr) {
        this.addr = addr;
    }

    @Override
    public void execute(Programable micro) {
        valorPrevio = micro.getAddr(addr);
        pC = micro.getProgramCounter();

        micro.setAddr(addr, micro.getAcumuladorA());
        micro.incProgramCounter();
    }

    @Override
    public void undo(Programable micro) {
        micro.setAddr(addr, valorPrevio);
        micro.setProgramCounter(pC);
    }
    
}
