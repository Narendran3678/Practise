package com.tree.trie;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Trie {

    private List<TrieNode> rootNode = new ArrayList<>();
    public Trie() {
    }

    public boolean search(String searchTxt) {
        for(TrieNode trieNode:rootNode) {
            if(trieNode.getCharacter().equals(searchTxt.charAt(0))) {
                return search(trieNode.getNextCharacters(),searchTxt,1);
            }
        }
        return true;
    }

    public boolean search(Set<TrieNode> trieNodes , String srhChar,int index) {
        if((trieNodes==null || trieNodes.isEmpty()) && srhChar.length()<index+1){
            return true;
        }
        for(TrieNode nextTrieNode:trieNodes) {
            if(nextTrieNode.getCharacter().equals(srhChar.charAt(index))) {
                return search(nextTrieNode.getNextCharacters(),srhChar,index+1);
            }
        }
        return false;
    }
    public void add(String word) {
        boolean isNewStr =true;
        TrieNode currentNode = null;
        for(int i=0;i<word.length();i++) {
            Character ch = word.charAt(i);
            if(rootNode.isEmpty() || (i==0 && !isNodeContains(ch))) {
                currentNode  = new TrieNode(ch);
                System.out.println(ch+" Added to Root");
                rootNode.add(currentNode);
                isNewStr=false;
            }
            else {
                if(currentNode==null) {
                    currentNode = getRootNode(ch);
                    if(isNewStr && currentNode!=null) {
                        continue;
                    }
                }
                Set<TrieNode> tempNodes = currentNode.getNextCharacters();
                currentNode = chainCharacter(currentNode,tempNodes, ch);
            }
        }
    }
    private boolean isNodeContains(Character ch) {
        return rootNode.stream().anyMatch(node -> node.getCharacter().equals(ch));
    }
    private TrieNode chainCharacter(TrieNode currentNode ,Set<TrieNode> nextTrieNodes, Character ch ) {

        if(nextTrieNodes.isEmpty()) {
            System.out.println(ch+" Added to Last Chain");
            TrieNode tempTrieNode = new TrieNode(ch);
            nextTrieNodes.add(tempTrieNode);
            currentNode=tempTrieNode;
            return currentNode;
        }
        for(TrieNode nextTrieNode : nextTrieNodes) {
            if(ch.equals(nextTrieNode.getCharacter())) {
                currentNode=nextTrieNode;
                break;
            }
            if(nextTrieNode.getCharacter().equals(currentNode.getCharacter()) ) {
                System.out.println(ch+" Checking Chain Character");
                currentNode=nextTrieNode;
                chainCharacter(currentNode,nextTrieNode.getNextCharacters(),ch);
            }
            else {
                System.out.println(ch+" Added to Last Chain Else");
                TrieNode tempTrieNode = new TrieNode(ch);
                nextTrieNodes.add(tempTrieNode);
                currentNode = tempTrieNode;
                break;
            }
        }
        return currentNode;
    }
    private TrieNode getRootNode(Character ch) {
        TrieNode trieNode = null;
        for(TrieNode tempNode:rootNode) {
            if (tempNode.getCharacter().equals(ch)) {
                return tempNode;
            }
            trieNode=tempNode;
        }
        return trieNode;
    }
    /*          S I S
      A P I
              B

      B T S
   */
    public void print() {
        String str = "";

        for(TrieNode printNode : this.rootNode) {
            str+=printNode.getCharacter();
            print(printNode.getNextCharacters(),str);
            str="";
        }
    }
    public void print(Set<TrieNode> tempNode,String word) {
        if(tempNode.isEmpty()){
            System.out.println(word);
            return;
        }
        for(TrieNode trieNode: tempNode) {
            print(trieNode.getNextCharacters(),word+trieNode.getCharacter());
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("APISIS");
        trie.add("APIB");
        trie.add("APIT");
        trie.add("BTS");
        trie.add("CTS");
        trie.print();

        System.out.println(trie.search("APIS")); // Not completely Fixed
    }
}
