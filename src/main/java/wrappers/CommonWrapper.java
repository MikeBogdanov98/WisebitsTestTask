package wrappers;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CommonWrapper {
    public static String getRandomStringOfLettersAndDigits(int length) {
        String result = "";
        for (int i = 0; i < length; i++) {
            int charNumber = (int) (Math.random() * 62);
            if (charNumber < 10) {
                result += (char) (charNumber + 48);
            } else if (charNumber < 36) {
                result += (char) (charNumber + 55);
            } else {
                result += (char) (charNumber + 61);
            }
        }
        return result;
    }

    public static String getRandomStringOfLetters(int length) {
        String result = "";
        for (int i = 0; i < length; i++) {
            int charNumber = (int) (Math.random() * 52);
            if (charNumber < 26) {
                result += (char) (charNumber + 65);
            } else {
                result += (char) (charNumber + 71);
            }
        }
        return result;
    }

    public static int getRandomIntInRange(int from, int to) {
        return (int) (Math.random() * (to - from + 1) + from);
    }

    public static File createFile(final String filename, final long sizeInBytes) throws IOException {
        File file = new File(filename);
        file.createNewFile();
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        raf.setLength(sizeInBytes);
        raf.close();

        return file;
    }
}
