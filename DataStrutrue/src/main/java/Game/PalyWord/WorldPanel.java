package Game.PalyWord;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class WorldPanel extends JPanel implements  Runnable, KeyListener {
    int [] x = new int[10];
    int [] y = new int[10];
    char [] words = new char[10];
    Color[] colors = new Color[10];

    int score = 0;
    int speed = 10;

    public WorldPanel(){
        for(int i = 0; i<10;++i){
            this.x[i] = (int)(Math.random()*800);
            this.y[i] = (int)(Math.random()*600);
            this.colors[i] = this.randomColor();
            this.words[i] = (char)((int)(Math.random()*26+65));
        }
    }

    public Color randomColor(){
        int R = (int)(Math.random()*255);
        int G = (int)(Math.random()*255);
        int B = (int)(Math.random()*255);
        Color color = new Color(R,G,B);
        return color;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Font ft = new Font("微软雅黑", 1, 28);
        g.setFont(ft);
        g.drawString("分数" + this.score, 50, 50);

        for(int i = 0; i < 10; ++i) {
            g.setColor(this.colors[i]);
//            g.drawImage('')
            g.drawString(String.valueOf(this.words[i]), this.x[i], this.y[i]);
        }

    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        for (int i = 0; i < 10; ++i) {
            if(e.getKeyCode() == this.words[i]){
                this.x[i] = (int)(Math.random()*800.0D);
                this.y[i] = 0;
                this.words[i] = (char)((int)(Math.random()*26+65));
                ++this.score;
                break;
            }
        }


        if(this.score > 5 && this.score < 10){
            this.speed =5;
        }else if(this.score > 10){
            this.speed = 1;
        }

        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }



    @Override
    public void run() {
        while(true){

            for(int i=0;i<10;++i){
                this.y[i]++;
                if(this.y[i]>600){
                    this.y[i] = 0;
                }
            }

            try{
                Thread.sleep((long)this.speed);
            }catch (InterruptedException var2){
                var2.printStackTrace();
            }

            this.repaint();
        }
    }
}
