package wrappers;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CommonWrapper {
    public static File createFile(final String filename, final long sizeInBytes) throws IOException {
        File file = new File(filename);
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        raf.setLength(sizeInBytes);
        raf.close();
        return file;
    }
}
