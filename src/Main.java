import java.util.Random;
import javax.swing.*;
import java.awt.*;

public class Main {
    protected static int spaceBetweenFigures;

    public static void main(String[] args) throws Exception {
        Random rand = new Random();
        spaceBetweenFigures = rand.nextInt(10) + 5;

        Figur[] figuren = new Figur[10];
        for (int i = 0; i < 5; i++) {
            figuren[i] = new Person();
        }

        for (int i = 5; i < 10; i++) {
            figuren[i] = new Cat();
        }

        for (int i = 1; i < figuren.length; i++) {
            Figur aktuellesElement = figuren[i];
            int j = i - 1;

            while (j >= 0 && figuren[j].getHeight() > aktuellesElement.getHeight()) {
                figuren[j + 1] = figuren[j];
                j--;
            }
            figuren[j + 1] = aktuellesElement;
        }

        int BreiteFig = 0;
        for (int i = 0; i < figuren.length; i++) {
            BreiteFig = BreiteFig + figuren[i].getWidth();
        }
        int totalWidthPanel = (11 * spaceBetweenFigures) + BreiteFig;

        int maxHeightPanel = figuren[figuren.length - 1].getHeight();

        JFrame fenster = new JFrame("Fenster mit Figuren");
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int contentWidth = totalWidthPanel;
        int contentHeight = maxHeightPanel;

        fenster.setSize(contentWidth, contentHeight);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                setBackground(Color.BLACK);

                int offsetLeft = spaceBetweenFigures;
                for (int i = 0; i < figuren.length; i++) {
                    figuren[i].paintOnGraphics(g, offsetLeft, maxHeightPanel);
                    offsetLeft += figuren[i].getWidth() + spaceBetweenFigures;
                }
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(totalWidthPanel, maxHeightPanel);
            }
        };
        fenster.add(panel);

        fenster.pack();
        fenster.setVisible(true);
    }
}
