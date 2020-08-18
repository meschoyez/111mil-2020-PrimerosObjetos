import java.awt.Color;

// Modificador visibilidad - palabra reservada - Nombre de la clase
// Identificadores son CamelCase
public class Circulo {
    // Caracteristicas - Comportamientos - Identidad

    // Caracteristicas (campos del objeto o de la clase)
    private static final int MAX_RADIO = 1000;
    // static -> campo de la clase
    // final -> hace que sea un valor constante (no modificable - inmutable)
    private Color color ;
    private int radio = 10; // Valor inicial por si me dan uno fuera de rango
    private int x;
    private int y;
    // Aclaracion -> Datos tipo objeto Integer, Double, Char, Boolean

    // Comportamientos (metodos)

    // Constructor -> crear objetos de la clase
    public Circulo (int radio) {
        setRadio(radio);
        determinarColor();
    }

    /**
     * Este metodo establece el color del circulo segun
     * el radio configurado.
     * 
     * Si radio < 100  -> tiene color azul (Color.BLUE)
     * Si radio < 200  -> tiene color verde (Color.GREEN)
     * Si radio < 300  -> tiene color amarillo (Color.YELLOW)
     * Si radio < 400  -> tiene color naranja (Color.ORANGE)
     * Si radio < 500  -> tiene color rojo (Color.RED)
     * Si radio >= 600 -> tiene color magenta (Color.MAGENTA)
     */
    private void determinarColor () {
        if (radio < 200) {
            setColor(Color.GREEN);
        }
        else if (radio < 500) {
            setColor(Color.YELLOW);
        }
        else {
            setColor(Color.RED);
        }
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
        if ((0 < radio) && (radio < MAX_RADIO)) {
            this.radio = radio;
            determinarColor();
        }
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }


}