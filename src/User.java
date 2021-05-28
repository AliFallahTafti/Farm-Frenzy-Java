public class User {
    private String username;
    private String password;
    private int coins;
    private int level;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.level=0;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getCoins() {
        return coins;
    }

    public int getLevel() {
        return level;
    }
}
