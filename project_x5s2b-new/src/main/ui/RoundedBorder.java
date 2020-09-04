package ui;

//website from setting roundedBroder
import javax.swing.border.Border;
import java.awt.*;

public class RoundedBorder implements Border {
    private int radius;

    //MODIFIES: this
    //EFFECTS: set the radius to the "radius"
    public RoundedBorder(int radius) {
        this.radius = radius;
    }

    //MODIFIES: this
    //EFFECTS:return a new Insets
    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
    }

    //EFFECTS: return true if it is border opaque
    public boolean isBorderOpaque() {
        return true;
    }


    //MODIFIES: this
    //EFFECTS: create the border we created
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
    }
}
