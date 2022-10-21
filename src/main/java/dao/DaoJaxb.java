package dao;

import generated.Factura;

public interface DaoJaxb {

     default Factura getInvoice(String pathXML, String pathXSD) {

    }
}
