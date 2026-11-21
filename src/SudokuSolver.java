// A simple Sudoku Solver program using Backtracking
public class SudokuSolver {
    public static void main(String[] args) {
        // 9x9 Sudoku board where '.' means an empty cell
        char[][] board = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        System.out.println("Welcome to Sudoku Solver!");
        // Print original board
        System.out.println("\nOriginal Sudoku Puzzle:");
        printBoard(board);
        // Solve the board
        if (solve(board)) {
            System.out.println("\nSudoku Solved Successfully!");
            System.out.println("\nFinal Sudoku Solution:");
            printBoard(board);
        } else {
            System.out.println("\nThis Sudoku puzzle has no solution.");
        }
    }
    // Function to solve Sudoku using backtracking
    public static boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                // Look for an empty cell
                if (board[row][col] == '.') {
                    // Try numbers from '1' to '9'
                    for (char num = '1'; num <= '9'; num++) {
                        // Check if the number is safe to place
                        if (isSafe(board, row, col, num)) {
                            board[row][col] = num; // Place number
                            // Recursively solve the next cells
                            if (solve(board)) {
                                return true;
                            }
                            board[row][col] = '.'; // Backtrack (reset)
                        }
                    }
                    // No valid number found, so go back
                    return false;
                }
            }
        }
        // All cells are filled
        return true;
    }
    // Function to check if placing 'num' at (row, col) is valid
    public static boolean isSafe(char[][] board, int row, int col, char num) {
        // 1. Check Row
        for (int c = 0; c < 9; c++) {
            if (board[row][c] == num) {
                return false;
            }
        }
        // 2. Check Column
        for (int r = 0; r < 9; r++) {
            if (board[r][col] == num) {
                return false;
            }
        }
        // 3. Check 3x3 Box
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int r = startRow; r < startRow + 3; r++) {
            for (int c = startCol; c < startCol + 3; c++) {
                if (board[r][c] == num) {
                    return false;
                }
            }
        }
        // Safe to place
        return true;
    }
    // Function to print the board with grid lines
    public static void printBoard(char[][] board) {
        System.out.println("\n------- SUDOKU BOARD -------");
        for (int row = 0; row < 9; row++) {
            // Horizontal line every 3 rows
            if (row % 3 == 0 && row != 0) {
                System.out.println("---------------------");
            }
            for (int col = 0; col < 9; col++) {
                // Vertical line every 3 columns
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