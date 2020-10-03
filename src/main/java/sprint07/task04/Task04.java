package sprint07.task04;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

//Create the method readFile(String filename) that read from file a sequence of bytes in binary format from previous
// task and return ridable string.
//
//For example, the sequence of 7-bit bytes
//100100011001011101100110110011011110100001
//
//should be represented as text fragment:
//Hello!
public class Task04 {
    public static String readFile(String filename) {

        StringBuilder result = new StringBuilder();

        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(filename))) {

            StringBuilder stringBuilder = new StringBuilder();

            int i = 0;
            while ((i = bufferedInputStream.read()) != -1) {
                stringBuilder.append((char) i);
            }

            String temp = stringBuilder.toString();

            for (int j = 0; j < temp.length(); j += 7) {
                result.append((char) Integer.parseInt(temp.substring(j, j + 7), 2));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(readFile("test.txt"));
    }
}
