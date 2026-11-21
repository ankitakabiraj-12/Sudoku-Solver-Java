/**
 * SudokuSolver
 * 
 * using the recursive backtracking algorithm.
 */
public class SudokuSolver {

    public static void main(String[] args) {
        // Sample 9x9 Sudoku puzzle from the assignment.
        // Empty cells are represented by '.' and fixed numbers by characters '1' through '9'.
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println("Welcome to Sudoku Solver!");

        // Display the initial unsolved board
        System.out.println("\nOriginal Sudoku Puzzle:");
        displayBoard(board);

        // Attempt to solve the puzzle using backtracking
        boolean isSolved = solveSudoku(board);

        // Display the result
        if (isSolved) {
            System.out.println("\nSudoku Solved Successfully!");
            System.out.println("\nFinal Sudoku Solution:");
            displayBoard(board);
        } else {
            System.out.println("\nThis Sudoku puzzle has no solution.");
        }
    }

    /**
     * Solves the Sudoku puzzle using recursive backtracking.
     * Iterates through each cell of the 9x9 grid looking for empty spots ('.').
     *
     * @param board 2D character array representing the 9x9 Sudoku board
     * @return true if the puzzle is successfully solved, false otherwise
     */
    public static boolean solveSudoku(char[][] board) {
        // Search for an empty cell across the 9x9 grid
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                // If an empty cell is found, try placing digits '1' through '9'
                if (board[row][col] == '.') {
                    for (char number = '1'; number <= '9'; number++) {
                        // Check if the current number satisfies row, column, and 3x3 box rules
                        if (isValidPlacement(board, row, col, number)) {
                            // Place the number tentatively
                            board[row][col] = number;

                            // Recursively attempt to solve the rest of the board
                            if (solveSudoku(board)) {
                                return true; // Solution found
                            }

                            // Backtrack: reset cell back to empty if the choice didn't lead to a solution
                            board[row][col] = '.';
                        }
                    }

                    // If no number from '1' to '9' can lead to a solution, backtrack
                    return false;
                }
            }
        }

        // All cells are filled with valid numbers, so the puzzle is solved
        return true;
    }

    /**
     * Validates whether placing a specific number at (row, col) violates any Sudoku rule.
     * Checks:
     * 1. Row uniqueness
     * 2. Column uniqueness
     * 3. 3x3 subgrid (box) uniqueness
     *
     * @param board  2D character array representing the board
     * @param row    row index (0-8)
     * @param col    column index (0-8)
     * @param number character digit ('1' - '9') to validate
     * @return true if placement is valid, false if a conflict exists
     */
    public static boolean isValidPlacement(char[][] board, int row, int col, char number) {
        // Check if the number already exists in the same row or column
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == number) {
                return false; // Found duplicate in the row
            }
            if (board[i][col] == number) {
                return false; // Found duplicate in the column
            }
        }

        // Calculate the top-left starting indices of the 3x3 sub-box
        int boxStartRow = (row / 3) * 3;
        int boxStartCol = (col / 3) * 3;

        // Check if the number already exists within the 3x3 sub-box
        for (int r = boxStartRow; r < boxStartRow + 3; r++) {
            for (int c = boxStartCol; c < boxStartCol + 3; c++) {
                if (board[r][c] == number) {
                    return false; // Found duplicate in the 3x3 sub-box
                }
            }
        }

        // The number does not violate any rule, so it is a valid placement
        return true;
    }

    /**
     * Prints the 9x9 Sudoku board to the console with clear visual borders.
     *
     * @param board 2D character array representing the board
     */
    public static void displayBoard(char[][] board) {
        System.out.println("\n------- SUDOKU BOARD -------");

        for (int row = 0; row < 9; row++) {
            // Print horizontal dividing line between 3x3 sub-boxes
            if (row % 3 == 0 && row != 0) {
                System.out.println("---------------------");
            }

            for (int col = 0; col < 9; col++) {
                // Print vertical dividing bar between 3x3 sub-boxes
                if (col % 3 == 0 && col != 0) {
                    System.out.print("| ");
                }

                System.out.print(board[row][col] + " ");
            }

            System.out.println();
        }

        System.out.println("---------------------------");
    }
}
