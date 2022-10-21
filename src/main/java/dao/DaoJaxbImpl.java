package dao;

import generated.Factura;
import handler.ValidationHandler;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.validation.SchemaFactory;
import java.io.File;

public class DaoJaxbImpl implements DaoJaxb {

    @Override
    public Factura getInvoice(String pathXML, String pathXSD) throws JAXBException, SAXException {
        File xml = new File(pathXML);
        File xsd = new File(pathXSD);
        JAXBContext jaxbContext = JAXBContext.newInstance(Factura.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        unmarshaller.setSchema(SchemaFactory.newInstance(
                XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI).newSchema(xsd));
        unmarshaller.setEventHandler(new ValidationHandler());
        return (Factura) unmarshaller.unmarshal(xml);
    }
}
