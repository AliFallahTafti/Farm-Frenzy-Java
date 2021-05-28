import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Inputs {
    public void inputProcessing() {
        Scanner scanner = new Scanner(System.in);
        Manager manager = new Manager();
        System.out.println("WELCOME TO FARM FRENZY!!");
        while (manager.getLoginStatus() != 2) {
            while (manager.getLoginStatus() == 1) {
                System.out.println("LOG IN\tSIGNUP!");
                String input = scanner.nextLine();
                if (patternMatcher(input, "^LOG\\s+IN\\s*$")) {
                    manager.login(scanner);
                } else if (patternMatcher(input, "^SIGNUP\\s*$")) {
                    manager.signup(scanner);
                }
            }
            while (manager.getLoginStatus() == 3) {
                System.out.println("START\tLOGOUT\tSETTING");
                String input = scanner.nextLine();
                if (patternMatcher(input, "^START\\s+(\\d+)\\s*$")) {
                    Matcher matcher = getMatcher(input, "^START\\s+(\\d+)\\s*$");
                    if (matcher.matches()) {
                        int level = Integer.parseInt(matcher.group(1));
                        manager.start(level);
                    }
                } else if (patternMatcher(input, "^LOGOUT\\s*$")) {
                    manager.logout();
                } else if (patternMatcher(input, "^SETTING\\s*$")) {

                } else if (patternMatcher(input, "^EXIT\\s*$")) {
                    manager.exit();
                } else
                    System.out.println("INVALID COMMAND!");
            }
                while (manager.getLoginStatus() == 0) {
                    String input =scanner.nextLine();
                    if (patternMatcher(input, "^BUY\\s+(\\w+)\\s*$")) {
                        Matcher matcher=getMatcher(input, "^BUY\\s+(\\w+)\\s*$");
                        if(matcher.matches()){
                            String animalName=matcher.group(1);
                            manager.buy(animalName);
                        }
                    } else if (patternMatcher(input, "^PICKUP\\s+(\\d+)\\s+(\\d+)\\s*$")) {
                        Matcher matcher=getMatcher(input, "^PICKUP\\s+(\\d+)\\s+(\\d+)\\s*$");
                        if(matcher.matches()){
                            int x= Integer.parseInt(matcher.group(1));
                            int y= Integer.parseInt(matcher.group(2));
                            manager.pickup(x,y);
                        }
                    } else if (patternMatcher(input, "^WELL\\s*$")) {
                        manager.well();
                    } else if (patternMatcher(input, "^PLANT\\s+(\\d+)\\s+(\\d+)\\s*$")) {
                        Matcher matcher=getMatcher(input, "^PLANT\\s+(\\d+)\\s+(\\d+)\\s*$");
                        if(matcher.matches()) {
                            int x= Integer.parseInt(matcher.group(1));
                            int y= Integer.parseInt(matcher.group(2));
                            manager.plant(x,y);
                        }
                    } else if (patternMatcher(input, "^WORK\\s+(\\w+)\\s*$")) {
                        Matcher matcher=getMatcher(input, "^WORK\\s+(\\w+)\\s*$");
                        if(matcher.matches()) {
                            String name=matcher.group(1);
                            manager.work(name);
                        }
                    } else if (patternMatcher(input, "^CAGE\\s+(\\d+)\\s+(\\d+)\\s*$")) {
                        Matcher matcher=getMatcher(input, "^CAGE\\s+(\\d+)\\s+(\\d+)\\s*$");
                        if(matcher.matches()) {
                            int x = Integer.parseInt(matcher.group(1));
                            int y = Integer.parseInt(matcher.group(2));
                            manager.cage(x,y);
                        }
                    } else if (patternMatcher(input, "^TURN\\s+(\\d+)\\s*$")) {
                        Matcher matcher=getMatcher(input, "^TURN\\s+(\\d+)\\s*$");
                        if(matcher.matches()) {
                            int n=Integer.parseInt(matcher.group(1));
                            manager.turn(n);
                        }
                    } else if (patternMatcher(input, "^TRUCK\\s+LOAD\\s+(\\w+)\\s*$")) {
                        Matcher matcher=getMatcher(input, "^TRUCK\\s+LOAD\\s+(\\w+)\\s*$");
                        if(matcher.matches()) {
                            String name=matcher.group(1);
                            manager.load(name);
                        }
                    } else if (patternMatcher(input, "^TRUCK\\s+UNLOAD\\s+(\\w+)\\s*$")) {
                        Matcher matcher=getMatcher(input, "^TRUCK\\s+UNLOAD\\s+(\\w+)\\s*$");
                        if(matcher.matches()) {
                            String name=matcher.group(1);
                            manager.unload(name);
                        }
                    } else if (patternMatcher(input, "^TRUCK\\s+GO\\s*$")) {
                        manager.truckGo();
                    }
                    manager.updateGame();
                }
        }
    }
    public boolean patternMatcher(String input,String regex){
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(input);
        return matcher.matches();
    }
    public Matcher getMatcher(String input,String regex){
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(input);
        return matcher;
    }
}
