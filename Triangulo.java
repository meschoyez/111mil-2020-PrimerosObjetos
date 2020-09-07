import java.awt.Color;

public class Triangulo extends FiguraGeometrica {
    private int base;
    private int altura;
    

    public Triangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }

    public Triangulo() {
    }

    public Triangulo(int base, int altura, Color color) {
        this.base = base;
        this.altura = altura;
        setColor(color);
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    

}