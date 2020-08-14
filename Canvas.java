import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * Class Canvas - una clase que permite dibujar sobre un canvas
 * 
 * @author Michael Kolling (mik)
 * @author Bruce Quig
 *
 * @version 2008.03.30
 */

public class Canvas
{
    private JFrame frame;
    private CanvasPane canvas;
    private Graphics2D grafico;
    private Color colorDeFondo;
    private Image imagenDelCanvas;

    /**
     * Crea un Canvas con alto, ancho y color de fondo por defecto
     * (300, 300, blanco).
     * @param titulo  ttitulo que aparecera en el marco del Canvas     
     */
    public Canvas(String titulo)
    {
        this(titulo, 300, 300, Color.white);        
    }
    /**
     * Crea un Canvas con  color de fondo por defecto(blanco).
     * @param titulo  titulo que aparecer� en el marco del Canvas
     * @param ancho  ancho del Canvas
     * @param alto alto del Canvas
     */
    public Canvas(String titulo, int ancho, int alto)
    {
        this(titulo, ancho, alto, Color.white);
    }

    /**
     * Crea un Canvas.
     * @param titulo  titulo que aparecer� en el marco del Canvas
     * @param ancho  ancho del Canvas
     * @param alto alto del Canvas
     * @param fdColor  color de fondo del Canvas
     */
    public Canvas(String titulo, int ancho, int alto, Color fdColor)
    {
        frame = new JFrame();
        canvas = new CanvasPane();
        frame.setContentPane(canvas);
        frame.setTitle(titulo);
        // Agregado para cierre de programa al cerrar ventana
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        canvas.setPreferredSize(new Dimension(ancho, alto));
        colorDeFondo = fdColor;
        frame.pack();
    }

    /**
 	 * Establece la visibilidad del Bastidor y lo trae al frente de la pantalla.  
     * Puede ser usado para traer al frente de la pantalla un Bastidor ya
     * existente.
     * @param visible  visible (true) o no visible (false)
     */
    public void setVisible(boolean visible)
    {
        if(grafico == null) {
        	// primera vez: instancia la imagen fuera de la pnatalla y la 
            // rellena con el color de fondo
            Dimension size = canvas.getSize();
            imagenDelCanvas = canvas.createImage(size.width, size.height);
            grafico = (Graphics2D)imagenDelCanvas.getGraphics();
            grafico.setColor(colorDeFondo);
            grafico.fillRect(0, 0, size.width, size.height);
            grafico.setColor(Color.black);
        }
        frame.setVisible(true);
    }

    /**
     * Muestra la informacion de la visibilidad del Bastidor
     * @return  true si es visible, false en otro caso
     */
    public boolean isVisible()
    {
        return frame.isVisible();
    }

    /**
    * Dibuja el contorno de una figura dentro del canvas
    * @param  figura  figura  a ser dibujada
    */
    public void dibujar(Shape figura)
    {
        grafico.draw(figura);
        canvas.repaint();
    }
 
    /**
     * Rellena una figura con el color de lapiz del canvas
     * @param  figura La figura a ser rellenada
     */
    public void rellenar(Shape figura)
    {
        grafico.fill(figura);
        canvas.repaint();
    }

    /**
     * Rellena un circulo con el color de lapiz del canvas
     */
    public void rellenarCirculo(int xPos, int yPos, int diametro)
    {
        Ellipse2D.Double circle = new Ellipse2D.Double(xPos, yPos, diametro, diametro);
        rellenar(circle);
    }

    /**
     * Rellena un rect�ngulo con el color de lapiz del canvas
     */
    public void rellenarRectangulo(int xPos, int yPos, int ancho, int alto)
    {
        rellenar(new Rectangle(xPos, yPos, ancho, alto));
    }

    /**
     * Rellena un rect�ngulo con el color de lapiz del canvas
     */
    public void rellenarTriangulo(int xPos, int yPos, int ancho, int alto)
    {
        int[] xpoints = { xPos, xPos + (ancho/2), xPos - (ancho/2) };
        int[] ypoints = { yPos, yPos + alto, yPos + alto };
        rellenar(new Polygon(xpoints, ypoints, 3));     
    }

    /**
     * Borra todo el canvas
     */
    public void borrar()
    {
        Color original = grafico.getColor();
        grafico.setColor(colorDeFondo);
        Dimension size = canvas.getSize();
        grafico.fill(new Rectangle(0, 0, size.width, size.height));
        grafico.setColor(original);
        canvas.repaint();
    }

    /**
     * Borra un circulo con las dimensiones especificadas del canvas.
     * Podr�a utilizarse tambi�n el m�todo borrar para esta tarea.
     */
    public void borrarCirculo(int xPos, int yPos, int diametro)
    {
        Ellipse2D.Double circulo = new Ellipse2D.Double(xPos, yPos, diametro, diametro);
        borrar(circulo);
    }

    /**
     *  Borra un rect�ngulo con las dimensiones especificadas del canvas
     *  Podr�a utilizarse tambi�n el m�todo borrar para esta tarea.
     */
    public void borrarRectangulo(int xPos, int yPos, int ancho, int alto)
    {
        borrar(new Rectangle(xPos, yPos, ancho, alto));
    }

    /**
     *  Borra un tri�ngulo con las dimensiones especificadas del canvas
     *  Podr�a utilizarse tambi�n el m�todo borrar para esta tarea.
     */
    public void borrarTriangulo(int xPos, int yPos, int ancho, int alto)
    {
        int[] xpoints = { xPos, xPos + (ancho/2), xPos - (ancho/2) };
        int[] ypoints = { yPos, yPos + alto, yPos + alto };
        borrar(new Polygon(xpoints, ypoints, 3));
    }

