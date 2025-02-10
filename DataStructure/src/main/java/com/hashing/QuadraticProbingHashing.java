package com.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuadraticProbingHashing {
    private String[] hashTable;
    private int hashTableSize;
    private int usedIndexCount=0;

    public QuadraticProbingHashing(int size) {
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
            int counter=0;
            int index = getHashingIndex(word);
            for(int i=index;i<index+hashTableSize;i++) {
                int tempIndex = (index+(counter*counter)) % hashTableSize;
                if (hashTable[tempIndex] == null) {
                    hashTable[tempIndex] = word;
                    //System.out.println("Inserted ["+word+"]");
                    break;
                } else {
                    //System.out.println("Array's Position is Filled");
                }
                counter++;
            }
        }
        usedIndexCount++;
    }


    public void print() {
        System.out.println(Arrays.toString(hashTable));
    }
    public static void main(String[] args) {
        QuadraticProbingHashing quadraticProbingHashing = new QuadraticProbingHashing(5);
        quadraticProbingHashing.insertIntoHashTable("Hi");
        quadraticProbingHashing.insertIntoHashTable("Hello");
        quadraticProbingHashing.insertIntoHashTable("World");
        quadraticProbingHashing.insertIntoHashTable("Java");
        quadraticProbingHashing.insertIntoHashTable("Java1");
        quadraticProbingHashing.insertIntoHashTable("Java2");
        quadraticProbingHashing.insertIntoHashTable("Java3");
        quadraticProbingHashing.insertIntoHashTable("Java4");
        quadraticProbingHashing.insertIntoHashTable("Java5");
        quadraticProbingHashing.insertIntoHashTable("Java6");
        quadraticProbingHashing.insertIntoHashTable("Java7");
        quadraticProbingHashing.insertIntoHashTable("Java8");
        quadraticProbingHashing.insertIntoHashTable("Java9");
        quadraticProbingHashing.insertIntoHashTable("Java10");
        quadraticProbingHashing.insertIntoHashTable("Java11");
        quadraticProbingHashing.insertIntoHashTable("Java12");
        quadraticProbingHashing.print();
    }
}
