package org.example.testsuite;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the startsas: ");
        int start = sc.nextInt();
        System.out.println("bsjfbsjdfb");
        int end = sc.nextInt();
        int sum = 0;
        int aver;
        for (int i = start; i<=end; i++){
            if(i % 2 == 0){
                sum += i;
            }
        }

        System.out.println("basasidbsia");
    }
}
