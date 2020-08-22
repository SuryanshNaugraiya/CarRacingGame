package car_racing_game;

import java.applet.Applet;
import java.awt.*;

public class CarRacingGame extends Applet implements Runnable{

    int white_strip0_y=-150;
    int white_strip1_y=40;
    int white_strip2_y=230;
    int white_strip3_y=420;

    Thread t;

    @Override
    public void start() {

        setSize(800,600);
        setBackground(Color.green);
        t = new Thread(this);
        t.start();
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
    }

    @Override
    public void run() {

    }
}
