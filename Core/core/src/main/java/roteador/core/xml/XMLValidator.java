package roteador.core.xml;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.net.URL;

public class XMLValidator {

    private static final String XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
    static final Logger log = Logger.getLogger(XMLValidator.class);

    public static boolean validateXML(String xsdFile, String xmlAsString) throws SAXException, IOException {

        final SchemaFactory factory = SchemaFactory.newInstance(XML_SCHEMA);
        final URL schemaUrl = XMLValidator.class.getClassLoader().getResource(xsdFile);
        final File schemaFile = new File(schemaUrl.getFile());

        final Schema schema = factory.newSchema(schemaFile);
        final Validator validator = schema.newValidator();
        final Source source = new StreamSource(new StringReader(xmlAsString));

        try {
            validator.validate(source);
            log.info("Validating " + xmlAsString + "against xsd: OK");
            return true;
        } catch (final SAXException ex) {
            log.info("Validating " + xmlAsString + "against xsd: FAIL");
            log.debug("Validation failure cause: " + ex.getCause());
            return false;
        }
    }
}
