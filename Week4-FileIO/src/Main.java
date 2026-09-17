import java.io.*;
public class Main {
    public static void main(String[] args) {

        Student student = new Student("Eric", 123, new Major("SWE", "CECS", 127));


        // https://www.bing.com/search?q=java+seralizable+interface

        try {
            FileOutputStream fos = new FileOutputStream("student.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(student);

            fos.close();

        } catch (IOException e) {
            System.out.println("output failed");
        }

        try{
            FileInputStream fis = new FileInputStream("student.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Student fileStudent = (Student) ois.readObject(); // down-casting object
            System.out.println(fileStudent.getName() + " " + fileStudent.getNumber());
        }catch (IOException e) {
            System.out.println("input failed");
        } catch (ClassNotFoundException e) {
            System.out.println("Conversion failed");
        }


        // from murach book
        String filename = "products.txt";

        try {
            PrintWriter out = new PrintWriter(
                    new BufferedWriter(
                    new FileWriter(filename)));

            out.println("some file text");

            out.close();

        } catch (IOException e) {
            System.out.println("Unable to open file");
        }


        try {
            // open an input stream
            BufferedReader in = new BufferedReader(
                    new FileReader(filename));

            String line = in.readLine();
            while(line != null) {    // prevent the EOFException
                System.out.println(line);
                line = in.readLine();
            }

            in.close();

        }
        catch ( IOException e) {
            System.out.println("Unable to open file");
        }

    }
}