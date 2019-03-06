package ru.job4j.input.inputoutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Class Archive.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 02.03.2019
 */
public class Archive {
    /**
     * Path to directory.
     */
    private static String srcDir;
    /**
     * Path to output file.
     */
    private static String outputZip;
    /**
     * List of extensions to exclude from compressing or null to compress all files.
     */
    private static List<String> exts;

    /**
     * Method main.
     * @param args string
     */
    public static void main(String[] args) {
        Args arguments = new Args(args);
        srcDir = arguments.directory();
        outputZip = arguments.output();
        exts = arguments.exclude();
    }

    /**
     * Method compresses the specified directory.
     */
    public void zip() {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(outputZip))) {
            SearchFiles filesSearch = new SearchFiles();
            List<File> listFilesZip = filesSearch.files(srcDir, exts);
            for (File sFile : listFilesZip) {
                ZipEntry ze = new ZipEntry(Paths.get(srcDir).relativize(Paths.get(sFile.getPath())).toString());
                zos.putNextEntry(ze);
                FileInputStream fis = new FileInputStream(sFile);
                writeStream(fis, zos);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method write to stream.
     * @param is - input stream
     * @param os - output stream
     */
    private void writeStream(InputStream is, OutputStream os) {
        try {
            byte[] buffer = new byte[1024];
            int bytesRead = is.read(buffer);
            while (bytesRead != -1) {
                os.write(buffer, 0, bytesRead);
                bytesRead = is.read(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
