package com.pattern;

public class PatternDemo {
	public static void main(String args[]) {
		traingleDesc() ;
	}
/*
		 			5
				4		5
			3		4		5	
		2		3		4 		5
	1 		2 		3		4		5
*/
	public static void traingleDesc() {
		int row=5,col=row*2,front=col/2,rear=col/2;
		int count=1;
		boolean flag=true;
		for(int i=1;i<=row;i++) {
			for(int j=1;j<=col;j++) {
				if(j>=front && j<=rear) {
					if(flag) {
						System.out.print(count++);
						flag=!flag;
					} else {
						System.out.print(" ");
						flag=!flag;
					}
					
				}
				else {
					System.out.print(" ");
					count++;
				}
			}
			count=1;
			flag=true;
			System.out.println();
			front--;
			rear++;
		}
	
	}
}
