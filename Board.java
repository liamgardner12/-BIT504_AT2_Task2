import java.awt.*;

/**
 * Represents the game board with a grid of cells.
 */
public class Board {
    // Grid line width
    public static final int GRID_WIDTH = 8;
    // Grid line half width
    public static final int GRID_WIDHT_HALF = GRID_WIDTH / 2;

    // 2D array of ROWS-by-COLS Cell instances
    public Cell[][] cells;

    /**
     * Constructor to create the game board.
     */
    public Board() {
        // Initialize the cells array
        cells = new Cell[GameMain.ROWS][GameMain.COLS];

        for (int row = 0; row < GameMain.ROWS; ++row) {
            for (int col = 0; col < GameMain.COLS; ++col) {
                cells[row][col] = new Cell(row, col);
            }
        }
    }

    /**
     * Checks if the game is a draw (i.e., no more EMPTY cells).
     * @return true if it's a draw, false otherwise
     */
    public boolean isDraw() {
        for (int row = 0; row < GameMain.ROWS; ++row) {
            for (int col = 0; col < GameMain.COLS; ++col) {
                if (cells[row][col].content == Player.Empty) {
                    return false; // There are still empty cells
                }
            }
        }
        return true; // No empty cells left
    }

    /**
     * Checks if the current player has won after making their move.
     * @param thePlayer The player to check
     * @param playerRow The row of the last move
     * @param playerCol The column of the last move
     * @return true if the player has won, false otherwise
     */
    public boolean hasWon(Player thePlayer, int playerRow, int playerCol) {
        // Check if the player has 3-in-a-row horizontally
        if (cells[playerRow][0].content == thePlayer &&
            cells[playerRow][1].content == thePlayer &&
            cells[playerRow][2].content == thePlayer) {
            return true;
        }

        // Check if the player has 3-in-a-column vertically
        if (cells[0][playerCol].content == thePlayer &&
            cells[1][playerCol].content == thePlayer &&
            cells[2][playerCol].content == thePlayer) {
            return true;
        }

        // Check the diagonal from top-left to bottom-right
        if (cells[0][0].content == thePlayer &&
            cells[1][1].content == thePlayer &&
            cells[2][2].content == thePlayer) {
            return true;
        }

        // Check the diagonal from top-right to bottom-left
        if (cells[0][2].content == thePlayer &&
            cells[1][1].content == thePlayer &&
            cells[2][0].content == thePlayer) {
            return true;
        }

        // No win detected
        return false;
    }

    /**
     * Draws the grid and cells on the canvas.
     * @param g Graphics object used for drawing
     */
    public void paint(Graphics g) {
        // Draw the grid lines
        g.setColor(Color.GRAY);
        for (int row = 1; row < GameMain.ROWS; ++row) {
            g.fillRect(0, GameMain.CELL_SIZE * row - GRID_WIDHT_HALF, 
                       GameMain.CANVAS_WIDTH, GRID_WIDTH);
        }
        for (int col = 1; col < GameMain.COLS; ++col) {
            g.fillRect(GameMain.CELL_SIZE * col - GRID_WIDHT_HALF, 0, 
                       GRID_WIDTH, GameMain.CANVAS_HEIGHT);
        }

        // Draw each cell
        for (int row = 0; row < GameMain.ROWS; ++row) {
            for (int col = 0; col < GameMain.COLS; ++col) {
                cells[row][col].paint(g);
            }
        }
    }
}
