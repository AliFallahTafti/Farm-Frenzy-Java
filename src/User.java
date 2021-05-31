public class User {

    private String username;
    private String password;
    private int coins;
    private int level;
    private int stars;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.level=1;
        this.coins=0;
        this.stars=0;
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

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
