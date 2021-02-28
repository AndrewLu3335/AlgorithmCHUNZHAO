/**
 * @Author: Andrew Lu
 * @Description: 省份数量
 */
public class NumberOfProvinces547 {

    /**
     * 采用dfs深度优先遍历
     * @param isConnected
     * @return
     */
    public int findCircleNum1(int[][] isConnected) {
        boolean [] visited=new boolean[isConnected.length];
        int count=0;
        for (int i=0; i<isConnected.length; i++) {
            if (!visited[i]) {
                dfs(isConnected,visited,i);
                count++;
            }
        }
        return count;
    }
    //dfs
    private void dfs(int[][] isConnected, boolean[] visited, int i) {
        for (int j=0; j<isConnected.length; j++) {
            //i城市和j城市相连，但是j城市还没背访问过，则标记j为访问过 然后继续深度优先遍历j
            if (isConnected[i][j]==1 && !visited[j]) {
                visited[j]=true;
                dfs(isConnected,visited,j);
            }
        }
    }




    class UnionFind {
        //并查集里有多少个集
        private int count=0;
        private int [] parent;

        //刚开始所有元素都是指向自己
        public UnionFind(int n) {
            count=n;
            parent=new int[n];
            for (int i=0; i<n; i++) {
                parent[i]=i;
            }
        }
        //找到自己的parent是自己就说明找到了一个并查集的头了
        public int find (int p) {
            while (p!=parent[p]) {
                parent[p]=parent[parent[p]];
                p=parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP=find(p);
            int rootQ=find(q);
            if (rootP==rootQ) return;
            parent[rootP]=rootQ;
            count--;
        }
    }
    public int findCircleNum(int[][] isConnected) {
       UnionFind unionFind=new UnionFind(isConnected.length);
       for (int i=0; i<isConnected.length-1; i++) {
            for (int j=i+1; j< isConnected.length; j++) {
                if (isConnected[i][j]==1) unionFind.union(i,j);
            }
       }
       return unionFind.count;

    }
}

