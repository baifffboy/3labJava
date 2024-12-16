package org.example;

import java.util.HashMap;

public class CPU implements iCPU  {
    int[] Memory = new int[1024];
    int[] Registrs = new int[4];
    static int MinMemory = 1025;
    static int MaxMemory = 0;


    @Override
    public void exec(Command c){
        switch(c.info[0]){
            case "init": init(c.info[1], c.info[2]); break;
            case "ld": ld(c.info[1], c.info[2]); break;
            case "st": st(c.info[1], c.info[2]); break;
            case "mv": mv(c.info[1], c.info[2]); break;
            case "print": print(); break;
            case "add": add(); break;
            case "sub": sub(); break;
            case "mult": mult(); break;
        }

    }

    public void ld(String s, String f){
        int y = Integer.parseInt(f);
        switch (s){
            case "a": Registrs[0] = Memory[y]; break;
            case "b": Registrs[1] = Memory[y]; break;
            case "c": Registrs[2] = Memory[y]; break;
            case "d": Registrs[3] = Memory[y]; break;
        }
    }
    public void st(String s, String f){
        int y = Integer.parseInt(f);
        switch (s){
            case "a": Memory[y] = Registrs[0]; break;
            case "b": Memory[y] = Registrs[1]; break;
            case "c": Memory[y] = Registrs[2]; break;
            case "d": Memory[y] = Registrs[3]; break;
        }
    }
    public void mv(String s, String f){
        s = f;
    }
    public void init(String s, String f){
        int x = Integer.parseInt(s);
        if (x > MaxMemory) MaxMemory = x;
        if (x < MinMemory) MinMemory = x;
        int y = Integer.parseInt(f);
        Memory[x] = y;
    }
    public void print(){
        System.out.print("Значения регистров a: " + Registrs[0] + " b: " + Registrs[1] + " c: " + Registrs[2] + " d: " + Registrs[3]); System.out.print("\n");
    }
    public void add(){
        Registrs[3] = Registrs[0] + Registrs[1];
    }
    public void sub(){
        Registrs[3] = Registrs[0] - Registrs[1];
    }
    public void mult(){
        Registrs[3] = Registrs[0] * Registrs[1];
    }
}
