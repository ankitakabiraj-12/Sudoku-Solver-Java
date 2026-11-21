public class SudokuValidator {

    public boolean canPlaceNumber(char[][] board, int row, int col, int number) {

        char value = (char) (number + '0');

        // Check the current column
        for (int i = 0; i < 9; i++) {

            if (board[i][col] == value) {
                return false;
            }
        }

        // Check the current row
        for (int j = 0; j < 9; j++) {

            if (board[row][j] == value) {
                return false;
            }
        }

        // Find the starting position of the 3x3 box
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        // Check the 3x3 box
        for (int i = startRow; i < startRow + 3; i++) {

            for (int j = startCol; j < startCol + 3; j++) {

                if (board[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }
}
