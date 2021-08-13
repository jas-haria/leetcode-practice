// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
class Solution {
    public int countComponents(int n, int[][] edges) {
        List<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adjList[i] = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }
        boolean[] visited = new boolean[n];
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                components++;
                visit(i, visited, adjList);
            }
        }
        return components;
    }
    
    private void visit(int i, boolean[] visited, List<Integer>[] adjList) {
        visited[i] = true;
        for (int j: adjList[i]) {
            if (!visited[j]) {
                visit(j, visited, adjList);
            }
        }
    }
}