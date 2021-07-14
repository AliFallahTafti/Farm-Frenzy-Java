import javafx.scene.control.PasswordField;
import javafx.scene.layout.Background;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageProducer;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Set;

public class Graphic extends JFrame{
    private Manager manager;
    private FileManagement fileManagement;
    private Loader loader;
    private Player player;
    private JFrame frame;
    private JPanel panel;
    private Font bigFont;
    private Font smallFont;
    private static final long serialVersionUID = 1L;
    private SwingWorker<Void, Void> worker;

    public Graphic() throws IOException, JavaLayerException {
//        manager=new Manager();
//        fileManagement=new FileManagement();
//        frame = new JFrame();
//        panel = new JPanel();
//
//        frame.setTitle("Farm Frenzy");
//        frame.setResizable(false);
//        frame.setBounds(250, 100, 800, 600);
//        frame.add(panel);
//
//        loadFont();
//        loadIcon();
//        loadBackground();
//        loadMusic();
//
//        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        manager=new Manager();
        fileManagement=new FileManagement();
        loader=new Loader(fileManagement.getAbsolutePath());
        panel = new JPanel();

        this.setTitle("Farm Frenzy");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setBounds(250, 100, 800, 600);
        this.add(panel);

        loadBackground();
        loadFont();
        loadIcon();
        loadMusic();

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void loadMusic() throws IOException, JavaLayerException {
        player = new Player(loader.backgroundMusic);

        new Thread(){
            @Override
            public void run() {
                try {
                    player.play();
                    if( player.isComplete() )
                    {
                         loadMusic();
                    }
                } catch (JavaLayerException | IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    public void loadBackground() throws IOException {
//        JLabel label=new JLabel();
//        label.setBounds(0,0,800,600);
//
//        Image image=myPicture.getImage();
//        image=image.getScaledInstance(800,600,Image.SCALE_SMOOTH);
//        myPicture=new ImageIcon(image);
//
//
//
//        label.setIcon(myPicture);
//        panel.add(label);
//        frame.pack();


        this.setContentPane(new JLabel(loader.background));
        setLayout(new FlowLayout());
        setBounds(250,100,800,600);
    }

    public void loadGameBackground(int state){
        if(state<=1){
            this.setContentPane(new JLabel(loader.gameBackground1));
        }else if(state==2){
            this.setContentPane(new JLabel(loader.gameBackground2));
        }else if(state==3){
            this.setContentPane(new JLabel(loader.gameBackground3));
        }else if(state==4){
            this.setContentPane(new JLabel(loader.gameBackground4));
        }

        setLayout(new FlowLayout());
        setBounds(250,100,800,600);
    }

    public void loadMap(){
        this.setContentPane(new JLabel(loader.map));
        setLayout(new FlowLayout());
        setBounds(250,100,800,600);
    }

    public void loadFont() {
        bigFont=new Font("Courier", Font.BOLD,60);
        smallFont=new Font("Courier", Font.BOLD,16);
    }

    public void loadIcon() throws IOException {
        this.setIconImage(loader.gameIcon);
    }

    public void playWav(String name) throws IOException {

        InputStream inputStream=new FileInputStream(fileManagement.getAbsolutePath()+"\\resources\\Music\\"+name+".wav");
        AudioStream audioStream=new AudioStream(inputStream);
        AudioPlayer.player.start(audioStream);

    }

    public void graphicProcessing() throws IOException {
        this.getContentPane().removeAll();
        this.getRootPane().updateUI();
        this.setLayout(null);

        JLabel welcome=new JLabel("WELCOME");
        welcome.setFont(bigFont);
        welcome.setBounds(240,100,400,60);


        ImageIcon imageIcon=loader.loginButton;
        Image image=imageIcon.getImage();
        image=image.getScaledInstance(160,80,Image.SCALE_SMOOTH);
        imageIcon=new ImageIcon(image);


        JButton log=new JButton();
        log.setOpaque(false);
        log.setContentAreaFilled(false);
        log.setBorderPainted(false);
        log.setBounds(320,300,160,80);
        log.setIcon(imageIcon);
        this.getContentPane().add(log);
        this.getContentPane().add(welcome);


        log.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    playWav("click");
                    login();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });


        imageIcon=loader.signupButton;
        image=imageIcon.getImage();
        image=image.getScaledInstance(160,80,Image.SCALE_SMOOTH);
        imageIcon=new ImageIcon(image);

        JButton sign=new JButton();
        sign.setOpaque(false);
        sign.setContentAreaFilled(false);
        sign.setBorderPainted(false);
        sign.setBounds(320,400,160,80);
        sign.setIcon(imageIcon);
        this.getContentPane().add(sign);

        sign.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    playWav("click");
                    signup();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        this.setVisible(true);
    }

    public void login(){
        this.getContentPane().removeAll();
        this.getRootPane().updateUI();
        this.setLayout(null);

        JLabel login=new JLabel("LOGIN");
        login.setFont(bigFont);
        login.setBounds(300,100,400,60);
        this.getContentPane().add(login);



        JTextField textField=new JTextField("Enter Your Username");
        textField.setBounds(300,300,200,40);
        textField.setBackground(Color.BLACK);
        textField.setForeground(Color.GRAY);
        textField.setFont(smallFont);
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                String tempString = textField.getText();
                if (tempString.equals("Enter Your Username")){
                    textField.setText("");
                    textField.setForeground(Color.WHITE);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                String tempString = textField.getText();
                if(tempString.equals("")) {
                    textField.setForeground(Color.GRAY);
                    textField.setText("Enter Your Username");
                }
            }
        });
        this.getContentPane().add(textField);


        JTextField passwordField=new JTextField("Enter Your Password");
        passwordField.setBounds(300,350,200,40);
        passwordField.setBackground(Color.BLACK);
        passwordField.setForeground(Color.GRAY);
        passwordField.setFont(smallFont);
        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                String tempString = passwordField.getText();
                if (tempString.equals("Enter Your Password")){
                    passwordField.setText("");
                    passwordField.setForeground(Color.WHITE);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                String tempString = passwordField.getText();
                if(tempString.equals("")) {
                    passwordField.setForeground(Color.GRAY);
                    passwordField.setText("Enter Your Password");
                }
            }
        });
        this.getContentPane().add(passwordField);

