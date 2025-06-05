package ar.edu.unahur.obj2.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ar.edu.unahur.obj2.command.comandos.Operable;
import ar.edu.unahur.obj2.command.excepctions.MicroException;

public class Microprocesador implements Programable {
    private Integer acumuladorA = 0;
    private Integer acumuladorB = 0;
    private Integer programCounter = 0;
    private Map<Integer, Integer> memoria = new HashMap<>();


    @Override
    public void run(List<Operable> operaciones) {
        while (programCounter < operaciones.size()) {
            operaciones.get(programCounter).execute(this);
        }
    }

    @Override
    public void incProgramCounter() {
        programCounter++;
    }

    @Override
    public Integer getProgramCounter() {
        return programCounter;
    }

    @Override
    public void setProgramCounter(Integer value) {
        programCounter = value;
    }

    @Override
    public void setAcumuladorA(Integer value) {
        acumuladorA = value;
    }

    @Override
    public Integer getAcumuladorA() {
        return acumuladorA;
    }

    @Override
    public void setAcumuladorB(Integer value) {
        acumuladorB = value;
    }

    @Override
    public Integer getAcumuladorB() {
        return acumuladorB;
    }

    @Override
    public void copyFrom(Programable programable) {
        this.acumuladorA = programable.getAcumuladorA();
        this.acumuladorB = programable.getAcumuladorB();
        this.programCounter = programable.getProgramCounter();

        for (Integer i = 0; i <= 1023; i++){
            this.setAddr(i, programable.getAddr(i));
        }
    }

    @Override
    public Programable copy() {
        Microprocesador copia = new Microprocesador();
        copia.copyFrom(this);
        return copia;
    }

    @Override
    public void reset() {
        acumuladorA = 0;
        acumuladorB = 0;
        programCounter = 0;
        memoria.clear();
    }

    //le agregue el interger valor antes en el programable setAddr
    @Override
    public void setAddr(Integer addr, Integer valor) {
        verificarRango(addr);
        memoria.put(addr, valor);
    }

    @Override
    public Integer getAddr(Integer addr) {
        verificarRango(addr);
        return memoria.getOrDefault(addr, 0); //si no hay nada en esa direc da devuelve 0
    }

    private void verificarRango(Integer addr){
        if (addr < 0 || addr > 1023){
            throw new MicroException("Dirección fuera de rango: " + addr);
        }
    }

}