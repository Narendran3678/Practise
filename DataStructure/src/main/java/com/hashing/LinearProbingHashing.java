package com.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinearProbingHashing {
    private String[] hashTable;
    private int hashTableSize;
    private int usedIndexCount=0;

    public LinearProbingHashing(int size) {
        this.hashTableSize=size;
        hashTable = new String[size];
    }

    private int getHashingIndex(String word) {
        char[] wordCh = word.toCharArray();
        int totalAsciiValue=0;
        for(char ch: wordCh) {
            totalAsciiValue+=ch;
        }
        return totalAsciiValue%hashTableSize;
    }

    private double getLoadFactor() {
        return usedIndexCount * 1.0 / hashTable.length;
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
            int index = getHashingIndex(word);
            for(int i=index;i<index+hashTableSize;i++) {
                int tempIndex = i%hashTableSize;
                if (hashTable[tempIndex] == null) {
                    hashTable[tempIndex] = word;
                    //System.out.println("Inserted ["+word+"]");
                    break;
                } else {
                    //System.out.println("Array's Position is Filled");
                }
            }
        }
        usedIndexCount++;
    }

    public void search(String searchTxt) {
        int indexPosition = getHashingIndex(searchTxt);
        for(int i=indexPosition ;i<indexPosition+hashTableSize;i++) {
            int tempIndex = i%hashTableSize;
            if(searchTxt.equalsIgnoreCase(hashTable[tempIndex]) ) {
                System.out.println(searchTxt+"="+tempIndex+"="+hashTable[tempIndex]);
                break;
            }
        }
    }

    public void print() {
        System.out.println(Arrays.toString(hashTable));
    }

    public static void main(String[] args) {
        LinearProbingHashing hashing = new LinearProbingHashing(5);
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