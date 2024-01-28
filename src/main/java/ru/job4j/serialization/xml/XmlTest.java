package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class XmlTest {

    public static void main(String[] args) throws JAXBException, IOException {
        Man man = new Man("Ivan", 35, true,
                new String[]{"Anna", "Petr"}, new Address("Moscow", "Pushkin"));
        JAXBContext context = JAXBContext.newInstance(Man.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml;
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(man, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            Man result = (Man) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}
