package com.example.entwicklerheld;

public class GFG {

    // Function to find the optimal weights
    static void findWeights(int X) {
        int sum = 0;

        // Number of weights required
        int power = 0;
        int number = 3;

        // Finding the value of required powers of 3
        while (sum < X) {
            sum = number - 1;
            sum /= 2;
            power++;
            number *= 3;
        }

        // Optimal Weights are powers of 3
        int ans = 1;
        for (int i = 1; i <= power; i++) {
            System.out.print(ans + " ");
            ans = ans * 3;
        }
    }


    // Driver code
    public static void main(String[] args) {
        int X = 2;

        findWeights(21);

    }
}



