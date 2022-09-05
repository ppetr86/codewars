package com.example.codewars3.playground.filereader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class FilePrefix {
    public static void main(String[] args) throws IOException {
        try (Reader r = new FileReader("/home/pen/code/codewars/src/playground/filereader/mobydick.txt");
             Writer w = new FileWriter("/home/pen/code/codewars/src/playground/filereader/shortmoby.txt")) {
            for (int i = 0; i < 10; i++) {
                int x = r.read();
                if (x < 0)
                    break;
                char c = (char) x;
                w.write(c);
            }
        }
    }
}