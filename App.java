import java.awt.Color;

public class App {
    
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Circulo miCirculo = new Circulo (45);
        Circulo otroCirculo = new Circulo (98);

        System.out.println(miCirculo.getRadio());
        System.out.println(otroCirculo.getRadio());
        
        miCirculo.setRadio(60);
        miCirculo.setX(250);
        miCirculo.setY(250);
        System.out.println(miCirculo.getRadio());

        // Codificar acciones parecidas para la 
        // clase Rectangulo
        // Rectangulo ...


        Canvas miVentana = new Canvas("Hola Ventana", 500, 500);
        miVentana.setVisible(true);

        miVentana.setColorDeLapiz(Color.BLUE);

        miVentana.rellenarCirculo(miCirculo.getX(), miCirculo.getY(), miCirculo.getDiametro());

        miVentana.setColorDeLapiz(Color.GREEN);

        miVentana.rellenarCirculo(otroCirculo.getX(), otroCirculo.getY(), otroCirculo.getDiametro());

        // Dibujar un rectangulo de color ROJO (RED)
        // rellenarRectangulo(int xPos, int yPos, int ancho, int alto)

        miVentana.espera(30000);
        miVentana.borrarCirculo(miCirculo.getX(), miCirculo.getY(), miCirculo.getDiametro());
        // miCirculo.setX(250);
        miCirculo.setY(150);
        miVentana.setColorDeLapiz(Color.BLUE);
        miVentana.rellenarCirculo(miCirculo.getX(), miCirculo.getY(), miCirculo.getDiametro());

    }
}
