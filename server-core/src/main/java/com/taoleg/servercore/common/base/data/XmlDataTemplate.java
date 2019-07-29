package com.taoleg.servercore.common.base.data;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;


public class XmlDataTemplate<T> implements DataTransfer<T> {


    @Override
    public String format() {
        try {
            JAXBContext context = JAXBContext.newInstance(this.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);

            StringWriter stringWriter = new StringWriter();
            marshaller.marshal(this, stringWriter);

            return stringWriter.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    public T parse(String source, String... excludes) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(this.getClass());
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (T) unmarshaller.unmarshal(new StringReader(source));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return (T) new Object();
    }

}
