package com.example.codewars.kyu4;
//https://www.codewars.com/kata/57680d0128ed87c94f000bfd/train/java
//https://www.codewars.com/kata/57680d0128ed87c94f000bfd/solutions/solutions

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//https://www.codewars.com/kata/57680d0128ed87c94f000bfd/train/java
public class Boggle3 {

    char[][] board;
    String word;
    String foundSoFar = "";
    int searchingAt;

    final private static char[][] INPUT = {
            {'E', 'A', 'R', 'A'},
            {'N', 'L', 'E', 'C'},
            {'I', 'A', 'I', 'S'},
            {'B', 'Y', 'O', 'R'}
    };
    private static final String[] CHECK = {"C", "EAR", "EARS", "BAILER", "RSCAREIOYBAILNEA", "CEREAL", "ROBES"};
    private static final boolean[] EXPECTED = {true, true, false, true, true, false, false};

    final private static char[][] INPUT2 = {
            {'T', 'T', 'M', 'D', 'A'},
            {'G', 'Y', 'I', 'N', 'N'},
            {'P', 'A', 'L', 'C', 'E'},
            {'I', 'A', 'U', 'L', 'G'},
            {'A', 'M', 'I', 'N', 'A'}};

    private static final String[] CHECK2 = {"T", "TT", "YTG", "ANIMA", "ANIMAL"};
    private static final boolean[] EXPECTED2 = {true, true, true, true, true, true};


    final private static char[][] INPUT3 = {
            {'L', 'H', 'A', 'R', 'R', 'G', 'A'},
            {'H', 'O', 'E', 'A', 'Y', 'C', 'L'},
            {'C', 'A', 'B', 'D', 'T', 'E', 'U'},
            {'C', 'N', 'A', 'Y', 'O', 'D', 'A'},
            {'R', 'O', 'K', 'T', 'L', 'I', 'R'},
            {'P', 'N', 'I', 'A', 'P', 'T', 'V'},
            {'G', 'M', 'S', 'E', 'M', 'R', 'S'}};

    private static final String[] CHECK3 = {"SEAMS", "IKTLOTDAEULCYRGA", "IKTLOTDAEULCYRGAR", "KITLITVSRMPAESMNONAABDTOD",
            "LHOABDTEUDARVSRTVS", "ABDOTYTEDLOTYCL", "LHARRGALUARVSRM", "LOBEDATLPEAS"};
    private static final boolean[] EXPECTED3 = {false, true, false, true, false, false, true, true};

