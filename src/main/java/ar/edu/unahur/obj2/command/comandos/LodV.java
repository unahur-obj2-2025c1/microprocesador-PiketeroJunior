package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class LodV implements Operable{
    private Integer valor;
    private Integer acumA;
    private Integer pC;

    public LodV (Integer valor){
        this.valor = valor;
    }

    @Override
    public void execute(Programable micro) {
        acumA = micro.getAcumuladorA();
        pC = micro.getProgramCounter();

        micro.setAcumuladorA(valor);
        micro.incProgramCounter();
    }

    @Override
    public void undo(Programable micro) {
        micro.setAcumuladorA(acumA);
        micro.setProgramCounter(pC);
    }
    
}
