public class Circulo {
    // Caracteristicas - Comportamientos - Identidad

    // Caracteristicas (campos del objeto)
    private double radio;
    private double x;
    private double y;

    // Comportamientos (metodos)
    public Circulo (double r) {
        radio = r;
    }
    
    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }


}