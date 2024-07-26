class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        
        compress(arr, 0, 0, arr.length, answer);
        
        return answer;
    }
    
    private void compress(int[][] arr, int x, int y, int size, int[] answer) {

        if (isUniform(arr, x, y, size)) {
            
            if (arr[x][y] == 0) {
                answer[0]++;
            } else {
                answer[1]++;
            }
        } else {
            
            int newSize = size / 2;
            compress(arr, x, y, newSize, answer); 
            compress(arr, x, y + newSize, newSize, answer); 
            compress(arr, x + newSize, y, newSize, answer); 
            compress(arr, x + newSize, y + newSize, newSize, answer); 
        }
    }
    
    private boolean isUniform(int[][] arr, int x, int y, int size) {
        int value = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }
}