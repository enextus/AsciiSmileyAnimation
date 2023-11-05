package org.mycompany;

import javax.swing.*;
import java.awt.*;

public class AsciiSmileyAnimation extends JPanel {

    private static final int DIAMETER = 700; // Увеличенный размер
    private static final Font FONT = new Font("Monospaced", Font.BOLD, 24); // Увеличенный размер шрифта
    private String smileyOpen = """
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
    private String smileyClosed = """
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
    private boolean isEyeOpen = true;

    public AsciiSmileyAnimation() {
        setPreferredSize(new Dimension(DIAMETER, DIAMETER));
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

    private void drawAsciiSmiley(Graphics g, String smiley) {
        g.setFont(FONT);
        FontMetrics fm = g.getFontMetrics();
        int x = (getWidth() - fm.stringWidth(smiley.split("\n")[0])) / 2; // Предполагается, что все строки одинаковой длины
        int y = (getHeight() - fm.getHeight() * smiley.split("\n").length) / 2 + fm.getAscent();

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
