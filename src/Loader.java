import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Locale;

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
    public ImageIcon pauseButton;
    public ImageIcon resumeButton;
    public ImageIcon woodButton;
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
    public ImageIcon storeRoom;
    public ImageIcon wideButton;
    public ImageIcon coin;
    public ImageIcon woodSurface;
    public ImageIcon time;
    public ImageIcon egg;
    public ImageIcon milk;
    public ImageIcon packedMilk;
    public ImageIcon feather;
    public ImageIcon clothes;
    public ImageIcon dress;
    public ImageIcon iceCream;
    public ImageIcon eggPowder;
    public ImageIcon bread;
    public ImageIcon chicken;
    public ImageIcon turkey;
    public ImageIcon buffalo;
    public ImageIcon cat;
    public ImageIcon dog;
    public ImageIcon truck;
    public ImageIcon buyChickenButton;
    public ImageIcon buyTurkeyButton;
    public ImageIcon buyBuffaloButton;
    public ImageIcon buyCatButton;
    public ImageIcon buyDogButton;
    public ImageIcon grass4;
    public ImageIcon grass1;
    public ImageIcon grass2;
    public ImageIcon grass3;
    public ImageIcon storeRoomBack;
    public ImageIcon upgrade;
    public ImageIcon gameOver;
    public ImageIcon victory;


    public Loader(String path) throws IOException {
        this.path=path;
        background=new ImageIcon(path+"\\resources\\GameUI\\background2.png");
        map=new ImageIcon(path+"\\resources\\GameUI\\map.png");
        backgroundMusic= new BufferedInputStream(new FileInputStream(path+"\\resources\\Music\\background.mp3"));
        gameIcon= ImageIO.read(new File(path+"\\resources\\GameUI\\GameIcon.jpg"));
        loginButton=new ImageIcon(path+"\\resources\\GameUI\\button\\wloginbutton.png");
        signupButton=new ImageIcon(path+"\\resources\\GameUI\\button\\wsignupbutton.png");
        startButton=new ImageIcon(path+"\\resources\\GameUI\\button\\wstartbutton.png");
        exitButton=new ImageIcon(path+"\\resources\\GameUI\\button\\wexitbutton.png");
        backButton= new ImageIcon(path+"\\resources\\GameUI\\button\\wbackloginbutton.png");
        turnButton=new ImageIcon(path+"\\resources\\GameUI\\button\\wturnbutton.png");
        pauseButton=new ImageIcon(path+"\\resources\\GameUI\\button\\wpausebutton.png");
        resumeButton=new ImageIcon(path+"\\resources\\GameUI\\button\\wresumebutton.png");
        woodButton=new ImageIcon(path+"\\resources\\GameUI\\button\\woodbutton.png");
        wideButton=new ImageIcon(path+"\\resources\\GameUI\\button\\widebutton.png");
        buyChickenButton=new ImageIcon(path+"\\resources\\GameUI\\button\\animals\\chickenbutton.png");
        buyBuffaloButton=new ImageIcon(path+"\\resources\\GameUI\\button\\animals\\buffalobutton.png");
        buyCatButton=new ImageIcon(path+"\\resources\\GameUI\\button\\animals\\catbutton.png");
        buyDogButton=new ImageIcon(path+"\\resources\\GameUI\\button\\animals\\dogbutton.png");
        buyTurkeyButton=new ImageIcon(path+"\\resources\\GameUI\\button\\animals\\turkeybutton.png");
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
        storeRoom=new ImageIcon(path+"\\resources\\GameUI\\storeroom\\storeroom.png");
        coin=new ImageIcon(path+"\\resources\\GameUI\\coin.png");
        woodSurface=new ImageIcon(path+"\\resources\\GameUI\\button\\woodsurface.png");
        time=new ImageIcon(path+"\\resources\\GameUI\\time.png");
        truck=new ImageIcon(path+"\\resources\\GameUI\\truck\\truck.png");
        storeRoomBack=new ImageIcon(path+"\\resources\\GameUI\\storeroom\\storeroommenu.png");
        upgrade=new ImageIcon(path+"\\resources\\Workshop\\button\\upgrade.png");
        gameOver=new ImageIcon(path+"\\resources\\GameUI\\button\\gameover.png");
        victory=new ImageIcon(path+"\\resources\\GameUI\\button\\victory.png");
    }

    public ImageIcon loadUpgrade(int w,int h){
        Image image=upgrade.getImage();
        image=image.getScaledInstance(w,h, Image.SCALE_SMOOTH);
        upgrade=new ImageIcon(image);
        return upgrade;
    }
    public ImageIcon loadProductIcon(String name,int w,int h){
        name.toLowerCase(Locale.ROOT);
        ImageIcon myPicture=  new ImageIcon(path+"\\resources\\Products\\"+name+".png");
        Image image=myPicture.getImage();
        image=image.getScaledInstance(w,h, Image.SCALE_SMOOTH);
        myPicture=new ImageIcon(image);
        return myPicture;
    }
    public ImageIcon loadAnimalIcon(String name,int w,int h){
        name.toLowerCase(Locale.ROOT);
        ImageIcon myPicture=  new ImageIcon(path+"\\resources\\GameUI\\button\\animals\\"+name+".png");
        Image image=myPicture.getImage();
        image=image.getScaledInstance(w,h, Image.SCALE_SMOOTH);
        myPicture=new ImageIcon(image);
        return myPicture;
    }
    public ImageIcon loadAnimal(String name,int state,int w,int h){
        name.toLowerCase(Locale.ROOT);
        ImageIcon myPicture=  new ImageIcon(path+"\\resources\\Animal\\"+name+"\\"+state+".png");
        Image image=myPicture.getImage();
        image = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        myPicture=new ImageIcon(image);
        return myPicture;
    }
    public ImageIcon loadGrass(int count,int w,int h){
        if(count>3)
            count=3;
        ImageIcon myPicture=  new ImageIcon(path+"\\resources\\GameUI\\grass\\grass"+(count+1)+".png");
        Image image=myPicture.getImage();
        image=image.getScaledInstance(w,h, Image.SCALE_SMOOTH);
        myPicture=new ImageIcon(image);
        return myPicture;
    }
    public ImageIcon loadFactory(String name,int w,int h){
        name.toLowerCase(Locale.ROOT);
        ImageIcon myPicture=  new ImageIcon(path+"\\resources\\Workshop\\"+name+".png");
        Image image=myPicture.getImage();
        image=image.getScaledInstance(w,h, Image.SCALE_SMOOTH);
        myPicture=new ImageIcon(image);
        return myPicture;
    }    public ImageIcon loadFactoryIcon(String name,int w,int h){
        name.toLowerCase(Locale.ROOT);
        ImageIcon myPicture=  new ImageIcon(path+"\\resources\\Workshop\\button\\"+name+".png");
        Image image=myPicture.getImage();
        image=image.getScaledInstance(w,h, Image.SCALE_SMOOTH);
        myPicture=new ImageIcon(image);
        return myPicture;
    }
    public ImageIcon loadUpgradeFactory(String name,int w,int h){
        name.toLowerCase(Locale.ROOT);
        ImageIcon myPicture=  new ImageIcon(path+"\\resources\\Workshop\\"+name+"update.png");
        Image image=myPicture.getImage();
        image=image.getScaledInstance(w,h, Image.SCALE_SMOOTH);
        myPicture=new ImageIcon(image);
        return myPicture;
    }
    public ImageIcon loadProgress(int i,int w,int h){
        int c=i%20;
        if(c!=0){
            c=i/20+1;
        }else
            c=i/20;
        ImageIcon myPicture=  new ImageIcon(path+"\\resources\\progress\\"+c+".png");
        Image image=myPicture.getImage();
        image=image.getScaledInstance(w,h, Image.SCALE_SMOOTH);
        myPicture=new ImageIcon(image);
        return myPicture;
    }
    public ImageIcon loadCage(int i,int w,int h){
        ImageIcon myPicture=  new ImageIcon(path+"\\resources\\cage\\"+(4-i)+".png");
        Image image=myPicture.getImage();
        image=image.getScaledInstance(w,h, Image.SCALE_SMOOTH);
        myPicture=new ImageIcon(image);
        return myPicture;
    }
}
