import java.awt.*;
import javax.swing.*;

public class TicTakToe extends JFrame {
    private final JButton buttons[][] = new JButton[3][3];
    private final char board[][] = new char[3][3];
    private char currentPlayer = 'X';
    private final  JLabel statusLabel;

    public TicTakToe() {
        setTitle("Ti-Tac-Toe");
        setSize(500,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(3, 3));
        for (int i=0; i < 3; i++) {
            for (int j=0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 60));
                int row = i, col = j;
                buttons[i][j].addActionListener(e -> makeMove(row, col));
                gamePanel.add(buttons[i][j]);
                board[i][j] = ' ';
            }
        }

        statusLabel = new JLabel("Current Player : " + currentPlayer);
        add(gamePanel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);
    }

    private void makeMove(int row, int col) {
        if (board[row][col] == ' ') {
            board[row][col] = currentPlayer;
            buttons[row][col].setText(String.valueOf(currentPlayer));
            if (checkWin(currentPlayer)) {
                JOptionPane.showMessageDialog(this, "Player " + currentPlayer + " wins!", getTitle(), 1);
                System.out.println("Player " + currentPlayer + " wins!");
                resetGame();
            } else if (isBoardFull()) {
                JOptionPane.showMessageDialog(this, "It's a draw!", getTitle(), 1);
                System.out.println("It's a draw!");
                resetGame();
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                statusLabel.setText("Current Player : " + currentPlayer);
            }
        }
    }

    private boolean checkWin (char player) {
        for (int i=0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player)    return true;
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player)    return true;
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player)    return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player)    return true;
        return false;
    }

    private boolean isBoardFull() {
        for (int i=0; i < 3; i++) {
            for (int j=0; j<3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    private void resetGame() {
        for (int i=0; i < 3; i++) {
            for (int j=0; j<3; j++) {
                board[i][j] = ' ';
                buttons[i][j].setText("");
            }
        }
        currentPlayer = 'X';
        statusLabel.setText("Current Player : " + currentPlayer);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TicTakToe().setVisible(true));
        System.out.println("TicTakToe game started");
    }
}
