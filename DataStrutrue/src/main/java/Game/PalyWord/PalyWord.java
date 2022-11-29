package Game.PalyWord;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PalyWord  extends JFrame {
    private JPanel contentPane;

    public void launch(){
        contentPane = new JPanel();
        JButton jButton = new JButton();
        jButton.setSize(200,200);
        jButton.setContentAreaFilled(false);// 设置按钮透明
        jButton.setBorderPainted(false); // 边框线透明
        jButton.setMargin(new Insets(0, 0, 0, 0));// 按钮内容与边框距离
        jButton.setFocusPainted(false);
        ImageIcon btnImg = new ImageIcon("src/main/resources/play.png");
        Image startBtn = btnImg.getImage().getScaledInstance(jButton.getWidth(),jButton.getHeight(),btnImg.getImage().SCALE_DEFAULT);
        btnImg = new ImageIcon(startBtn);
        jButton.setIcon(btnImg);
        contentPane.setOpaque(false);
        contentPane.add(jButton);
        setContentPane(contentPane);
        ImageIcon bg = new ImageIcon("src/main/resources/bg.jpg");
        JLabel label = new JLabel(bg);
        JFrame jFrame = new JFrame("打字游戏"){
            private static final long serialVersionUID = 1L;
            @Override
            public void paint(Graphics g) {
                g.drawImage(bg.getImage().getScaledInstance(label.getWidth(),label.getHeight(),Image.SCALE_DEFAULT),0,0,this.getWidth(),this.getHeight(),null);
            }
        };
        label.setSize(bg.getIconWidth(),bg.getIconHeight());
        this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
        this.getContentPane();
        // 窗口大小
        this.setSize(bg.getIconWidth(),bg.getIconHeight());
        // 设置窗口位置
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);


        jButton.addActionListener(new StartActionListener());
    }

    class StartActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            contentPane.setVisible(false);
            WorldPanel panel = new WorldPanel();
            contentPane.add(panel);
            Thread t = new Thread(panel);
            t.start();
        }
    }

    public static void main(String [] args){
        PalyWord palyWord = new PalyWord();
        palyWord.launch();
    }
}
