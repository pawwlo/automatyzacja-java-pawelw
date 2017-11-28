package Zadanie1;

import java.util.Scanner;

public class Zadanie1 {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Witaj świecie");
        System.out.println("Wpisanie exit zakończy działanie programu");
        while(! "exit".equals(sc.nextLine()) ) {
            System.out.println("Złe polecenie. Wpisz exit by wyjść");
        }
        sc.close();
    }
}
