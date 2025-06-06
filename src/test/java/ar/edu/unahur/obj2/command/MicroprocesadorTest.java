package ar.edu.unahur.obj2.command;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.command.comandos.Add;
import ar.edu.unahur.obj2.command.comandos.Operable;

public class MicroprocesadorTest {
    
    @Test
    public void hacerAvanzar3PosicionesAlPC(){
        var micro = new Microprocesador();
        var programa = new ProgramBuilder()
            .nop()
            .nop()
            .nop()
            .build();

        micro.run(programa);
        assertEquals(3, micro.getProgramCounter());
    }

    @Test
    public void sumarVeinteMas17(){
        var micro = new Microprocesador();
        var programa = new ProgramBuilder()
            .lodV(20)
            .swap()
            .lodV(17)
            .add()
            .build();
    
        micro.run(programa);
        assertEquals(37, micro.getAcumuladorA());
        assertEquals(0, micro.getAcumuladorB());
        assertEquals(4, micro.getProgramCounter());
    }

    @Test
    public void sumarDosMasOchoMasCinco(){
        var micro = new Microprocesador();
        var programa = new ProgramBuilder()
            .lodV(2)
            .str(0)
            .lodV(8)
            .swap()
            .lodV(5)
            .add()
            .swap()
            .lod(0)
            .add()
            .build();
        micro.run(programa);
        assertEquals(15, micro.getAcumuladorA());
        assertEquals(0, micro.getAcumuladorB());
    }

    @Test
    public void undoSwapYAdd(){
        var micro = new Microprocesador();
        var programa = new ProgramBuilder()
            .lodV(20)
            .swap()
            .lodV(10)
            .add()
            .build();
        micro.run(programa);
        assertEquals(30, micro.getAcumuladorA());
        assertEquals(0, micro.getAcumuladorB());

        micro.undo();
        assertEquals(10, micro.getAcumuladorA());
        assertEquals(20, micro.getAcumuladorB());

        micro.undo();        
        assertEquals(0, micro.getAcumuladorA());
        assertEquals(20, micro.getAcumuladorB());

        micro.undo();        
        assertEquals(20, micro.getAcumuladorA());
        assertEquals(0, micro.getAcumuladorB());

        micro.undo();        
        assertEquals(0, micro.getAcumuladorA());
        assertEquals(0, micro.getAcumuladorB());
    }

    @Test
    public void testIfnzEjecutaBloqueSiAcumuladorNoEsCero() {
        var micro = new Microprocesador();
        var programa = new ProgramBuilder()
            .lodV(5) 
            .ifnz(List.of(
                new Operable() {
                    public void execute(Programable micro) {
                        micro.setAcumuladorA(micro.getAcumuladorA() + 10);
                        
                    }
                    public void undo(Programable micro) {}
                }
            ))
            .build();

        micro.run(programa);
        assertEquals(15, micro.getAcumuladorA());
        assertEquals(2, micro.getProgramCounter()); 
    }

    @Test
    public void testWhnzEjecutaMientrasAcumuladorNoEsCero() {
        var micro = new Microprocesador();
        var programa = new ProgramBuilder()
            .lodV(3) 
            .whnz(List.of(
                new Operable() {
                    public void execute(Programable micro) {
                        micro.setAcumuladorA(micro.getAcumuladorA() - 1);
                        
                    }
                    public void undo(Programable micro) {}
                }
            ))
            .build();

        micro.run(programa);
        assertEquals(0, micro.getAcumuladorA());
        assertEquals(2, micro.getProgramCounter()); 
    }
}
