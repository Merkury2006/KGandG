import java.awt.*;

public class Lamppost {
    private int x, y, size;
    private Color colorPost, colorLamp;


    public Lamppost(int x, int y, int size, Color colorPost, Color colorLamp) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.colorPost = colorPost;
        this.colorLamp = colorLamp;
    }

    public void draw(Graphics2D g) {
        g.setColor(colorPost);
        g.fillRect(x - size / 4, y, size / 4, size / 32);
        g.fillRect(x, y, size / 16, size);
        g.setColor(colorLamp);
        g.fillOval((int) (x - size / 3.5), y, size / 6, size / 16);
    }
}
