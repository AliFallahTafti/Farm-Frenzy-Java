import java.time.LocalDate;
import java.util.Date;

public class Logger {
    private Date date;
    private FileManagement fileManagement;

    public Logger(){
        fileManagement=new FileManagement();
    }
    public void printError(String input){
        date=new Date();
        fileManagement.write("log.txt",date+" [ERROR] : "+input,true);
        fileManagement.newLine("log.txt");
    }
    public void printInfo(String input){
        date=new Date();
        fileManagement.write("log.txt",date+" [INFO] : "+input,true);
        fileManagement.newLine("log.txt");
    }
    public void printAlarm(String input){
        date=new Date();
        fileManagement.write("log.txt",date+" [ALARM] : "+input,true);
        fileManagement.newLine("log.txt");
    }
    public void printHeader(User user){
        date=new Date();
        fileManagement.write("log.txt",date+" [USER] : "+user.getUsername(),true);
        fileManagement.newLine("log.txt");
    }
}
