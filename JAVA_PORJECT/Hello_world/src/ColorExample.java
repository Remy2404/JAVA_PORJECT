import javax.swing.*;
import java.awt.*;

public class ColorExample extends JFrame {

    public ColorExample() {
        // Create a custom JPanel
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Set the color to red
                g.setColor(Color.RED);

                // Draw a filled rectangle
                g.fillRect(50, 50, 100, 50);
            }
        };

        // Add the panel to the frame
        add(panel);

        // Set frame properties
        setTitle("Drawing Example");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ColorExample());
    }
}
