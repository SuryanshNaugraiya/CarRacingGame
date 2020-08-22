package car_racing_game;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class CarRacingGame extends Applet implements Runnable , KeyListener {

    int white_strip0_y=-150;
    int white_strip1_y=40;
    int white_strip2_y=230;
    int white_strip3_y=420;

    Thread t;

    Image img_mycar;
    Image img_carobs;

    int mycar_x = 350;
    int obscar_x =400;
    int obscar_y = -100;

    Random rand;
    int low = 195;
    int high = 515;

    @Override
    public void start() {

        setSize(800,600);
        t = new Thread(this);
        t.start();
        //img_mycar = getImage(getDocumentBase() , "mycar.jpg");
        //img_carobs = getImage(getDocumentBase() , "obstaclecar.jpg");
        setBackground(Color.green);
        img_mycar = createImage(90,90);
        setBackground(Color.red);
        img_carobs = createImage(90,90);
        setBackground(Color.orange);
        addKeyListener(this);
        rand = new Random();
    }

    @Override
    public void run() {

        while (true){

            try {

                Thread.sleep(30);

                white_strip0_y = white_strip0_y + 5;
                white_strip1_y = white_strip1_y + 5;
                white_strip2_y = white_strip2_y + 5;
                white_strip3_y = white_strip3_y + 5;

                //System.out.println(white_strip3_y);

                if(white_strip0_y == 630){
                    white_strip0_y = -150;
                }
                if(white_strip1_y == 630){
                    white_strip1_y = -150;
                }
                if(white_strip2_y == 630){
                    white_strip2_y = -150;
                }
                if(white_strip3_y == 630){
                    white_strip3_y = -150;
                }
                if(obscar_y == 625){
                    obscar_x = rand.nextInt(high-low) + low;
                    obscar_y = -95;
                }
                obscar_y = obscar_y + 5;
                //------------------------------collision code starts-----------------
                if(obscar_y >= 421){
                    if(obscar_x + 90 >= mycar_x){
                        int diff = obscar_x+90 - mycar_x;
                        if(diff <= 90){
                            t.stop();
                        }
                    }
                    if(obscar_x <= mycar_x + 90){
                        int diff = mycar_x+90 - obscar_x;
                        if(diff <= 90){
                            t.stop();
                        }
                    }

                }
                //------------------------------collision code ends-------------------
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

        g.drawImage(img_mycar,mycar_x,508,this);
        g.drawImage(img_carobs,obscar_x,obscar_y,this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if(mycar_x <= 505){
                mycar_x = mycar_x + 5;
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if(mycar_x >= 205){
                mycar_x = mycar_x - 5;
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
