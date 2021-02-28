/**
 * @Author: Andrew Lu
 * @Description: 实现字典树
 */
public class ImplementTreePrefix208 {

    class Trie {
        private Trie [] tries;
        private boolean isEnd;
        private final int AB =26;

        /** Initialize your data structure here. */
        public Trie() {
            tries=new Trie[AB];
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Trie root=this;
            //判空
            if (word!=null) {
                char [] words=word.toCharArray();
                for (char ch: words) {
                    //判断当前层是否包含这个字母
                    if (root.tries[ch-'a']==null) {
                        root.tries[ch-'a']=new Trie();
                    }
                    //将当前的节点变为下一层节点
                    root=root.tries[ch-'a'];
                }
                //标记单词的最后一个字母
                root.isEnd=true;

            }else{
                throw new RuntimeException("word is null");
            }
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Trie root=this;
            if(word!=null) {
                 char [] words=word.toCharArray();
                 for (char ch: words) {
                     //如果为空 则没找到字母 则没有该单词
                     if (root.tries[ch-'a']==null) {return false;}
                     root=root.tries[ch-'a'];
                 }
                 //如果最后个字母有结尾标记则存在该单词
                 return root.isEnd;
            }else{
                return false;
            }
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Trie root=this;
            if(prefix!=null) {
                char [] words=prefix.toCharArray();
                for (char ch: words) {
                    //如果为空 则没找到字母 则没有该单词
                    if (root.tries[ch-'a']==null) {return false;}
                    root=root.tries[ch-'a'];
                }
                return true;
            }else{
                return false;
            }
        }
    }
}
