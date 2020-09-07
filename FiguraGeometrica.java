import java.awt.Color;

public class FiguraGeometrica {
    private Color color ;
    private int x;
    private int y;
    private int despX;
    private int despY;
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Actualizar posicion del objeto
     */
    public void actualizarPosicion () {
        setX( getX() + getDespX() );
        setY( getY() + getDespY() );
    }

    public int getDespX() {
        return despX;
    }

    public void setDespX(int despX) {
        this.despX = despX;
    }

    public int getDespY() {
        return despY;
    }

    public void setDespY(int despY) {
        this.despY = despY;
    }

}
