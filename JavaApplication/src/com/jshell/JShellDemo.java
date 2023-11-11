package com.jshell;
import java.util.List;
import java.util.Scanner;
import jdk.jshell.JShell;
import jdk.jshell.SnippetEvent;

public class JShellDemo {

	public static void main(String[] args) {
		jShell();
	}
	
	public static void jShell() {
		try {
			String expression = "";
			JShell jshellConsole =  JShell.create();
			Scanner scanner = new Scanner(System.in);
			while(true) {
				expression = scanner.nextLine();
				if(expression.equalsIgnoreCase("EXIT")) {
					break;
				}
				List<SnippetEvent> eventList = jshellConsole.eval(expression);
				eventList.stream().forEach(se -> {
					System.out.println("Expression..."+se.value());
				});
			}
			jshellConsole.close();
			scanner.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}	
	}

}
