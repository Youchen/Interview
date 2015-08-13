/**
 * DO THIS AGAIN.
 * 
 * Understand the Trie Structure completely.
 */
class TrieNode {
    //2015-06-19 21:41:04 - 2015-06-19 23:00:45 (1 h 19 min)
    char c;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    boolean isLeaf;
    
    public TrieNode() {
        // children = new HashMap<Character, TrieNode>();
    }
    
    public TrieNode(char c){
        // children = new HashMap<Character, TrieNode>();
        this.c = c;
    }
}

public class Trie {
    //Caution: the root node of Trie is DUMMY node.
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    //Caution: the root node of Trie is DUMMY node.
    public void insert(String word) {
        // if(word == null || word.length() == 0) //It's okay to have this line.
        //     return;
        
        HashMap<Character, TrieNode> children = root.children;
        
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            
            TrieNode t;
            if(children.containsKey(c))
                t = children.get(c);
            else{
                t = new TrieNode(c);
                children.put(c, t);
            }
            
            children = t.children;
            
            if(i == word.length() - 1)
                t.isLeaf = true;
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        // if(word == null || word.length() == 0) //It's okay to have this line.
        //     return false;
        
        TrieNode t = searchNode(word);
        
        if(t != null && t.isLeaf)
            return true;
        else
            return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        // if(prefix == null || prefix.length() == 0) //It's okay to have this line.
        //     return false;
        
        TrieNode t = searchNode(prefix);
        
        if(t != null)
            return true;
        else
            return false;
    }
    
    /**
     * if this Trie contains "word"
     *      return the last node which "c" is word[word.length() - 1]
     * else
     *      return null
     */
    private TrieNode searchNode(String word){
        // if(word == null || word.length() == 0) //It's okay to have this line.
        //     return null;
            
        HashMap<Character, TrieNode> children = root.children;
        TrieNode t = null;
        
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            
            if(children.containsKey(c)){
                t = children.get(c);
                children = t.children;
            }else
                return null;
        }
        return t;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");