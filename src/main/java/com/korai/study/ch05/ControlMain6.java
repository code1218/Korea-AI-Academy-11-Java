package com.korai.study.ch05;

import java.util.Arrays;
import java.util.Scanner;

public class ControlMain6 {

    public static void main(String[] args) {
        String[] names = new String[0];
        Scanner scanner = new Scanner(System.in);
        System.out.println("이름 입력 프로그램");

        while (true) {
            System.out.print("이름을 추가하시겠습니까? (y/n): ");
            String yesOrNo = scanner.nextLine();
            if ("y".equalsIgnoreCase(yesOrNo)) {
                System.out.print("이름: ");
                String name = scanner.nextLine();

                String[] newNames = new String[names.length + 1];
                for (int i = 0; i < names.length; i++) {
                    newNames[i] = names[i];
                }
                newNames[newNames.length - 1] = name;
                names = newNames;
            } else if (yesOrNo.equalsIgnoreCase("n")) {
                break;
            } else {
                System.out.println("다시 입력하세요.");
            }
        }

        System.out.println(Arrays.toString(names));
    }

}
