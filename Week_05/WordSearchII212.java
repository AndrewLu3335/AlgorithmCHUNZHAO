import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: Andrew Lu
 * @Description: 单词搜索II
 */
public class WordSearchII212 {
    class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        String word = null;
        public TrieNode() {}
    }

    class Solution {
        char[][] board = null;
        ArrayList<String> result = new ArrayList<String>();

        /**
         * 时间复杂度：
         * board.row.length->R  board.col.length->C  average length of each word->K
         *
         * 每一格的起始启动步数为 4*3^(K-1):
         *  刚开始的时候第一次可以探索4格(一开始不存在探索过的格子)，之后每次可以探索3格（排除掉了之前探索过的一格），k-1：减去之前找到的那个字母
         * 在此基础上乘以单元格的总格子数 R*C
         * 最终时间复杂度：（R*C）* (4*3^(K-1))
         *
         * @param board
         * @param words
         * @return
         */
        public List<String> findWords(char[][] board, String[] words) {

            // 构建字典树
            TrieNode root = new TrieNode();
            for (String word : words) {
                TrieNode node = root;
                //将单词放入字典树
                for (Character letter : word.toCharArray()) {
                    if (node.children.containsKey(letter)) {
                        node = node.children.get(letter);
                    } else {
                        TrieNode newNode = new TrieNode();
                        node.children.put(letter, newNode);
                        node = newNode;
                    }
                }
                //给单词最后个字母标记 整个单词
                node.word = word;
            }

            this.board = board;
            // Step 2). Backtracking starting for each cell in the board
            for (int row = 0; row < board.length; ++row) {
                for (int col = 0; col < board[row].length; ++col) {
                    if (root.children.containsKey(board[row][col])) {
                        backtracking(row, col, root);
                    }
                }
            }

            return this.result;
        }

        //dfs
        private void backtracking(int row, int col, TrieNode parent) {
            //保存好最开始的值
            Character letter = this.board[row][col];

            TrieNode currNode = parent.children.get(letter);

            // 是最后一个字母
            if (currNode.word != null) {
                this.result.add(currNode.word);
                currNode.word = null;
            }

            // 给当前的字母标记# 防止之后再用到这个单词
            this.board[row][col] = '#';

            // 上下左右
            int[] rowOffset = {-1, 0, 1, 0};
            int[] colOffset = {0, 1, 0, -1};
            for (int i = 0; i < 4; ++i) {
                // 定义新的行
                int newRow = row + rowOffset[i];
                //定义新的列
                int newCol = col + colOffset[i];
                //判断新的行和列是否超出board的限制
                if (newRow < 0 || newRow >= this.board.length || newCol < 0 || newCol >= this.board[0].length) {
                    continue;
                }
                //如果四周的格子中包含这个字母就继续dfs
                if (currNode.children.containsKey(this.board[newRow][newCol])) {
                    backtracking(newRow, newCol, currNode);
                }
            }

            // 还原原来的字母
            this.board[row][col] = letter;

           //如果走到了叶子节点则删除这个字母
            if (currNode.children.isEmpty()) {
                parent.children.remove(letter);
            }
        }
    }
}
