package car_racing_game;

import java.applet.Applet;
import java.awt.*;

public class CarRacingGame extends Applet {

    @Override
    public void start() {

        setSize(800,600);
        setBackground(Color.green);
    }

    @Override
    public void paint(Graphics g) {

        g.setColor(Color.black);
        g.fillRect(200,0,400,600);
        g.setColor(Color.white);
        g.fillRect(380,40,40,150);
        g.fillRect(380,230,40,150);
        g.fillRect(380,420,40,150);
    }
}
