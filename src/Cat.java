import java.util.*;
import java.awt.*;

public class Cat extends Figur {
    private final int mainBodyWidth = 10;
    private final int mainBodyHeight = 4;
    private final int legsWidth = 2;
    private final int legsHeight = 4;
    private final int headRadius = 4;
    private final int earsHeight = 2;
    private final int earsWidth = 2;
    private final int tailWidth = 1;
    private final int tailHeight = 4;

    public Cat() {
        super();
    }

    public int getHeight() {
        return (legsHeight + mainBodyHeight + (int) (headRadius * 0.75)) * factor;
    }

    public int getWidth() {
        return (mainBodyWidth + (int) (headRadius * 0.75)) * factor;
    }

    @Override
    public void paintOnGraphics(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Random rand = new Random();
        Color farbe = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
        g2.setColor(farbe);

        double factor = this.factor;
        int legW = (int) (legsWidth * factor);
        int legH = (int) (legsHeight * factor);

        int offsetTop = maxHeightPanel - legH;
        int x = offsetLeft;

        g2.fillRect(x + (int) (tailWidth * factor), offsetTop, legW, legH);
        g2.fillRect(x + (int) (mainBodyWidth * factor) - legW, offsetTop, legW, legH);

        offsetTop -= (int) (mainBodyHeight * factor);

        int bodyW = (int) (mainBodyWidth * factor);
        int bodyH = (int) (mainBodyHeight * factor);
        g2.fillRect(x, offsetTop, bodyW, bodyH);

        offsetTop -= (int) (headRadius * factor * 0.75);

        int headR = (int) (headRadius * factor);
        int headH = (int) (headRadius * factor);
        g2.fillOval(x + bodyW - (headR / 2) + 10, offsetTop, headR, headH);

        int tailW = (int) (tailWidth * factor);
        int tailH = (int) (tailHeight * factor);
        g2.fillRect(x, offsetTop + headH + bodyH - (tailH * 2), tailW, tailH);

        int earW = (int) (earsWidth * factor);
        int earH = (int) (earsHeight * factor);
        g2.fillRect(x + bodyW - earW + 10, offsetTop, earW, earH);
    }
}