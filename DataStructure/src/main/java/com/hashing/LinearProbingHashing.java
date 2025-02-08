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
        if(getLoadFactor()>=0.75) {
            rehash(word);
        } else {
            int index = getHashingIndex(word);
            for(int i=index;i<hashTableSize;i++) {
                if (hashTable[i] == null) {
                    hashTable[i] = word;
                    //System.out.println("Inserted ["+word+"]");
                    usedIndexCount++;
                    break;
                } else {
                    //System.out.println("Array's Position is Filled");
                }
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
    }
}