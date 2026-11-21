public class Main {

    public static void main(String[] args) {

        SudokuBoard sudoku = new SudokuBoard();

        SudokuSolver solver = new SudokuSolver();

        char[][] board = sudoku.getBoard();

        System.out.println("Welcome to Sudoku Solver!");

        System.out.println("\nOriginal Sudoku Puzzle:");
        sudoku.displayBoard();

        boolean solved = solver.solveSudoku(board);

        if (solved) {

            System.out.println("\nSudoku Solved Successfully!");

            System.out.println("\nFinal Sudoku Solution:");
            sudoku.displayBoard();

        } else {

            System.out.println("\nThis Sudoku puzzle has no solution.");
        }
    }
}
