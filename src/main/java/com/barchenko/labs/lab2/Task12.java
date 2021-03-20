package com.barchenko.labs.lab2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task12 {
    //демострация работы сортировки слов из файла
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Степень многочленов n = ");
        int n = scanner.nextInt();
        Map<Integer, Integer> firstMap = setUpFirstMap(scanner, n);
        Map<Integer, Integer> secondMap = setUpSecondMap(scanner, n);
        Map<Integer, Integer> resultMap = calculateMap(firstMap, secondMap, n);
    }

    //создание первого многочлена
    private static Map<Integer, Integer> setUpFirstMap(Scanner scanner, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        System.out.print("D(x)= c0");
        for(int i=1; i <= n; i++)
        {
            System.out.print(" + c" + i + "*x^" + i);
        }
        System.out.println();
        for(int i = 0; i <= n; i++)
        {
            System.out.print("c" + i + "=");
            map.put(i, scanner.nextInt());
        }
        System.out.print("D(x)= " + map.get(0));
        for(int i = 1; i <= n; i++){
            System.out.print(" + " + map.get(i) + "x^"+i);
        }
        System.out.println();
        return map;
    }

    //создание второго многочлена
    private static Map<Integer, Integer> setUpSecondMap(Scanner scanner, int n) {
        Map<Integer, Integer> secondMap = new HashMap<>();
        System.out.print("E(x)= a0");
        for(int i = 1; i <= n; i++)
        {
            System.out.print(" + a" + i +"*x^" + i);
        }
        System.out.println();
        for(int i = 0; i <= n; i++)
        {
            System.out.print("a" + i + "=");
            secondMap.put(i, scanner.nextInt());
        }
        System.out.print("E(x)= " + secondMap.get(0));
        for(int i = 1; i <= n; i++)
        {
            System.out.print(" + " + secondMap.get(i) + "x^" + i);
        }
        System.out.println();
        return secondMap;
    }

    //сложение двух многочленов
    private static Map<Integer, Integer> calculateMap(Map<Integer, Integer> map1, Map<Integer,Integer> map2, int n) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        resultMap.put(0, map1.get(0) + map2.get(0));
        System.out.print("D(x)+E(x)= " + resultMap.get(0));
        for(int i = 1; i <= n; i++)
        {
            resultMap.put(i, map1.get(i) + map2.get(i));
            System.out.print(" + "+ resultMap.get(i)+"x^"+i);
        }
        return resultMap;
    }
}
