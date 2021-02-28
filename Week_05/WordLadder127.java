import java.util.*;

/**
 * @Author: Andrew Lu
 * @Description: 单词接龙
 */
public class WordLadder127 {
    /**
     * BFS 广度优先遍历
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 第 1 步：先将 wordList 放到哈希表里，便于判断某个单词是否在 wordList 里
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.remove(beginWord);

        // 第 2 步：图的广度优先遍历，必须使用队列和表示是否访问过的 visited 哈希表
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        // 第 3 步：开始广度优先遍历，包含起点，因此初始化的时候步数为 1
        int step = 1;
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                // 依次遍历当前队列中的单词
                String currentWord = queue.poll();
                // 如果 currentWord 能够修改 1 个字符与 endWord 相同，则返回 step + 1
                if (changeWordEveryOneLetter(currentWord, endWord, queue, visited, wordSet)) {
                    return step + 1;
                }
            }
            step++;
        }
        return 0;
    }

    /**
     * 尝试对 currentWord 修改每一个字符，看看是不是能与 endWord 匹配
     *
     * @param currentWord
     * @param endWord
     * @param queue
     * @param visited
     * @param wordSet
     * @return
     */
    private boolean changeWordEveryOneLetter(String currentWord, String endWord,
                                             Queue<String> queue, Set<String> visited, Set<String> wordSet) {
        char[] charArray = currentWord.toCharArray();
        for (int i = 0; i < endWord.length(); i++) {
            // 先保存，然后恢复
            char originChar = charArray[i];
            for (char k = 'a'; k <= 'z'; k++) {
                if (k == originChar) {
                    continue;
                }
                charArray[i] = k;
                String nextWord = String.valueOf(charArray);
                if (wordSet.contains(nextWord)) {
                    if (nextWord.equals(endWord)) {
                        return true;
                    }
                    if (!visited.contains(nextWord)) {
                        queue.add(nextWord);
                        // 注意：添加到队列以后，必须马上标记为已经访问
                        visited.add(nextWord);
                    }
                }
            }
            // 恢复
            charArray[i] = originChar;
        }
        return false;
    }


    /**
     * 双向bfs
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {

        //加快查询效率
        Set<String> wordLis=new HashSet<>(wordList);
        //开始的词和结束词是否包括早wordlist中
        if (!wordLis.contains(beginWord) && !wordLis.contains(endWord)) {
            return 0;
        }
        //头开始记录每一步bfs搜索到的结果
        Set<String> beginSet=new HashSet<>();
        //从尾开始记录每一步bfs搜索到的结果
        Set<String> endSet=new HashSet<>();
        int len=1;
        //int strlen=beginWord.length();
        HashSet<String> visited=new HashSet<>();

        beginSet.add(beginWord);
        endSet.add(endWord);

        //BFS开始
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            //如果endset比beginSet小 则 交换beginSet和endSet
            if (beginSet.size()>endSet.size()) {
                Set<String> changeTemp=beginSet;
                beginSet=endSet;
                endSet=changeTemp;
            }
            //用来存放bfs每一层搜索到的新的单词
            Set<String>temp= new HashSet<>();
            //遍历beginSet里面的所有单词，这里也是为啥要小的一方作为beginset来操作，节省时间
            for (String word : beginSet) {
                char []chs=word.toCharArray();
                for (int i=0;i<chs.length; i++) {
                    //尝试改变单词中一个位置的字母 从a-z一个个去替换原来的字母
                    for (char c='a'; c<='z'; c++) {
                        char old=chs[i];
                        //尝试替换新的字符
                        chs[i]=c;
                        String target=String.valueOf(chs);
                        //如果另一个set里有这个字符串则说明双向bfs已经找到了连接好了单词
                        if (endSet.contains(target)) {
                            return len+1;
                        }
                        //没被访问过，但是匹配wordlis
                        if (!visited.contains(target) && wordLis.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        //恢复以前的字符
                        chs[i]=old;
                    }
                }
            }
            beginSet=temp;
            len++;
        }
        return 0;
    }

    public static void main(String[] args) {
        WordLadder127 w=new WordLadder127();
        int result=w.ladderLength("hit","cog",new ArrayList<String>(Arrays.asList("hot","dot","dog","lot","log")));
        System.out.println(result);
    }
}
