package com.testinium.casone;

public class CaseOne {

	public static void main(String[] args) {

		int endPoint = 7;
		int i = 0;
		while (i <= 7) {	
			for (int j = 0; j < endPoint; j++) {
				if (j <= endPoint)
					System.out.print("*");
				else
					System.out.print("");
			}
			endPoint-=2;
			i++;
			System.out.println("");
		}
	}

}
