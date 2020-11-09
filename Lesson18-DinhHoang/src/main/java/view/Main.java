package view;

import java.util.Scanner;

import exercises.Ex01;
import exercises.Ex02;
import exercises.Ex03;
import exercises.Ex04;

public class Main {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("Bài tập số: ");
			int number = Integer.parseInt(sc.nextLine());

			switch (number) {
			case 0:
				System.exit(0);
				break;
			case 1:
				new Ex01().setVisible(true);
				break;
			case 2:
				new Ex02().setVisible(true);
				break;
			case 3:
				new Ex03().setVisible(true);
				break;
			case 4:
				new Ex04().setVisible(true);
				break;
			default:
				System.out.println("Nhập đúng số bài tập!");
				break;
			}
		}
	}
}