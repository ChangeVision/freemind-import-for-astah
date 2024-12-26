package com.github.astah.mm2asta.util;

import java.io.InputStream;
import java.io.Writer;

import javax.xml.validation.Schema;

import jakarta.xml.bind.JAXB;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

public class JAXBUtils {

    public static void marshal(Object jaxbObject, Writer xml) {
        Thread currentThread = Thread.currentThread();
        ClassLoader originalClassLoader = currentThread.getContextClassLoader();
        ClassLoader pluginClassLoader = JAXBUtils.class.getClassLoader();
        try {
            currentThread.setContextClassLoader(pluginClassLoader);
            JAXB.marshal(jaxbObject, xml);
        } finally {
            currentThread.setContextClassLoader(originalClassLoader);
        }
    }

    public static <T> T unmarshal(InputStream xml, Class<T> type) {
        Thread currentThread = Thread.currentThread();
        ClassLoader originalClassLoader = currentThread.getContextClassLoader();
        ClassLoader pluginClassLoader = JAXBUtils.class.getClassLoader();
        try {
            currentThread.setContextClassLoader(pluginClassLoader);
            return JAXB.unmarshal(xml, type);
        } finally {
            currentThread.setContextClassLoader(originalClassLoader);
        }
    }

    public static <T> T unmarshal(Schema schema, InputStream xml, Class<T> type)
            throws JAXBException {
        Thread currentThread = Thread.currentThread();
        ClassLoader originalClassLoader = currentThread.getContextClassLoader();
        ClassLoader pluginClassLoader = JAXBUtils.class.getClassLoader();
        try {
            currentThread.setContextClassLoader(pluginClassLoader);
            JAXBContext context = JAXBContext.newInstance(type);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            unmarshaller.setSchema(schema);
            return type.cast(unmarshaller.unmarshal(xml));
        } finally {
            currentThread.setContextClassLoader(originalClassLoader);
        }
    }
}
