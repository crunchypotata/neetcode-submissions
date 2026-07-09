class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        //количество строк
        int rowSize = matrix.length;
        //количество столбцов
        int colSize = matrix[0].length;

        int left = 0;
        int right = (rowSize * colSize) - 1;
        int mid = 0;
        
        while (left <= right) {
            mid = left + (right - left) / 2;

            int row = mid / colSize;
            int col = mid % colSize;


            if(matrix[row][col] == target) {
                return true;
            }

            if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        } 

        return false;
        
    }
}
