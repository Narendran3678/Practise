package com.tree.trie;

import java.util.HashSet;
import java.util.Set;

public class TrieNode {
    private Character character;
    private Boolean isEndOfString=true;
    private Set<TrieNode> nextCharacters ;
    public TrieNode(Character character) {
        this.character =character;
        nextCharacters = new HashSet<>();
        this.isEndOfString =true;
    }

    public Character getCharacter() {
        return character;
    }

    public Set<TrieNode> getNextCharacters() {
        return nextCharacters;
    }

    public Boolean isEndOfString() {
        return isEndOfString;
    }

}
