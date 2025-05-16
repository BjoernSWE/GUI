import java.awt.Graphics;

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
        return (mainBodyWidth * 2 + (int) (headRadius * 0.75)) * factor;
    }

    @Override
    public void paintOnGraphics(Graphics g) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'paintOnGraphics'");
    }
}