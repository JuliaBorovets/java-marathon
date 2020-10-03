package sprint07.task03;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

//Create the method writeFile(String filename, String text) that write the text to file as sequence of bytes in binary format.
//
//For example, the text fragment
//Hello!
//
//should be represented in the file as a sequence of 7-bit bytes without spaces between them:
//100100011001011101100110110011011110100001
//If less than 7 bits are required to represent the character then add to binary sequence leading zeros '0'.
public class Task03 {
    public static void writeFile(String filename, String text) throws IOException {

        Path filePath = new File(filename).toPath();

        StringBuilder stringBuilder = new StringBuilder();

        for (byte b : text.getBytes()) {

            int dec = Integer.parseInt(Byte.toString(b));
            String by = Integer.toBinaryString(dec);

            stringBuilder.append("0".repeat(Math.max(0, 7 - by.length())));
            stringBuilder.append(by);
        }

        Files.write(filePath, stringBuilder.toString().getBytes());

    }


    public static void writeFile2(String filename, String text) {

        StringBuilder stringBuilder = new StringBuilder();

        for (byte b : text.getBytes()) {

            int dec = Integer.parseInt(Byte.toString(b));
            String by = Integer.toBinaryString(dec);

            stringBuilder.append("0".repeat(Math.max(0, 7 - by.length())));
            stringBuilder.append(by);
        }

        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filename))) {
            bos.write(stringBuilder.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        writeFile2("test.txt", "Hello!");
    }
}
