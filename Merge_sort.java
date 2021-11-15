/*
Author: Sipeng He
Project: A simple practice for merge sort.
Features:
1) A random-sized array is generated randomly.
2) The array is sorted by the merge sort algorithm.
Date: 2021-11-14
*/

import java.util.Random;

public class Merge_sort {
    public static void main(String[] args) {

       
        Random rd = new Random();
        int n = rd.nextInt(100);
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = rd.nextInt(100);
        }

        System.out.println("The initial array: ");
        for (int i = 0; i < n; i++) {
            System.out.printf("%d ", array[i]);
        }
        System.out.println("\n");

        array = merge_sort(array);
        
        System.out.println("The result array: ");
        for (int i = 0; i < n; i++) {
            System.out.printf("%d ", array[i]);
        }
    }

    public static int[] merge_sort(int[] T){
        int n = T.length;
        if(n == 1){
            int[] result = new int[1];
            result[0] = T[0];
            return result;
        } else{
            int n1 = n/2;
            int n2 = n/2;
            if(n1 + n2 < n){
                n1 = n1 + 1;
            }
            int[] A1 = new int[n1];
            int[] A2 = new int[n2];
            for(int i  = 0; i < n1; i++){
                A1[i] = T[i];
            }
            for(int i = 0; i < n2; i++){
                A2[i] = T[n1 + i];
            }
            A1 = merge_sort(A1);
            A2 = merge_sort(A2);
            int[] result = merge(A1,A2);
            return result;
        }
    }

    public static int[] merge(int[] T1, int[] T2){
        int n1 = T1.length;
        int n2 = T2.length;
        int n = n1 + n2;
        int[] result = new int[n];
        int i1 = 0;
        int i2 = 0;
        int j = 0;
        while(i1 < n1 && i2 < n2){
            if(T1[i1]<T2[i2]){
                result[j] = T1[i1];
                i1++;
            } else{
                result[j] = T2[i2];
                i2++;
            }
            j++;
        }
        while(i1 < n1){
            result[j] = T1[i1];
            j++;
            i1++;
        }
        while(i2 < n2){
            result[j] = T2[i2];
            j++;
            i2++;
        }
        return result;
    }
}
