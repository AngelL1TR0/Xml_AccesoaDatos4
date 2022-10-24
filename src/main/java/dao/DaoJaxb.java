package dao;

import generated.Factura;
import jakarta.xml.bind.JAXBException;
import org.xml.sax.SAXException;

public interface DaoJaxb {

     Factura getInvoice(String pathXml, String pathXsd) throws JAXBException, SAXException;
}
