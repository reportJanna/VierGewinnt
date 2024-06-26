package gui.frames;

import api.BoardInterface;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndFrame extends JFrame {
    private JButton closeButton;
    private JButton againPlayButton;
    private JButton settingButton;
    private JLabel messageLabel;
    private MainPanel mainPanelGame;
    private BoardInterface boardInterfaceGame;
    private JFrame parentFrameGame;

    public EndFrame(String playerName, MainPanel mainPanelGame, BoardInterface boardInterfaceGame, JFrame parentFrameGame) {
        this.parentFrameGame = parentFrameGame;
        this.boardInterfaceGame = boardInterfaceGame;
        this.mainPanelGame = mainPanelGame;
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(new GridBagLayout());


        // Components setting
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;

        // Label
        messageLabel = new RoundedLabel(playerName, SwingConstants.CENTER);
        Dimension labelSize = new Dimension(450, 110);
        messageLabel.setPreferredSize(labelSize);
        messageLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(),
                new EmptyBorder(15, 10, 18, 10)
        ));
        Font newFont = new Font("American Typewriter", Font.ITALIC, 24);
        messageLabel.setFont(newFont);
        messageLabel.setOpaque(false);


        mainPanel.add(messageLabel, gbc);


        // Buttons
        Dimension btnSize = new Dimension(120, 35);
        Border grayBorder = new LineBorder(Color.GRAY, 1, true);
        Font btnFont = new Font("Tahoma", Font.PLAIN, 14);

        closeButton = new JButton("Verlassen");
        closeButton.addActionListener(new CloseButtonListener());
        closeButton.setPreferredSize(btnSize);
        closeButton.setBorder(grayBorder);
        closeButton.setFont(btnFont);

        againPlayButton = new JButton("Neustarten");
        againPlayButton.addActionListener(e -> {
            this.dispose();
            restartApplication();
        });
        againPlayButton.setPreferredSize(btnSize);
        againPlayButton.setBorder(grayBorder);
        againPlayButton.setFont(btnFont);

        settingButton = new JButton("Einstellungen");
        settingButton.addActionListener(new SettingButtonListener());
        settingButton.setPreferredSize(btnSize);
        settingButton.setBorder(grayBorder);
        settingButton.setFont(btnFont);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 30));
        buttonPanel.add(closeButton);
        buttonPanel.add(againPlayButton);
        buttonPanel.add(settingButton);


        gbc.gridy = 1;
        gbc.gridwidth = 1;
        mainPanel.add(buttonPanel, gbc);

        add(mainPanel);

        this.setResizable(false);
        this.setSize(1000, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    // Listeners
    private class CloseButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            System.exit(0);
        }
    }
    private class SettingButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event){
            openOptionsFrame();
        }
    }

    // methodies for listeners
    private void openOptionsFrame() {
        new OptionsFrame(mainPanelGame, boardInterfaceGame, parentFrameGame);
    }

    private void restartApplication() {
        JFrame auswahlfenster = StartFrame.getAuswahlfenster();
        auswahlfenster.setVisible(true);
    }


    // Rounded borders class
    public class RoundedLabel extends JLabel {
        public RoundedLabel(String text, int horizontalAlignment) {
            super(text, horizontalAlignment);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            int arcSize = (getHeight() - 5) / 2;
            g2.fillRoundRect(0, 0, getWidth() - 5, getHeight() - 5, arcSize, arcSize);
            g2.setColor(getForeground());
            super.paintComponent(g2);
            g2.dispose();
        }

        @Override
        public void setBorder(Border border) {
            super.setBorder(new EmptyBorder(15, 10, 18, 10));
        }

        @Override
        public boolean isOpaque() {
            return false;
        }
    }
}