    final private static char[][] INPUT4 = {
            {'E', 'P', 'F', 'R', 'Q', 'Q', 'L', 'X', 'U', 'K', 'Y', 'I', 'C', 'F', 'C', 'F', 'G', 'Z', 'N', 'O'},
            {'U', 'C', 'O', 'X', 'U', 'J', 'O', 'P', 'K', 'J', 'B', 'T', 'Q', 'Z', 'H', 'G', 'M', 'R', 'V', 'G'},
            {'R', 'R', 'C', 'M', 'I', 'Q', 'F', 'L', 'W', 'W', 'S', 'U', 'K', 'H', 'Q', 'Y', 'L', 'V', 'R', 'E'},
            {'C', 'Q', 'X', 'B', 'T', 'F', 'P', 'V', 'V', 'W', 'E', 'Q', 'G', 'Z', 'R', 'C', 'Q', 'M', 'S', 'B'},
            {'Z', 'Z', 'S', 'H', 'Y', 'R', 'D', 'H', 'V', 'Y', 'F', 'F', 'J', 'P', 'Q', 'W', 'D', 'L', 'X', 'Z'},
            {'W', 'Y', 'F', 'B', 'W', 'Y', 'X', 'N', 'O', 'R', 'V', 'F', 'Q', 'C', 'R', 'C', 'L', 'H', 'C', 'U'},
            {'G', 'P', 'L', 'D', 'K', 'M', 'R', 'V', 'N', 'R', 'L', 'T', 'Q', 'J', 'F', 'K', 'V', 'M', 'E', 'M'},
            {'Z', 'E', 'P', 'V', 'X', 'E', 'V', 'S', 'J', 'E', 'M', 'U', 'M', 'O', 'L', 'I', 'G', 'P', 'X', 'D'},
            {'T', 'Y', 'P', 'S', 'N', 'W', 'B', 'Y', 'R', 'U', 'Y', 'G', 'M', 'C', 'K', 'I', 'E', 'F', 'C', 'X'},
            {'S', 'N', 'O', 'L', 'V', 'T', 'Y', 'T', 'I', 'P', 'G', 'V', 'R', 'H', 'F', 'V', 'G', 'W', 'F', 'H'},
            {'R', 'Z', 'W', 'K', 'G', 'O', 'P', 'J', 'Q', 'N', 'C', 'C', 'D', 'C', 'S', 'U', 'T', 'M', 'S', 'A'},
            {'C', 'N', 'U', 'P', 'C', 'Q', 'P', 'V', 'D', 'Z', 'T', 'K', 'Q', 'U', 'C', 'A', 'K', 'T', 'E', 'Q'},
            {'J', 'R', 'X', 'I', 'C', 'R', 'G', 'M', 'T', 'J', 'R', 'R', 'Q', 'Q', 'A', 'A', 'P', 'Y', 'V', 'U'},
            {'U', 'M', 'O', 'F', 'M', 'N', 'Z', 'X', 'U', 'F', 'U', 'U', 'Q', 'V', 'I', 'E', 'Q', 'N', 'J', 'B'},
            {'X', 'L', 'I', 'Q', 'X', 'G', 'F', 'U', 'Y', 'O', 'V', 'D', 'H', 'O', 'J', 'Y', 'Z', 'O', 'H', 'U'},
            {'U', 'M', 'E', 'F', 'M', 'F', 'A', 'N', 'Y', 'J', 'N', 'F', 'D', 'W', 'V', 'Q', 'S', 'S', 'S', 'D'},
            {'H', 'J', 'F', 'P', 'Q', 'W', 'V', 'S', 'I', 'F', 'Z', 'G', 'W', 'P', 'T', 'Z', 'W', 'K', 'N', 'B'},
            {'A', 'M', 'G', 'D', 'M', 'W', 'H', 'P', 'L', 'F', 'F', 'F', 'Z', 'T', 'A', 'F', 'F', 'G', 'Q', 'J'},
            {'Z', 'I', 'D', 'M', 'N', 'F', 'U', 'P', 'Z', 'U', 'U', 'Z', 'F', 'F', 'X', 'Z', 'X', 'A', 'P', 'T'},
            {'C', 'D', 'L', 'L', 'C', 'E', 'M', 'U', 'N', 'M', 'J', 'W', 'C', 'A', 'D', 'D', 'I', 'R', 'Q', 'J'}};
    private static final String[] CHECK4 = {"UFIYYUJ", "UFZNVFTVPTNEKYYT", "HWMXMRCGTB", "CQUQMQQOMVC",
            "JUFFNVURZCVGMLVF", "SQFVRMGV", "QRPRJOCHDW", "DXTPVJ", "TWHQRKCVG", "FGDOQRTJTXGRCK", "SWYVTUGGCKR", "PIYYUJZCPRS", "WQMGMIUWN", "XFTWJIAASHCOQFFQSBY", "MUFFNDUJTC", "BWWVNVSNRVT"};
    private static final boolean[] EXPECTED4 = {false, true, false, true, false, false, true, true};

