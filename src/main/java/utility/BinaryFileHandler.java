package utility;

import java.io.*;
import java.util.ArrayList;

public class BinaryFileHandler {

    public static <T> ArrayList<T> readAll(String fileName) {
        ArrayList<T> list = new ArrayList<>();
        File f = new File(fileName);
        if (!f.exists()) {
            return list;
        }

        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            try {
                while (true) {
                    T obj = (T) ois.readObject();
                    list.add(obj);
                }
            } catch (Exception e) {

            }
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }


    public static <T> void appendObject(String fileName, T obj) {
        File f = new File(fileName);
        try {
            FileOutputStream fos;
            ObjectOutputStream oos;
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(obj);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> void rewriteAll(String fileName, ArrayList<T> list) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (T obj : list) {
                oos.writeObject(obj);
            }
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
