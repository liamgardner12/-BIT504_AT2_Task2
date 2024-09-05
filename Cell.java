import java.awt.*;

/**
 * Represents a single cell on the Tic Tac Toe board.
 */
public class Cell {
    public int row;
    public int col;
    public Player content;

    /**
     * Constructor to create a cell at a specific position.
     * @param row The row of the cell
     * @param col The column of the cell
     */
    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.content = Player.Empty; // Default content is empty
    }

    /**
     * Draws the cell on the canvas.
     * @param g Graphics object used for drawing
     */
    public void paint(Graphics g) {
        // Draw the symbol based on cell content
        int x = col * GameMain.CELL_SIZE;
        int y = row * GameMain.CELL_SIZE;

        if (content == Player.Cross) {
            g.setColor(Color.RED);
            g.drawLine(x + GameMain.CELL_PADDING, y + GameMain.CELL_PADDING,
                       x + GameMain.CELL_SIZE - GameMain.CELL_PADDING, 
                       y + GameMain.CELL_SIZE - GameMain.CELL_PADDING);
            g.drawLine(x + GameMain.CELL_SIZE - GameMain.CELL_PADDING, 
                       y + GameMain.CELL_PADDING, 
                       x + GameMain.CELL_PADDING, 
                       y + GameMain.CELL_SIZE - GameMain.CELL_PADDING);
        } else if (content == Player.Nought) {
            g.setColor(Color.BLUE);
            g.drawOval(x + GameMain.CELL_PADDING, y + GameMain.CELL_PADDING, 
                       GameMain.SYMBOL_SIZE, GameMain.SYMBOL_SIZE);
        }
    }
}
