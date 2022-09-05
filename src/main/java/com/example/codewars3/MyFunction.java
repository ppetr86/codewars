package com.example.codewars3;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public interface MyFunction {

    String apply(String text, String text2);


    default void printUtf8To(String text, OutputStream stream) {
        try {
            stream.write(text.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException("Err");
        }
    }


    static void printToSystemsOut(String tex) {
        System.out.println(tex);
    }

}
