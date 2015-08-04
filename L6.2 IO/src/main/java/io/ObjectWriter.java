package io;

import java.io.*;

/**
 * @author v.chibrikov
 */
public class ObjectWriter {
    public static void main(String[] args) {
        stringExample();
        descriptorExample();
    }

    private static void stringExample() {
        write("Ph'nglui mglw'nafh Cthulhu R'lyeh wgah'nagl fhtagn", "./string.bin");
        String fromFile = (String) read("./string.bin");
        System.out.println(fromFile);
    }

    private static void descriptorExample() {
        Descriptor descriptor = new Descriptor("Anna", 15);
        write(descriptor, "./descriptor.bin");
        Descriptor fromFile = (Descriptor) read("./descriptor.bin");
        System.out.println(fromFile);
    }

    public static void write(Object object, String fileName) {
        try (FileOutputStream out = new FileOutputStream(fileName)) {
            BufferedOutputStream bout = new BufferedOutputStream(out);
            ObjectOutputStream dout = new ObjectOutputStream(bout);
            dout.writeObject(object);
            dout.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object read(String fileName) {
        try (FileInputStream out = new FileInputStream(fileName)) {
            BufferedInputStream bout = new BufferedInputStream(out);
            ObjectInputStream dout = new ObjectInputStream(bout);
            return dout.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}
