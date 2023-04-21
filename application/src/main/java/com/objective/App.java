package com.objective;

import javax.swing.*;
import java.awt.*;

public class App extends JFrame {

    private Context context;

    public App() {
        super("Jogo Gourmet");
        this.initContext();
    }

    private void initContext() {
        this.context = new Context();

        setSize(250, 120);
        setLayout(new BorderLayout());

        add(this.createPanel(), BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setVisible(true);
    }

    private JPanel createPanel() {
        JPanel panel = new JPanel();
        add(this.createLabel(), BorderLayout.CENTER);

        panel.add(this.createButton());
        return panel;
    }

    private JLabel createLabel() {
        JLabel label = new JLabel("Pense em um prato que gosta");
        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
    }

    private JButton createButton() {
        JButton button = new JButton("OK");
        button.addActionListener(e -> this.context.init());
        return button;
    }
}