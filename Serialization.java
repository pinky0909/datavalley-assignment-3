import java.io.*;

class MyObject implements Serializable {
    private static final long serialVersionUID = 1L;
    private String data;

    public MyObject(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}

public class SerializationExample {
    public static void main(String[] args) {
        // Create an object to serialize
        MyObject obj = new MyObject("Hello, World!");

        // Serialization
        try {
            FileOutputStream fileOut = new FileOutputStream("object.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obj);
            out.close();
            fileOut.close();
            System.out.println("Object has been serialized");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialization
        try {
            FileInputStream fileIn = new FileInputStream("object.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            MyObject newObj = (MyObject) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Object has been deserialized");
            System.out.println("Data: " + newObj.getData());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
