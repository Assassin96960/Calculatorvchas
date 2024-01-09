import javax.swing.*;
import java.awt.*;

public class Buttons {

    public static JButton createStyledButton(String text) {
        JButton button = new JButton(text);

        // Customize button appearance
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(true);
        button.setBackground(new Color(65, 131, 215)); // Custom background color
        button.setForeground(Color.RED); // Custom text color
        button.setFont(new Font("Arial", Font.PLAIN, 14)); // Custom font

        return button;
    }
}
