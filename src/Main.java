import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        LOGGER.log(Level.INFO,"Начало работы");

        byte[] input = new byte[]{48, 49, 50, 51};
        LOGGER.log(Level.INFO,"инициализация входного массива");

        InputStream inputStream = new ByteArrayInputStream(input);
        LOGGER.log(Level.INFO,"создание inputStream");
        Charset charset = StandardCharsets.US_ASCII;
        LOGGER.log(Level.INFO,"создание charset {0}",charset);
        try {
            System.out.println(readAsString(inputStream, charset));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        LOGGER.log(Level.INFO, "Работа с потоками ");
        int byteRead;
        while ((byteRead = inputStream.read()) != -1) {
            byteArrayOutputStream.write(byteRead);
            LOGGER.log(Level.INFO, "Байт {0} записан ", byteRead);
        }
        return byteArrayOutputStream.toString(charset);
    }

}