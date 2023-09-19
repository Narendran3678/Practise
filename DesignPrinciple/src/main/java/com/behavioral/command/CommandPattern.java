package com.behavioral.command;

//Receiver Part
interface FileReceiver
{
	public void readFile();
	public void writeFile();
	public void closeFile();
}
class WindowsReceiver implements FileReceiver
{
	private String fileName =  null;
	public WindowsReceiver(String fileName)
	{
		this.fileName=fileName;
	}
	@Override
	public void readFile() {
		System.out.println("Windows "+fileName+" Read Successfully");
	}

	@Override
	public void writeFile() {
		System.out.println("Windows "+fileName+" Write Successfully");
	}

	@Override
	public void closeFile() {
		System.out.println("Windows "+fileName+" Close Successfully");
	}
}
class MacReceiver implements FileReceiver
{
	private String fileName =  null;
	public MacReceiver(String fileName)
	{
		this.fileName=fileName;
	}
	@Override
	public void readFile() {
		System.out.println("Mac "+fileName+" Read Successfully");
	}

	@Override
	public void writeFile() {
		System.out.println("Mac "+fileName+" Write Successfully");
	}

	@Override
	public void closeFile() {
		System.out.println("Mac "+fileName+" Close Successfully");
	}
}

//Remote Part
class FileInvoker
{
	private Command command = null;
	public FileInvoker(Command command)
	{
		this.command = command;
	}
	public void execute()
	{
		command.execute();
	}
	public void setCommand(Command command) {
		this.command = command;
	}
}

//Command Part
interface Command
{
	public void execute();
}
class FileReadOperation implements Command
{	
	private FileReceiver fileReceiver;
	public FileReadOperation(FileReceiver fileReceiver) {
		this.fileReceiver = fileReceiver;
	}
	@Override
	public void execute() {
		fileReceiver.readFile();
	}
	public FileReceiver getFileReceiver() {
		return fileReceiver;
	}
	public void setFileReceiver(FileReceiver fileReceiver) {
		this.fileReceiver = fileReceiver;
	}
}
class FileWriteOperation implements Command
{
	private FileReceiver fileReceiver;
	public FileWriteOperation(FileReceiver fileReceiver) {
		this.fileReceiver = fileReceiver;
	}
	@Override
	public void execute() {
		fileReceiver.writeFile();
	}
	public FileReceiver getFileReceiver() {
		return fileReceiver;
	}
	public void setFileReceiver(FileReceiver fileReceiver) {
		this.fileReceiver = fileReceiver;
	}
}
class FileCloseOperation implements Command
{
	private FileReceiver fileReceiver;
	public FileCloseOperation(FileReceiver fileReceiver) {
		this.fileReceiver = fileReceiver;
	}
	@Override
	public void execute() {
		fileReceiver.closeFile();
	}
	public FileReceiver getFileReceiver() {
		return fileReceiver;
	}
	public void setFileReceiver(FileReceiver fileReceiver) {
		this.fileReceiver = fileReceiver;
	}
}

/*
 * This pattern receiver request and store in form of command and pass it to Invoker which search for right commanding object and execute the respective command. 
 */
public class CommandPattern {
	public static void main(String args[])
	{
		String fileName = "CommandDesignPattern.txt";
		String osName = System.getProperty("os.name");
		
		FileReceiver receiver = osName.contains("Windows") ? new WindowsReceiver(fileName) : new MacReceiver(fileName);
		FileInvoker invoker = new FileInvoker(new FileReadOperation(receiver));
		invoker.execute();
		
		invoker.setCommand(new FileWriteOperation(receiver));
		invoker.execute();
		
		invoker.setCommand(new FileCloseOperation(receiver));
		invoker.execute();
	}
}
