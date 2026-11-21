public class SudokuSolver {

    private SudokuValidator validator;

    public SudokuSolver() {
        validator = new SudokuValidator();
    }

    public boolean solve(char[][] board, int row, int col) {

        // All rows have been completed
        if (row == 9) {
            return true;
        }

        int nextRow;
        int nextCol;

        // Move to the next row
        if (col == 8) {
            nextRow = row + 1;
            nextCol = 0;
        } else {
            nextRow = row;
            nextCol = col + 1;
        }

        // Skip the cell if it already contains a number
        if (board[row][col] != '.') {

            return solve(board, nextRow, nextCol);
        }

        // Try numbers from 1 to 9
        for (int number = 1; number <= 9; number++) {

            if (validator.canPlaceNumber(board, row, col, number)) {

                board[row][col] = (char) (number + '0');

                // Try solving the remaining cells
                if (solve(board, nextRow, nextCol)) {
                    return true;
                }

                // Undo the number if it leads to a dead end
                board[row][col] = '.';
            }
        }

        return false;
    }

    public boolean solveSudoku(char[][] board) {
        return solve(board, 0, 0);
    }
}
