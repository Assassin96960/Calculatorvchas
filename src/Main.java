import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public Main() {

    }

    static JPanel panel = new JPanel();
    static JLabel label = new JLabel("Enter something:");
    static JTextField textField = new JTextField(40);
    static JFrame frame = new JFrame("Calculator");

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });

    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Калкулатор");

        panel = new JPanel();
        label = new JLabel("Enter something:");
        textField = new JTextField(40);
        panel.add(label);
        panel.add(textField);
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JButton clearButton = Buttons.createStyledButton("Clear Text");
        JButton readyButton = Buttons.createStyledButton("Ready");
        JButton closeButton = Buttons.createStyledButton("Close Program");


        // Add ActionListener to clear the text field
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Container contentPane = frame.getContentPane();
                if (contentPane.getComponentCount() > 0) {
                    Component component = contentPane.getComponent(0);
                    if (component instanceof JPanel) {
                        JPanel panel = (JPanel) component;
                        Component[] components = panel.getComponents();
                        for (Component comp : components) {
                            if (comp instanceof JTextField) {
                                ((JTextField) comp).setText("");
                            }
                        }
                    }
                }
            }
        });

        // Add ActionListener to close the program
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        readyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String expression = textField.getText();
                System.out.println(expression);
                textField.setText(Evaluate.eval(expression));
            }
        });
        buttonPanel.add(clearButton);
        buttonPanel.add(readyButton);
        buttonPanel.add(closeButton);
        frame.add(buttonPanel);


        JFrame frame2 = new JFrame("Графика");
        JFrame frame3 = new JFrame("Генериране");


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(960, 540);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(960, 540);
        JMenuBar menuBar = new JMenuBar();
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setSize(960, 540);

        // Create three menus
        JMenu menu1 = new JMenu("Пресмятане");
        JMenu menu2 = new JMenu("Графика на функция");
        JMenu menu3 = new JMenu("Генериране на полиноми");

        // Add menus to the menu bar
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);

        // Arrange menus equally
        menuBar.setLayout(new GridLayout(1, 3));

        // Create menu items with actions
        JMenuItem menuItem1 = new JMenuItem("Пресмятане");
        menu1.add(menuItem1);

        JMenuItem menuItem2 = new JMenuItem("Графика на функция");
        menu2.add(menuItem2);

        JMenuItem menuItem3 = new JMenuItem("Генериране на полином");
        menu3.add(menuItem3);

        // Add ActionListener to handle menu item clicks
        ActionListener menuActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JMenuItem source = (JMenuItem) e.getSource();
                frame.setVisible(false);
                frame3.setVisible(false);
                frame2.setVisible(false);
                if (e.getSource() == menuItem1) {
                    frame.setVisible(true);
                    frame.setJMenuBar(menuBar);
                } else if (e.getSource() == menuItem2) {
                    frame2.setVisible(true);
                    frame2.setJMenuBar(menuBar);

                } else {
                    frame3.setVisible(true);
                    frame3.setJMenuBar(menuBar);

                }

            }
        };

        // Attach the ActionListener to each menu item
        menuItem1.addActionListener(menuActionListener);
        menuItem2.addActionListener(menuActionListener);
        menuItem3.addActionListener(menuActionListener);

        // Set the menu bar for the frames
        frame.setJMenuBar(menuBar);

        // Add components and buttons to the frames

        addComponentsToFrame(frame2);
        addButtonsToFrame(frame2);
        addComponentsToFrame(frame3);
        addButtonsToFrame(frame3);
        frame.setVisible(true);
        frame.add(panel);

    }

    private static JFrame createNewFrame(String title) {
        JFrame newFrame = new JFrame(title);
        newFrame.setSize(960, 540);
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return newFrame;
    }

    private static void addComponentsToFrame(JFrame frame) {
    }

    private static void addButtonsToFrame(JFrame frame) {

    }
}
