import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.junit.Assert;

public class HuffmanDecoderTest {
    @Test
    public void testReadEncodedMessage() throws IOException {
        // Escribir un mensaje codificado en un archivo
        String fileName = "test_encoded.txt";
        String message = "01011"; // Mensaje de prueba
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write(message);
        }

        // Leer el mensaje codificado usando el método HuffmanDecoder.readEncodedMessage
        String readMessage = HuffmanDecoder.readEncodedMessage(fileName);

        // Verificar que el mensaje leído es correcto
        assertEquals(message, readMessage);
    }
}
