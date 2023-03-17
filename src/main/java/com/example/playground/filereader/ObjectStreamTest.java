package com.example.playground.filereader;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectStreamTest {
    public static void main(String[] args) throws Exception {
        List<String> L = Arrays.asList("a", "b", "c");
// Write the list to a file, in two ways.
        try (OutputStream os = new FileOutputStream("sav.dat");
             ObjectOutput oos = new ObjectOutputStream(os)) {
            oos.writeObject(L);// Write the list.
            oos.writeInt(L.size()); // Write the list size,
            for (String s : L)// and then its elements.
                oos.writeObject(s);
        }
// Read the lists from the file.
        try (InputStream is = new FileInputStream("sav.dat");
             ObjectInput ois = new ObjectInputStream(is)) {
            List<String> L1 = (List<String>) ois.readObject();
            List<String> L2 = new ArrayList<>();
            int size = ois.readInt();// Read the list size.
            for (int i = 0; i < size; i++) {// Read the elements.
                String s = (String) ois.readObject();
                L2.add(s);
            }
// L, L1, and L2 are equivalent.
            System.out.println(L + ", " + L1 + ", " + L2);
        }
    }
}
