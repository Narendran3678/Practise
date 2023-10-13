package com.io;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDemo {
	public static void filesTest() {
		try {
			Path path = Paths.get("E:\\A\\B");
			System.out.println(new File(path.toString()).isDirectory());
			System.out.println(path.toFile().isDirectory());
			System.out.println(Files.isDirectory(path));
			System.out.println(Files.getAttribute(path, "isDirectory"));

			File dir = new File("F:" + File.separator + "A" + File.separator + "B");
			
			System.out.println(dir.getParentFile().getParent());
			System.out.println(dir.getParentFile().getParentFile());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		filesTest();
	}
}
