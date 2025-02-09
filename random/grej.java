package random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

class LitetSpel {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Litet Spel");
        JButton button = new JButton("Klicka");
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        frame.setLayout(new BorderLayout());
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        button.setPreferredSize(new Dimension(350, 50)); 
        button.setBackground(Color.PINK);
        button.setForeground(Color.WHITE); 
        buttonPanel.add(button);
        
        frame.add(buttonPanel, BorderLayout.SOUTH);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(400, 350));
        
        ImageIcon firstImageIcon = new ImageIcon(LitetSpel.class.getResource("/cat.png"));
        Image firstImage = firstImageIcon.getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH);
        ImageIcon scaledFirstImageIcon = new ImageIcon(firstImage);
        JLabel firstImageLabel = new JLabel(scaledFirstImageIcon);
        firstImageLabel.setBounds(0, 0, 400, 300);
        layeredPane.add(firstImageLabel, JLayeredPane.DEFAULT_LAYER);
        
        ImageIcon secondImageIcon = new ImageIcon(LitetSpel.class.getResource("/happycat.png"));
        Image secondImage = secondImageIcon.getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH);
        ImageIcon scaledSecondImageIcon = new ImageIcon(secondImage);
        JLabel secondImageLabel = new JLabel(scaledSecondImageIcon);
        secondImageLabel.setBounds(0, 0, 400, 300);
        secondImageLabel.setVisible(false);
        layeredPane.add(secondImageLabel, JLayeredPane.PALETTE_LAYER);
        
        frame.add(layeredPane, BorderLayout.CENTER);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstImageLabel.setVisible(false);
                secondImageLabel.setVisible(true);
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        secondImageLabel.setVisible(false);
                        firstImageLabel.setVisible(true);
                    }
                }, 200);
            }
        });

        frame.setVisible(true);
    }
}