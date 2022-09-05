package com.example.codewars3.playground.progressmonitoring;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ProgressMonitorFileRead {
    public static void main(String[] args) throws IOException {
        String src = "mobydick.txt";
        String msg = "reading " + src;
        try (InputStream is = new FileInputStream(src);
             InputStream pis = new ProgressMonitorInputStream(null, msg, is)) {
            int x = pis.read();
            while (x >= 0) {
                byte b = (byte) x;
                // process b ...
                x = pis.read();
            }
        }
    }
}
