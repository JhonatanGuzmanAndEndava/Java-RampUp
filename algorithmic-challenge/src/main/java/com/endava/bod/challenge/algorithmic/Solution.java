/**
 * @Author: Jhonatan Guzmán
 * @Author: Sergio Forero
 */

package com.endava.bod.challenge.algorithmic;

import java.util.*;

public class Solution {

    static int cont = 0;
    static int n;
    static LinkedList<String> gozintas = new LinkedList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        n = sc.nextInt();
        test(n, new ArrayList<>());
        System.out.println(cont);
        gozintas.forEach(System.out::println);
    }

    private static void test(int number, List<Integer> list) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i < number; i++) {
            if (number % i == 0)
                stack.push(i);
        }

        while (!stack.isEmpty()) {

            int i = stack.pop();
            List<Integer> newList = new ArrayList<>(list);
            newList.add(i);
            test(i, new ArrayList<>(newList));

        }

        if (list.contains(1)) {
            cont++;
            StringBuilder sb = new StringBuilder().append('{');
            for (int i = list.size()-1; i >= 0; --i ) {
                sb.append(list.get(i) + ",");
            }
            sb.append(String.valueOf(n));
            sb.append('}');
            gozintas.addFirst(sb.toString());
        }
    }
}