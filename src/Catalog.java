package src;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Catalog {

    public static String getHash(File file) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
            InputStream is = new FileInputStream(file);
            DigestInputStream dis = new DigestInputStream(is, md);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        byte[] digest = md.digest();
        return new String(digest);
    }

}
