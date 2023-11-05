package org.mycompany;

import javax.swing.*;
import java.awt.*;

public class AsciiSmileyAnimation extends JPanel {
    private Rectangle leftEye;
    private Rectangle rightEye;
    private static final int DIAMETER = 700; // Увеличенный размер
    private static final Font FONT = new Font("Monospaced", Font.BOLD, 24); // Увеличенный размер шрифта
    String smileyOpen = """
        +------------+
        |            |
        |  O     O  |
        |            |
        |            |
        |     __     |
        |            |
        |            |
        +------------+
        """;
    String smileyClosed = """
        +------------+
        |            |
        |  -     -  |
        |            |
        |            |
        |     __     |
        |            |
        |            |
        +------------+
        """;
    boolean isEyeOpen = true;

    public AsciiSmileyAnimation() {
        setPreferredSize(new Dimension(DIAMETER, DIAMETER));
        // Initialize the eye rectangles (You'll need to adjust the size and position accordingly)
        leftEye = new Rectangle(290, 270, 30, 30);
        rightEye = new Rectangle(370, 270, 30, 30);

        new Timer(500, e -> {
            isEyeOpen = !isEyeOpen;
            repaint();
        }).start();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawAsciiSmiley(g, isEyeOpen ? smileyOpen : smileyClosed);
    }

/*    private void drawAsciiSmiley(Graphics g, String smiley) {
        g.setFont(FONT);
        FontMetrics fm = g.getFontMetrics();
        int x = (getWidth() - fm.stringWidth(smiley.split("\n")[0])) / 2; // Предполагается, что все строки одинаковой длины
        int y = (getHeight() - fm.getHeight() * smiley.split("\n").length) / 2 + fm.getAscent();

        for (String line : smiley.split("\n")) {
            g.drawString(line, x, y);
            y += fm.getHeight();
        }
    }*/

    private void drawAsciiSmiley(Graphics g, String smiley) {
        g.setFont(FONT);
        FontMetrics fm = g.getFontMetrics();
        int x = (getWidth() - fm.stringWidth(smiley.split("\n")[0])) / 2; // Предполагается, что все строки одинаковой длины
        int y = (getHeight() - fm.getHeight() * smiley.split("\n").length) / 2 + fm.getAscent();

        // Draw white rectangles where the eyes are
        g.setColor(Color.WHITE);
        g.fillRect(leftEye.x, leftEye.y, leftEye.width, leftEye.height);
        g.fillRect(rightEye.x, rightEye.y, rightEye.width, rightEye.height);

        // Reset color to default (black) for drawing the text
        g.setColor(Color.BLACK);

        for (String line : smiley.split("\n")) {
            g.drawString(line, x, y);
            y += fm.getHeight();
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("ASCII Smiley Animation");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new AsciiSmileyAnimation());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

}