    final private static char[][] INPUT5 = {
            {'Q', 'C', 'X', 'C', 'Q', 'I', 'J', 'Z', 'M', 'D', 'B', 'W', 'I', 'R', 'O', 'H', 'X', 'F', 'R', 'I'},
            {'W', 'D', 'Q', 'A', 'S', 'F', 'S', 'Q', 'C', 'Z', 'K', 'R', 'R', 'B', 'T', 'L', 'T', 'O', 'H', 'M'},
            {'C', 'S', 'J', 'A', 'F', 'I', 'P', 'W', 'G', 'Q', 'Y', 'M', 'D', 'O', 'T', 'H', 'L', 'D', 'G', 'N'},
            {'T', 'P', 'M', 'R', 'I', 'O', 'O', 'D', 'S', 'W', 'U', 'J', 'Y', 'P', 'M', 'L', 'J', 'A', 'J', 'S'},
            {'F', 'X', 'Z', 'B', 'Z', 'M', 'P', 'L', 'A', 'H', 'O', 'K', 'N', 'D', 'M', 'J', 'W', 'W', 'R', 'O'},
            {'J', 'N', 'W', 'P', 'K', 'D', 'R', 'Q', 'O', 'Y', 'H', 'V', 'L', 'H', 'T', 'G', 'E', 'Q', 'E', 'B'},
            {'F', 'Z', 'Z', 'Y', 'X', 'T', 'U', 'J', 'T', 'R', 'U', 'P', 'E', 'D', 'R', 'K', 'H', 'N', 'B', 'M'},
            {'O', 'S', 'T', 'K', 'N', 'M', 'Z', 'M', 'O', 'E', 'N', 'T', 'G', 'W', 'T', 'T', 'D', 'O', 'G', 'N'},
            {'K', 'Z', 'D', 'W', 'J', 'S', 'Y', 'B', 'K', 'F', 'Z', 'Y', 'V', 'O', 'J', 'W', 'W', 'O', 'R', 'E'},
            {'G', 'A', 'H', 'O', 'K', 'F', 'N', 'Q', 'D', 'X', 'R', 'N', 'M', 'R', 'P', 'U', 'S', 'F', 'G', 'U'},
            {'A', 'C', 'G', 'T', 'Z', 'B', 'I', 'X', 'E', 'S', 'Q', 'B', 'T', 'H', 'Z', 'B', 'F', 'A', 'U', 'Z'},
            {'T', 'D', 'T', 'U', 'O', 'K', 'N', 'R', 'H', 'A', 'V', 'A', 'I', 'X', 'Y', 'C', 'K', 'T', 'Y', 'I'},
            {'I', 'F', 'S', 'S', 'H', 'K', 'R', 'U', 'R', 'E', 'U', 'J', 'C', 'I', 'S', 'Y', 'Z', 'Q', 'M', 'C'},
            {'R', 'Y', 'F', 'I', 'L', 'K', 'X', 'K', 'W', 'Q', 'R', 'H', 'N', 'V', 'S', 'Y', 'P', 'D', 'J', 'M'},
            {'S', 'F', 'Y', 'E', 'Q', 'P', 'Y', 'Y', 'Z', 'R', 'F', 'B', 'O', 'L', 'W', 'C', 'X', 'B', 'Y', 'U'},
            {'E', 'P', 'B', 'X', 'W', 'D', 'V', 'C', 'J', 'M', 'F', 'U', 'W', 'T', 'D', 'F', 'M', 'N', 'I', 'Z'},
            {'Z', 'O', 'G', 'P', 'M', 'P', 'S', 'E', 'F', 'H', 'V', 'H', 'S', 'S', 'R', 'I', 'U', 'U', 'R', 'L'},
            {'B', 'X', 'K', 'W', 'C', 'C', 'F', 'M', 'S', 'V', 'C', 'L', 'I', 'K', 'E', 'U', 'U', 'D', 'S', 'I'},
            {'G', 'F', 'G', 'C', 'G', 'J', 'U', 'X', 'F', 'U', 'N', 'N', 'E', 'J', 'S', 'S', 'S', 'K', 'X', 'A'},
            {'G', 'K', 'M', 'P', 'P', 'B', 'M', 'H', 'X', 'D', 'I', 'W', 'D', 'V', 'F', 'D', 'N', 'W', 'T', 'M'}};

    private static final String[] CHECK5 = {"MSVPCWGXGBFYFTCG"};
    private static final boolean[] EXPECTED5 = {true};

    static class Element {
        int row;
        int col;
        boolean used;

        public Element(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public Element(int row, int col, boolean used) {
            this.row = row;
            this.col = col;
            this.used = used;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Element element = (Element) o;
            return row == element.row && col == element.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }

        @Override
        public String toString() {
            return "row=" + row + ", col=" + col;
        }
    }

