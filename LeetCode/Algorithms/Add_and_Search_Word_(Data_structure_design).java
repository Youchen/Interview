/**
 * Almost same Algorithm as the problem:
 *       Implement Trie (Prefix Tree) 
 * 
 * Learn how to iterate in hashTable from this problem.
 *      for ( Map.Entry<Character, TrieNode> child: n.children.entrySet() )
 *      child.getValue() return the value of the <key, value> pair
 *      child.getKey() .............key   ........................
 *      
 *      Reference:
 *          HashMap:
 *              http://docs.oracle.com/javase/7/docs/api/java/util/HashMap.html
 *          Map:
 *              http://docs.oracle.com/javase/7/docs/api/java/util/Map.html
 *          Map.Entry:
 *              http://docs.oracle.com/javase/7/docs/api/java/util/Map.Entry.html
 *
 * Reference:
 *      http://www.programcreek.com/2014/05/leetcode-add-and-search-word-data-structure-design-java/
 */
public class WordDictionary {
    //2015-06-19 23:18:59 pause 2015-06-19 23:33:00
    //2015-06-20 14:18:54 pause 2015-06-20 14:43:16
    //2015-06-20 21:32:57 - 2015-06-20 21:53:37 (15 + 25 + 21 = 61 min)
    
    
    public class TrieNode{
        char c;
        HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        boolean isLeaf;
        
        public TrieNode(){}
        
        public TrieNode(char c){
            this.c = c;
        }
    }
    
    
    
    
    
    TrieNode root;
    
    public WordDictionary(){
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        if(word == null || word.length() == 0)
            return;
        
        HashMap<Character, TrieNode> children = root.children;
        
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            
            TrieNode t;
            if(children.containsKey(c)){
                t = children.get(c);
                
            }else{
                t = new TrieNode(c);
                children.put(c, t);
            }
            
            children = t.children;
            
            if(i == word.length() - 1)
                t.isLeaf = true;
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return dfsSearch(root, word, 0);
    }
    
    public boolean dfsSearch(TrieNode n, String s, int strStartAt){
        if(strStartAt == s.length() ){
            if(n.isLeaf)
                return true;
            else
                return false;
        }
        
        char c = s.charAt(strStartAt);
        
        if(n.children.containsKey(c) ){
            if(strStartAt == s.length() - 1 && n.children.get(c).isLeaf )
                return true;
            
            return dfsSearch(n.children.get(c), s, strStartAt + 1);
        }else if( c == '.') {
            
                for(Map.Entry<Character, TrieNode> child: n.children.entrySet()){
                    if(strStartAt == s.length() - 1 && child.getValue().isLeaf )
                        return true;
                    
                    if(dfsSearch(child.getValue(), s, strStartAt + 1))
                        return true;
                }
                
                return false;
                
        }else
            return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");