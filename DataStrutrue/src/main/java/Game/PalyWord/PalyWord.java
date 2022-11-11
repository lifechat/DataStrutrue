package Game.PalyWord;

import javax.swing.*;

public class PalyWord  extends JFrame {

    public void launch(){
        // 设置窗口可见
        this.setVisible(true);
        // 窗口大小
        this.setSize(800,800);
        // 设置窗口位置
        this.setLocationRelativeTo(null);
        // 设置标题
        this.setTitle("打字游戏");
    }


    public static void main(String [] args){
        PalyWord palyWord = new PalyWord();
    }
}
