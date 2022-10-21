package app;

import service.JaxbService;

public class Actividad3 {

    private final static String PATH_XML = "src/main/resources/xml/factura.xml";
    private static final String PATH_XSD = "src/main/resources/xsd/factura.xsd";

    public static void main(String[] args) {
        JaxbService unmarshall = new JaxbService();
        unmarshall.unmarshall(PATH_XML, PATH_XSD);
    }
}