        ImageIcon myPicture = loader.loginButton;
        Image image=myPicture.getImage();
        image=image.getScaledInstance(160,80,Image.SCALE_SMOOTH);
        myPicture=new ImageIcon(image);


        JButton log=new JButton();
        log.setOpaque(false);
        log.setContentAreaFilled(false);
        log.setBorderPainted(false);
        log.setBounds(320,450,160,80);
        log.setIcon(myPicture);
        this.getContentPane().add(log);

        JLabel info=new JLabel();
        info.setBounds(315,420,300,25);
        info.setFont(smallFont);
        log.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    playWav("click");
                    String user=textField.getText();
                    String pass=passwordField.getText();

                    if(manager.login(user,pass)==0){
                        setTransientText(info,"WRONG PASSWORD !!",2000);
                    }else if(manager.login(user,pass)==2){
                        setTransientText(info,"USER NOT FOUND !!",2000);
                    }else{
                        menu(1);
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        this.getContentPane().add(info);

        this.setVisible(true);
    }

    public void signup(){
        this.getContentPane().removeAll();
        this.getRootPane().updateUI();
        this.setLayout(null);

        JLabel signup=new JLabel("SIGNUP");
        signup.setFont(bigFont);
        signup.setBounds(280,100,400,60);
        this.getContentPane().add(signup);



        JTextField textField=new JTextField("Enter Your Username");
        textField.setBounds(300,300,200,40);
        textField.setBackground(Color.BLACK);
        textField.setForeground(Color.GRAY);
        textField.setFont(smallFont);
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                String tempString = textField.getText();
                if (tempString.equals("Enter Your Username")){
                    textField.setText("");
                    textField.setForeground(Color.WHITE);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                String tempString = textField.getText();
                if(tempString.equals("")) {
                    textField.setForeground(Color.GRAY);
                    textField.setText("Enter Your Username");
                }
            }
        });
        this.getContentPane().add(textField);


        JTextField passwordField=new JTextField("Enter Your Password");
        passwordField.setBounds(300,350,200,40);
        passwordField.setBackground(Color.BLACK);
        passwordField.setForeground(Color.GRAY);
        passwordField.setFont(smallFont);
        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                String tempString = passwordField.getText();
                if (tempString.equals("Enter Your Password")){
                    passwordField.setText("");
                    passwordField.setForeground(Color.WHITE);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                String tempString = passwordField.getText();
                if(tempString.equals("")) {
                    passwordField.setForeground(Color.GRAY);
                    passwordField.setText("Enter Your Password");
                }
            }
        });
        this.getContentPane().add(passwordField);

        ImageIcon myPicture =loader.signupButton;
        Image image=myPicture.getImage();
        image=image.getScaledInstance(160,80,Image.SCALE_SMOOTH);
        myPicture=new ImageIcon(image);


        JButton sign=new JButton();
        sign.setOpaque(false);
        sign.setContentAreaFilled(false);
        sign.setBorderPainted(false);
        sign.setBounds(320,450,160,80);
        sign.setIcon(myPicture);
        this.getContentPane().add(sign);

        JLabel info=new JLabel();
        info.setBounds(315,420,300,25);
        info.setFont(smallFont);
        sign.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    playWav("click");
                    String user=textField.getText();
                    String pass=passwordField.getText();

                    if(manager.signup(user,pass)==0){
                        setTransientText(info,"USERNAME IS AVAILABLE",2000);
                    }else{
                        menu(2);
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        this.getContentPane().add(info);

        this.setVisible(true);
    }

    public void menu(int state){
        this.getContentPane().removeAll();
        this.getRootPane().updateUI();
        this.setLayout(null);

        JLabel info=new JLabel();
        info.setBounds(315,500,300,25);
        info.setFont(smallFont);


        if(state==1){
            setTransientText(info,"LOGIN SUCCESSFULLY!",2000);
        }else{
            setTransientText(info,"SIGNUP SUCCESSFULLY",2000);
        }
        this.getContentPane().add(info);


        JLabel menu=new JLabel("MENU");
        menu.setFont(bigFont);
        menu.setBounds(310,100,400,60);
        this.getContentPane().add(menu);


        ImageIcon myPicture = loader.startButton;
        Image image=myPicture.getImage();
        image=image.getScaledInstance(160,80,Image.SCALE_SMOOTH);
        myPicture=new ImageIcon(image);


        JButton start=new JButton();
        start.setOpaque(false);
        start.setContentAreaFilled(false);
        start.setBorderPainted(false);
        start.setBounds(320,300,160,80);
        start.setIcon(myPicture);
        this.getContentPane().add(start);

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    playWav("click");
                    startMap();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        myPicture = loader.exitButton;
        image=myPicture.getImage();
        image=image.getScaledInstance(160,80,Image.SCALE_SMOOTH);
        myPicture=new ImageIcon(image);


        JButton exit=new JButton();
        exit.setOpaque(false);
        exit.setContentAreaFilled(false);
        exit.setBorderPainted(false);
        exit.setBounds(320,400,160,80);
        exit.setIcon(myPicture);
        this.getContentPane().add(exit);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    playWav("click");
                    manager.exit();
                    player.close();
                    getContentPane().removeAll();
                    dispose();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });


        myPicture =loader.backButton;
        image=myPicture.getImage();
        image=image.getScaledInstance(100,50,Image.SCALE_SMOOTH);
        myPicture=new ImageIcon(image);


        JButton back=new JButton();
        back.setOpaque(false);
        back.setContentAreaFilled(false);
        back.setBorderPainted(false);
        back.setBounds(650,480,100,50);
        back.setIcon(myPicture);
        this.getContentPane().add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    playWav("click");
                    manager.logout();
                    graphicProcessing();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        this.setVisible(true);
    }

    public void startMap(){
        loadMap();

        this.getRootPane().updateUI();
        this.setLayout(null);


        ImageIcon myPicture = loader.mapLevel1;
        Image image=myPicture.getImage();
        image=image.getScaledInstance(70,70,Image.SCALE_SMOOTH);
        myPicture=new ImageIcon(image);


        boolean[] isActive=new boolean[5];
        Arrays.fill(isActive,false);
        JButton[] map=new JButton[5];
        map[0]=new JButton();
        map[0].setOpaque(false);
        map[0].setContentAreaFilled(false);
        map[0].setBorderPainted(false);
        map[0].setIcon(myPicture);
        map[0].setBounds(380,430,70,70);
        this.getContentPane().add(map[0]);
        map[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    playWav("click");
                    startGame(1);
                } catch (IOException | CloneNotSupportedException ioException) {
                    ioException.printStackTrace();
                }
            }
        });


        map[1]=new JButton();
        map[1].setOpaque(false);
        map[1].setContentAreaFilled(false);
        map[1].setBorderPainted(false);
        map[1].setBounds(210,350,70,70);
        if(1<manager.getUser().getLevel()){
            myPicture = loader.mapLevel2;
            isActive[1]=true;
        }else{
            myPicture =loader.mapLockLevel2;
        }
        image=myPicture.getImage();
        image=image.getScaledInstance(70,70,Image.SCALE_SMOOTH);
        myPicture=new ImageIcon(image);
        map[1].setIcon(myPicture);
        this.getContentPane().add(map[1]);
        map[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    playWav("click");
                    if(isActive[1]){
                        startGame(2);
                    }
                } catch (IOException | CloneNotSupportedException ioException) {
                    ioException.printStackTrace();
                }
            }
        });



        map[2]=new JButton();
        map[2].setOpaque(false);
        map[2].setContentAreaFilled(false);
        map[2].setBorderPainted(false);
        map[2].setBounds(410,238,70,70);
        if(2<manager.getUser().getLevel()){
            myPicture =loader.mapLevel3;
            isActive[2]=true;
        }else{
            myPicture =loader.mapLockLevel3;
        }
        image=myPicture.getImage();
        image=image.getScaledInstance(70,70,Image.SCALE_SMOOTH);
        myPicture=new ImageIcon(image);
        map[2].setIcon(myPicture);
        this.getContentPane().add(map[2]);
        map[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    playWav("click");
                    if(isActive[2]){
                        startGame(3);
                    }
                } catch (IOException | CloneNotSupportedException ioException) {
                    ioException.printStackTrace();
                }
            }
        });


        map[3]=new JButton();
        map[3].setOpaque(false);
        map[3].setContentAreaFilled(false);
        map[3].setBorderPainted(false);
        map[3].setBounds(520,125,70,70);
        if(3<manager.getUser().getLevel()){
            myPicture = loader.mapLevel4;
            isActive[3]=true;
        }else{
            myPicture =loader.mapLockLevel4;
        }
        image=myPicture.getImage();
        image=image.getScaledInstance(70,70,Image.SCALE_SMOOTH);
        myPicture=new ImageIcon(image);
        map[3].setIcon(myPicture);
        this.getContentPane().add(map[3]);
        map[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    playWav("click");
                    if(isActive[3]){
                        startGame(4);
                    }
                } catch (IOException | CloneNotSupportedException ioException) {
                    ioException.printStackTrace();
                }
            }
        });


        map[4]=new JButton();
        map[4].setOpaque(false);
        map[4].setContentAreaFilled(false);
        map[4].setBorderPainted(false);
        map[4].setBounds(466,10,70,70);
        if(4<manager.getUser().getLevel()){
            myPicture = loader.mapLevel5;
            isActive[4]=true;
        }else{
            myPicture =loader.mapLockLevel5;
        }
        image=myPicture.getImage();
        image=image.getScaledInstance(70,70,Image.SCALE_SMOOTH);
        myPicture=new ImageIcon(image);
        map[4].setIcon(myPicture);
        this.getContentPane().add(map[4]);
        map[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    playWav("click");
                    if(isActive[4]){
                        startGame(5);
                    }
                } catch (IOException | CloneNotSupportedException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
    }

    public void startGame(int level) throws CloneNotSupportedException {
        manager.start(level);
        loadGameBackground(manager.getNumberOfFactory());

        this.getRootPane().updateUI();
        this.setLayout(null);

        preGame(level);
        showComponent();
        setVisible(true);
    }

    public void preGame(int level){
        JLabel label=new JLabel();
        label.setBounds(300,200,200,200);
        ImageIcon myPicture;


        if(level==1){
            myPicture=loader.preLevel1;
        }else if(level==2){
            myPicture=loader.preLevel2;
        }else if(level==3){
            myPicture=loader.preLevel3;
        }else if(level==4){
            myPicture=loader.preLevel4;
        }else{
            myPicture=loader.preLevel5;
        }

        Image image=myPicture.getImage();
        image=image.getScaledInstance(200,200,Image.SCALE_SMOOTH);
        myPicture=new ImageIcon(image);
        label.setIcon(myPicture);
        Timer timer=new Timer(1000, e -> label.setVisible(false));
        timer.setRepeats(false);
        timer.start();
        this.getContentPane().add(label);

        myPicture=loader.getReady;
        image=myPicture.getImage();
        image=image.getScaledInstance(200,200,Image.SCALE_SMOOTH);
        myPicture=new ImageIcon(image);

        JLabel label1=new JLabel();
        label1.setBounds(300,200,200,200);
        label1.setIcon(myPicture);
        timer=new Timer(2000, e -> label1.setVisible(false));
        timer.setRepeats(false);
        timer.start();
        getContentPane().add(label1);
    }

    public void showComponent(){
        //well
        ImageIcon myPicture=loader.well;
        Image image=myPicture.getImage();
        image=image.getScaledInstance(140,140,Image.SCALE_SMOOTH);
        myPicture=new ImageIcon(image);

        JButton well=new JButton();
        well.setOpaque(false);
        well.setContentAreaFilled(false);
        well.setBorderPainted(false);
        well.setBounds(310,5,140,140);
        well.setIcon(myPicture);
        this.getContentPane().add(well);
        well.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int c=manager.well();
                    if(c==1) {
                        playWav("water");
                    }else if(c==0){
                        playWav("invalid");
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        //well progress
        if(manager.getWaterSupplying().getCapacity()==0){
            myPicture=loader.wellFill0;
        }else if(manager.getWaterSupplying().getCapacity()==1){
            myPicture=loader.wellFill1;
        }else if(manager.getWaterSupplying().getCapacity()==2){
            myPicture=loader.wellFill2;
        }else if(manager.getWaterSupplying().getCapacity()==3){
            myPicture=loader.wellFill3;
        }else if(manager.getWaterSupplying().getCapacity()==4){
            myPicture=loader.wellFill4;
        }else if(manager.getWaterSupplying().getCapacity()==5){
            myPicture=loader.wellFill5;
        }
        image=myPicture.getImage();
        image=image.getScaledInstance(20,60,Image.SCALE_SMOOTH);
        myPicture=new ImageIcon(image);
        JLabel wellProgress=new JLabel();
        wellProgress.setBounds(300,50,15,60);
        wellProgress.setIcon(myPicture);
        getContentPane().add(wellProgress);


        //storeroom

        myPicture=loader.storeRoom;
        image=myPicture.getImage();
        image=image.getScaledInstance(200,180,Image.SCALE_SMOOTH);
        myPicture=new ImageIcon(image);

        JButton storeRoom=new JButton();
        storeRoom.setOpaque(false);
        storeRoom.setContentAreaFilled(false);
        storeRoom.setBorderPainted(false);
        storeRoom.setBounds(300,400,200,180);
        storeRoom.setIcon(myPicture);
        this.getContentPane().add(storeRoom);
        storeRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
            }
        });



        //information

        JLabel money=new JLabel();
        money.setBounds(500,20,100,40);
        myPicture=loader.wideButton;
        image=myPicture.getImage();
        image=image.getScaledInstance(100,40,Image.SCALE_SMOOTH);
        myPicture=new ImageIcon(image);

        money.setIcon(myPicture);
        myPicture=loader.coin;
        image=myPicture.getImage();
        image=image.getScaledInstance(30,30,Image.SCALE_SMOOTH);
        myPicture=new ImageIcon(image);
        JLabel coin=new JLabel();
        coin.setBounds(5,5,30,30);
        coin.setIcon(myPicture);

        JLabel amount=new JLabel(manager.getUser().getCoins()+"$");
        amount.setFont(smallFont);
        amount.setBounds(40,5,80,30);
        money.add(amount);
        money.add(coin);
        getContentPane().add(money);

        JLabel info=new JLabel();
        info.setBounds(580,420,180,130);
        myPicture=loader.woodSurface;
        image=myPicture.getImage();
        image=image.getScaledInstance(180,130,Image.SCALE_SMOOTH);
        myPicture=new ImageIcon(image);
        info.setIcon(myPicture);
        getContentPane().add(info);

        Set<String> productKeys=manager.getMission().productTasks.keySet();
        Set<String >animalKeys=manager.getMission().animalTask.keySet();
        int counter=0;
        for(String productKey: productKeys){
            JLabel icon=new JLabel();
            icon.setBounds(50,10+counter*30,30,30);
            icon.setIcon(loader.loadProductIcon(productKey,30,30));
            JLabel label=new JLabel(manager.getMission().productTasks.get(productKey)+"/"+manager.getMissions().get(manager.getLevel()-1).productTasks.get(productKey));
            label.setFont(smallFont);
            label.setBounds(90,15+counter*30,150,20);
            info.add(label);
            info.add(icon);
            ++counter;
        }
        for(String animalKey: animalKeys){
            JLabel icon=new JLabel();
            icon.setBounds(50,10+counter*30,30,30);
            icon.setIcon(loader.loadAnimalIcon(animalKey,30,30));
            JLabel label=new JLabel(manager.getMission().animalTask.get(animalKey)+"/"+manager.getMissions().get(manager.getLevel()-1).animalTask.get(animalKey));
            label.setFont(smallFont);
            label.setBounds(90,15+counter*30,150,20);
            info.add(label);
            info.add(icon);
            ++counter;
        }


        JLabel time=new JLabel();
        time.setBounds(680,370,100,40);
        myPicture=loader.wideButton;
        image=myPicture.getImage();
        image=image.getScaledInstance(100,40,Image.SCALE_SMOOTH);
        myPicture=new ImageIcon(image);

        time.setIcon(myPicture);
        myPicture=loader.time;
        image=myPicture.getImage();
        image=image.getScaledInstance(20,20,Image.SCALE_SMOOTH);
        myPicture=new ImageIcon(image);
        JLabel timel=new JLabel();
        timel.setBounds(10,10,20,20);
        timel.setIcon(myPicture);

        JLabel timeAmount=new JLabel(String.valueOf(manager.getTimeIndex()));
        timeAmount.setFont(smallFont);
        timeAmount.setBounds(50,5,80,30);
        time.add(timeAmount);
        time.add(timel);
        getContentPane().add(time);



        //show truck

        myPicture=loader.truck;
        image=myPicture.getImage();
        image=image.getScaledInstance(160,160,Image.SCALE_SMOOTH);
        myPicture=new ImageIcon(image);

        JButton truck=new JButton();
        truck.setOpaque(false);
        truck.setContentAreaFilled(false);
        truck.setBorderPainted(false);
        truck.setBounds(140,400,160,160);
        truck.setIcon(myPicture);
        this.getContentPane().add(truck);
        truck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
            }
        });


        //animal buy button
        myPicture=loader.buyChickenButton;
        image=myPicture.getImage();
        image=image.getScaledInstance(55,55,Image.SCALE_SMOOTH);
        myPicture=new ImageIcon(image);
        JButton buyChicken=new JButton();
        buyChicken.setOpaque(false);
        buyChicken.setContentAreaFilled(false);
        buyChicken.setBorderPainted(false);
        buyChicken.setBounds(5,5,55,55);
        buyChicken.setIcon(myPicture);
        this.getContentPane().add(buyChicken);
        buyChicken.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    playWav("chicken");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });


        myPicture=loader.buyTurkeyButton;
        image=myPicture.getImage();
        image=image.getScaledInstance(55,55,Image.SCALE_SMOOTH);
        myPicture=new ImageIcon(image);
        JButton buyTurkey=new JButton();
        buyTurkey.setOpaque(false);
        buyTurkey.setContentAreaFilled(false);
        buyTurkey.setBorderPainted(false);
        buyTurkey.setBounds(60,5,55,55);
        buyTurkey.setIcon(myPicture);
        this.getContentPane().add(buyTurkey);
        buyTurkey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    playWav("turkey");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });


        myPicture=loader.buyBuffaloButton;
        image=myPicture.getImage();
        image=image.getScaledInstance(55,55,Image.SCALE_SMOOTH);
        myPicture=new ImageIcon(image);
        JButton buyBuffalo=new JButton();
        buyBuffalo.setOpaque(false);
        buyBuffalo.setContentAreaFilled(false);
        buyBuffalo.setBorderPainted(false);
        buyBuffalo.setBounds(115,5,55,55);
        buyBuffalo.setIcon(myPicture);
        this.getContentPane().add(buyBuffalo);
        buyBuffalo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    playWav("buffalo");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });


        myPicture=loader.buyCatButton;
        image=myPicture.getImage();
        image=image.getScaledInstance(55,55,Image.SCALE_SMOOTH);
        myPicture=new ImageIcon(image);
        JButton buyCat=new JButton();
        buyCat.setOpaque(false);
        buyCat.setContentAreaFilled(false);
        buyCat.setBorderPainted(false);
        buyCat.setBounds(170,5,55,55);
        buyCat.setIcon(myPicture);
        this.getContentPane().add(buyCat);
        buyCat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    playWav("cat");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });


        myPicture=loader.buyDogButton;
        image=myPicture.getImage();
        image=image.getScaledInstance(55,55,Image.SCALE_SMOOTH);
        myPicture=new ImageIcon(image);
        JButton buyDog=new JButton();
        buyDog.setOpaque(false);
        buyDog.setContentAreaFilled(false);
        buyDog.setBorderPainted(false);
        buyDog.setBounds(225,5,55,55);
        buyDog.setIcon(myPicture);
        this.getContentPane().add(buyDog);
        buyDog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    playWav("dog");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });


        //show animals show products





        //plant





        //workshop







        myPicture=loader.pauseButton;
        image=myPicture.getImage();
        image=image.getScaledInstance(100,50,Image.SCALE_SMOOTH);
        myPicture=new ImageIcon(image);
        JButton pause=new JButton();
        pause.setOpaque(false);
        pause.setContentAreaFilled(false);
        pause.setBorderPainted(false);
        pause.setBounds(650,50,100,50);
        pause.setIcon(myPicture);
        this.getContentPane().add(pause);
        pause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    playWav("click");
                    pause();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });



        myPicture=loader.turnButton;
        image=myPicture.getImage();
        image=image.getScaledInstance(100,50,Image.SCALE_SMOOTH);
        myPicture=new ImageIcon(image);
        JButton turn=new JButton();
        turn.setOpaque(false);
        turn.setContentAreaFilled(false);
        turn.setBorderPainted(false);
        turn.setBounds(650,5,100,50);
        turn.setIcon(myPicture);
        this.getContentPane().add(turn);
        turn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    playWav("click");
                    //TODO
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
    }

    public void pause(){
        getContentPane().removeAll();
        this.getRootPane().updateUI();
        this.setLayout(null);
        JLabel label=new JLabel();
        label.setBounds(250,100,300,400);

        ImageIcon myPicture=loader.woodButton;
        Image image=myPicture.getImage();
        image=image.getScaledInstance(300,400,Image.SCALE_SMOOTH);
        myPicture=new ImageIcon(image);

        label.setIcon(myPicture);
        getContentPane().add(label);


        myPicture=loader.resumeButton;
        image=myPicture.getImage();
        image=image.getScaledInstance(100,50,Image.SCALE_SMOOTH);
        myPicture=new ImageIcon(image);
        JButton resume=new JButton();
        resume.setOpaque(false);
        resume.setContentAreaFilled(false);
        resume.setBorderPainted(false);
        resume.setBounds(100,120,100,50);
        resume.setIcon(myPicture);
        label.add(resume);
        resume.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    playWav("click");
                    getContentPane().removeAll();
                    getRootPane().updateUI();
                    setLayout(null);
                    showComponent();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });


        myPicture=loader.backButton;
        image=myPicture.getImage();
        image=image.getScaledInstance(100,50,Image.SCALE_SMOOTH);
        myPicture=new ImageIcon(image);
        JButton back=new JButton();
        back.setOpaque(false);
        back.setContentAreaFilled(false);
        back.setBorderPainted(false);
        back.setBounds(100,180,100,50);
        back.setIcon(myPicture);
        label.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    playWav("click");
                    manager.logout();
                    loadBackground();
                    graphicProcessing();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });


        myPicture=loader.exitButton;
        image=myPicture.getImage();
        image=image.getScaledInstance(100,50,Image.SCALE_SMOOTH);
        myPicture=new ImageIcon(image);
        JButton exit=new JButton();
        exit.setOpaque(false);
        exit.setContentAreaFilled(false);
        exit.setBorderPainted(false);
        exit.setBounds(100,240,100,50);
        exit.setIcon(myPicture);
        label.add(exit);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    playWav("click");
                    manager.exit();
                    player.close();
                    getContentPane().removeAll();
                    dispose();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
    }

    public void setTransientText(JLabel label1,String text, long duration) {

        if (worker != null && !worker.isDone()) return;

        final String originalText = label1.getText();
        worker = new SwingWorker<Void, Void>() {

            @Override
            protected Void doInBackground() throws Exception {
                label1.setText(text);
                Thread.sleep(duration);
                return null;
            }

            @Override
            protected void done() {
                label1.setText(originalText);
            }
        };
        worker.execute();
    }

}
