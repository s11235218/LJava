package newCode;

public class floodFill {

    public void DFS(int[][] image, int row, int col, int[][] visited, int newX, int newY, int oldColor, int newColor) {
        int[][] nextP = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        // 1.染色
        image[newX][newY] = newColor;
        visited[newX][newY] = 1;
        // 2.搜索新的位置：上下左右
        // 上
        for (int i = 0; i < 4; i++) {
            int nextX = newX + nextP[i][0];
            int nextY = newY + nextP[i][1];

            // 3.判断位置有效性
            if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col) {
                continue;
            }
            // 颜色如果符合要求，且没被搜索过
            if (image[nextX][nextY] == oldColor && visited[nextX][nextY] == 0){
                DFS(image, row, col, visited, nextX, nextY, oldColor, newColor);
            }
        }

    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int row = image.length;
        int col = image[0].length;
        int[][] visited = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                visited[i][j] = 0;
            }
        }
        int oldColor = image[sr][sc];
        DFS(image, row, col, visited, sr, sc, oldColor, newColor);
        return image;
    }
}
