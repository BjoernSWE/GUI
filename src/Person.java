import java.util.*;
import java.awt.*;

public class Person extends Figur {
    private final int mainBodyWidth = 10;
    private final int mainBodyHeight = 10;
    private final int legsWidth = 4;
    private final int legsHeight = 10;
    private final int headRadius = 6;
    private final int neckWidth = 4;
    private final int neckHeight = 4;
    private final int armsHeight = 8;
    private final int armsWidth = 3;
    Color farbe;

    public Person() {
        super();
    }

    public int getHeight() {
        return (legsHeight + mainBodyHeight + (int) (headRadius * 0.75) + neckHeight) * factor;
    }

    public int getWidth() {
        return (armsWidth * 2 + mainBodyWidth) * factor;
    }

    @Override
    public void paintOnGraphics(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Random rand = new Random();

        Color color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
        g2.setColor(color);

        double factor = this.factor;

        int x = offsetLeft;
        int offsetTop = maxHeightPanel - this.getHeight();

        int headW = (int) (headRadius * factor);
        int headH = (int) (headRadius * factor);
        g2.fillOval((x + getWidth() / 2) - headW / 2, offsetTop + 10, headW, headH);
        offsetTop += headH;

        int neckW = (int) (neckWidth * factor);
        int neckH = (int) (neckHeight * factor);
        g2.fillRect((x + getWidth() / 2) - neckW / 2, offsetTop, neckW, neckH);
        offsetTop += neckH;

        int armW = (int) (armsWidth * factor);
        int armH = (int) (armsHeight * factor);
        g2.fillRect(x, offsetTop, armW, armH);
        g2.fillRect(x + getWidth() - armW, offsetTop, armW, armH);

        int bodyW = (int) (mainBodyWidth * factor);
        int bodyH = (int) (mainBodyHeight * factor);
        g2.fillRect((x + getWidth() / 2) - bodyW / 2, offsetTop, bodyW, bodyH);
        offsetTop += bodyH;

        int legW = (int) (legsWidth * factor);
        int legH = (int) (legsHeight * factor);
        g2.fillRect((x + getWidth() / 2) - bodyW / 2, offsetTop, legW, legH);
        g2.fillRect((x + getWidth() / 2) + bodyW / 2 - legW, offsetTop, legW, legH);
    }
}