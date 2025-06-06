package ar.edu.unahur.obj2.command;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.command.comandos.Add;
import ar.edu.unahur.obj2.command.comandos.Ifnz;
import ar.edu.unahur.obj2.command.comandos.Lod;
import ar.edu.unahur.obj2.command.comandos.LodV;
import ar.edu.unahur.obj2.command.comandos.Nop;
import ar.edu.unahur.obj2.command.comandos.Operable;
import ar.edu.unahur.obj2.command.comandos.Str;
import ar.edu.unahur.obj2.command.comandos.Swap;
import ar.edu.unahur.obj2.command.comandos.Whnz;

public class ProgramBuilder {
    private final List<Operable> instrucciones = new ArrayList<>();

    public ProgramBuilder nop(){
        instrucciones.add(new Nop());
        return this;
    }

    public ProgramBuilder add(){
        instrucciones.add(new Add());
        return this;
    }

    public ProgramBuilder swap(){
        instrucciones.add(new Swap());
        return this;
    }

    public ProgramBuilder str(Integer direccion){
        instrucciones.add(new Str(direccion));
        return this;
    }

    public ProgramBuilder lod(Integer direccion){
        instrucciones.add(new Lod(direccion));
        return this;
    }

    public ProgramBuilder lodV(Integer valor){
        instrucciones.add(new LodV(valor));
        return this;
    }

    public ProgramBuilder ifnz(List<Operable> operaciones){
        instrucciones.add(new Ifnz(operaciones));
        return this;
    }

    public ProgramBuilder whnz(List<Operable> operaciones){
        instrucciones.add(new Whnz(operaciones));
        return this;
    }

    public List<Operable> build(){
        return this.instrucciones;
    }
}
