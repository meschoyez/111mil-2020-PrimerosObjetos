// Modificador visibilidad - palabra reservada - Nombre de la clase
// Identificadores son CamelCase
public class Circulo {
    // Caracteristicas - Comportamientos - Identidad

    // Caracteristicas (campos del objeto o de la clase)
    private static final int MAX_RADIO = 1000;
    // static -> campo de la clase
    // final -> hace que sea un valor constante (no modificable - inmutable)
    private int radio; // int char
    private int x;
    private int y;
    // Aclaracion -> Datos tipo objeto Integer, Double, Char, Boolean

    // Comportamientos (metodos)

    // Constructor -> crear objetos de la clase
    public Circulo (int r) {
        radio = r;
    }

    public double getPerimetro () {
        return 3.1416 * 2 * radio;
    }
    
    public double getSuperficie () {
        return 3.1416 * radio * radio;        
    }

    // setters y getters -> son metodos de acceso a los campos
    public int getRadio() {
        return radio;
    }

    public int getDiametro() {
        return radio * 2;
    }

    public void setRadio(int radio) {
        // this = este
        // asignar radio al campo radio de este objeto
        this.radio = radio;
    }

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


}