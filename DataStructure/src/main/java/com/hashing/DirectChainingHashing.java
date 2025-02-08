package com.hashing;

import java.util.Iterator;
import java.util.LinkedList;

public class DirectChainingHashing {
    private LinkedList<String>[] hashTable;
    private int hashTableSize =0 ;
    public DirectChainingHashing(int hashTableSize) {
        this.hashTableSize=hashTableSize;
        hashTable = new LinkedList[hashTableSize];
    }

    public int getStrToAscii(String word) {
        char[] wordCh = word.toCharArray();
        int totalAsciiValue=0;
        for(char ch: wordCh) {
            totalAsciiValue+=ch;
        }
        //System.out.println("ASCII VALUE...."+totalAsciiValue);
        return totalAsciiValue;
    }
    public int getHashingIndex(String word) {
        int totalAsciiValue=  getStrToAscii(word);
        return totalAsciiValue%hashTableSize;
    }

    public void insert(String string) {
        int hashingIndex = getHashingIndex(string);
        insertIntoHashTable(string,hashingIndex);
    }
    public void insertIntoHashTable(String word, int index) {
        if(hashTable[index]==null) {
            hashTable[index] = new LinkedList<>();
            hashTable[index].add(word);
        } else {
            hashTable[index].add(word);
        }
    }

    public void print() {
        int index = 1;
        System.out.println("===========================HASH TABLE===========================");
        for(LinkedList ht : hashTable) {
            if(ht==null)
            {
                System.out.println("Bucket "+index+" [ ]");
                index++;
                continue;
            }
            Iterator iterator = ht.iterator();
            System.out.print("Bucket "+index+" [ ");
            while(iterator.hasNext())
                System.out.print(iterator.next()+" ");

            System.out.print("]");
            System.out.println();
            index++;
        }
        System.out.println("================================================================");
    }
    public static void main(String[]  args) {
        DirectChainingHashing directChainingHashing = new DirectChainingHashing(5);
        directChainingHashing.insert("ABCD");
        directChainingHashing.insert("ABCD");
        directChainingHashing.insert("EFGH");
        directChainingHashing.insert("EFGH");
        directChainingHashing.insert("IJKL");
        directChainingHashing.insert("IJKL");
        directChainingHashing.insert("LMNO");
        directChainingHashing.insert("LMNO");
        directChainingHashing.print();
    }
}
