package org.example;

import java.util.*;

public class Program implements Iterable<Command> {
    private ArrayList<Command> commands = new ArrayList<>();
    private HashMap<String, Integer> counter = new HashMap<>();


    public Program(){};
/*
    public Program(Command c) {
        commands.add(c);
        if (counter.containsKey(c.info[0])) {
            counter.put(c.info[0], counter.get(c.info[0]) + 1);
        } else
            counter.put(c.info[0], 1);
    }
*/
    void addCommand(Command c) {
        commands.add(c);
        if(counter.containsKey(c.info[0])){
            counter.put(c.info[0], counter.get(c.info[0]) + 1);
        }
        else
            counter.put(c.info[0], 1 );
    }

    String mostPopularInstruction(Map<String, Integer> counterRef){
        // сортировка словаря
        /*
        Collection<Integer> i = counterRef.values();
        ArrayList<Integer> sortedList = new ArrayList<>(i);
        Collections.sort(sortedList);
        Set<String> k = counterRef.keySet();
        for (int m: sortedList) {
            for (String s: k){


            }
        }
        counterRef.forEach((key, value) -> {for (int i = 0; i < sortedList.size(); i++) {counter.put(counter.get(sortedList[i]), }});
        System.out.println(sortedList);
        MaxKey = counterRef.get(sortedList.get(sortedList.size()-1));
        counterRef.forEach((key, value) -> {for (int i = 0; i < sortedList.size(); i++) {counterRef.put(counter1.get(sortedList.get(i)), sortedList.get(i));}});
        */
        // реализация нахождения Max
        /*Collection<Integer> i = counterRef.values();
        ArrayList<Integer> sortedList = new ArrayList<>(i);
        Collections.sort(sortedList);


        Set<Map.Entry<String, Integer>> k = counterRef.entrySet();
        for(Map.Entry s : k) {if (s.getValue() == counter.get(sortedList.get(sortedList.size() - 1))) MaxKey = s.getKey()};

        return counterRef;
        */
        Map<String, Integer> da = new HashMap<>();
        for (Command command : commands) {
            String cmdName = command.getcommands(0);
            da.put(cmdName, da.getOrDefault(cmdName, 0) + 1);
        }
        return Collections.max(counterRef.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
    ArrayList<String> s = new ArrayList<>();
    Map<String, Integer> Vporyadkeubivaniya(Map<String, Integer> counterRef){
        String g = mostPopularInstruction(counterRef);
        String key = g;
        Integer value = counterRef.get(g);
        counterRef.remove(g);
        s.add(g);
        //System.out.println("Команда: " + key + " значение " + value);
        return counterRef;
    }
/*
    String MaxKey(){
        // прописать нахождение максимального ключа по значению в словаре
        String result;
        counter.forEach((key, value) -> {result = key;});
        return result;
    }
*/
    void print() {// тут надо сделать сортировку хэшмэп
        System.out.println("\nИнструкции в классе Command:");
        for (Command command : commands) {
            if (command.getcommands(1).equals("0")) {System.out.println("В Command используется команда: <<" + command.getcommands(0) + ">>"); }
            else {System.out.println("В Command используется команда: <<" + command.getcommands(0) + ">> и ее аргументы: " + command.getcommands(1) + ", " + command.getcommands(2)); }
        }
        System.out.println("\n1) Наиболее часто встречаемая инструкция: " + mostPopularInstruction(counter) + " количество её использования " + counter.get(mostPopularInstruction(counter)));
        System.out.println("2) Наибольшее значение памяти: " + CPU.MaxMemory + ", наименьшее значение в памяти: " + CPU.MinMemory + ", диапазон: " + (CPU.MaxMemory - CPU.MinMemory));
        System.out.println("3) Операции в порядке уменьшения частоты появления: ");
        Map<String, Integer> da = counter;
        int y = counter.size();
        for (int i = 0; i < y; i++) {
            da = Vporyadkeubivaniya(da);
            System.out.println(s.get(i));
        }


    }

    @Override
    public Iterator<Command> iterator() {
        return new CommandIterator();
    }

    public class CommandIterator implements Iterator<Command> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < commands.size();
        }

        @Override
        public Command next() {
            return commands.get(currentIndex++);
         }
    }
}