    /**
     * Borra el interior de una figura de la pantalla
     * @param  figura  La forma a ser borrada
     */
    public void borrar(Shape figura)
    {
        Color original = grafico.getColor();
        grafico.setColor(colorDeFondo);
        grafico.fill(figura);              // borra rellenando con el color de fondo
        grafico.setColor(original);
        canvas.repaint();
    }

    /**
     * Borra el contorno de una figura de la pantalla
     * @param  figura  La figura a ser borrada
     */
    public void borrarControno(Shape figura)
    {
        Color original = grafico.getColor();
        grafico.setColor(colorDeFondo);
        grafico.draw(figura);  // borra dibujando con el color de fondo.
        grafico.setColor(original);
        canvas.repaint();
    }

    /**
     * Dibjua una imagen en el canvas.
     * @param  imagen  la imagen a ser dibujada
     * @param  x       coordenada x para ubicar la imagen 
     * @param  y       ooordenada y para ubicar la imagen
     * @return  devuelve un valor booleano que indica si la imagen pudo o no
     *          ser cargada 
     */
    public boolean dibujarImagen(Image imagen, int x, int y)
    {
        boolean resultado = grafico.drawImage(imagen, x, y, null);
        canvas.repaint();
        return resultado;
    }

    /**
     * Dibjua un texto en el Canvas.
     * @param  texto   el texto a ser mostrado 
     * @param  x      coordenada x para ubicar el texto 
     * @param  y      coordenada y para ubicar el texto
     */
    public void dibujarTexto(String texto, int x, int y)
    {
        grafico.drawString(texto, x, y);   
        canvas.repaint();
    }

    /**
     * Borra un texto del Canvas.
     * @param  texto     el texto a ser borrado. 
     * @param  x        coordenada x para ubicar el texto 
     * @param  y        coordenada y para ubicar el texto
     */
    public void borrarTexto(String texto, int x, int y)
    {
        Color original = grafico.getColor();
        grafico.setColor(colorDeFondo);
        grafico.drawString(texto, x, y);   
        grafico.setColor(original);
        canvas.repaint();
    }

    /**
     * Dibuja una l�nea en el Canvas.
     * @param  x1   coordenada x para el inicio de la linea
     * @param  y1   coordenada y para el inicio de la linea 
     * @param  x2   coordenada x para el fin de la linea 
     * @param  y2   coordenada y para el fin de la linea 
     */
    public void dibujarLinea(int x1, int y1, int x2, int y2)
    {
        grafico.drawLine(x1, y1, x2, y2);   
        canvas.repaint();
    }

    /**
     * Establece el color de l�piz del Canvas.
     * @param  nuevoColor   el nuevo color de l�piz del Canvas 
     */
    public void setColorDeLapiz(Color nuevoColor)
    {
        grafico.setColor(nuevoColor);
    }

    /**
     * Retorna el color de l�piz del Canvas.
     * @return  el color de l�piz del canvas
     */
    public Color getColorDeLapiz()
    {
        return grafico.getColor();
    }

    /**
     * Establece el color de fondo del Canvas.
     * @param  nuevoColor   el nuevo color de fondo del Canvas 
     */
    public void setColorDeFondo(Color nuevoColor)
    {
        colorDeFondo = nuevoColor;   
        grafico.setBackground(nuevoColor);
    }

    /**
     * Retorna el color de fondo del Canvas.
     * @return   el color de fondo del Canvas.
     */
    public Color getColorDeFondo()
    {
        return colorDeFondo;
    }

    /**
     * Cambia el tipo de letra utilizado en el Canvas
     * @param  nuevoTipoDeLetra   nuevo tipo de letra a ser usado para el texto de salida
     */
    public void setTipoDeLetra(Font nuevoTipoDeLetra)
    {
        grafico.setFont(nuevoTipoDeLetra);
    }

    /**
     * Retorna el tipo de letra utilizado en el canvas.
     * @return     the font currently in use
     **/
    public Font getTipoDeLetra()
    {
        return grafico.getFont();
    }

    /**
     * Establece el tama�o del canvas
     * @param  ancho    nuevo ancho
     * @param  alto   nuevo alto
     */
    public void setTamanio(int ancho, int alto)
    {
        canvas.setPreferredSize(new Dimension(ancho, alto));
        Image oldImage = imagenDelCanvas;
        imagenDelCanvas = canvas.createImage(ancho, alto);
        grafico = (Graphics2D)imagenDelCanvas.getGraphics();
        grafico.drawImage(oldImage, 0, 0, null);
        frame.pack();
    }

    /**
     * Retorna el tama�o del canvas
     * @return     Las dimensiones del canvas
     */
    public Dimension getTamanio()
    {
        return canvas.getSize();
    }

    /**
     * Espera por el tiempo especificado en milisegundos.
     * Una manera facil para especificar una peque�a demora qeu puede
     * ser utilizada cuando se producen animaciones
     * @param  milisegundos  el numero de milisegundos a esperar 
     */
    public void espera(int milisegundos)
    {
        try
        {
            Thread.sleep(milisegundos);
        } 
        catch (InterruptedException e)
        {
            // ignoramos excepciones por ahora
        }
    }

    /************************************************************************
     * Clase interna CanvasPane - El componente real conenido en Canvas
     * Esta es escencialmente un JPanel con capacidad agregada 
     * para refrescar la imagen dibujada en �l.
     */
    private class CanvasPane extends JPanel
    {
        private static final long serialVersionUID = 1L;
        
        public void paint(Graphics g)
        {
            g.drawImage(imagenDelCanvas, 0, 0, null);
        }
    }
}