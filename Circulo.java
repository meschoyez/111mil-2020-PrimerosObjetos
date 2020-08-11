// Modificador visibilidad - palabra reservada - Nombre de la clase
// Identificadores son CamelCase
public class Circulo {
    // Caracteristicas - Comportamientos - Identidad

    // Caracteristicas (campos del objeto o de la clase)
    private static final double MAX_RADIO = 100.0;
    // static -> campo de la clase
    // final -> hace que sea un valor constante (no modificable - inmutable)
    private double radio; // int char
    private double x;
    private double y;
    // Aclaracion -> Datos tipo objeto Integer, Double, Char, Boolean

    // Comportamientos (metodos)

    // Constructor -> crear objetos de la clase
    public Circulo (double r) {
        radio = r;
    }

    public double getPerimetro () {
        return 3.1416 * 2 * radio;
    }
    
    public double getSuperficie () {
        return 3.1416 * radio * radio;        
    }

    // setters y getters -> son metodos de acceso a los campos
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