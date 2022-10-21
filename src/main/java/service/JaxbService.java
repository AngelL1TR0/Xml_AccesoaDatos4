package service;

import dao.DaoJaxb;
import dao.DaoJaxbImpl;
import generated.DatosCliente;
import generated.Factura;
import jakarta.xml.bind.JAXBException;
import org.xml.sax.SAXException;

public class JaxbService {

    DaoJaxb daoJaxb = new DaoJaxbImpl();
    public void unmarshall(String pathXml, String pathXsd) {
        try {
            try {
                Factura invoice = daoJaxb.getInvoice(pathXml, pathXsd);
                printInvoice(invoice);
            }catch (JAXBException | SAXException e ){
                throw new RuntimeException(e);
            }
        }




    }

    private void printInvoice(Factura invoice) {
        printClienteData(invoice.getDatosCliente());
    }

    private void printClienteData(DatosCliente datosCliente) {
        System.out.println("---------");
        System.out.println("Cliente: " + datosCliente.getNombre());
        System.out.println();
    }
}
