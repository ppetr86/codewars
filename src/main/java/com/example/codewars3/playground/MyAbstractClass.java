package com.example.codewars3.playground;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class MyAbstractClass {

    private String name;

    protected final String introduceYourself(String name) {
        this.name = name;
        return """
                Hello Mr.,
                my name is: """ + name;
    }

    protected abstract String hashSurname(String surname);

    public static void main(String[] args) {
        MyAbstractClass c1 = new MyAbstractClassImpl();
        MyAbstractClass c2 = new MyAbstractClassImpl2();

        System.out.println(c1.introduceYourself("petr"));
        System.out.println(c2.introduceYourself("petr"));

        System.out.println(c1.hashSurname("Novotny"));
        System.out.println(c2.hashSurname("Novotny"));

        List<MyAbstractClass> linkedList = new LinkedList<>();
        linkedList.add(c1);
        linkedList.add(c2);

        Iterator<MyAbstractClass> it = linkedList.listIterator();

        while (it.hasNext()) {
            MyAbstractClass instance = it.next();
            System.out.println(instance.name);
        }
    }

}

