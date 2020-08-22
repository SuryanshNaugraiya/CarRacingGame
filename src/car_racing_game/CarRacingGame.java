package car_racing_game;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CarRacingGame extends Applet implements Runnable , KeyListener {

    int white_strip0_y=-150;
    int white_strip1_y=40;
    int white_strip2_y=230;
    int white_strip3_y=420;

    Thread t;
    Image img;
    int mycar_x = 380;

    @Override
    public void start() {

        setSize(800,600);
        setBackground(Color.green);
        t = new Thread(this);
        t.start();
        img=getImage(getDocumentBase() , "mycar.jpg");
        addKeyListener(this);
    }

    @Override
    public void run() {

        while (true){

            try {

                Thread.sleep(50);

                white_strip0_y = white_strip0_y + 5;
                white_strip1_y = white_strip1_y + 5;
                white_strip2_y = white_strip2_y + 5;
                white_strip3_y = white_strip3_y + 5;

                //System.out.println(white_strip3_y);

                if(white_strip0_y == 600){
                    white_strip0_y = -150;
                }
                if(white_strip1_y == 600){
                    white_strip1_y = -150;
                }
                if(white_strip2_y == 600){
                    white_strip2_y = -150;
                }
                if(white_strip3_y == 600){
                    white_strip3_y = -150;
                }

                repaint();
            }

            catch (InterruptedException e) {

                e.printStackTrace();
            }

        }
    }

    @Override
    public void paint(Graphics g) {

        g.setColor(Color.black);
        g.fillRect(200,0,400,600);

        g.setColor(Color.white);
        g.fillRect(380,white_strip0_y,40,150);
        g.fillRect(380,white_strip1_y,40,150);
        g.fillRect(380,white_strip2_y,40,150);
        g.fillRect(380,white_strip3_y,40,150);

        g.drawImage(img,mycar_x,100,this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            mycar_x = mycar_x + 5;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            mycar_x = mycar_x - 5;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
