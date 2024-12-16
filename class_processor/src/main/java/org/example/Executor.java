package org.example;

public class Executor {
    iCPU cpu;

    Executor(iCPU i) {
        cpu = i;
    }

    void run(Program C) {
        for (Command i : C) {
            cpu.exec(i);
        }
    }
}