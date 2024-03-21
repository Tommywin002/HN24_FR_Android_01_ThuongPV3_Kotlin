package com.example.hn24_fr_android_01_thuongpv3_kotlin.assignments.assignment4.question5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyKotlinFunctions myKotlinFunctionsKt = new MyKotlinFunctions();
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("sum: " + myKotlinFunctionsKt.sumTwoLongNumber(a, b));
        System.out.println("sub: " + myKotlinFunctionsKt.subTwoLongNumber(a, b));
        System.out.println("multi: " + myKotlinFunctionsKt.multiTwoLongNumber(a, b));
        System.out.println("divided: " + myKotlinFunctionsKt.divideTwoLongNumber(a, b));
    }
}
