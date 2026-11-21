public class SudokuBoard {

    private char[][] board;

    public SudokuBoard() {

        board = new char[][] {
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
    }

    public char[][] getBoard() {
        return board;
    }

    public void displayBoard() {

        System.out.println("\n------- SUDOKU BOARD -------");

        for (int row = 0; row < 9; row++) {

            if (row % 3 == 0 && row != 0) {
                System.out.println("---------------------");
            }

            for (int col = 0; col < 9; col++) {

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
