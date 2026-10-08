package com.korai.study.ch05;

import java.util.Scanner;

public class ScannerMain03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = new int[0];

        while (true) {
            System.out.print("입력: ");
            int num = scanner.nextInt();
            scanner.nextLine();

            int[] newNums = new int[nums.length + 1];

            for (int i = 0; i < nums.length; i++) {
                newNums[i] = nums[i];
            }
            newNums[newNums.length - 1] = num;
            nums = newNums;

            System.out.print("추가입력을 멈추시려면 n을 입력하세요: ");
            String yn = scanner.nextLine();
            if ("n".equalsIgnoreCase(yn)) {
                break;
            }
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        System.out.println("총합: " + sum);



    }
}
