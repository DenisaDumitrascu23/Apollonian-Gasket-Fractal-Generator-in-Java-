import javax.swing.*;
import java.awt.*;

public class ApollonianGasket extends JPanel {

    static int level =10 ; // cate operatii de recuren

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(1));

        int width = getWidth();
        int height = getHeight();

        // cercul principal
        double R = Math.min(width, height) / 3.0;
        double cx = width / 2.0;
        double cy = height / 2.0;

        drawApollonian(g2, cx, cy, R, level);
    }

    private void drawApollonian(Graphics2D g, double cx, double cy, double R, int lvl) {
        if (lvl == 0 || R < 2) return;

        // cercul curent
        g.drawOval((int)(cx - R), (int)(cy - R), (int)(2*R), (int)(2*R));

        // raza cercurilor mai mici
        double r = R / 2.0;

        // distanta dintre cercurile mari si cele mici
        double h = R - r;

        // desenarea celor 3 cercuri mai mici in unul mare si centrarea lor
        drawApollonian(g, cx, cy - h, r, lvl - 1); // sus
        drawApollonian(g, cx - h * Math.sqrt(3)/2, cy + h/2, r, lvl - 1); // jos stanga
        drawApollonian(g, cx + h * Math.sqrt(3)/2, cy + h/2, r, lvl - 1); // jos dreapta
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Apollonian Gasket");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
        frame.add(new ApollonianGasket());
        frame.setVisible(true);
    }
}
