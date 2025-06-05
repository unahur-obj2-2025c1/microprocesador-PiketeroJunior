package ar.edu.unahur.obj2.command;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

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
}
