package com.reunico.bpm;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static org.junit.Assert.*;

public class QrReaderTest {

    @Test
    public void decodeQRCode() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("example3.png").getFile());
        try {
            InputStream inputStream = new FileInputStream(file);
            QrReader qrReader = new QrReader();
            /*
            System.out.println(qrReader.decodeQRCode(inputStream));
            */
            assertEquals ("t=20181203T0812&s=264.00&fn=9286000100105429&i=30651&fp=80362384&n=1",
                    qrReader.decodeQRCode(inputStream));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}