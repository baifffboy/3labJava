package org.example;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Program program = new Program();
        program.addCommand(new Command("init", "10", "20"));
        program.addCommand(new Command("init", "11", "25"));
        program.addCommand(new Command("ld", "a", "10"));
        program.addCommand(new Command("ld", "b", "11"));
        program.addCommand(new Command("st", "c", "13"));
        program.addCommand(new Command("init", "110", "35"));
        program.addCommand(new Command("add"));
        program.addCommand(new Command("print"));
        program.addCommand(new Command("mv", "a", "d"));
        program.addCommand(new Command("mv", "b", "c"));
        program.addCommand(new Command("div"));
        program.addCommand(new Command("print"));
        program.addCommand(new Command("init", "171", "65"));
        program.addCommand(new Command("sub"));
        program.addCommand(new Command("print"));
        program.addCommand(new Command("mult"));
        program.addCommand(new Command("init", "345", "95"));
        program.addCommand(new Command("print"));
        iCPU CPU = BCPU.build();
        Executor executor = new Executor(CPU);
        executor.run(program);
        program.print();


    }
}