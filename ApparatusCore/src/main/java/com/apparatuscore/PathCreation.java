import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

class PlotPanel extends JPanel {
    HermitePath preloadPath = new HermitePath()
        .addPose(84.0, 0.0, new Vector2D(0.0, 250.0))
        .addPose(84.0, 48.0, new Vector2D(0.0, 250.0))
        .addPose(96.0, 60.0, new Vector2D(250.0, 0.0))
        .addPose(144.0, 60.0, new Vector2D(250.0, 0.0))
        .construct();

    HermitePath scoringPath = new HermitePath()
        .addPose(144.0, 60.0, new Vector2D(250.0, 0.0))
        .addPose(120.0, 60.0, new Vector2D(250.0, 0.0))
        .addPose(100.0, 68.0, new Vector2D(400.0, 150.0))
        .construct();

    HermitePath parkingPath = new HermitePath()
        .addPose(100.0, 68.0, new Vector2D(0.0, 150.0))
        .addPose(108, 48, new Vector2D(0.0, 500.0))
        .addPose(96, 36, new Vector2D(250.0, 0.0))
        .construct();

    PlotPanel() {}

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        drawHermitePath(preloadPath, g2d, Color.RED);
        drawHermitePath(scoringPath, g2d, Color.BLUE);
        drawHermitePath(parkingPath, g2d, Color.BLACK);
    }

    public void drawHermitePath(HermitePath path, Graphics2D g2d, Color color) {
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(5));

        int numIntermediatePoints = (path.length() - 1) * 100;
        int nPoints = numIntermediatePoints + 1;

        int[] xPoints = new int[nPoints];
        int[] yPoints = new int[nPoints];

        for (int i = 0; i <= numIntermediatePoints; i++) {
            double t = ((double) i) / ((double) numIntermediatePoints / ((double) path.length() - 1));
            Pose pose = path.get(t);
            xPoints[i] = (int) (pose.x * 10);
            yPoints[i] = (int) -(pose.y * 10) + getHeight();
        }

        g2d.drawPolyline(xPoints, yPoints, nPoints);
    }
}

public class PathCreation {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Interactive Plot");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            frame.add(new PlotPanel());
            frame.setVisible(true);
        });
    }   
}