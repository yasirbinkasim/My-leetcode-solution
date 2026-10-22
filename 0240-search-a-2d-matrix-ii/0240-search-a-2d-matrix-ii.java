class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0;
        int col = cols - 1;
        while (row < rows && col >= 0) {
            int currentVal = matrix[row][col];
            
            if (currentVal == target) {
                return true;
            } else if (currentVal > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
