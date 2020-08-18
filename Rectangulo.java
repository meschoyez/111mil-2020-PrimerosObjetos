public class Rectangulo {
    private int lado1;
    private int lado2;
    private int x;
    private int y;


    /**
     * Este metodo establece el color del Rectangulo segun
     * la superficie configurada.
     * 
     * Si superficie <   500 -> tiene color azul
     * Si superficie <  1000 -> tiene color verde
     * Si superficie <  1500 -> tiene color amarillo
     * Si superficie <  2000 -> tiene color naranja
     * Si superficie <  2500 -> tiene color rojo
     * Si superficie >= 3000 -> tiene color magenta
     */
    private void determinarColor () {
        // TODO implementar
    }


    public int getLado1() {
        return lado1;
    }

    public void setLado1(int lado1) {
        this.lado1 = lado1;
    }

    public int getLado2() {
        return lado2;
    }

    public void setLado2(int lado2) {
        this.lado2 = lado2;
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

    // Click derecho sobre el codigo fuente
    // click en "Source action"
    // click en "Generate Getter and Setters"
}