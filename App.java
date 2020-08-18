import java.awt.Color;

public class App {
    
    public static void main(String[] args) throws Exception {
        Circulo circulo1 = new Circulo (100);
        Circulo circulo2 = new Circulo (300);
        Circulo circulo3 = new Circulo (600);
        // Codificar acciones parecidas para la 
        // clase Rectangulo
        // Rectangulo ...

        circulo1.setX(250);
        circulo1.setY(250);

        circulo2.setX(150);
        circulo2.setY(150);

        Canvas miVentana = new Canvas("Hola Ventana", 800, 600);
        miVentana.setVisible(true);

        // Dibujamos el primer Circulo
        // miVentana.setColorDeLapiz(Color.GREEN);
        miVentana.setColorDeLapiz(circulo3.getColor());
        miVentana.rellenarCirculo(circulo3.getX(), circulo3.getY(), circulo3.getDiametro());

        miVentana.setColorDeLapiz(circulo2.getColor());
        miVentana.rellenarCirculo(circulo2.getX(), circulo2.getY(), circulo2.getDiametro());

        miVentana.setColorDeLapiz(circulo1.getColor());
        miVentana.rellenarCirculo(circulo1.getX(), circulo1.getY(), circulo1.getDiametro());

        // Dibujar un rectangulo de color ROJO (RED)
        // rellenarRectangulo(int xPos, int yPos, int ancho, int alto)

        // miVentana.espera(30000);
        // miVentana.borrarCirculo(circulo1.getX(), circulo1.getY(), circulo1.getDiametro());
        // // circulo1.setX(250);
        // circulo1.setY(150);
        // miVentana.setColorDeLapiz(Color.BLUE);
        // miVentana.rellenarCirculo(circulo1.getX(), circulo1.getY(), circulo1.getDiametro());

    }
}
