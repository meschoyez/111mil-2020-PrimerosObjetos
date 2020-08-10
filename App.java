public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Circulo miCirculo = new Circulo (4.5);
        Circulo otroCirculo = new Circulo (9.8);

        System.out.println(miCirculo.getRadio());
        System.out.println(otroCirculo.getRadio());

        miCirculo.setRadio(2.5);
        System.out.println(miCirculo.getRadio());
    }
}
