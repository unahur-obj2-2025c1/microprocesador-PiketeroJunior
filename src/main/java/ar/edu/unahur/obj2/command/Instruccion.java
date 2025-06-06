package ar.edu.unahur.obj2.command;

import java.util.ArrayList;
import java.util.List;

public class Instruccion {
    private List<Programable> instrucciones = new ArrayList<>();

    public void agregarInstruccion(Programable instruccion){
        instrucciones.add(instruccion);
    }

    public Boolean hayInstruccion(){
        return !instrucciones.isEmpty();
    }

    public Programable ultimaInstruccion(){
        return instrucciones.remove(instrucciones.size() - 1);
    }
}
