import java.awt.Color;

public class App {
    
    public static void main(String[] args) throws Exception {
        Circulo circulo1 = new Circulo (100);
        Circulo circulo2 = new Circulo (300);
        Circulo circulo3 = new Circulo (1600);
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
        // Rectangulo r = new Rectangulo();
        // rellenarRectangulo(int xPos, int yPos, int ancho, int alto)
        // miVentana.rellenarRectangulo(r.getX(), r.getY(), 400, 300);


        /**
         * Ciclos de repeticion -> permiten iterar
         * 
         * while -> (hacer mientras) -> repeticion indefinida
         * 
         * for -> (para) -> repeticion definida
         */
        miVentana.espera(10000);
        // int repeticiones = 0;
        // while (repeticiones < 5) {
        //     miVentana.borrarCirculo(circulo1.getX(), circulo1.getY(), circulo1.getDiametro());
        //     circulo1.setX( circulo1.getX() + 10 );
        //     miVentana.rellenarCirculo(circulo1.getX(), circulo1.getY(), circulo1.getDiametro());
        //     repeticiones = repeticiones + 1;
        //     miVentana.espera(500);
        // }
        for ( int repeticiones = 0 ; repeticiones < 100 ; repeticiones++ ) {
            miVentana.borrarCirculo(circulo1.getX(), circulo1.getY(), circulo1.getDiametro());
            circulo1.setX( circulo1.getX() + 10 );
            circulo1.setY( circulo1.getY() - 5 );
            miVentana.rellenarCirculo(circulo1.getX(), circulo1.getY(), circulo1.getDiametro());
            miVentana.espera(250);
        }
        
        // DESAFIO
        // Hacer que un circulo crezca de tamaño, por ej. comenzar con
        //  radio = 50 y que llegue a radio = 400

    }
}
