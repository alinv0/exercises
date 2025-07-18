package trie;

// https://leetcode.com/problems/implement-trie-prefix-tree


public class ImplementTrie {
  static class Trie {
    Trie[] children;
    boolean isLeaf;

    public Trie() {
      children = new Trie[26];
      isLeaf = false;
    }

    public void insert(String word) {
      Trie node = this;
      for (char c : word.toCharArray()) {
        int idx = c - 'a';
        if (node.children[idx] == null) {
          node.children[idx] = new Trie();
        }
        node = node.children[idx];
      }
      node.isLeaf = true;
    }

    public boolean search(String word) {
      Trie node = this;
      for (char c : word.toCharArray()) {
        int idx = c - 'a';
        if (node.children[idx] == null) return false;
        node = node.children[idx];
      }
      return node.isLeaf;
    }

    public boolean startsWith(String prefix) {
      Trie node = this;
      for (char c : prefix.toCharArray()) {
        int idx = c - 'a';
        if (node.children[idx] == null) return false;
        node = node.children[idx];
      }
      return true;
    }
  }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */


  public static void main(String[] args){
    Trie trie = new Trie();
    trie.insert("apple");
    System.out.println(trie.search("apple"));   // returns true
    System.out.println(trie.search("app"));     // returns false
    System.out.println(trie.startsWith("app")); // returns true
    trie.insert("app");
    System.out.println(trie.search("app"));     // returns true
    System.out.println("Starts with: " + trie.startsWith("some")); // returns true
    trie.insert("application");
    trie.insert("another");
    trie.insert("something else");
    System.out.println(trie.search("applications"));
    System.out.println(trie.search("another"));
    System.out.println(trie.search("something else"));
  }
}
