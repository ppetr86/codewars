package com.example.playground;/*
package playground;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayBinarySearch {

    static Osoba[] poleOsob;

    static void vypisOsob(){
        for (int i = 0; i < poleOsob.length; i++) {
            System.out.println(poleOsob[i].toString());
        }
    }

    static void najdi(double vaha){
        Osoba os = new Osoba(0, vaha, "nedulezite");
        int k = Arrays.binarySearch(poleOsob, os, new KomparatorOsobyPodleVahy());

        System.out.print("[" +k+ "]=" + vaha);

        if(k<0)
            System.out.println(" -->[" +-(k+1)+ "]=" + vaha);
        else
            System.out.println();
    }

    public static void main(String[] args) {
        poleOsob = new Osoba[4];
        poleOsob[0] = new Osoba(186, 82.5, "m");
        poleOsob[1] = new Osoba(172, 63, "m");
        poleOsob[2] = new Osoba(116, 26.1, "m");
        poleOsob[3] = new Osoba(105, 80.5, "m");

        System.out.println("razeni podle vahy");
        Arrays.sort(poleOsob, new KomparatorOsobyPodleVahy());
        vypisOsob();

        najdi(82.5);
        najdi(63);
        najdi(20);
        najdi(99);
        najdi(100);
        najdi(0);
    }

    public record Osoba(int vyska, double vaha, String popis) implements Comparable<Osoba> {
        @Override
        public int compareTo(Osoba o) {
            return this.vyska - o.vyska;
        }
    }

    static class KomparatorOsobyPodleVahy implements Comparator<Osoba>{

        @Override
        public int compare(Osoba o1, Osoba o2) {
            return (int) (o1.vaha() - o2.vaha());
        }
    }
}
*/
