class Solution {
    class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public void BFS(int [][]image, int visited[][], int sr, int sc,int color){
        int m = image.length;
        int n = image[0].length;
        visited[sr][sc] = 1;
        int initial = image[sr][sc];
        image[sr][sc] = color;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr,sc));
        while(!q.isEmpty()){
            Pair node =  q.remove();
            int first = node.first;
            int second = node.second;

            // Right
            if (second < n - 1 && image[first][second + 1] == initial  && visited[first][second + 1] == 0) {
                q.add(new Pair(first, second + 1));
                image[first][ second + 1] = color;
                visited[first][second + 1] = 1;
            }

            // Left
            if (second > 0 && image[first][second - 1] == initial && visited[first][second - 1] == 0) {
                q.add(new Pair(first, second - 1));
                image[first][ second - 1] = color;
                visited[first][second - 1] = 1;
            }

            // Down
            if (first < m - 1 && image[first + 1][second] == initial && visited[first + 1][second] == 0) {
                q.add(new Pair(first + 1, second));
                image[first + 1][second] = color;
                visited[first + 1][second] = 1;
            }

            // Up
            if (first > 0 && image[first - 1][second] == initial && visited[first - 1][second] == 0) {
                q.add(new Pair(first - 1, second));
                image[first - 1][second] = color;
                visited[first - 1][second] = 1;
            }

            
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int visited[][] = new int[m][n];

        BFS(image, visited, sr, sc, color);

        return image;
    }
}