import java.io.*;
import java.nio.Buffer;
import java.util.Scanner;

public class FileManagement {
    private String absolutePath;
    public FileManagement(){
        File file=new File("");
        absolutePath=file.getAbsolutePath();
    }
    public void write(String name,String data,boolean append){
        try {
            File file=new File(name);
            if(!file.exists()) file.createNewFile();
            FileWriter fileWriter=new FileWriter(name,append);
            fileWriter.write(data);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    public String read(String fileName){
        File file=new File(fileName);
        String outPut="";
        try {
            Scanner scanner=new Scanner(file);
            while (scanner.hasNextLine()){
                outPut+=scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        return outPut;
    }
    public void newLine(String name){
        try {
            File file=new File(name);
            if(!file.exists()) file.createNewFile();
            FileWriter fileWriter=new FileWriter(name,true);
            fileWriter.write("\n");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
