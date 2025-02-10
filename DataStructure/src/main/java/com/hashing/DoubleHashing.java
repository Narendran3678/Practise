package com.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DoubleHashing {
    private String[] hashTable;
    private int hashTableSize;
    private int usedIndexCount=0;

    public DoubleHashing(int size) {
        this.hashTableSize=size;
        hashTable = new String[size];
    }


    private void rehash(String word) {
        usedIndexCount=0;
        List<String> rehashTable= new ArrayList<>();
        for(String tableWord:hashTable) {
            if(tableWord!=null) {
                rehashTable.add(tableWord);
            }
        }
        rehashTable.add(word);
        hashTable = new String[hashTable.length*2] ;
        hashTableSize = hashTable.length;
        for(String wordStr : rehashTable) {
            insertIntoHashTable(wordStr);
        }
        //System.out.println("Hashtable Rehashed");
    }

    public void insertIntoHashTable(String word) {
        double loadFactor = getLoadFactor();
        if(loadFactor>=0.75) {
            rehash(word);
        } else {
            int firstIndex = getFirstHashingIndex(word);
            int secondIndex =getSecondHashingIndex(word);
            for(int i=0;i<hashTableSize;i++) {
                int tempIndex = (firstIndex + i + secondIndex) % hashTableSize;
                if (hashTable[tempIndex] == null) {
                    hashTable[tempIndex] = word;
                    System.out.println(word +" inserted at location:" +tempIndex);
                    break;
                } else {
                    System.out.println(tempIndex +" is occupied. Tryin next empty index..");
                }
            }
        }
        usedIndexCount++;
    }

    private int getFirstHashingIndex(String word) {
        char[] wordCh = word.toCharArray();
        int totalAsciiValue=0;
        for(char ch: wordCh) {
            totalAsciiValue+=ch;
        }
        return totalAsciiValue%hashTableSize;
    }


    private int getSecondHashingIndex(String word) {
        char[] wordCh = word.toCharArray();
        int totalAsciiValue=0;
        for(char ch: wordCh) {
            totalAsciiValue+=ch;
        }
        if(totalAsciiValue>hashTableSize) {
            totalAsciiValue= addAllDigitsTogether(totalAsciiValue);
        }
        return totalAsciiValue%hashTableSize;
    }
    private int addAllDigitsTogether(int sum) {
        int value = 0;
        while (sum > 0) {
            value = sum % 10;
            sum = sum / 10;
        }
        return value;
    }
    private double getLoadFactor() {
        return usedIndexCount * 1.0 / hashTable.length;
    }

    public void print() {
        System.out.println(Arrays.toString(hashTable));
    }
    public void search(String word) {
        int firstIndex = getFirstHashingIndex(word);
        int secondIndex =getSecondHashingIndex(word);
        for(int i=0;i<hashTableSize;i++) {
            int tempIndex = (firstIndex + i + secondIndex) % hashTableSize;
            if (word.equalsIgnoreCase(hashTable[tempIndex]) ) {
                System.out.println(word+" Found");
                break;
            }
        }
    }

    public static void main(String[] args) {
        DoubleHashing hashing = new DoubleHashing(5);
        hashing.insertIntoHashTable("Hi");
        hashing.insertIntoHashTable("Hello");
        hashing.insertIntoHashTable("World");
        hashing.insertIntoHashTable("Java");
        hashing.insertIntoHashTable("Java1");
        hashing.insertIntoHashTable("Java2");
        hashing.insertIntoHashTable("Java3");
        hashing.insertIntoHashTable("Java4");
        hashing.insertIntoHashTable("Java5");
        hashing.print();
        hashing.search("Hi");
        hashing.search("Hello");
        hashing.search("World");
        hashing.search("Java");
        hashing.search("Java1");
        hashing.search("Java2");
        hashing.search("Java3");
        hashing.search("Java4");
        hashing.search("Java5");

    }
}
