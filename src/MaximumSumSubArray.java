import java.util.Scanner;

import static java.lang.Math.max;

public class MaximumSumSubArray {
    /*
    Problem : -Given an array of positive numbers and a positive number ‘k,’ find the maximum sum of any contiguous subarray of size ‘k’.
    ref link :- https://gist.github.com/ankitwww/19e9368f3ac68d43279778ad0b6b6cd3
     */
    public static void main(String[] args) {
        int arrayLength , windowSize;
        Scanner sc = new Scanner(System.in);
        arrayLength = sc.nextInt();
        windowSize = sc.nextInt();
        int[] array = new int[arrayLength];
        if(arrayLength<windowSize) {
            System.out.println("Size of window is greater than array lenght, No     solution exist");
            return;
        }
        //Array Input
        for(int i = 0; i < arrayLength; i ++){
            array[i] = sc.nextInt();
        }
        //maximumSum stores the maximum sum of contiguous subarray of size windowSize.
        //currentSum is the sum of last contiguous subarray of size windowSize.
        int maximumSum = 0, currentSum = 0;
        for(int i = 0; i < arrayLength; i ++){
            if(i < windowSize) {
                maximumSum += array[i]  ;
                currentSum += array[i];
            } else {
                currentSum -= array[i-windowSize];
                currentSum += array[i];
                maximumSum = Math.max(maximumSum,currentSum);
            }
        }
        System.out.println(maximumSum);
    }
}

