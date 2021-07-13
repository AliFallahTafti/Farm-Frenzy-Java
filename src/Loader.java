import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Loader {
    private String path;
    public ImageIcon background;
    public ImageIcon map;
    public BufferedInputStream backgroundMusic;
    public BufferedImage gameIcon ;
    public ImageIcon loginButton;
    public ImageIcon signupButton;
    public ImageIcon startButton;
    public ImageIcon exitButton;
    public ImageIcon backButton;
    public ImageIcon turnButton;
    public ImageIcon mapLevel1;
    public ImageIcon mapLevel2;
    public ImageIcon mapLevel3;
    public ImageIcon mapLevel4;
    public ImageIcon mapLevel5;
    public ImageIcon mapLockLevel2;
    public ImageIcon mapLockLevel3;
    public ImageIcon mapLockLevel4;
    public ImageIcon mapLockLevel5;
    public ImageIcon gameBackground1;
    public ImageIcon gameBackground2;
    public ImageIcon gameBackground3;
    public ImageIcon gameBackground4;
    public ImageIcon preLevel1;
    public ImageIcon preLevel2;
    public ImageIcon preLevel3;
    public ImageIcon preLevel4;
    public ImageIcon preLevel5;
    public ImageIcon getReady;
    public ImageIcon well;
    public ImageIcon wellFill0;
    public ImageIcon wellFill1;
    public ImageIcon wellFill2;
    public ImageIcon wellFill3;
    public ImageIcon wellFill4;
    public ImageIcon wellFill5;


    public Loader(String path) throws IOException {
        this.path=path;
        background=new ImageIcon(path+"\\resources\\GameUI\\background2.png");
        map=new ImageIcon(path+"\\resources\\GameUI\\map.png");
        backgroundMusic= new BufferedInputStream(new FileInputStream(path+"\\resources\\Music\\background.mp3"));
        gameIcon= ImageIO.read(new File(path+"\\resources\\GameUI\\GameIcon.jpg"));
        loginButton=new ImageIcon(path+"\\resources\\GameUI\\button\\loginbutton.png");
        signupButton=new ImageIcon(path+"\\resources\\GameUI\\button\\signupbutton.png");
        startButton=new ImageIcon(path+"\\resources\\GameUI\\button\\startbutton.png");
        exitButton=new ImageIcon(path+"\\resources\\GameUI\\button\\exitbutton.png");
        backButton= new ImageIcon(path+"\\resources\\GameUI\\button\\backbutton.png");
        turnButton=new ImageIcon(path+"\\resources\\GameUI\\button\\turnbutton.png");
        mapLevel1=new ImageIcon(path+"\\resources\\GameUI\\button\\level1.png");
        mapLevel2=new ImageIcon(path+"\\resources\\GameUI\\button\\level2.png");
        mapLevel3=new ImageIcon(path+"\\resources\\GameUI\\button\\level3.png");
        mapLevel4=new ImageIcon(path+"\\resources\\GameUI\\button\\level4.png");
        mapLevel5=new ImageIcon(path+"\\resources\\GameUI\\button\\level5.png");
        mapLockLevel2= new ImageIcon(path+"\\resources\\GameUI\\button\\lockedlevel2.png");
        mapLockLevel3= new ImageIcon(path+"\\resources\\GameUI\\button\\lockedlevel3.png");
        mapLockLevel4= new ImageIcon(path+"\\resources\\GameUI\\button\\lockedlevel4.png");
        mapLockLevel5= new ImageIcon(path+"\\resources\\GameUI\\button\\lockedlevel5.png");
        gameBackground1=new ImageIcon(path+"\\resources\\GameUI\\gamebackground\\back1.png");
        gameBackground2=new ImageIcon(path+"\\resources\\GameUI\\gamebackground\\back2.png");
        gameBackground3=new ImageIcon(path+"\\resources\\GameUI\\gamebackground\\back3.png");
        gameBackground4=new ImageIcon(path+"\\resources\\GameUI\\gamebackground\\back4.png");
        preLevel1=new ImageIcon(path+"\\resources\\GameUI\\button\\gamelevel1.png");
        preLevel2=new ImageIcon(path+"\\resources\\GameUI\\button\\gamelevel2.png");
        preLevel3=new ImageIcon(path+"\\resources\\GameUI\\button\\gamelevel3.png");
        preLevel4=new ImageIcon(path+"\\resources\\GameUI\\button\\gamelevel4.png");
        preLevel5=new ImageIcon(path+"\\resources\\GameUI\\button\\gamelevel5.png");
        getReady=new ImageIcon(path+"\\resources\\GameUI\\button\\getready.png");
        well=new ImageIcon(path+"\\resources\\GameUI\\well\\well.png");
        wellFill0=new ImageIcon(path+"\\resources\\GameUI\\well\\full0.png");
        wellFill1=new ImageIcon(path+"\\resources\\GameUI\\well\\full1.png");
        wellFill2=new ImageIcon(path+"\\resources\\GameUI\\well\\full2.png");
        wellFill3=new ImageIcon(path+"\\resources\\GameUI\\well\\full3.png");
        wellFill4=new ImageIcon(path+"\\resources\\GameUI\\well\\full4.png");
        wellFill5=new ImageIcon(path+"\\resources\\GameUI\\well\\full5.png");

    }
}
