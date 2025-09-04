import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
import java.util.Random;

public class TiTacToe {
    private static boolean gameOver = false; // To stop moves after win

    public static void main(String[] args) {
        // Create the main window
        JFrame frame = new JFrame("Tic Tac Toe");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a 3x3 grid layout for the board
        JPanel panel = new JPanel(new GridLayout(3, 3));
        JButton[][] buttons = new JButton[3][3]; // 9 buttons
        Random rand = new Random();

        // Initialize buttons
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.BOLD, 60));

                // Add action listener for each button
                buttons[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (gameOver) return; // Stop moves if game over

                        JButton clicked = (JButton) e.getSource();

                        // Player's move
                        if (clicked.getText().equals("")) {
                            clicked.setText("X");

                            // Check if player wins
                            if (checkWin(buttons, "X")) {
                                showResult(frame, "You Wins!", buttons);
                                return;
                            }

                            // Computer's move (random)
                            if (!isBoardFull(buttons)) {
                                int row, col;
                                do {
                                    row = rand.nextInt(3);
                                    col = rand.nextInt(3);
                                } while (!buttons[row][col].getText().equals(""));

                                buttons[row][col].setText("O");

                                // Check if computer wins
                                if (checkWin(buttons, "O")) {
                                    showResult(frame, "Computer Wins!", buttons);
                                    return;
                                }
                            }
                        }

                        // Check for tie
                        if (isBoardFull(buttons) && !gameOver) {
                            showResult(frame, "It's a Tie!", buttons);
                        }
                    }
                });

                panel.add(buttons[i][j]);
            }
        }

        // Add panel to the frame
        frame.add(panel);
        frame.setVisible(true);
    }

    // Helper method to check if the board is full
    private static boolean isBoardFull(JButton[][] buttons) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    // Helper method to check if a player has won
    private static boolean checkWin(JButton[][] buttons, String player) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (buttons[i][0].getText().equals(player) &&
                buttons[i][1].getText().equals(player) &&
                buttons[i][2].getText().equals(player)) {
                return true; // Row win
            }
            if (buttons[0][i].getText().equals(player) &&
                buttons[1][i].getText().equals(player) &&
                buttons[2][i].getText().equals(player)) {
                return true; // Column win
            }
        }

        // Check diagonals
        if (buttons[0][0].getText().equals(player) &&
            buttons[1][1].getText().equals(player) &&
            buttons[2][2].getText().equals(player)) {
            return true;
        }
        if (buttons[0][2].getText().equals(player) &&
            buttons[1][1].getText().equals(player) &&
            buttons[2][0].getText().equals(player)) {
            return true;
        }

        return false;
    }

    // Show result and ask to play again
    private static void showResult(JFrame frame, String message, JButton[][] buttons) {
        gameOver = true;
        int choice = JOptionPane.showConfirmDialog(frame, message + " Play again?",
                                                   "Game Over", JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION) {
            resetBoard(buttons);
            gameOver = false;
        } else {
            System.exit(0);
        }
    }

    // Reset the board for a new game
    private static void resetBoard(JButton[][] buttons) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
    }
}