    public Boggle3(final char[][] board, final String word) {
        this.board = board;
        this.word = word;
        /*for (char[] c : board) {
            System.out.println(Arrays.toString(c));
        }
        System.out.println(word);
        System.out.println("----");*/
    }

    public boolean check() {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                //add only those which are relevant
                char currentLetter = board[i][j];
                // pokud najdu prvni pismeno, jdi do hledani sousedu
                if (word.charAt(0) == currentLetter) {
                    List<Element> usedSoFar = new ArrayList<>();
                    foundSoFar = "" + word.charAt(0);
                    searchingAt = 1;
                    usedSoFar.add(new Element(i, j, true));
                    if (startSearching(i, j, usedSoFar))
                        return true;
                }
            }
        }
        return false;
    }

    private boolean startSearching(int i, int j, List<Element> usedSoFar) {
        if (word.equals(foundSoFar))
            return true;
        List<Element> neighbours = findNotUsedNeighbours(i, j, word.charAt(searchingAt), usedSoFar);
        for (Element toUse : neighbours) {
            toUse.used = true;
            usedSoFar.add(toUse);
            foundSoFar += word.charAt(searchingAt);
            if (word.equals(foundSoFar))
                return true;
            ++searchingAt;
            if (startSearching(toUse.row, toUse.col, usedSoFar))
                return true;
            else {
                foundSoFar = foundSoFar.length() == 1 ? "" : foundSoFar.substring(0, foundSoFar.length() - 1);
                --searchingAt;
                usedSoFar.remove(usedSoFar.size() - 1);
            }
        }
        return word.equals(foundSoFar);
    }

    private List<Element> findNotUsedNeighbours(int i, int j, char letterToFind, List<Element> usedSoFar) {
        List<Element> neighbours = new ArrayList<>();
        int startRow = i - 1 == -1 ? 0 : i - 1;
        int endRow = (i + 1) == board.length ? i : i + 1;
        int startCol = j - 1 == -1 ? j : j - 1;
        int endCol = j + 1 == board.length ? j : j + 1;

        for (int row = startRow; row <= endRow; row++) {
            for (int col = startCol; col <= endCol; col++) {
                if (row == i && col == j)
                    continue;
                if (board[row][col] == letterToFind) {
                    Element e = new Element(row, col);
                    if (usedSoFar.stream().noneMatch(a -> a.equals(e)))
                        neighbours.add(e);
                }
            }
        }
        return neighbours;
    }

    public static void main(String[] args) {

        for (int i = 0; i < CHECK.length; i++) {
            Boggle3 boggle = new Boggle3(INPUT, CHECK[i]);
            boolean result = boggle.check();
            System.out.println("Iteration nr. + " + i + ". Is: " + result + ". Should be: " + EXPECTED[i] + ". Test was " + (result == EXPECTED[i] ? "SUCCESS." : "FAIL."));
        }
        System.out.println("------");

        for (int i = 0; i < CHECK2.length; i++) {
            Boggle3 boggle = new Boggle3(INPUT2, CHECK2[i]);
            boolean result = boggle.check();
            System.out.println("Iteration nr. + " + i + ". Is: " + result + ". Should be: " + EXPECTED2[i] + ". Test was " + (result == EXPECTED2[i] ? "SUCCESS." : "FAIL."));
        }
        System.out.println("------");

        for (int i = 0; i < CHECK3.length; i++) {
            Boggle3 boggle = new Boggle3(INPUT3, CHECK3[i]);
            boolean result = boggle.check();
            System.out.println("Iteration nr. + " + i + ". Is: " + result + ". Should be: " + EXPECTED3[i] + ". Test was " + (result == EXPECTED3[i] ? "SUCCESS." : "FAIL."));
        }
        System.out.println("------");
        for (int i = 0; i < CHECK5.length; i++) {
            Boggle3 boggle = new Boggle3(INPUT5, CHECK5[i]);
            boolean result = boggle.check();
            System.out.println("Iteration nr. + " + i + ". Is: " + result + ". Should be: " + EXPECTED5[i] + ". Test was " + (result == EXPECTED5[i] ? "SUCCESS." : "FAIL."));
        }


    }
}









