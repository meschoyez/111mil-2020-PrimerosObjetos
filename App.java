import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class App {
    // Campos para su funcionamiento
    // Canvas es la ventana para graficar
    private Canvas miVentana;
    private Random aleatorio;
    // Mas informacion sobre ArrayList en la API de Java
    // API - Application Programming Interface
    //       Interface para Programacion de Aplicaciones
    private ArrayList<Circulo> circulos;
    private ArrayList<Rectangulo> rectangulos;
    private int ancho = 800;
    private int alto = 600;

    /**
     * Constructor sin parametros
     */
    public App () {
        aleatorio = new Random();
        circulos = new ArrayList<>();
        rectangulos = new ArrayList<>();
        miVentana = new Canvas("Hola Ventana", ancho, alto);
        miVentana.setVisible(true);
    }

    /**
     * Solo lanza la aplicacion
     * @param args Los del Sistema Operativo
     * @throws Exception En caso de fallo
     */
    public static void main(String[] args) throws Exception {
        App miAplicacion = new App();
        // miAplicacion.ejecutar();
        miAplicacion.imagenes();
    }

    public void imagenes () {
        Dibujo dibujo = new Dibujo();
        miVentana.dibujarImagen(dibujo.getImagen(), dibujo.getAncho(), dibujo.getAlto());
    }

    /**
     * Metodo para ejecutar las diferentes actividades
     */
    public void ejecutar () {
        // PrimerosEjemplos();
        // Metodo para movimiento de circulo
        // PelotaRebotando();
        // CrearFigurasGeometricas();
        CrearFigurasAleatorias(30);
        // Variable local para un subconjunto de los circulos
        ArrayList<Circulo> enRango;
        // Selecciona los circulos que cumplen la condicion del radio
        enRango = CirculosConRadioEnRango(40, 70);
        // Establece el color de los circulos de la coleccion
        PintarCirculos(enRango, Color.BLUE);
        // Selecciona los circulos que cumplen la condicion del radio
        enRango = CirculosConRadioEnRango(70, 100);
        // Establece el color de los circulos de la coleccion
        PintarCirculos(enRango, Color.RED);
        miVentana.espera(15000);
        GraficarCirculosColeccionados();
        for (int i = 0; i < 100 ; i++) {
            miVentana.espera(500);
            BorrarCirculosColeccionados();
            ActualizarPosicionCirculos();
            if (i == 15) {
                PintarCirculos(circulos, Color.MAGENTA);
            }
            GraficarCirculosColeccionados();
        }
        // TODO - Repetir la animacion para Rectangulo
    }

    /**
     * Selecciona los circulos que cumplen la condicion del radio
     * @param min Radio minimo a considerar
     * @param max Radio maximo a considerar
     * @return La lista con circulos que cumplen la condicion
     */
    public ArrayList<Circulo> CirculosConRadioEnRango(int min, int max) {
        // Creo la nueva lista de circulos
        ArrayList<Circulo> lista = new ArrayList<>();
        for (Circulo c : circulos) {
            // Si esta en rango
            if ( (min <= c.getRadio()) && (c.getRadio() <= max) ) {
                // Lo agrego a la NUEVA lista
                lista.add(c);
            }
        }
        // Devuelvo los circulos que cumplen la condicion
        return lista;
    }
    
    // TODO - RectangulosConSuperficieEnRango()

    /**
     * Toma los circulos que se encuentran en las posiciones
     * entre 0 y 300 en X y entre 0 y 300 en Y
     * @return La lista de circulos en ese sector
     */
    public ArrayList<Circulo> CirculosEnUnArea () {
        // TODO - Implementar
        return null; // Reemplazar por la lista
    }

    // TODO - RectangulosEnUnArea()

    /**
     * Establece el color de los circulos de la coleccion
     * @param lista Los circulos a pintar
     * @param color El color para pintar los circulos
     */
    public void PintarCirculos(ArrayList<Circulo> lista, Color color) {
        for (Circulo c : lista) {
            c.setColor(color);
        }
    }

    // TODO - PintarRectangulos()

    /**
     * Genera los objetos graficos en forma aleatoria
     * y los agrega a la coleccion correspondiente
     * @param cantidad Cantidad de figuras a crear
     */
    public void CrearFigurasAleatorias (int cantidad) {
        for (int c = 0; c < cantidad; c++) {
            Circulo circulo = new Circulo ( aleatorio.nextInt(91) + 10 );
            circulo.setX( aleatorio.nextInt( getAncho() ) );
            circulo.setY( aleatorio.nextInt( getAlto() ) );
            circulo.setDespX( aleatorio.nextInt( 31 ) - 15 );
            circulo.setDespY( aleatorio.nextInt( 31 ) - 15 );
            // Lo agrego en la coleccion
            circulos.add(circulo);
            // TODO - Repetir lo mismo para Rectangulo
        }
    }

    /**
     * Genera los objetos graficos y los agrega a la
     * coleccion correspondiente
     */
    public void CrearFigurasGeometricas () {
        System.out.println("Hay " + circulos.size() + " circulos creados");
        // Creo el primer objeto circulo
        Circulo circulo = new Circulo (100);
        circulo.setX(150);
        circulo.setY(150);
        circulo.setDespX(5);
        circulo.setDespY(5);
        // Lo agrego en la coleccion
        circulos.add(circulo);
        System.out.println("Hay " + circulos.size() + " circulos creados");

        // Creo el segundo objeto circulo
        circulo = new Circulo (50);
        circulo.setX(300);
        circulo.setY(250);
        circulo.setDespX(-15);
        circulo.setDespY(5);
        circulo.setColor(Color.RED);
        // Lo agrego en la coleccion
        circulos.add(circulo);
        System.out.println("Hay " + circulos.size() + " circulos creados");

        // Creo el tercer objeto circulo
        circulo = new Circulo (150);
        circulo.setX(400);
        circulo.setY(350);
        circulo.setDespX(5);
        circulo.setDespY(-15);
        circulo.setColor(Color.BLUE);
        // Lo agrego en la coleccion
        circulos.add(circulo);
        System.out.println("Hay " + circulos.size() + " circulos creados");

        // TODO Agregar 3 rectangulos a la coleccion
    }

    /**
     * Toma uno a uno los circulos de la coleccion y los
     * grafica en el canvas
     */    
    public void GraficarCirculosColeccionados () {
        // Con colecciones puedo usar for-each (para cada elemento)
        for (Circulo c : circulos) {
            miVentana.setColorDeLapiz(c.getColor());
            miVentana.rellenarCirculo(c.getX(), c.getY(), c.getDiametro());
        }
    }

    /**
     * Toma uno a uno los circulos de la coleccion y los
     * grafica en el canvas
     */    
    public void BorrarCirculosColeccionados () {
        // Con colecciones puedo usar for-each (para cada elemento)
        for (Circulo c : circulos) {
            miVentana.borrarCirculo(c.getX(), c.getY(), c.getDiametro());
        }
    }

    /**
     * Toma uno a uno los circulos de la coleccion y les
     * pide que actualicen su posicion
     */    
    public void ActualizarPosicionCirculos () {
        // Con colecciones puedo usar for-each (para cada elemento)
        for (Circulo c : circulos) {
            c.actualizarPosicion();
        }
    }

    /**
     * Toma uno a uno los rectangulos de la coleccion y los
     * grafica en el canvas
     */    
    public void GraficarRectangulosColeccionados () {
        // TODO implementar el metodo
    }

    /**
     * Simula el rebote de una pelota en los bordes de la ventana
     */
    public void PelotaRebotando () {
        int desplazamiento = 10;
        Circulo circulo = new Circulo (20);
        circulo.setX(150);
        circulo.setY(350);
        miVentana.setColorDeLapiz(circulo.getColor());
        miVentana.rellenarCirculo(circulo.getX(), circulo.getY(), circulo.getDiametro());
        miVentana.espera(5000);
        for ( int repeticiones = 0 ; repeticiones < 600 ; repeticiones++ ) {
            miVentana.borrarCirculo(circulo.getX(), circulo.getY(), circulo.getDiametro());
            // Verifica rebote en los bordes
            if ((circulo.getX() + circulo.getDiametro() >= getAncho()) || 
                    (circulo.getX() <= 0)) {
                desplazamiento = - desplazamiento;
            }
            circulo.setX( circulo.getX() + desplazamiento );

            // Agreguen movimiento vertical

            // circulo.setY( circulo.getY() - 5 );
            miVentana.rellenarCirculo(circulo.getX(), circulo.getY(), circulo.getDiametro());
            miVentana.espera(75);
        }
        
    }

    public void RectanguloRebotando () {
        
    }

    public void PrimerosEjemplos () {
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

    /**
     * El ancho de la ventana grafica
     * @return el ancho
     */
    public int getAncho () {
        return ancho;
    }

    /**
     * El alto de la ventana grafica
     * @return el alto
     */
    public int getAlto () {
        return alto;
    }

}
