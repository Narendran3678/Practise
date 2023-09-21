package com.behavioral.memento;

import java.util.*;

class TextArea // Original
{
	private StringBuilder textsb;
	public TextArea()
	{
		textsb = new StringBuilder();
	}
	public Memento snapshot() {		
		return new Memento(textsb.toString());
	}
	public void restore(Memento memento) {
		if(memento!=null)
			textsb = new StringBuilder(memento.getSavedText());
		else
			textsb.setLength(0);
	}
	public void setText(String text) {
		textsb.append(text).append(" ");
	}
	public String getText() {
		return textsb.toString();
	}
	
	public static class Memento {
		private final String text ;

		private Memento(String text) {
			this.text = text;
		}

		public String getSavedText() {
			return text;
		}
	}
}

class Editor // CareTaker
{
	private Deque<TextArea.Memento> textAreaMem;
	private TextArea textArea;
	public Editor() {
		textAreaMem = new LinkedList<>();
		textArea = new TextArea();
	}
	public void write(String text) {
		textArea.setText(text);
		textAreaMem.push(textArea.snapshot());
	}
	public void undo() {
		if(textAreaMem.size()>0)
		{
			textAreaMem.pop();   
			textArea.restore(textAreaMem.size()>0 ? textAreaMem.getFirst():null);
		}
		else
		{
			System.out.println("Text Area Clean");
		}
	}
	public String getTextFromTextArea()
	{
		return textArea.getText();
	}
	public Deque<TextArea.Memento> getTextAreaMem() {
		return textAreaMem;
	}
}

public class MementoPattern {
	public static void main(String args[]) {	
		Deque<String> textAreaMem = new LinkedList<>();
		textAreaMem.push("Text1");
		textAreaMem.push("Text2");
		textAreaMem.push("Text3");
		textAreaMem.remove();
		textAreaMem.remove();
		textAreaMem.remove();
		
		System.out.println(textAreaMem.size());
	
		Editor editor = new Editor();
		editor.write("This");
		editor.write("is");
		editor.write("TextArea");
		System.out.println(editor.getTextFromTextArea());
		
		System.out.println("Text Area Undo....");
		editor.undo();
		editor.undo();
		editor.undo(); 
		editor.undo();
		System.out.println(editor.getTextFromTextArea());
	}
}
