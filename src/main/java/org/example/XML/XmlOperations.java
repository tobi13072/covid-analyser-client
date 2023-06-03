package org.example.XML;

import lombok.RequiredArgsConstructor;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

@RequiredArgsConstructor
public class XmlOperations<T> {
    public T importXML(File file, Class<?>... classesToBeBound) throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(classesToBeBound);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        return (T) unmarshaller.unmarshal(file);
    }

    public void exportXML(T rootElement, File file, Class<?>... classesToBeBound) throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(classesToBeBound);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(rootElement, file);
    }
}
