package sharemarketingsoftware;

import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.*;
import javax.swing.*;
import javax.swing.JFrame; 
import javax.swing.JPanel;
import javax.swing.JScrollPane; 
import javax.swing.JTable; 
import javax.imageio.ImageIO;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public  class Sharemarketingsoftware extends Thread implements ActionListener, ItemListener
{

        Connection myconn=null,dconn=null;
        PreparedStatement ps=null,dps=null;
        Statement stmt=null;
        ResultSet rs=null,drs=null;
        String dburl="jdbc:mysql://localhost:3306/demo";
        String usr="student";
        String pas="student";
        
        JFrame home=new JFrame("Share marketing software");
        
        
        JPanel  homep=new JPanel();
        JPanel logn=new JPanel();
        JPanel  alogin=new JPanel();
        JPanel  n=new JPanel();
        JPanel  cont=new JPanel();
        JPanel  abut=new JPanel();
        JPanel  sus=new JPanel();
        JPanel  share=new JPanel();
        JPanel marquee =new JPanel();
        JPanel  adminpage=new JPanel();
        JPanel  newspage=new JPanel();
        JPanel  datapage=new JPanel();
        JPanel  updatedata=new JPanel();
        JPanel  updatedatapage=new JPanel();
        JPanel  gainer=new JPanel();
        JPanel  losser=new JPanel();
        JPanel  userinfo=new JPanel();
        JPanel  compinfo=new JPanel();
        JPanel  userstatus=new JPanel();
        
        JTextArea ta=new JTextArea(20,28);
        JTextArea newstext=new JTextArea(10,20);
        
        JScrollPane spane=new JScrollPane(ta);
       // JScrollPane panelr=new JScrollPane(share);
    String[] newslist=new String[10];
    int i=0;
        
        JLabel picslide=new JLabel();
        JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l111,log,llogin,lpass,ldesc,c1,c2,c3,c4,c5,c6,c7,c8,d1,d2,d3,d4,d5;
        JLabel u1,u2,u3,u4,u5,u6;
        JTextField a1,a2,a3,a4,a5,a6,a7,a8,a9 ,t1,t2,t3,t5,t6,t7,tlogi,tadd,dt1,dt2,dt3,dt4,dt5,ut1,ut2,ut3,ut4,ut5;
        JTextField tlogin=new JTextField();
        //JTextField tgin=new JTextField();
        JPasswordField tpass=new JPasswordField();
        JTextField tlog=new JTextField();
        JPasswordField tlpass=new JPasswordField();
        
        String[] gen={"Male","Female","Other"};
        String[] list={"D:\\share\\st.jpg","D:\\share\\sdsdd.jpg","D:\\share\\ssss.jpg","D:\\share\\dice.jpg","D:\\share\\money.jpg"};
        
        JComboBox genderbox=new JComboBox(gen); 
        JComboBox statename=new JComboBox(); 
        JComboBox districtname=new JComboBox(); 
        JComboBox cityname=new JComboBox();
        
        JComboBox genderbox1=new JComboBox(gen); 
        JComboBox statename1=new JComboBox(); 
        JComboBox districtname1=new JComboBox(); 
        JComboBox cityname1=new JComboBox();
        
        JButton regbu=new JButton("REGISTER");
        JButton resbu=new JButton("RESET");
        JButton loadButton = new JButton("Browse Image");
        JButton loadButton1 = new JButton("Browse Image");
        JButton logbu=new JButton("Login");
        
        JButton logoutbu1=new JButton("Logout");
        JButton logoutbuad=new JButton("Logout");
        JButton createbu=new JButton("Create New Account");
        JButton editbu=new JButton("Edit");
        JButton updatebu=new JButton("Update");
        JButton admin=new JButton("Login");
        JButton homebu=new JButton("Home");
        JButton userbu=new JButton("User");
        JButton adminbu=new JButton("Admin");
        JButton adminbu1=new JButton("Admin");
        JButton registerbu=new JButton("Register");
        JButton contactbu=new JButton("Contact us");
        JButton aboutbu=new JButton("About");
        JButton profile=new JButton("View profile");
        JButton backbu=new JButton("back");
        JButton news=new JButton("Update news");
        JButton sharedata=new JButton("Upload  data");
        JButton updatesdata=new JButton("Update ");
        JButton updatesharedata=new JButton("Update data");
        JButton searchbu=new JButton("Search");
        JButton uploadnews=new JButton("Upload");
        JButton uploaddata=new JButton("Upload");
        JButton backnews=new JButton("back");
        JButton backdata=new JButton("back");
        JButton backupdate=new JButton("back");
        JButton backuser=new JButton("back");
        JButton backcomp=new JButton("back");
        JButton gainbu=new JButton("view more...");
        JButton losebu=new JButton("view more...");
        JButton gainbu1=new JButton("Gainer");
        JButton losebu1=new JButton("Loser");
        JButton uibu=new JButton("user info");
        JButton cibu=new JButton("comapny info");
        JButton actbu=new JButton("Activate");
        JButton dactbu=new JButton("Deactivate");
        JButton ustatus=new JButton("user status");
        
        Font fn=new Font("ALGERIAN",Font.BOLD,80);
        Font lfn=new Font("ALGERIAN",Font.TYPE1_FONT,30);
        Font tfn=new Font("ARIAL",Font.PLAIN,20);
        Font tlfn=new Font("ARIAL",Font.PLAIN,30);
        Font bfn=new Font("ARIAL",Font.TYPE1_FONT,28);
        
        JTextField tus=new JTextField();
        
        String sname=null,sgander=null,sfather=null,sadd=null,semail=null,sstate=null,sdist=null,scity=null,simg=null,imgpa=null,cname=null,chigh=null,clow=null,clast=null,cchg=null;
        String usrreg,pasreg,conreg,fareg,emareg,addreg,statereg,usrcheck;
        String filename,getn,usrname,faltu,getnn,ct,dt;
        String stat=null;
        String dist=null;
        int il=0;
        int abc=0;
        int temp=0;
        int em=0,imch=0;
        
        Timer tm;
        int x = 0;
        ImageIcon picicon;
 public static void main(String[] args)  {
     
     Sharemarketingsoftware sws=new Sharemarketingsoftware();
     sws.fillnews();
     sws.fillcombox();
     sws.run();
      
    }
 
 public Sharemarketingsoftware()
    {
        home();
       
        
    }
  
 
   

 void home()
 { 
        home.setVisible(true);
        home.setLayout(null);
        home.setSize(2000, 1100);
        home.setLocation(0, 0);
        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container h=home.getContentPane();
        JPanel  pup=new JPanel();
        JPanel  pl=new JPanel();
         
        TitledBorder borderl = BorderFactory.createTitledBorder("BelowTop");
        borderl.setTitlePosition(TitledBorder.LEFT);
        
        homep.setVisible(false);
        homep.setLayout(null);
        homep.setBounds(500, 200, 1500, 900);
        
        
        //homep.add(newsl);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        ImageIcon image = new ImageIcon(new ImageIcon("D:\\share\\dice.jpg").getImage().getScaledInstance(1000, 900, Image.SCALE_DEFAULT));
        JLabel pic=new JLabel(image);
        pic.setBounds(0, 0, 1000, 900);
        homep.add(pic);
        
        
        /*ta.setBounds(100, 100, 500, 100);
        ta.setEditable(false);
        marquee.add(spane);
        spane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        homep.add(marquee);
        marquee.setBounds(1000, 200, 500, 500);*/
        pl.setVisible(true);
        pl.setLayout(null);
        pl.setBackground(Color.decode("#EC7063"));
        pl.setBounds(00, 200, 500, 900);
        JLabel menu=new JLabel("MENU ");
        menu.setBounds(150, 50, 400, 50);
        menu.setFont(fn);
        menu.setForeground(Color.YELLOW);
        
        pl.add(menu);
        userbu.setBounds(150, 180, 400, 60);
        userbu.setFont(bfn);
        userbu.setHorizontalAlignment(JLabel.LEFT);
        userbu.setOpaque(false);
        userbu.setContentAreaFilled(false);
        userbu.setBorderPainted(false);
        userbu.setForeground(Color.WHITE);
        userbu.setBorder(borderl);
        userbu.addActionListener(this);
        pl.add(userbu);
        
        adminbu.setBounds(150, 250, 400, 60);
        adminbu.setFont(bfn);
        adminbu.setHorizontalAlignment(JLabel.LEFT);
        adminbu.setBorder(borderl);
        adminbu.setOpaque(false);
        adminbu.setContentAreaFilled(false);
        adminbu.setBorderPainted(false);
        adminbu.setForeground(Color.white);
        
        adminbu.addActionListener(this);
        pl.add(adminbu);
        
        adminbu1.setBounds(150, 250, 400, 60);
        adminbu1.setFont(bfn);
        adminbu1.setHorizontalAlignment(JLabel.LEFT);
        adminbu1.setBorder(borderl);
        adminbu1.setOpaque(false);
        adminbu1.setContentAreaFilled(false);
        adminbu1.setBorderPainted(false);
        adminbu1.setForeground(Color.white);
        
        adminbu1.addActionListener(this);
        pl.add(adminbu1);
        adminbu1.setVisible(false);
        
        
        registerbu.setBounds(150, 320, 400, 70);
        registerbu.setFont(bfn);
        registerbu.setHorizontalAlignment(JLabel.LEFT);
        registerbu.setOpaque(false);
        registerbu.setContentAreaFilled(false);
        registerbu.setBorderPainted(false);
        registerbu.setForeground(Color.white);
        registerbu.setBorder(borderl);
        registerbu.addActionListener(this);
        pl.add(registerbu);
        
        contactbu.setBounds(140, 400, 400, 60);
        contactbu.setFont(bfn);
        contactbu.setHorizontalAlignment(JLabel.LEFT);
        contactbu.setOpaque(false);
        contactbu.setContentAreaFilled(false);
        contactbu.setBorderPainted(false);
        contactbu.setForeground(Color.white);
        contactbu.addActionListener(this);
        pl.add(contactbu);
        
        aboutbu.setBounds(140, 460, 400, 60);
        aboutbu.setFont(bfn);
        aboutbu.setHorizontalAlignment(JLabel.LEFT);
        aboutbu.setOpaque(false);
        aboutbu.setContentAreaFilled(false);
        aboutbu.setBorderPainted(false);
        aboutbu.setForeground(Color.white);
        aboutbu.addActionListener(this);
        pl.add(aboutbu);
        
        profile.setBounds(140, 180, 400, 60);
        profile.setFont(bfn);
        profile.setHorizontalAlignment(JLabel.LEFT);
        profile.setOpaque(false);
        profile.setContentAreaFilled(false);
        profile.setBorderPainted(false);
        profile.setForeground(Color.white);
        profile.setVisible(false);
        profile.addActionListener(this);
        pl.add(profile);
       
        gainbu1.setBounds(140, 530, 400, 60);
        gainbu1.setFont(bfn);
        gainbu1.setHorizontalAlignment(JLabel.LEFT);
        gainbu1.setOpaque(false);
        gainbu1.setContentAreaFilled(false);
        gainbu1.setBorderPainted(false);
        gainbu1.setForeground(Color.white);
        gainbu1.addActionListener(this);
        pl.add(gainbu1);
        
        losebu1.setBounds(140, 600, 400, 60);
        losebu1.setFont(bfn);
        losebu1.setHorizontalAlignment(JLabel.LEFT);
        losebu1.setOpaque(false);
        losebu1.setContentAreaFilled(false);
        losebu1.setBorderPainted(false);
        losebu1.setForeground(Color.white);
        losebu1.addActionListener(this);
        pl.add(losebu1);
        
        pup.setVisible(true);
        pup.setLayout(null);
        pup.setBackground(Color.decode("#003366"));
        pup.setBounds(00, 00, 2000, 200);
        homebu.setBounds(1600, 150, 150, 40);
        homebu.setFont(bfn);
        homebu.setOpaque(false);
        homebu.setContentAreaFilled(false);
        homebu.setBorderPainted(false);
        homebu.setForeground(Color.red);
        homebu.addActionListener(this);
        pup.add(homebu);
        
        logoutbu1.setBounds(1750, 150, 200, 40);
        logoutbu1.setOpaque(false);
        logoutbu1.setHorizontalAlignment(JLabel.LEFT);
        logoutbu1.setContentAreaFilled(false);
        logoutbu1.setBorderPainted(false);
        logoutbu1.setForeground(Color.red);
        logoutbu1.addActionListener(this);
        logoutbu1.setFont(bfn);
        pup.add(logoutbu1);
        logoutbu1.setVisible(false);
        
        logoutbuad.setBounds(1750, 150, 200, 40);
        logoutbuad.setOpaque(false);
        logoutbuad.setHorizontalAlignment(JLabel.LEFT);
        logoutbuad.setContentAreaFilled(false);
        logoutbuad.setBorderPainted(false);
        logoutbuad.setForeground(Color.red);
        logoutbuad.addActionListener(this);
        logoutbuad.setFont(bfn);
        pup.add(logoutbuad);
        logoutbuad.setVisible(false);
        
        
        JLabel title=new JLabel("SHARE MARKETING");
        title.setFont(fn);
        title.setBounds(700, 50, 800,100 );
        title.setForeground(Color.WHITE);
        pup.add(title);
        
        ImageIcon logopic = new ImageIcon(new ImageIcon("D:\\share\\logo.jpg").getImage().getScaledInstance(500, 200, Image.SCALE_DEFAULT));
        JLabel logo=new JLabel(logopic);
        logo.setBounds(00, 0, 500, 200);
        pup.add(logo);
        
       
        
        //login page
        
        logn.setVisible(false);
        logn.setLayout(null);
        logn.setBounds(500, 200, 1500, 900);
        log=new JLabel("Login Page :");
        JLabel llogin=new JLabel("User_name :");
        lpass=new JLabel("Password :");
        ldesc=new JLabel("If You Don't have an Account , Create New Account :");
        
        //log.setForeground(Color.cyan);                                                                                                                                                                                                                                                                                                                                                                                              
        ldesc.setForeground(Color.decode("#A3E4D7"));
        llogin.setForeground(Color.decode("#5F6A6A"));
        lpass.setForeground(Color.decode("#5F6A6A"));
        
         
        
        tlog.setEditable(true);
        tlpass.setEditable(true);
        
        
        ImageIcon userpic=new ImageIcon(new ImageIcon("D:\\share\\user.png").getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT));
        JLabel userlogo=new JLabel(userpic);
        
        log.setFont(fn);
        llogin.setFont(lfn);
        lpass.setFont(lfn);
        ldesc.setFont(lfn);
        tlog.setFont(tfn);
        tlpass.setFont(tfn);
        logbu.setFont(lfn);
        createbu.setFont(lfn);
        
        log.setBounds(300, 130, 800, 100);
        llogin.setBounds(300, 300, 300, 30);
        tlog.setBounds(600, 300, 300, 30);
        lpass.setBounds(300, 400, 300, 30);
        tlpass.setBounds(600, 400, 300, 30);
        logbu.setBounds(500, 500, 300, 100);
        ldesc.setBounds(150, 650, 1100, 30);
        createbu.setBounds(400, 700, 500, 100);
        userlogo.setBounds(1000, 150, 400, 400);
        
        
        
        logn.add(log);
        logn.add(llogin);
        logn.add(tlog);
        logn.add(lpass);
        logn.add(tlpass);
        logn.add(logbu);
        logn.add(ldesc);
        logn.add(createbu);
        logn.add(userlogo);
        
        logbu.setBackground(Color.decode("#3498DB"));
        createbu.setBackground(Color.decode("#3498DB"));
        
        logbu.setForeground(Color.WHITE);
        createbu.setForeground(Color.white);
        
        logbu.addActionListener(this);
        createbu.addActionListener(this);
        
       
         //Admin login
        
        
        alogin.setVisible(false);
        alogin.setLayout(null);
        alogin.setBounds(500, 200, 1500, 900);
        
        log=new JLabel("Admin Login Page :");
        llogin=new JLabel("Admin_name :");
        lpass=new JLabel("Password :");
        
        
        //log.setForeground(Color.cyan);
        llogin.setForeground(Color.decode("#5F6A6A"));
        lpass.setForeground(Color.decode("#5F6A6A"));
        
        
        tlogin.setEditable(true);
        tpass.setEditable(true);
        
        ImageIcon adminpic=new ImageIcon(new ImageIcon("D:\\share\\admin1.png").getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
        JLabel adminlogo=new JLabel(adminpic);
        
        
        log.setFont(fn);
        llogin.setFont(lfn);
        lpass.setFont(lfn);
        
        tlogin.setFont(tfn);
        tpass.setFont(tfn);
        admin.setFont(lfn);
        
        
        log.setBounds(300, 80, 1000, 200);
        llogin.setBounds(300, 300, 300, 30);
        tlogin.setBounds(600, 300, 300, 30);
        lpass.setBounds(300, 400, 300, 30);
        tpass.setBounds(600, 400, 300, 30);
        admin.setBounds(500, 500, 300, 100);
        adminlogo.setBounds(1000, 150, 400, 400);
        
        
        alogin.add(log);
        alogin.add(llogin);
        alogin.add(tlogin);
        alogin.add(lpass);
        alogin.add(tpass);
        alogin.add(admin);
        alogin.add(adminlogo);
        
        
        admin.setBackground(Color.decode("#3498DB"));
        admin.setForeground(Color.WHITE);
        admin.addActionListener(this);
       
        
        
        //register page
        
        n.setVisible(false);
        n.setLayout(null);
        n.setBounds(500, 200, 1500, 900);
        
        
        
        l=new JLabel("CREATE NEW ACCOUNT");
        l1=new JLabel("USER NAME :");
        l2=new JLabel("PASSWARD :");
        l3=new JLabel("CONFRIM PASSWARD :");
        l4=new JLabel("GANDER :");
        l5=new JLabel("FATHER NAME :");
        l6=new JLabel("ADDRESS :");
        l7=new JLabel("EMAIL :");
        l8=new JLabel("STATE :");
        l9=new JLabel("DISTRICT :");
        l10=new JLabel("CITY :");
        l111=new JLabel("SELECT IMAGE :");
        c1=new JLabel("(compalsary to be filled)");
        c2=new JLabel("(compalsary to be filled)");
        c3=new JLabel("(compalsary to be filled)");
        c4=new JLabel("(compalsary to be filled)");
        c5=new JLabel("(compalsary to be filled)");
        c6=new JLabel("(compalsary to be filled)");
        c7=new JLabel("(compalsary to be filled)");
        c8=new JLabel("(compalsary to be filled)");
        
        
        c1.setForeground(Color.red);
        c2.setForeground(Color.red);
        c3.setForeground(Color.red);
        c4.setForeground(Color.red);
        c5.setForeground(Color.red);
        c6.setForeground(Color.red);
        c7.setForeground(Color.red);
        c8.setForeground(Color.red);
        
        resbu.setForeground(Color.white);
        resbu.setBackground(Color.decode("#3498DB"));
        regbu.setForeground(Color.white);
        regbu.setBackground(Color.decode("#3498DB"));
        loadButton1.setForeground(Color.white);
        loadButton1.setBackground(Color.decode("#3498DB"));
        
        l.setForeground(Color.decode("#82E0AA"));
        
        t1=new JTextField();
        
        
        
         
         
         
        
        t1.addKeyListener(new KeyAdapter(){
        public void keyReleased(KeyEvent ke){
            usrreg=t1.getText();
            
            

                char ch = ke.getKeyChar();
                
                
        
                    c1.setVisible(false);
                    if(usrreg.isEmpty())
                    c1.setVisible(true);

                if(Character.isDigit(ch)){

                    abc=1;
                    
                    t1.setText("");
                    JOptionPane.showMessageDialog(null, "Only characters are allowed");
                    c1.setVisible(true);

                }
                

            }

        });
        
        t2=new JPasswordField();
        
        t2.addKeyListener(new KeyAdapter()
        {
        public void keyReleased(KeyEvent ke)
        {
           pasreg=t2.getText();
           c2.setVisible(false);
           if(pasreg.isEmpty())
           c2.setVisible(true);
       }

        });
        
        
        
        t3=new JPasswordField();
        t5=new JTextField();
        t5.addKeyListener(new KeyAdapter(){
        public void keyReleased(KeyEvent ke){
            fareg=t5.getText();

                char ch = ke.getKeyChar();
                c4.setVisible(false);
                if(fareg.isEmpty())
                    c4.setVisible(true);

                if(Character.isDigit(ch)){

                    t5.setText("");
                    

                    JOptionPane.showMessageDialog(null, "Only characters are allowed ");
                    t5.setText(" ");

                }

            }

        });
        t6=new JTextField();
        t6.addKeyListener(new KeyAdapter(){
        public void keyReleased(KeyEvent ke){
            addreg=t6.getText();

                char ch = ke.getKeyChar();
                c5.setVisible(false);
                if(addreg.isEmpty())
                    c5.setVisible(true);

                if(Character.isDigit(ch)){

                    t1.setText("");
                    

                    JOptionPane.showMessageDialog(null, "Only characters are allowed plese reset");
                    t1.setText(" ");

                }

            }

        });
        t7=new JTextField();
         t7.addKeyListener(new KeyAdapter()
        {
        public void keyReleased(KeyEvent ke)
        {
           emareg=t7.getText();
           c6.setVisible(false);
           if(emareg.isEmpty())
           c6.setVisible(true);
       }

        });
        
         
         ImageIcon regpic=new ImageIcon(new ImageIcon("D:\\share\\regester.png").getImage().getScaledInstance(170, 170, Image.SCALE_DEFAULT));
        JLabel reglogo=new JLabel(regpic);
        
        l.setFont(fn);
        l1.setFont(lfn);
        l2.setFont(lfn);
        l3.setFont(lfn);
        l4.setFont(lfn);
        l5.setFont(lfn);
        l6.setFont(lfn);
        l7.setFont(lfn);
        l8.setFont(lfn);
        l9.setFont(lfn);
        l10.setFont(lfn);
        l111.setFont(lfn);
        t1.setFont(tfn);
        t2.setFont(tfn);
        t3.setFont(tfn);
        t5.setFont(tfn);
        t6.setFont(tfn);
        t7.setFont(tfn);
        genderbox1.setFont(tfn);
        statename1.setFont(tfn);
        districtname1.setFont(tfn);
        cityname1.setFont(tfn);
        regbu.setFont(lfn);
        resbu.setFont(lfn);
        loadButton1.setFont(lfn);
         l.setBounds(300, 50, 1100, 100);
         reglogo.setBounds(50, 00, 170, 170); 
         l1.setBounds(50, 200, 300, 30);
         t1.setBounds(300, 200, 300, 30);
         c1.setBounds(350, 230, 300, 30); 
         l4.setBounds(800, 200, 300, 30);
         genderbox1.setBounds(1000, 200, 300, 30);
         l2.setBounds(50, 280, 300, 30);
         t2.setBounds(300, 280, 300, 30);
         c2.setBounds(350, 310, 300, 30);
         l3.setBounds(800, 280, 350, 30);
         t3.setBounds(1150, 280, 300, 30);
         c3.setBounds(1220, 310, 300, 30);
         l5.setBounds(50, 360, 300, 30);
         t5.setBounds(300, 360, 300, 30);
         c4.setBounds(350, 390, 300, 30);
         l8.setBounds(800, 360, 300, 30);
         statename1.setBounds(1000, 360, 300, 30);
         c7.setBounds(1050, 390, 300, 30);
         l7.setBounds(50, 440, 300, 30);
         t7.setBounds(300, 440, 300, 30); 
         c6.setBounds(350, 470, 300, 30); 
         l9.setBounds(800, 440, 300, 30);
         districtname1.setBounds(1000, 440, 300, 30); 
         l6.setBounds(50,520, 300, 30);
         t6.setBounds(300, 520, 300, 30);  
         c5.setBounds(350, 550, 300, 30);
         l10.setBounds(800, 520, 300, 30);
         cityname1.setBounds(1000, 520, 300, 30); 
         resbu.setBounds(450, 750, 300, 50);
         regbu.setBounds(800, 750, 300, 50);
         l111.setBounds(50, 600, 300, 150);
         loadButton1.setBounds(450, 650, 300, 50);
         
         regbu.addActionListener(this);
         resbu.addActionListener(this);
         n.add(l);
         n.add(reglogo);
         n.add(l1);
         n.add(t1);
         n.add(l2);
         n.add(t2);
         n.add(l3);
         n.add(t3);
         n.add(l4);
         n.add(genderbox1);
         n.add(l5);
         n.add(t5);
         n.add(l6);
         n.add(t6);
         n.add(l7);
         n.add(t7);
         n.add(l8);
         n.add(statename1);
         n.add(l9);
         n.add(districtname1);
         n.add(l10);
         n.add(cityname1);
         n.add(resbu);
         n.add(regbu);
         n.add(l111);
         n.add(loadButton1);
         n.add(c1);
         n.add(c2);
         n.add(c3);
         n.add(c4);
         n.add(c5);
         n.add(c6);
         n.add(c7);
         
         
         t3.addKeyListener(new KeyAdapter(){
                 public void keyReleased(KeyEvent re){
                     conreg=t3.getText();
                     String pa=t2.getText();
                      char a = re.getKeyChar();
                      
                      c3.setVisible(false);
                      if(conreg.isEmpty())
                          c3.setVisible(true);
                      
                      char ch;
            String con=t3.getText();
            

                
                int length=pa.length();
                
                    ch=a;
                    if(i<length)
                    {

                if(pa.charAt(i)==ch  ){
                    i++;
                    
                } else {
                    JOptionPane.showMessageDialog(null, "password not matched");
                    i=6;
                    t3.setText("");
                    t2.setText("");
                    i=0;
                     c3.setVisible(true);
                    c2.setVisible(true);
                    
                     }
                    }
                    else {
                    JOptionPane.showMessageDialog(null, "password not matched");
                    i=6;
                    t3.setText("");
                    t2.setText("");
                    i=0;
                     c3.setVisible(true);
                     c2.setVisible(true);
                    
                    
                     }
                
                
                

            }

        });
         
         
         
         
         loadButton1.addActionListener(ev -> {
             
      JFileChooser fc = new JFileChooser(System.getProperty("user.home"));
      fc.addChoosableFileFilter(new FileNameExtensionFilter("Image files",
          new String[] { "png", "jpg", "jpeg", "gif" }));
      if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
        try {
          Image image1 = ImageIO.read(fc.getSelectedFile());
          File f=fc.getSelectedFile();
          getn=f.getName();
           filename=f.getAbsolutePath();
          
          if (image1 != null) {
              ImageIcon ii=new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(300, 150, Image.SCALE_DEFAULT));
              
              l111.setText("");
              
              l111.setIcon(ii);
            
            
      
          }
        } catch (Exception ex) {
          ex.printStackTrace();
        }
      }
    });
       
         if(stat!="--select state--")
         c7.setVisible(false);
        
        
        
         //contact us page
         
        cont.setVisible(false);
        cont.setLayout(null);
        cont.setBounds(500, 200, 1500, 900);
        
        l=new JLabel("CONTACT US");
        JLabel wn=new JLabel("Whatsapp no. - 8126003072");
        JLabel emailid=new JLabel("Email id - nitesh.shahu9390@gmail.com");
        
        l.setFont(fn);
        wn.setFont(tlfn);
        emailid.setFont(tlfn);
        
        l.setForeground(Color.blue);
        
        
        ImageIcon coni=new ImageIcon(new ImageIcon("D:\\share\\cons.jpg").getImage().getScaledInstance(1500, 520, Image.SCALE_DEFAULT));
        JLabel conlogo=new JLabel(coni);
        
        
        conlogo.setBounds(0, 380, 1500, 520);
        l.setBounds(300,100,1000,100);
        wn.setBounds(200,250,1000,30);
        emailid.setBounds(200,320,1000,30);
        
        
        cont.add(conlogo);
        cont.add(l);
        cont.add(wn);
        cont.add(emailid);
        
        
        
        // about page
        
        abut.setVisible(false);
        abut.setLayout(null);
        abut.setBounds(500, 200, 1500, 900);
        
        l=new JLabel("ABOUT US");
        
        l.setFont(fn);
        JTextArea abt=new JTextArea();
        
        abt.setText("\"Don't just do something because it's a trendy idea and will make you a lot of money. The reason I say that is because any kind of \n venture involves going through difficult times. If you're doing something you are passionate about and really believe in, then that will \n carry  you through,\" said American businessman Jerry Greenfield.\n\n I Nitesh Shahu made this project at Azansys infotech during my Summer Internship period.\n I have made this project in JAVA Language ");
        abt.setFont(tfn);
        abt.setEditable(false);
        abt.setBounds(100, 200,1200,200 );
        l.setForeground(Color.blue);
        ImageIcon abu=new ImageIcon(new ImageIcon("D:\\share\\abutus.png").getImage().getScaledInstance(1500, 520, Image.SCALE_DEFAULT));
        JLabel abul=new JLabel(abu);
        abul.setBounds(0, 380, 1500, 520);
        l.setBounds(300,50,1000,100);
        
        abut.add(abul);
        abut.add(abt);
        abut.add(l);
        
        
        
        
        
        // suscessfull login page
        
        sus.setVisible(false);
        sus.setLayout(null);
        sus.setBounds(500, 200, 1500, 900);
        
        
        a1=new JTextField();
        a2=new JTextField();
        a3=new JTextField();
        a4=new JTextField();
        a5=new JTextField();
        a6=new JTextField();
        a7=new JTextField();
        a8=new JTextField();
        a9=new JTextField();
        
               
        l=new JLabel("WELCOME");
        l1=new JLabel("NAME :");
        l4=new JLabel("GANDER :");
        l5=new JLabel("FATHER NAME :");
        l6=new JLabel("ADDRESS :");
        l7=new JLabel("EMAIL :");
        l8=new JLabel("STATE :");
        l9=new JLabel("DISTRICT :");
        l10=new JLabel("CITY :");
        l11=new JLabel("LOADING IMAGE...");
        
        l.setFont(fn);
        l1.setFont(lfn);
        l4.setFont(lfn);
        l5.setFont(lfn);
        l6.setFont(lfn);
        l7.setFont(lfn);
        l8.setFont(lfn);
        l9.setFont(lfn);
        l10.setFont(lfn);
        l11.setFont(lfn);
        a1.setFont(tlfn);
        a2.setFont(tlfn);
        a3.setFont(tlfn);
        a4.setFont(tlfn);
        a5.setFont(tlfn);
        a6.setFont(tlfn);
        a7.setFont(tlfn);
        a8.setFont(tlfn);
        statename.setFont(tfn);
        districtname.setFont(tfn);
        cityname.setFont(tfn);
             
        
        
        l.setForeground(Color.red);
        
        
        
        l.setBounds(500, 50, 500, 50);
        l1.setBounds(200, 150, 300, 50);
        a1.setBounds(400, 150, 300, 50);
        l4.setBounds(200, 220, 300, 50);
        genderbox.setBounds(400, 220, 300, 50);
        l5.setBounds(200, 290, 300, 50);
        a3.setBounds(500, 290, 300, 50);
        l6.setBounds(200, 360, 300, 50);
        a4.setBounds(400, 360, 300, 50);
        l7.setBounds(200, 430, 300, 50);
        a5.setBounds(400, 430, 500, 50);
        l8.setBounds(200, 510, 300, 50);
        statename.setBounds(400, 510, 300, 50);
        l9.setBounds(200, 580, 300, 50);
        districtname.setBounds(400, 580, 300, 50);
        l10.setBounds(200, 650, 300, 50);
        cityname.setBounds(400, 650, 300, 50);
        l11.setBounds(1200, 150, 210, 210);
        editbu.setBounds(650, 750, 300, 100);
        updatebu.setBounds(650, 750, 300, 100);
        
        loadButton.setBounds(1200, 400, 320, 40);
        
        
        editbu.setFont(lfn);
        editbu.setForeground(Color.white);
        editbu.setBackground(Color.decode("#3498DB"));
        updatebu.setFont(lfn);
        updatebu.setForeground(Color.white);
        updatebu.setBackground(Color.decode("#3498DB"));
        loadButton.setFont(lfn);
        loadButton.setForeground(Color.white);
        loadButton.setBackground(Color.decode("#3498DB"));
        
        
            sus.add(l);
            sus.add(l1);
            sus.add(a1);
             sus.add(l4);
            sus.add(genderbox);
             sus.add(l5);
            sus.add(a3);
             sus.add(l6);
            sus.add(a4);
             sus.add(l7);
            sus.add(a5);
             sus.add(l8);
            sus.add(statename);
             sus.add(l9);
            sus.add(districtname);
             sus.add(l10);
            sus.add(cityname);
             sus.add(l11);
            sus.add(a9);
            
            sus.add(editbu);
            sus.add(updatebu);
            sus.add(loadButton);
            
            editbu.addActionListener(this);
            
          /* backbu.setBounds(100, 50,100, 30);
        backbu.setForeground(Color.white);
        backbu.setBackground(Color.decode("#3498DB"));
       // sus.add(backbu);
        backbu.addActionListener(this);*/
            
            
            a1.setOpaque(false);
            a1.setBorder(null);
            a1.setEditable(false);
            a3.setOpaque(false);
            a3.setBorder(null);
            a3.setEditable(false);
            a4.setOpaque(false);
            a4.setBorder(null);
            a4.setEditable(false);
            a5.setOpaque(false);
            a5.setBorder(null);
            a5.setEditable(false);
            statename.setEnabled(false);
            districtname.setEnabled(false);
            cityname.setOpaque(false);
            cityname.setEnabled(false);
            genderbox.setEnabled(false);
            updatebu.setEnabled(false);
            updatebu.setVisible(false);
            loadButton.setEnabled(false);
            loadButton.setVisible(false);
            editbu.setVisible(true);
            editbu.setEnabled(true);
       /* }catch(Exception susp)
        {
            //JOptionPane.showMessageDialog(null,susp);
           susp.printStackTrace();
        }
          */
        
        
        // share marketing page
        
        
        share.setVisible(true);
        share.setLayout(null);
        share.setBounds(500, 200, 1500, 1500);
       /*  JScrollPane panelr=new JScrollPane();
         panelr.setBounds(00, 00, 50, 1500);
         panelr.getViewport();
         share.add(panelr);
         panelr.getVerticalScrollBar().setValue(panelr.getVerticalScrollBar().getMaximum());
         panelr.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
         JButton myButton=new JButton();
         share.scrollRectToVisible(myButton.getBounds());*/
//       share.add(panelr);
        
        ta.setBounds(100, 00, 500, 500);
        ta.setEditable(false);
        marquee.add(spane);
        spane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        marquee.setBounds(1000, 100, 500, 300);
        share.add(marquee);
        
        
        
        
            tm = new Timer(2000,new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                 picicon = new ImageIcon( new ImageIcon(list[x]).getImage().getScaledInstance(700, 400, Image.SCALE_DEFAULT));
                 picslide.setIcon(picicon);
                
                x += 1;
                if(x >= list.length )
                    x = 0; 
            }
        });
        
        tm.start();
        
        String[][] tgs=new String[5][5];
        String[][] tls=new String[5][5];
        String[] col={"company","high","low","lastprice","perchange"};
                
        int j=0;
        try{
               myconn=DriverManager.getConnection(dburl,usr,pas);
               String sql="select * from sharedata where perchange>0 order by perchange desc";
               ps=myconn.prepareStatement(sql);
               rs=ps.executeQuery();
               while(rs.next()&&j<5){
                   tgs[j][0]=rs.getString("company");
                   tgs[j][1]=rs.getString("high");
                   tgs[j][2]=rs.getString("low");
                   tgs[j][3]=rs.getString("lastprice");
                   tgs[j][4]=rs.getString("perchange");
                   
                   j++;
                   
                   
               }
               
               j=0;
               
                sql="select * from sharedata where perchange<0 order by perchange desc";
               ps=myconn.prepareStatement(sql);
               rs=ps.executeQuery();
               while(rs.next()&&j<5){
                   tls[j][0]=rs.getString("company");
                   tls[j][1]=rs.getString("high");
                   tls[j][2]=rs.getString("low");
                   tls[j][3]=rs.getString("lastprice");
                   tls[j][4]=rs.getString("perchange");
                   
                   j++;
               
               }
               
        
        }catch(Exception tge){
            tge.printStackTrace();
            
        }
        
        JTable gtable = new JTable(tgs, col);
        gtable.setEnabled(false);
        
        
        
        
        JTable ltable = new JTable(tls, col);
        ltable.setEnabled(false);
        
        
        
        
        
        JLabel tg,tg1,tg2,tg3,tg4,tg5,tl,tl1,tl2,tl3,tl4,tl5;
        tg=new JLabel("Top gainer");
        tg1=new JLabel("company");
        tg2=new JLabel("high");
        tg3=new JLabel("low");
        tg4=new JLabel("lastprice");
        tg5=new JLabel("% change");
        tl=new JLabel("Top Loser");
        tl1=new JLabel("company");
        tl2=new JLabel("high");
        tl3=new JLabel("low");
        tl4=new JLabel("lastprice");
        tl5=new JLabel("% change");
        
        JLabel newsl=new JLabel("News Handlines");
        newsl.setForeground(Color.red);
        newsl.setBounds(1100, 50,360 , 30);
        newsl.setFont(lfn);
        
        
        picslide.setBounds(200, 00, 700, 400);
        
        tg.setBounds(500, 400, 200, 100);
        tl.setBounds(500, 620, 200, 100);
        tg1.setBounds(10, 460, 100, 50); 
        tg2.setBounds(310, 460, 100, 50);
        tg3.setBounds(610, 460, 100, 50); 
        tg4.setBounds(910, 460, 100, 50); 
        tg5.setBounds(1210,460, 100, 50); 
        tl1.setBounds(10, 680, 100, 50); 
        tl2.setBounds(310, 680, 100, 50);
        tl3.setBounds(610, 680, 100, 50); 
        tl4.setBounds(910, 680, 100, 50); 
        tl5.setBounds(1210, 680, 100, 50);
        gtable.setBounds(00, 500, 1500, 100);
        ltable.setBounds(00, 720, 1500, 100);
        
        tg.setForeground(Color.red);
        tl.setForeground(Color.red);
        tg1.setForeground(Color.blue);
        tg2.setForeground(Color.blue);
        tg3.setForeground(Color.blue);
        tg4.setForeground(Color.blue);
        tg4.setForeground(Color.blue);
        tg5.setForeground(Color.blue);
        
        tl1.setForeground(Color.blue);
        tl2.setForeground(Color.blue);
        tl3.setForeground(Color.blue);
        tl4.setForeground(Color.blue);
        tl4.setForeground(Color.blue);
        tl5.setForeground(Color.blue);
        
        
        tg.setFont(lfn);
        tl.setFont(lfn);
        ltable.setFont(tfn);
        gtable.setFont(tfn);
        tg1.setFont(tfn);
        tg2.setFont(tfn);
        tg3.setFont(tfn);
        tg4.setFont(tfn);
        tg5.setFont(tfn);
        tl1.setFont(tfn);
        tl2.setFont(tfn);
        tl3.setFont(tfn);
        tl4.setFont(tfn);
        tl5.setFont(tfn);
        
        
        gainbu.setBounds(1200, 600, 200, 20);
        gainbu.setFont(bfn);
        gainbu.setHorizontalAlignment(JLabel.LEFT);
        gainbu.setOpaque(false);
        gainbu.setContentAreaFilled(false);
        gainbu.setBorderPainted(false);
        gainbu.setForeground(Color.BLUE);
        gainbu.addActionListener(this);
        share.add(gainbu);
        
        losebu.setBounds(1200, 820, 200, 20);
        losebu.setFont(bfn);
        losebu.setHorizontalAlignment(JLabel.LEFT);
        losebu.setOpaque(false);
        losebu.setContentAreaFilled(false);
        losebu.setBorderPainted(false);
        losebu.setForeground(Color.BLUE);
        losebu.addActionListener(this);
        share.add(losebu);
        
        
        
        share.add(newsl);
        share.add(tg);
        share.add(tl);
        share.add(picslide);
        share.add(gtable);
        share.add(ltable);
        share.add(tg1);
        share.add(tg2);
        share.add(tg3);
        share.add(tg4);
        share.add(tg5);
        share.add(tl1);
        share.add(tl2);
        share.add(tl3);
        share.add(tl4);
        share.add(tl5);
        
        
        //admin page
        l=new JLabel("what do you want to do?");
        l.setFont(fn);
        l.setBounds(100, 20, 1350,150 );
        l.setForeground(Color.red);
        adminpage.setVisible(false);
        adminpage.setLayout(null);
        adminpage.setBounds(500, 200, 1500, 900);
        
        news.setBounds(200, 200, 300, 40);
        sharedata.setBounds(200, 300, 300, 40);
        updatesharedata.setBounds(200, 400, 300, 40);
        uibu.setBounds(200, 500, 300, 40);
        cibu.setBounds(200, 600, 300, 40);
        ustatus.setBounds(200, 700, 300, 40);
        
        news.setBackground(Color.decode("#3498DB"));
        news.setForeground(Color.white);
        news.setFont(lfn);
        sharedata.setBackground(Color.decode("#3498DB"));
        sharedata.setForeground(Color.white);
        sharedata.setFont(lfn);
        updatesharedata.setBackground(Color.decode("#3498DB"));
        updatesharedata.setForeground(Color.white);
        updatesharedata.setFont(lfn);
        uibu.setBackground(Color.decode("#3498DB"));
        uibu.setForeground(Color.white);
        uibu.setFont(lfn);
        cibu.setBackground(Color.decode("#3498DB"));
        cibu.setForeground(Color.white);
        cibu.setFont(lfn);
        ustatus.setBackground(Color.decode("#3498DB"));
        ustatus.setForeground(Color.white);
        ustatus.setFont(lfn);
        
        news.addActionListener(this);
        sharedata.addActionListener(this);
        updatesharedata.addActionListener(this);
        uibu.addActionListener(this);
        cibu.addActionListener(this);
        ustatus.addActionListener(this);
        
        adminpage.add(l);
        adminpage.add(news);
        adminpage.add(sharedata);
        adminpage.add(updatesharedata);
        adminpage.add(cibu);
        adminpage.add(uibu);
        adminpage.add(ustatus);
        
        //news page
        
        newspage.setVisible(false);
        newspage.setLayout(null);
        newspage.setBounds(500, 200, 1500, 900);
        
        l=new JLabel("Upload news");
        l.setBounds(150, 100, 800, 100);
        l.setFont(fn);
        l.setForeground(Color.blue);
        
        newstext.setBounds(100, 250, 500, 60);
        newstext.setFont(tfn);
        //backnews.setFont(bfn);
        uploadnews.setFont(bfn);
        
        backnews.setBounds(50, 50, 100, 30);
        uploadnews.setBounds(250, 350, 270, 50);
        
        uploadnews.setBackground(Color.decode("#3498DB"));
        uploadnews.setForeground(Color.white);
        uploadnews.addActionListener(this);
        backnews.setBackground(Color.decode("#3498DB"));
        backnews.setForeground(Color.white);
        backnews.addActionListener(this);
        
        
        newspage.add(l);
        newspage.add(newstext);
        newspage.add(uploadnews);
        newspage.add(backnews);
        
        //company data
        
        datapage.setVisible(false);
        datapage.setLayout(null);
        datapage.setBounds(500, 200, 1500, 900);
        
        l=new JLabel("Upload Data");
        d1=new JLabel("Company name:");
        d2=new JLabel("High price:");
        d3=new JLabel("Low price:");
        d4=new JLabel("Last Price:");
        d5=new JLabel("% change:");
        
        dt1 =new JTextField();
        dt2 =new JTextField();
        dt3 =new JTextField();
        dt4 =new JTextField();
        dt5 =new JTextField();
        
        l.setFont(fn);
        d1.setFont(lfn);
        d2.setFont(lfn);
        d3.setFont(lfn);
        d4.setFont(lfn);
        d5.setFont(lfn);
        dt1.setFont(tfn);
        dt2.setFont(tfn);
        dt3.setFont(tfn);
        dt4.setFont(tfn);
        dt5.setFont(tfn);
        uploaddata.setFont(lfn);
        uploaddata.setForeground(Color.white);
        uploaddata.setBackground(Color.decode("#3498DB"));
        l.setForeground(Color.red);
        
        l.setBounds(200, 50, 700, 60);
        d1.setBounds(100, 170, 300, 30);
        dt1.setBounds(500, 170, 300, 30);
        d2.setBounds(100, 250, 300, 30);
        dt2.setBounds(500, 250, 300, 30);
        d3.setBounds(100, 330, 300, 30);
        dt3.setBounds(500, 330, 300, 30);
        d4.setBounds(100, 410, 300, 30);
        dt4.setBounds(500, 410, 300, 30);
        d5.setBounds(100, 490, 300, 30);
        dt5.setBounds(500, 490, 300, 30);
        uploaddata.setBounds(350, 590, 300, 50);
        
        uploaddata.addActionListener(this);
        
        //backdata.setFont(bfn);
        
        
        backdata.setBounds(50, 50, 100, 30);
        
        backdata.setBackground(Color.decode("#3498DB"));
        backdata.setForeground(Color.white);
        backdata.addActionListener(this);
        
        
        datapage.add(l);
        datapage.add(d1);
        datapage.add(d2);
        datapage.add(d3);
        datapage.add(d4);
        datapage.add(d5);
        datapage.add(dt1);
        datapage.add(dt2);
        datapage.add(dt3);
        datapage.add(dt4);
        datapage.add(dt5);
        datapage.add(uploaddata);
        datapage.add(backdata);
        
        
        //update date page
        
        updatedatapage.setVisible(false);
        updatedatapage.setLayout(null);
        updatedatapage.setBounds(500, 200, 1500, 900);
        
        
        
        u1=new JLabel("Update data");
        u2=new JLabel("company");
        u3=new JLabel("high");
        u4=new JLabel("low");
        u5=new JLabel("last price");
        u6=new JLabel("% change");
        
        ut1=new JTextField();
        ut2=new JTextField();
        ut3=new JTextField();
        ut4=new JTextField();
        ut5=new JTextField();
        
        u1.setFont(fn);
        u2.setFont(lfn);
        u3.setFont(lfn);
        u4.setFont(lfn);
        u5.setFont(lfn);
        u6.setFont(lfn);
        ut1.setFont(tfn);
        ut2.setFont(tfn);
        ut3.setFont(tfn);
        ut4.setFont(tfn);
        ut5.setFont(tfn);
        
        u1.setBounds(150, 50, 800, 150);
        u2.setBounds(100, 200, 400, 30);
        u3.setBounds(100, 300, 400, 30);
        u4.setBounds(100, 400, 400, 30);
        u5.setBounds(100, 500, 400, 30);
        u6.setBounds(100, 600, 400, 30);
        ut1.setBounds(400, 200, 300, 30);
        ut2.setBounds(400, 300, 300, 30);
        ut3.setBounds(400, 400, 300, 30);
        ut4.setBounds(400, 500, 300, 30);
        ut5.setBounds(400, 600, 300, 30);
        
        u1.setForeground(Color.red);
        
        backupdate.setBounds(00, 50, 100, 30);
        backupdate.setBackground(Color.decode("#3498DB"));
        backupdate.setForeground(Color.white);
        backupdate.addActionListener(this);
       // backupdate.setFont(lfn);
                
        searchbu.setBounds(800, 200, 300, 30);
        searchbu.setBackground(Color.decode("#3498DB"));
        searchbu.setForeground(Color.white);
        searchbu.addActionListener(this);
        searchbu.setFont(lfn);
        
        updatesdata.setBounds(350, 700, 300, 100);
        updatesdata.setBackground(Color.decode("#3498DB"));
        updatesdata.setForeground(Color.white);
        updatesdata.addActionListener(this);
        updatesdata.setFont(lfn);
        
        u3.setVisible(false);
        u4.setVisible(false);
        u5.setVisible(false);
        u6.setVisible(false);
        ut2.setVisible(false);
        ut3.setVisible(false);
        ut4.setVisible(false);
        ut5.setVisible(false);
        updatesdata.setVisible(false);
        
        
        
        updatedatapage.add(u1);
        updatedatapage.add(u2);
        updatedatapage.add(u3);
        updatedatapage.add(u4);
        updatedatapage.add(u5);
        updatedatapage.add(u6);
        updatedatapage.add(ut1);
        updatedatapage.add(ut2);
        updatedatapage.add(ut3);
        updatedatapage.add(ut4);
        updatedatapage.add(ut5);
        updatedatapage.add(backupdate);
        updatedatapage.add(searchbu);
        updatedatapage.add(updatesdata);
        
        
        //gainer page
        
        gainer.setVisible(false);
        gainer.setLayout(null);
        gainer.setBounds(500, 200, 1500, 900);
        gainer.setBackground(Color.WHITE);
        
          String[][] tgss=new String[15][5];
        
        String[] coltj={"company","high","low","lastprice","perchange"};
                
        int tj=0;
        try{
               myconn=DriverManager.getConnection(dburl,usr,pas);
               String sql="select * from sharedata where perchange>0 order by perchange desc";
               ps=myconn.prepareStatement(sql);
               rs=ps.executeQuery();
               while(rs.next()&&tj<15){
                   tgss[tj][0]=rs.getString("company");
                   tgss[tj][1]=rs.getString("high");
                   tgss[tj][2]=rs.getString("low");
                   tgss[tj][3]=rs.getString("lastprice");
                   tgss[tj][4]=rs.getString("perchange");
                   
                   tj++;
                   
                   
               }
        }catch(Exception tgp){
            tgp.printStackTrace();
            
        }
        
        
        JTable tgtable = new JTable(tgss, coltj);
        
        tgtable.setEnabled(false);
        tgtable.setFont(tfn);
        tgtable.setRowHeight(35);
        
        JLabel tgg,tgg1,tgg2,tgg3,tgg4,tgg5;
        tgg=new JLabel("Top gainers");
        tgg1=new JLabel("company");
        tgg2=new JLabel("high");
        tgg3=new JLabel("low");
        tgg4=new JLabel("lastprice");
        tgg5=new JLabel("% change");
        
        tgg.setFont(fn);
        tgg1.setFont(lfn);
        tgg2.setFont(lfn);
        tgg3.setFont(lfn);
        tgg4.setFont(lfn);
        tgg5.setFont(lfn);
        
        tgg.setForeground(Color.red);
        tgg1.setForeground(Color.BLUE);
        tgg2.setForeground(Color.BLUE);
        tgg3.setForeground(Color.BLUE);
        tgg4.setForeground(Color.BLUE);
        tgg5.setForeground(Color.BLUE);
        
        tgg.setBounds(400, 100, 700, 100);
        tgg1.setBounds(00, 250, 200, 50);
        tgg2.setBounds(300, 250, 200, 50);
        tgg3.setBounds(600, 250, 200, 50);
        tgg4.setBounds(900, 250, 200, 50);
        tgg5.setBounds(1200, 250, 200, 50);
        tgtable.setBounds(0, 300, 1500, 600);
        
        
        gainer.add(tgg);
        gainer.add(tgg1);
        gainer.add(tgg2);
        gainer.add(tgg3);
        gainer.add(tgg4);
        gainer.add(tgg5);
        gainer.add(tgtable);
        
        
        
        
        
        
        
        
        
        //losser page
        
        losser.setVisible(false);
        losser.setLayout(null);
        losser.setBounds(500, 200, 1500, 900);
        losser.setBackground(Color.WHITE);
        
          String[][] tlss=new String[15][5];
        
        String[] coltl={"company","high","low","lastprice","perchange"};
                
        int ti=0;
        try{
               myconn=DriverManager.getConnection(dburl,usr,pas);
               String sql="select * from sharedata where perchange<0 order by perchange desc";
               ps=myconn.prepareStatement(sql);
               rs=ps.executeQuery();
               while(rs.next()&&ti<15){
                   tlss[ti][0]=rs.getString("company");
                   tlss[ti][1]=rs.getString("high");
                   tlss[ti][2]=rs.getString("low");
                   tlss[ti][3]=rs.getString("lastprice");
                   tlss[ti][4]=rs.getString("perchange");
                   
                   ti++;
                   
                   
               }
        }catch(Exception tgp){
            tgp.printStackTrace();
            
        }
        
        
        JTable tltable = new JTable(tlss, coltj);
        //tltable.setBounds(0, 0, 1500, 600);
        tltable.setEnabled(false);
        tltable.setFont(tfn);
        tltable.setRowHeight(35);
        JScrollPane sp = new JScrollPane(tltable); 
        
        JLabel tll,tll1,tll2,tll3,tll4,tll5;
        tll=new JLabel("Top losers");
        tll1=new JLabel("company");
        tll2=new JLabel("high");
        tll3=new JLabel("low");
        tll4=new JLabel("lastprice");
        tll5=new JLabel("% change");
        
        tll.setFont(fn);
        tll1.setFont(lfn);
        tll2.setFont(lfn);
        tll3.setFont(lfn);
        tll4.setFont(lfn);
        tll5.setFont(lfn);
        
        tll.setForeground(Color.red);
        tll1.setForeground(Color.BLUE);
        tll2.setForeground(Color.BLUE);
        tll3.setForeground(Color.BLUE);
        tll4.setForeground(Color.BLUE);
        tll5.setForeground(Color.BLUE);
        
        tll.setBounds(400, 100, 700, 100);
        tll1.setBounds(00, 250, 200, 50);
        tll2.setBounds(300, 250, 200, 50);
        tll3.setBounds(600, 250, 200, 50);
        tll4.setBounds(900, 250, 200, 50);
        tll5.setBounds(1200, 250, 200, 50);
        tltable.setBounds(0, 300, 1500, 600);
        
        losser.add(tll);
        losser.add(tll1);
        losser.add(tll2);
        losser.add(tll3);
        losser.add(tll4);
        losser.add(tll5);
        losser.add(tltable);
        losser.add(sp);
        
        // company informatin
        
        compinfo.setVisible(false);
        compinfo.setLayout(null);
        compinfo.setBounds(500, 200, 1500, 1500);
        
        // Data to be displayed in the JTable 
        
            
  
        // Column Names 
        String[] columnNames = { "company", "high", "low","lastprice","% change" }; 
        JTable jp ;
        try{
               myconn=DriverManager.getConnection(dburl,usr,pas);
               String sql="select count(*) from sharedata ";
               ps=myconn.prepareStatement(sql);
               rs=ps.executeQuery();
               rs.next();
               String r=rs.getString(1);
               //System.out.println(r);
               int tiii=Integer.parseInt(r);
               String[][] data = new String[tiii][5];
               int tii=0;
               sql="select * from sharedata ";
               ps=myconn.prepareStatement(sql);
               
               rs=ps.executeQuery();
               while(rs.next()&&tii<tiii){
                   data[tii][0]=rs.getString("company");
                   data[tii][1]=rs.getString("high");
                   data[tii][2]=rs.getString("low");
                   data[tii][3]=rs.getString("lastprice");
                   data[tii][4]=rs.getString("perchange");
                   
                   tii++;
                   
                   
               }
                jp = new JTable(data, columnNames); 
                jp.setRowHeight(20);
        jp.setFont(tfn);
        jp.setBounds(0, 150, 1500, 900); 
        jp.setRowHeight(20);
  
        // adding it to JScrollPane 
        jp.setVisible(true);
         jp.setEnabled(false);
        compinfo.add(jp);
        
        }catch(Exception tgp){
            tgp.printStackTrace();
            
        }
        
        JLabel ci1,ci2,ci3,ci4,ci5;
        l=new JLabel("company Info");
        ci1=new JLabel("company");
        ci2=new JLabel("high");
        ci3=new JLabel("low");
        ci4=new JLabel("lastprice");
        ci5=new JLabel("% change");
        
        l.setFont(fn);
        ci1.setFont(lfn);
        ci2.setFont(lfn);
        ci3.setFont(lfn);
        ci4.setFont(lfn);
        ci5.setFont(lfn);
        
        l.setForeground(Color.red);
        ci1.setForeground(Color.BLUE);
        ci2.setForeground(Color.BLUE);
        ci3.setForeground(Color.BLUE);
        ci4.setForeground(Color.BLUE);
        ci5.setForeground(Color.BLUE);
        
        
        l.setBounds(500, 00, 800, 100);
        ci1.setBounds(00, 120, 200, 30);
        ci2.setBounds(300, 120, 200, 30);
        ci3.setBounds(600, 120, 200, 30);
        ci4.setBounds(900, 120, 200, 30);
        ci5.setBounds(1200, 120, 200, 30);
        
        backcomp.setBackground(Color.decode("#3498DB"));
        backcomp.setForeground(Color.white);
        backcomp.addActionListener(this);
        backcomp.setBounds(10, 10, 100, 30);
        backcomp.setVisible(true);
        
        compinfo.add(backcomp);
        compinfo.add(l);
        compinfo.add(ci1);
        compinfo.add(ci1);
        compinfo.add(ci2);
        compinfo.add(ci3);
        compinfo.add(ci4);
        compinfo.add(ci5);
        
          
           // user info
        
        
        userinfo.setVisible(false);
        userinfo.setLayout(null);
        userinfo.setBounds(500, 200, 1500, 1500);
        
        String[] columnNames1 = { "username", "password", "gander","fname","email","address","state","district","city" }; 
        JTable jp1 ;
        try{
               myconn=DriverManager.getConnection(dburl,usr,pas);
               String sql="select count(*) from registration ";
               ps=myconn.prepareStatement(sql);
               rs=ps.executeQuery();
               rs.next();
               String r=rs.getString(1);
              // System.out.println(r);
               int tiii=Integer.parseInt(r);
               String[][] data = new String[tiii][9];
               int tii=0;
               sql="select * from registration ";
               ps=myconn.prepareStatement(sql);
               
               rs=ps.executeQuery();
               while(rs.next()&&tii<tiii){
                   data[tii][0]=rs.getString("username");
                   data[tii][1]=rs.getString("password");
                   data[tii][2]=rs.getString("gander");
                   data[tii][3]=rs.getString("email");
                   data[tii][4]=rs.getString("address");
                   data[tii][5]=rs.getString("state");
                   data[tii][6]=rs.getString("district");
                   data[tii][7]=rs.getString("city");
                   data[tii][8]=rs.getString("status");
                   tii++;
                   
                   
               }
                jp1 = new JTable(data, columnNames1); 
                jp1.setRowHeight(18);
        jp1.setFont(tfn);
        jp1.setBounds(0, 150, 1450, 900); 
        //jp1.setRowHeight(20);
  
        // adding it to JScrollPane 
        jp1.setVisible(true);
        jp1.setEnabled(false);
         
        userinfo.add(jp1);
        
        }catch(Exception tgp){
            tgp.printStackTrace();
            
        }
        JLabel ui1,ui2,ui3,ui4,ui5,ui6,ui7,ui8,ui9;
        l=new JLabel("User Info");
        ui1=new JLabel("username");
        ui2=new JLabel("password");
        ui3=new JLabel("gander");
        ui4=new JLabel("address");
        ui5=new JLabel("email");
        ui6=new JLabel("state");
        ui7=new JLabel("district");
        ui8=new JLabel("city");
        ui9=new JLabel("status");
        l.setFont(fn);
        ui1.setFont(tfn);
        ui2.setFont(tfn);
        ui3.setFont(tfn);
        ui4.setFont(tfn);
        ui5.setFont(tfn);
        ui6.setFont(tfn);
        ui7.setFont(tfn);
        ui8.setFont(tfn);
        ui9.setFont(tfn);
        
        l.setForeground(Color.red);
        ui1.setForeground(Color.BLUE);
        ui2.setForeground(Color.BLUE);
        ui3.setForeground(Color.BLUE);
        ui4.setForeground(Color.BLUE);
        ui5.setForeground(Color.BLUE);
        ui6.setForeground(Color.BLUE);
        ui7.setForeground(Color.BLUE);
        ui8.setForeground(Color.BLUE);
        ui9.setForeground(Color.BLUE);
        
        l.setBounds(500, 00, 800, 100);
        ui1.setBounds(00, 120, 180, 30);
        ui2.setBounds(165, 120, 180, 30);
        ui3.setBounds(323, 120, 180, 30);
        ui4.setBounds(490, 120, 180, 30);
        ui5.setBounds(647, 120, 180, 30);
        ui6.setBounds(804, 120, 180, 30);
        ui7.setBounds(971, 120, 180, 30);
        ui8.setBounds(1128, 120, 180, 30);
        ui9.setBounds(1295, 120, 180, 30);
        
        backuser.setBackground(Color.decode("#3498DB"));
        backuser.setForeground(Color.white);
        backuser.addActionListener(this);
        backuser.setBounds(10, 10, 100, 30);
        
        userinfo.add(l);
        userinfo.add(ui1);
        userinfo.add(ui2);
        userinfo.add(ui3);
        userinfo.add(ui4);
        userinfo.add(ui5);
        userinfo.add(ui6);
        userinfo.add(ui7);
        userinfo.add(ui8);
        userinfo.add(ui9);
        userinfo.add(backuser);
        
        
        
        
        // change user status
        
        userstatus.setVisible(false);
        userstatus.setLayout(null);
        userstatus.setBounds(500, 200, 1500, 1500);
        
        l=new JLabel("update user status");
        JLabel us=new JLabel("user name:");
        
        l.setFont(fn);
        us.setFont(lfn);
        tus.setFont(tfn);
        
        l.setForeground(Color.red);
        
        actbu.setBackground(Color.decode("#3498DB"));
        actbu.setForeground(Color.white);
        actbu.addActionListener(this);
        actbu.setFont(bfn);
        
        dactbu.setBackground(Color.decode("#3498DB"));
        dactbu.setForeground(Color.white);
        dactbu.addActionListener(this);
        dactbu.setFont(bfn);
        
        l.setBounds(300, 50, 900, 100);
        us.setBounds(400, 200, 200, 50);
        tus.setBounds(600, 200, 200, 50);
        actbu.setBounds(400, 350, 200, 100);
        dactbu.setBounds(700, 350, 200, 100);
        
        userstatus.add(l);
        userstatus.add(us);
        userstatus.add(tus);
        userstatus.add(actbu);
        userstatus.add(dactbu);
        
        
        
        
        
        
        
        
        
        
        
        h.add(homep);
        h.add(pl);
        h.add(pup);
        h.add(logn);
        h.add(alogin);
        h.add(n);
        h.add(cont);
        h.add(abut);
        h.add(sus);
        h.add(share);
        h.add(adminpage);
        h.add(newspage);
        h.add(datapage);
        h.add(updatedatapage);
        h.add(gainer);
        h.add(losser);
        h.add(compinfo);
        h.add(userinfo);
        h.add(userstatus);
        
        
 }
 
public void run()
{
    while(true)
    {
        ta.append(newslist[il]+"\n \n");
        
        if(ShouldScroll())
        {
            
            SwingUtilities.invokeLater(new Runnable(){
                
                
                @Override
                public void run()
                {
                    spane.getVerticalScrollBar().setValue(spane.getVerticalScrollBar().getMaximum());
                    
                    
                    
                }
                
                
            }
            
            
            
            
            
            
            );
            
        }
        
        try
        {
            Thread.sleep(2000);
            if(il>=5)
                il=0;
            else
                il++;
        }
        catch(Exception mar){
            mar.printStackTrace();
        }
        
        
    }
    
    
    
    
}

public boolean ShouldScroll()
{
    int minval=spane.getVerticalScrollBar().getValue() + spane.getVerticalScrollBar().getVisibleAmount();
    int maxval=spane.getVerticalScrollBar().getMaximum();
    return true;//minval==maxval;
}
 
 

 

 public void actionPerformed(ActionEvent e) 
    {
        
        
        if(e.getSource()==regbu)
        { 
            String user=t1.getText();

                    
            String pass=t2.getText();
            String conpass=t3.getText();
             
            String gend=genderbox1.getSelectedItem().toString();
            
            
            String st=statename1.getSelectedItem().toString();
            if(st=="--select state--")
            {
                st=null;
            }
            //System.out.println(st);
            try{
             dt=districtname1.getSelectedItem().toString();
             if(dt=="--select district--")
            {
                dt=null;
            }
             
            }
            catch(Exception nul){
                dt=null;
                ct=null;
            }
            try{
             
             ct=cityname1.getSelectedItem().toString();
             if(ct=="--select city--")
            {
                ct=null;
            }
            }
            catch(Exception nul){
                
                ct=null;
            }
            String fname=t5.getText();
            String address=t6.getText();
            String email=t7.getText();
            if (isValid(email)) 
            {
                em=1;
            }
            else
            {
                //JOptionPane.showMessageDialog(null,"Email address not valid  ");
                em=0;
               
            }
            
            String imgpath="D:\\registration form photo\\"+getn;
            BufferedImage ima = null;
    File fi = null;

    //read image file
    try{
      fi = new File(filename);
     
      ima = ImageIO.read(fi);
    }catch(Exception ew){
      //System.out.println("Error: "+ew);
      
    }
     //write image
    try{
      fi = new File("D:\\registration form photo\\"+getn);
      ImageIO.write(ima, "jpg", fi);
    }catch(Exception ew){
      //System.out.println("Error: "+ew);
    }
             
            
            try
            {
                myconn=DriverManager.getConnection(dburl,usr,pas);
                ps=myconn.prepareStatement("insert into registration values(?,?,?,?,?,?,?,?,?,?,?)");
                ps.setString(1, user);
                ps.setString(2, pass);
                ps.setString(3, conpass);
                ps.setString(4, gend);
                ps.setString(5, fname);
                ps.setString(6, address);
                ps.setString(7, email);
                ps.setString(8, st);
                ps.setString(9, dt);
                ps.setString(10, ct);
                //try{
                ps.setString(11, imgpath);
                //}
                /*catch(Exception ew){
                    ps.setString(11,null);
                }*/
                 
                if(pass.equalsIgnoreCase(conpass)&& !user.isEmpty() && !pass.isEmpty() && !conpass.isEmpty() && !gend.isEmpty() && !fname.isEmpty() && !address.isEmpty() && !email.isEmpty() && em==1  && st!=null)
                {
                    try
                    {
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null,"you are succesfully created your account now you can login!!!");
                    
                    cont.setVisible(false);
                    n.setVisible(false);
                    alogin.setVisible(false);
                    homep.setVisible(false);
                    
                    abut.setVisible(false);  
                    share.setVisible(false);
                    sus.setVisible(false);
                    updatedatapage.setVisible(false);
                    losser.setVisible(false);
            gainer.setVisible(false);
                    logn.setVisible(true);
                  
                    }
                    catch(Exception username)
                    {
                        
                        JOptionPane.showMessageDialog(null,"This user name is already exist kindly change it");
                        t1.setText("");
                    }
                }
               else if(user.isEmpty()|| pass.isEmpty() || conpass.isEmpty() || gend.isEmpty() || fname.isEmpty() || address.isEmpty() || email.isEmpty() || st==null)
                {
                   JOptionPane.showMessageDialog(null,"Fill all entries "); 
                }
               else
               {
                   if(em==0)
                {
                    JOptionPane.showMessageDialog(null,"Email address not valid  ");
                }
                if(!pass.equalsIgnoreCase(conpass)) 
                {
                    JOptionPane.showMessageDialog(null,"Password didn't match");
                    t2.setText("");
                    t3.setText("");
                }
               }
            }
            catch(Exception ex){
                 JOptionPane.showMessageDialog(null,ex);
                ex.printStackTrace();
            }
          
            
            
            
        }
        if(e.getSource()==resbu)
        {
            t1.setText("");
            t2.setText("");
            t3.setText("");
            genderbox1.setSelectedItem("Male");
            t5.setText("");
            t6.setText("");
            t7.setText("");
            l111.setIcon(null);
            l111.setText("SELECT IMAGE :");
            statename1.setSelectedItem("--select state--");
            districtname1.setSelectedItem("--select district--");
            cityname1.setSelectedItem("--select city--");
            districtname1.setEnabled(false);
            cityname1.setEnabled(false);
            c1.setVisible(true);
            c2.setVisible(true);
            c3.setVisible(true);
            c4.setVisible(true);
            c5.setVisible(true);
            c6.setVisible(true);
            c7.setVisible(true);
        }
        
        if(e.getSource()==createbu)
        {
            statename1.setSelectedItem("--select state--");
            districtname1.setSelectedItem("--select district--");
            cityname1.setSelectedItem("--select city--");
           // jf();
           alogin.setVisible(false);
            homep.setVisible(false);
            logn.setVisible(false);
            abut.setVisible(false);  
            share.setVisible(false);
            sus.setVisible(false);
            cont.setVisible(false);
            updatedatapage.setVisible(false);
            losser.setVisible(false);
            gainer.setVisible(false);
           n.setVisible(true);
           
        }
        if(e.getSource()==profile  ){
            
            String status=null;
            
           try
        {
               usrname=tlog.getText();
               
               myconn=DriverManager.getConnection(dburl,usr,pas);
               String detail="select * from registration where username='"+usrname+"'";
               
               ps=myconn.prepareStatement(detail);
               rs=ps.executeQuery();
               
               
               while(rs.next())
               {
                   
                    sname=rs.getString("username");
                    sgander=rs.getString("gander");
                    sfather=rs.getString("fathername");
                    sadd=rs.getString("address");
                    semail=rs.getString("email");
                    sstate=rs.getString("state");
                    sdist=rs.getString("district");
                    scity=rs.getString("city");
                    simg=rs.getString("imagepath");
                    status=rs.getString("status");
                    
               }
             
             
        l=new JLabel("WELCOME");
        l1=new JLabel("NAME :");
        l4=new JLabel("GANDER :");
        l5=new JLabel("FATHER NAME :");
        l6=new JLabel("ADDRESS :");
        l7=new JLabel("EMAIL :");
        l8=new JLabel("STATE :");
        l9=new JLabel("DISTRICT :");
        l10=new JLabel("CITY :");
       // l11=new JLabel("LOADING IMAGE...");
        
        l.setFont(fn);
        l1.setFont(lfn);
        l4.setFont(lfn);
        l5.setFont(lfn);
        l6.setFont(lfn);
        l7.setFont(lfn);
        l8.setFont(lfn);
        l9.setFont(lfn);
        l10.setFont(lfn);
        l11.setFont(lfn);
        a1.setFont(tlfn);
        a2.setFont(tlfn);
        a3.setFont(tlfn);
        a4.setFont(tlfn);
        a5.setFont(tlfn);
        a6.setFont(tlfn);
        a7.setFont(tlfn);
        a8.setFont(tlfn);
        statename.setFont(tfn);
        districtname.setFont(tfn);
        cityname.setFont(tfn);
        
        
        a1.setText(sname);
        a2.setText(sgander);
        a3.setText(sfather);
        a4.setText(sadd);
        a5.setText(semail);
        a6.setText(sstate);
        a7.setText(sdist);
        a8.setText(scity);
        ImageIcon sad=new ImageIcon(new ImageIcon(simg).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        l11.setText("");
        l11.setIcon(sad);
        
         
         statename.setEditable(true);
         districtname.setEditable(true);
         cityname.setEditable(true);
        genderbox.setSelectedItem(sgander);
            statename.setSelectedItem(sstate);
            districtname.setSelectedItem(sdist);
            cityname.setSelectedItem(scity);
          
        /*
         if(imch==0){
        ImageIcon ii=new ImageIcon(new ImageIcon(simg).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        l11.setText("");
              l11.setIcon(ii);
              System.out.println(simg+"1");
        }
        else
        {
            ImageIcon ii=new ImageIcon(new ImageIcon(simg).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
            l11.setText("");
              l11.setIcon(ii);
              imch=0;
              System.out.println(simg+"2");
        } 
         */
            
        }catch(Exception ew )
        {
            ew.printStackTrace();
        }
            
            
            
            
            
            
            
            
            
            
          //  home();
            
            if(status.equalsIgnoreCase("a"))
            {
            cont.setVisible(false);
            n.setVisible(false);
            alogin.setVisible(false);
            homep.setVisible(false);
            logn.setVisible(false);
            abut.setVisible(false);  
            share.setVisible(false);
            updatedatapage.setVisible(false);
            profile.setVisible(true);
            marquee.setVisible(false);
                   userbu.setVisible(false);
                   losser.setVisible(false);
            gainer.setVisible(false);
                   logoutbu1.setVisible(true);
                   logoutbu1.setEnabled(true);
                   sus.setVisible(true);
                   userstatus.setVisible(false);
                   adminbu.setEnabled(false);
            }
            else{
                JOptionPane.showMessageDialog(null,"your account is deactivated kindly contact to admin");
            }
            
        }
        
       
        if(e.getSource()==admin)
        {
            
            
            String adname=tlogin.getText();
            
            
            String adpass=tpass.getText();
            
            //System.out.println(tlogin+" "+tpass);
            
             try{
                   
                   
                   
                   dconn=DriverManager.getConnection(dburl,usr,pas);
                   String dissql="select * from admintable where adminid='"+adname+"'";
               dps=myconn.prepareStatement(dissql);
               drs=dps.executeQuery();
               String pass=null;
               
               
               while(drs.next()){
                   
                    pass=drs.getString("adminpass");
                    
                    
               }
               
               if(adpass.equalsIgnoreCase(pass)){
                   
                   
                   adminpage.setVisible(true);
                   logn.setVisible(false);
                   sus.setVisible(false);
            
            cont.setVisible(false);
            n.setVisible(false);
            alogin.setVisible(false);
            homep.setVisible(false);
            logn.setVisible(false);
            abut.setVisible(false);
                   profile.setVisible(false);
                   share.setVisible(false);
                   losser.setVisible(false);
            gainer.setVisible(false);
                   updatedatapage.setVisible(false);
               logoutbuad.setVisible(true);
                   adminbu.setVisible(false);
            adminbu1.setVisible(true);
            userbu.setEnabled(false);
            userstatus.setVisible(false);
               registerbu.setEnabled(false);
                   
                   
               }
               else if(pass==null)
               {
                   JOptionPane.showMessageDialog(null,"User name and password didn't matched");
               }
               else
               {
                   JOptionPane.showMessageDialog(null,"Incorrect password");
               }
               
            
        }catch(Exception login )
                       {
                           JOptionPane.showMessageDialog(null,"User name and password didn't matched");
                       }
                       
                       }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        if(e.getSource()==logbu)
        {
        
            share.setVisible(false);
            usrname=tlog.getText();
            String usame=tlog.getText();
            String status=null;
            usrcheck=usrname;
            String password=tlpass.getText();
            tlog.setEditable(true);
            tlpass.setEditable(true);
             try{
                   
                   
                   
                   dconn=DriverManager.getConnection(dburl,usr,pas);
                   String dissql="select * from registration where username='"+usrname+"'";
               dps=myconn.prepareStatement(dissql);
               drs=dps.executeQuery();
               String pass=null;
               
               
               while(drs.next()){
                   
                    pass=drs.getString("password");
                    sname=drs.getString("username");
                    sgander=drs.getString("gander");
                    sfather=drs.getString("fathername");
                    sadd=drs.getString("address");
                    semail=drs.getString("email");
                    sstate=drs.getString("state");
                    sdist=drs.getString("district");
                    scity=drs.getString("city");
                    simg=drs.getString("imagepath");
                    status=drs.getString("status");
                    
                    
                    
               }
               
               if(password.equalsIgnoreCase(pass) && status.equalsIgnoreCase("a")){
                   
                    cont.setVisible(false);
            n.setVisible(false);
            alogin.setVisible(false);
            homep.setVisible(false);
            logn.setVisible(false);
            abut.setVisible(false);  
            share.setVisible(false);
            updatedatapage.setVisible(false);
            profile.setVisible(true);
            marquee.setVisible(false);
                   userbu.setVisible(false);
                   losser.setVisible(false);
            gainer.setVisible(false);
                   logoutbu1.setVisible(true);
                   logoutbu1.setEnabled(true);
                   sus.setVisible(true);
                   userstatus.setVisible(false);
                   adminbu.setEnabled(false);
                   
                   a1.setText(sname);
                   a2.setText(sgander);
                   a3.setText(sfather);
                   a4.setText(sadd);
                   a5.setText(semail);
                  a6.setText(sstate);
                  a7.setText(sdist);
                  a8.setText(scity);
                  ImageIcon sad=new ImageIcon(new ImageIcon(simg).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        l11.setText("");
        l11.setIcon(sad);
        
         
         statename.setEditable(true);
         districtname.setEditable(true);
         cityname.setEditable(true);
        genderbox.setSelectedItem(sgander);
            statename.setSelectedItem(sstate);
            districtname.setSelectedItem(sdist);
            cityname.setSelectedItem(scity);
          
                   
                   
               }
               else if(!status.equalsIgnoreCase("a")){
                JOptionPane.showMessageDialog(null,"your account is deactivated kindly contact to admin");
            }
               else if(pass==null)
               {
                   JOptionPane.showMessageDialog(null,"User name and password didn't matched");
               }
               else
               {
                   JOptionPane.showMessageDialog(null,"Incorrect password");
               }
               
            
        }catch(Exception login )
                       {
                           JOptionPane.showMessageDialog(null,"User name and password didn't matched");
                       }
                       
                       }
        
        
        
        if(e.getSource()==logoutbu1)
        {
            //succesframe.setSize(50, 50);
            //succesframe.setLocation(500, 500);
            tlpass.setText("");
            profile.setVisible(false);
            userbu.setVisible(true);
            //tlogin.setText("");
           // jlogin();
           sus.setVisible(false);
            share.setVisible(false);
            cont.setVisible(false);
            n.setVisible(false);
            alogin.setVisible(false);
            homep.setVisible(false);
            logoutbu1.setVisible(false);
            adminbu.setEnabled(true);
            abut.setVisible(false);
           updatedatapage.setVisible(false);
           losser.setVisible(false);
            gainer.setVisible(false);
            logn.setVisible(true);
            
            
        }
        
        if(e.getSource()==editbu)
        {
            
            
            
            a1.setOpaque(false);
            a1.setBorder(null);
            a1.setEditable(false);
            a3.setOpaque(true);
            
            a3.setEditable(true);
            a4.setOpaque(true);
            a4.setBorder(null);
            a4.setEditable(true);
            
            statename.setEnabled(true);
            districtname.setEnabled(true);
            cityname.setOpaque(true);
            cityname.setEnabled(true);
            //genderbox.setEnabled(true);
            updatebu.setEnabled(true);
            updatebu.setVisible(true);
            editbu.setEnabled(false);
            editbu.setVisible(false);
            loadButton.setVisible(true);
            loadButton.setEnabled(true);
                loadButton.addActionListener(ev -> {
             
      JFileChooser fc = new JFileChooser(System.getProperty("user.home"));
      fc.addChoosableFileFilter(new FileNameExtensionFilter("Image files",
          new String[] { "png", "jpg", "jpeg", "gif" }));
      if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
        try {
          Image image = ImageIO.read(fc.getSelectedFile());
          File f=fc.getSelectedFile();
          getnn=f.getName();
           filename=f.getAbsolutePath();
         
          if (image != null) {
              ImageIcon ii=new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
              l11.setText("");
              l11.setIcon(ii);
            
      
          }
        } catch (Exception ex) {
          ex.printStackTrace();
        }
      }
    });
                updatebu.addActionListener(this);
            
        }
        
        if(e.getSource()==updatebu)
        {
            try{
                String ucity=null,udist=null, ustate=null;
            String uadd=a4.getText();
            ustate=statename.getSelectedItem().toString();
            try{
             udist=districtname.getSelectedItem().toString();
            }
            catch(Exception ud)
            {
                udist=null;
                ucity=null;
            }
            try{
             ucity=cityname.getSelectedItem().toString();
            }
            catch(Exception uc){
                ucity=null;
            }
            String uimg=simg;
           
            
            if(filename==null)
                filename=uimg;
            uimg=filename;
           /* if(uadd.equalsIgnoreCase(sadd) && ustate.equalsIgnoreCase(sstate) && udist.equalsIgnoreCase(sdist) && ucity.equalsIgnoreCase(scity) && uimg.equalsIgnoreCase(simg))
            {
                JOptionPane.showMessageDialog(null,"no change found");
            }*/
            
                myconn=DriverManager.getConnection(dburl,usr,pas);
                stmt=myconn.createStatement();
                
                if(! (uadd.equalsIgnoreCase(sadd) ))
                { 
                    stmt.executeUpdate("update  registration set address='"+uadd+"' where username='"+usrname+"'");
                    
                }
                if(! (ustate.equalsIgnoreCase(sstate) ))
                { 
                   /* stmt.executeUpdate("update  registration set state='"+ustate+"' where username='"+usrname+"'");
                    stmt.executeUpdate("update  registration set district='"+udist+"' where username='"+usrname+"'");
                    stmt.executeUpdate("update  registration set city='"+ucity+"' where username='"+usrname+"'");*/
                    ps=myconn.prepareStatement("update  registration set state=? where username='"+usrname+"'");
                    ps.setString(1, ustate);
                    ps.executeUpdate();
                    ps=myconn.prepareStatement("update  registration set district=? where username='"+usrname+"'");
                    ps.setString(1, udist);
                    ps.executeUpdate();
                    ps=myconn.prepareStatement("update  registration set city=? where username='"+usrname+"'");
                    ps.setString(1, ucity);
                    ps.executeUpdate();
                    a6.setText("");
                    a7.setText("");
                    a8.setText("");
                    
                }
                try{
                if(! (udist.equalsIgnoreCase(sdist) ))
                { 
                    stmt.executeUpdate("update  registration set district='"+udist+"' where username='"+usrname+"'");
                    stmt.executeUpdate("update  registration set city='"+ucity+"' where username='"+usrname+"'");
                    a7.setText("");
                    a8.setText("");
                }
                }catch(Exception exd)
                {
                    
                }
                try{
                if(! (ucity.equalsIgnoreCase(scity) ))
                { 
                    stmt.executeUpdate("update  registration set city='"+ucity+"' where username='"+usrname+"'");
                    a8.setText("");
                    
                }
                }catch(Exception exd)
                {
                    
                }
                if(! (uimg.equalsIgnoreCase(simg) ))
                    
                { 
                   imgpa="D:\\registration form photo\\"+getnn;
            BufferedImage ima = null;
    File fi = null;

    //read image file
    try{
      fi = new File(filename);
     
      ima = ImageIO.read(fi);
    }catch(IOException ew){
      System.out.println("Error: "+ew);
    }
     //write image
    try{
      fi = new File("D:\\registration form photo\\ "+getnn);
      ImageIO.write(ima, "jpg", fi);
    }catch(IOException ew){
      System.out.println("Error: "+ew);
    }
                    System.out.println(imgpa);
                    ps=myconn.prepareStatement("update  registration set imagepath=? where username='"+usrname+"'");
                    ps.setString(1, imgpa);
                    l11.setText("");
                    ps.executeUpdate();
                    imch=1;
                   // stmt.executeUpdate("update  registration set imagepath='"+imgpa+"' where username='"+usrname+"'");
                    //String imgpa="D:\\registration form photo\\"+uimg;
                    //stmt.executeUpdate("update  registration set imagepath='D:\\registration form photo\\ "+getnn+"' where username='"+usrname+"'");
                    
                    
                }
                JOptionPane.showMessageDialog(null,"sucessfully updated");
                
                //succesframe();
               
            share.setVisible(false);
            cont.setVisible(false);
            n.setVisible(false);
            alogin.setVisible(false);
            homep.setVisible(false);
            logn.setVisible(false);
            abut.setVisible(false);
            marquee.setVisible(false);
            adminpage.setVisible(false);
            datapage.setVisible(false);
            newspage.setVisible(false);
            updatedatapage.setVisible(false);
            sus.setVisible(true);
            
            
              a1.setOpaque(false);
            a1.setBorder(null);
            a1.setEditable(false);
            a3.setOpaque(false);
            a3.setBorder(null);
            a3.setEditable(false);
            a4.setOpaque(false);
            a4.setBorder(null);
            a4.setEditable(false);
            a5.setOpaque(false);
            a5.setBorder(null);
            a5.setEditable(false);
            statename.setEnabled(false);
            districtname.setEnabled(false);
            cityname.setOpaque(false);
            cityname.setEnabled(false);
            genderbox.setEnabled(false);
            updatebu.setEnabled(false);
            updatebu.setVisible(false);
            loadButton.setEnabled(false);
            loadButton.setVisible(false);
            
            editbu.setVisible(true);
            editbu.setEnabled(true);
                    
            
             }
            catch(Exception exup)
            {
               // 
                JOptionPane.showMessageDialog(null,"worrng sql"+exup);
            }
            
        }
        
        if(e.getSource()==homebu){
           
            logn.setVisible(false);
            alogin.setVisible(false);
            n.setVisible(false);
            cont.setVisible(false);
            abut.setVisible(false);
            sus.setVisible(false);
            share.setVisible(true);
            adminpage.setVisible(false);
            datapage.setVisible(false);
            newspage.setVisible(false);
            updatedatapage.setVisible(false);
            losser.setVisible(false);
            gainer.setVisible(false);
            compinfo.setVisible(false);
            userinfo.setVisible(false);
            userstatus.setVisible(false);
            //homep.setVisible(true);
            marquee.setVisible(true);
        }
        
        if(e.getSource()==userbu){
            
            tlpass.setText("");
            
          marquee.setVisible(false);
          cont.setVisible(false);
          abut.setVisible(false);
          sus.setVisible(false);
          share.setVisible(false);
          homep.setVisible(false);
          n.setVisible(false);
          alogin.setVisible(false);
          adminpage.setVisible(false);
            datapage.setVisible(false);
            newspage.setVisible(false);
            updatedatapage.setVisible(false);
            losser.setVisible(false);
            gainer.setVisible(false);
            compinfo.setVisible(false);
            userinfo.setVisible(false);
            userstatus.setVisible(false);
          logn.setVisible(true);
        }
        
        if(e.getSource()==adminbu)
        {
            tpass.setText("");
            marquee.setVisible(false);
            cont.setVisible(false);
            abut.setVisible(false);
            sus.setVisible(false);
            share.setVisible(false);
            homep.setVisible(false);
            n.setVisible(false);
            logn.setVisible(false);
            adminpage.setVisible(false);
            datapage.setVisible(false);
            newspage.setVisible(false);
            updatedatapage.setVisible(false);
            losser.setVisible(false);
            gainer.setVisible(false);
            compinfo.setVisible(false);
            userinfo.setVisible(false);
            userstatus.setVisible(false);
            alogin.setVisible(true);
        }
        
        if(e.getSource()==registerbu)
        {
            marquee.setVisible(false);
            cont.setVisible(false);
            abut.setVisible(false);
            sus.setVisible(false);
            share.setVisible(false);
            alogin.setVisible(false);
            homep.setVisible(false);
            logn.setVisible(false);
            adminpage.setVisible(false);
            datapage.setVisible(false);
            newspage.setVisible(false);
            updatedatapage.setVisible(false);
            losser.setVisible(false);
            gainer.setVisible(false);
            compinfo.setVisible(false);
            userinfo.setVisible(false);
            userstatus.setVisible(false);
            n.setVisible(true);
        }
        
        if(e.getSource()==contactbu)
        {
            marquee.setVisible(false);
            abut.setVisible(false);
            sus.setVisible(false);
            share.setVisible(false);
            n.setVisible(false);
            alogin.setVisible(false);
            homep.setVisible(false);
            logn.setVisible(false);
            adminpage.setVisible(false);
            datapage.setVisible(false);
            newspage.setVisible(false);
            updatedatapage.setVisible(false);
            losser.setVisible(false);
            gainer.setVisible(false);
            compinfo.setVisible(false);
            userinfo.setVisible(false);
            userstatus.setVisible(false);
            cont.setVisible(true);
        }
        
        if(e.getSource()==aboutbu){
           
           marquee.setVisible(false);
            sus.setVisible(false);
            share.setVisible(false);
            cont.setVisible(false);
            n.setVisible(false);
            alogin.setVisible(false);
            homep.setVisible(false);
            logn.setVisible(false);
            adminpage.setVisible(false);
            datapage.setVisible(false);
            newspage.setVisible(false);
            updatedatapage.setVisible(false);
            losser.setVisible(false);
            gainer.setVisible(false);
            compinfo.setVisible(false);
            userinfo.setVisible(false);
            userstatus.setVisible(false);
            abut.setVisible(true);
        }
        
        if(e.getSource()==news)
        {
            
            marquee.setVisible(false);
            sus.setVisible(false);
            share.setVisible(false);
            cont.setVisible(false);
            n.setVisible(false);
            alogin.setVisible(false);
            homep.setVisible(false);
            logn.setVisible(false);
            abut.setVisible(false);
            adminpage.setVisible(false);
            datapage.setVisible(false);
            updatedatapage.setVisible(false);
            losser.setVisible(false);
            gainer.setVisible(false);
            compinfo.setVisible(false);
            userinfo.setVisible(false);
            userstatus.setVisible(false);
            newspage.setVisible(true);
            
            
            
        }
        
        if(e.getSource()==sharedata){
            
            marquee.setVisible(false);
            sus.setVisible(false);
            share.setVisible(false);
            cont.setVisible(false);
            n.setVisible(false);
            alogin.setVisible(false);
            homep.setVisible(false);
            logn.setVisible(false);
            abut.setVisible(false);
            adminpage.setVisible(false);
            newspage.setVisible(false);
            updatedatapage.setVisible(false);
            losser.setVisible(false);
            gainer.setVisible(false);
            compinfo.setVisible(false);
            userinfo.setVisible(false);
            userstatus.setVisible(false);
            datapage.setVisible(true);
            
            
        }
        
        
        if(e.getSource()==uploadnews)
        {
            String newst=newstext.getText().toString();
            System.out.println(newst);
            try{
            myconn=DriverManager.getConnection(dburl,usr,pas);
                ps=myconn.prepareStatement("insert into newstable (news) values(?)");
                ps.setString(1, newst);
                if(!newst.isEmpty()){
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null,"suscessfully uploaded");
                newstext.setText("");
                uploadnews.setText("upload more");
                }
                else
                    JOptionPane.showMessageDialog(null,"fill news");
            }catch(Exception upl)
            {
                upl.printStackTrace();
            }
                
        }
        
        if(e.getSource()==uploaddata)
        {
            String comp=dt1.getText();
            String hp=dt2.getText();
            String lp=dt3.getText();
            String lastp=dt4.getText();
            String chg=dt5.getText();
            
            
            
            try{
                
                myconn=DriverManager.getConnection(dburl,usr,pas);
                ps=myconn.prepareStatement("insert into sharedata(company,high,low,lastprice,perchange) values (?,?,?,?,?)");
                ps.setString(1, comp);
                ps.setString(2, hp);
                ps.setString(3, lp);
                ps.setString(4, lastp);
                ps.setString(5, chg);
                
                if(!comp.isEmpty() && !hp.isEmpty() && !lp.isEmpty() && !lastp.isEmpty() && !chg.isEmpty())
                {
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null,"suscessfully uploaded now u can upload more");
                    dt1.setText("");
                    dt2.setText("");
                    dt3.setText("");
                    dt4.setText("");
                    dt5.setText("");
                    uploaddata.setText("Upload more");
                    
                    
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Fill all entries");
                }
                
                
            }catch(Exception upld)
            {
              
                upld.printStackTrace();
                
            }
            
            
        }
        
        
        if(e.getSource()==backnews || e.getSource()==backdata||e.getSource()==backupdate||e.getSource()==backcomp||e.getSource()==backuser)
        {
          marquee.setVisible(false);
            sus.setVisible(false);
            share.setVisible(false);
            cont.setVisible(false);
            n.setVisible(false);
            alogin.setVisible(false);
            homep.setVisible(false);
            logn.setVisible(false);
            abut.setVisible(false);
            newspage.setVisible(false);
            datapage.setVisible(false);
            compinfo.setVisible(false);
            userinfo.setVisible(false);
            updatedatapage.setVisible(false);
            losser.setVisible(false);
            gainer.setVisible(false);
            userstatus.setVisible(false);
            u3.setVisible(false);
               u4.setVisible(false);
               u5.setVisible(false);
              u6.setVisible(false);
        ut2.setVisible(false);
        ut3.setVisible(false);
        ut4.setVisible(false);
        ut5.setVisible(false);
        updatesdata.setVisible(false);
        ut1.setText("");
        ut2.setText("");
        ut3.setText("");
        ut4.setText("");
        ut5.setText("");
        
            adminpage.setVisible(true);
        }
        if(e.getSource()==updatesharedata){
            marquee.setVisible(false);
            sus.setVisible(false);
            share.setVisible(false);
            cont.setVisible(false);
            n.setVisible(false);
            alogin.setVisible(false);
            homep.setVisible(false);
            logn.setVisible(false);
            abut.setVisible(false);
            newspage.setVisible(false);
            datapage.setVisible(false);
            adminpage.setVisible(false);
            losser.setVisible(false);
            gainer.setVisible(false);
            compinfo.setVisible(false);
            userinfo.setVisible(false);
            userstatus.setVisible(false);
            updatedatapage.setVisible(true);
            
        }
        
        if(e.getSource()==searchbu)
        {
             cname=ut1.getText();
            if(!cname.isEmpty()){
            try{
            dconn=DriverManager.getConnection(dburl,usr,pas);
                   String dissql="select * from sharedata where company='"+cname+"'";
               dps=myconn.prepareStatement(dissql);
               drs=dps.executeQuery();
               String pass=null;
               
        int flag=0;
        u3.setVisible(false);
               u4.setVisible(false);
               u5.setVisible(false);
              u6.setVisible(false);
        ut2.setVisible(false);
        ut3.setVisible(false);
        ut4.setVisible(false);
        ut5.setVisible(false);
        updatesdata.setVisible(false);
        
        ut2.setText("");
        ut3.setText("");
        ut4.setText("");
        ut5.setText("");
               
               while(drs.next()){
                   
                    chigh=drs.getString("high");
                    clow=drs.getString("low");
                    clast=drs.getString("lastprice");
                    cchg=drs.getString("perchange");
                   System.out.println(chigh+clow+clast+cchg);
                   
                   ut2.setText(chigh);
                   ut3.setText(clow);
                  ut4.setText(clast);
                  ut5.setText(cchg);
                  u3.setVisible(true);
               u4.setVisible(true);
               u5.setVisible(true);
              u6.setVisible(true);
        ut2.setVisible(true);
        ut3.setVisible(true);
        ut4.setVisible(true);
        ut5.setVisible(true);
        updatesdata.setVisible(true);
        flag=1;
                           
               }
               if(flag==0){
                   JOptionPane.showMessageDialog(null,"company not  exist in database");
                   ut1.setText("");
               }
                    
                    
               }catch(Exception d){
                   JOptionPane.showMessageDialog(null,"company not  exist in database");
                   d.printStackTrace();
                   
               }
            
        }else
        JOptionPane.showMessageDialog(null,"fill company name");
        
        }
        
        if(e.getSource()==updatesdata)
        {
            try{
            //System.out.println("1 "+cname+"2 "+chigh+clow+clast+cchg);
            String upname=null,uphigh=null,uplow=null,uplast=null,upchg=null;
            upname=ut1.getText();
            uphigh=ut2.getText();
            uplow=ut3.getText();
            uplast=ut4.getText();
            upchg=ut5.getText();
            if(upname.isEmpty()||uphigh.isEmpty()||uplow.isEmpty()||uplast.isEmpty()||upchg.isEmpty()){
                JOptionPane.showMessageDialog(null,"fill all entries");
            }
            else{
           
           myconn=DriverManager.getConnection(dburl,usr,pas);
                stmt=myconn.createStatement();
                
                if(! (upname.equalsIgnoreCase(cname) ))
                { 
                    stmt.executeUpdate("update  sharedata set company='"+upname+"'  where company='"+cname+"'");
                    
                }
                if(! (uphigh.equalsIgnoreCase(chigh) ))
                { 
                    stmt.executeUpdate("update  sharedata set high='"+uphigh+"'  where company='"+cname+"'");
                    
                }
                if(! (uplow.equalsIgnoreCase(clow) ))
                { 
                    stmt.executeUpdate("update  sharedata set low='"+uplow+"'  where company='"+cname+"'");
                    
                }
                if(! (uplast.equalsIgnoreCase(clast) ))
                { 
                    stmt.executeUpdate("update  sharedata set lastprice='"+uplast+"'  where company='"+cname+"'");
                    
                }
                if(! (upchg.equalsIgnoreCase(cchg) ))
                { 
                    stmt.executeUpdate("update  sharedata set perchange='"+upchg+"'  where company='"+cname+"'");
                    
                }
           JOptionPane.showMessageDialog(null,"Updated susscesfully");
           u3.setVisible(false);
               u4.setVisible(false);
               u5.setVisible(false);
              u6.setVisible(false);
        ut2.setVisible(false);
        ut3.setVisible(false);
        ut4.setVisible(false);
        ut5.setVisible(false);
        updatesdata.setVisible(false);
        ut1.setText("");
        ut2.setText("");
        ut3.setText("");
        ut4.setText("");
        ut5.setText("");
           
            }
            }
            catch(Exception upd)
            {
                JOptionPane.showMessageDialog(null,"error");
                upd.printStackTrace();
            }
            
        }
        
        if(e.getSource()==gainbu|| e.getSource()==gainbu1)
        {
            marquee.setVisible(false);
            sus.setVisible(false);
            share.setVisible(false);
            cont.setVisible(false);
            n.setVisible(false);
            alogin.setVisible(false);
            homep.setVisible(false);
            logn.setVisible(false);
            abut.setVisible(false);
            newspage.setVisible(false);
            datapage.setVisible(false);
            adminpage.setVisible(false);
            updatedatapage.setVisible(false);
            losser.setVisible(false);
            compinfo.setVisible(false);
            userinfo.setVisible(false);
            userstatus.setVisible(false);
            gainer.setVisible(true);
        }
        
        
        if(e.getSource()==losebu|| e.getSource()==losebu1)
        {
            marquee.setVisible(false);
            sus.setVisible(false);
            share.setVisible(false);
            cont.setVisible(false);
            n.setVisible(false);
            alogin.setVisible(false);
            homep.setVisible(false);
            logn.setVisible(false);
            abut.setVisible(false);
            newspage.setVisible(false);
            datapage.setVisible(false);
            adminpage.setVisible(false);
            updatedatapage.setVisible(false);
            gainer.setVisible(false);
            compinfo.setVisible(false);
            userinfo.setVisible(false);
            userstatus.setVisible(false);
            losser.setVisible(true);
        }
        if(e.getSource()==adminbu1)
        {
            marquee.setVisible(false);
            sus.setVisible(false);
            share.setVisible(false);
            cont.setVisible(false);
            n.setVisible(false);
            alogin.setVisible(false);
            homep.setVisible(false);
            logn.setVisible(false);
            abut.setVisible(false);
            newspage.setVisible(false);
            datapage.setVisible(false);
            updatedatapage.setVisible(false);
            gainer.setVisible(false);
            losser.setVisible(false);
            compinfo.setVisible(false);
            userinfo.setVisible(false);
            userstatus.setVisible(false);
            adminpage.setVisible(true);
        }
        if(e.getSource()==logoutbuad)
        {
            
             marquee.setVisible(false);
            sus.setVisible(false);
            share.setVisible(false);
            cont.setVisible(false);
            n.setVisible(false);
            
            homep.setVisible(false);
            logn.setVisible(false);
            abut.setVisible(false);
            newspage.setVisible(false);
            datapage.setVisible(false);
            updatedatapage.setVisible(false);
            gainer.setVisible(false);
            losser.setVisible(false);
            adminpage.setVisible(false);
            alogin.setVisible(true);
            adminbu1.setVisible(false);
            compinfo.setVisible(false);
            userinfo.setVisible(false);
            userstatus.setVisible(false);
            adminbu.setVisible(true);
            userbu.setEnabled(true);
            registerbu.setEnabled(true);
            tpass.setText("");
            
        }
        if(e.getSource()==uibu){
            userinfo.setVisible(true);
            marquee.setVisible(false);
            sus.setVisible(false);
            share.setVisible(false);
            cont.setVisible(false);
            n.setVisible(false);
            
            homep.setVisible(false);
            logn.setVisible(false);
            abut.setVisible(false);
            newspage.setVisible(false);
            datapage.setVisible(false);
            updatedatapage.setVisible(false);
            gainer.setVisible(false);
            losser.setVisible(false);
            adminpage.setVisible(false);
            alogin.setVisible(false);
            adminbu1.setVisible(true);
            adminbu.setVisible(false);
            userbu.setEnabled(false);
            registerbu.setEnabled(false);
            compinfo.setVisible(false);
            userstatus.setVisible(false);
            userinfo.setVisible(true);
            
        }
        
        if(e.getSource()==cibu){
            userinfo.setVisible(true);
            marquee.setVisible(false);
            sus.setVisible(false);
            share.setVisible(false);
            cont.setVisible(false);
            n.setVisible(false);
            
            homep.setVisible(false);
            logn.setVisible(false);
            abut.setVisible(false);
            newspage.setVisible(false);
            datapage.setVisible(false);
            updatedatapage.setVisible(false);
            gainer.setVisible(false);
            losser.setVisible(false);
            adminpage.setVisible(false);
            alogin.setVisible(false);
            adminbu1.setVisible(true);
            adminbu.setVisible(false);
            userbu.setEnabled(false);
            registerbu.setEnabled(false);
            userinfo.setVisible(false);
            userstatus.setVisible(false);
            compinfo.setVisible(true);
            
        }
        
        if(e.getSource()==ustatus)
        {
            userinfo.setVisible(true);
            marquee.setVisible(false);
            sus.setVisible(false);
            share.setVisible(false);
            cont.setVisible(false);
            n.setVisible(false);
            
            homep.setVisible(false);
            logn.setVisible(false);
            abut.setVisible(false);
            newspage.setVisible(false);
            datapage.setVisible(false);
            updatedatapage.setVisible(false);
            gainer.setVisible(false);
            losser.setVisible(false);
            adminpage.setVisible(false);
            alogin.setVisible(false);
            adminbu1.setVisible(true);
            adminbu.setVisible(false);
            userbu.setEnabled(false);
            registerbu.setEnabled(false);
            userinfo.setVisible(false);
            compinfo.setVisible(false);
            userstatus.setVisible(true);
        }
        
        if(e.getSource()==actbu)
        {
            String useract=tus.getText();
            try{
                myconn=DriverManager.getConnection(dburl,usr,pas);
                stmt=myconn.createStatement();
                int flag=0;
                String abc;
                
                   String dissql="select * from registration";
               dps=myconn.prepareStatement(dissql);
               drs=dps.executeQuery();
                while(drs.next())
                {
                  abc=drs.getString("username");
                  
                  if(abc.equalsIgnoreCase(useract)){
                      flag=1;
                  }
                 // System.out.println(abc+" "+flag);
                }
                
                
                
                
                
                
                
                if(! useract.isEmpty()&& flag==1)
                { 
                    stmt.executeUpdate("update  registration set status='"+"a"+"' where username='"+useract+"'");
                    JOptionPane.showMessageDialog(null,"updated suscessfully");
                }
                else if(useract.isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Enter user name ");
                }
                else if(flag==0)
                {
                    JOptionPane.showMessageDialog(null,"user not exist");
                }
                
                
            }catch(Exception act)
            {
                JOptionPane.showMessageDialog(null,"user not found");
                act.printStackTrace();
            }
        }
        if(e.getSource()==dactbu)
        {
            String userdact=tus.getText();
            try{
                myconn=DriverManager.getConnection(dburl,usr,pas);
                stmt=myconn.createStatement();
                int flag=0;
                String abc;
                
                   String dissql="select * from registration";
               dps=myconn.prepareStatement(dissql);
               drs=dps.executeQuery();
                while(drs.next())
                {
                  abc=drs.getString("username");
                  
                  if(abc.equalsIgnoreCase(userdact)){
                      flag=1;
                  }
                 // System.out.println(abc+" "+flag);
                }
                
                
                
                
                
                
                
                if(! userdact.isEmpty()&& flag==1)
                { 
                    stmt.executeUpdate("update  registration set status='"+"d"+"' where username='"+userdact+"'");
                    JOptionPane.showMessageDialog(null,"updated suscessfully");
                }
                else if(userdact.isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Enter user name ");
                }
                else if(flag==0)
                {
                    JOptionPane.showMessageDialog(null,"user not exist");
                }
                
                
            }catch(Exception act)
            {
                JOptionPane.showMessageDialog(null,"user not found");
                act.printStackTrace();
            }
        }
        
       
       
        
    }
 
 
   public static boolean isValid(String email) 
    { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false; 
        return pat.matcher(email).matches(); 
    }
   
   
   
   
   
   
   public void fillnews(){
       
       try{
           
           myconn=DriverManager.getConnection(dburl,usr,pas);
               String sql="select * from newstable order by dateup desc";
               ps=myconn.prepareStatement(sql);
               rs=ps.executeQuery();
               int ne=0;
               while(rs.next()&&ne<6){
                   
                   String sa=rs.getString("news");
                   newslist[ne]=sa;
                   //System.out.println(newslist[ne] );
                   ne++;
                   
               }
           
       }
       catch(Exception xx){
           xx.printStackTrace();
           JOptionPane.showMessageDialog(null,"news dddd");
       }
       
       
       
       
       
       
       
       
       
   }
 
   
   
   public  void fillcombox(){
           
           
           try{
               myconn=DriverManager.getConnection(dburl,usr,pas);
               String sql="select * from statenam";
               ps=myconn.prepareStatement(sql);
               rs=ps.executeQuery();
               while(rs.next()){
                   String name=rs.getString("statee");
                   statename1.addItem(name);
               }
               statename1.addItemListener( this);
               
               statename1.setEditable(true);
               statename1.setSelectedItem("--select state--");
               districtname1.setEditable(true);
               districtname1.setSelectedItem("--select district--");
               cityname1.setEditable(true);
               cityname1.setSelectedItem("--select city--");
               districtname1.setEnabled(false);
               cityname1.setEnabled(false);
             }catch( Exception exp){
               JOptionPane.showMessageDialog(null,"null combobox of state name");
               
               
           }
           
           try{
               myconn=DriverManager.getConnection(dburl,usr,pas);
               String sql="select * from statenam";
               ps=myconn.prepareStatement(sql);
               rs=ps.executeQuery();
               while(rs.next()){
                   String name=rs.getString("statee");
                   statename.addItem(name);
               }
               statename.addItemListener( this);
               
              /* statename.setEditable(true);
               statename.setSelectedItem("--select state--");
               districtname.setEditable(true);
               districtname.setSelectedItem("--select district--");
               cityname.setEditable(true);
               cityname.setSelectedItem("--select city--");
               */
             }catch( Exception exp){
               JOptionPane.showMessageDialog(null,"null combobox of state name");
               
               
           }
       }
   
   public void itemStateChanged(ItemEvent ie) 
       {
           if(ie.getSource()==statename1)
           {
               
               stat=statename1.getSelectedItem().toString();
               
               statename1.setEditable(true);
               
               
            try{
               myconn=DriverManager.getConnection(dburl,usr,pas);
               String ssql="select * from statenam where statee='"+stat+"'";
               ps=myconn.prepareStatement(ssql);
               rs=ps.executeQuery();
               String id=null;
               
               while(rs.next()){
                   
                    id=rs.getString("sid");
                    
                    
               }
                districtname1.removeAllItems();
                cityname1.removeAllItems();
                   
                    String dsql="select * from statenam  s join districtnam d on s.sid =d.sid where d.sid='"+id+"'";
               ps=myconn.prepareStatement(dsql);
               rs=ps.executeQuery();
               while(rs.next()){
                   
                    String dname=rs.getString("districtt");
                   districtname1.addItem(dname);
                  
                    
               }
               districtname1.setEditable(true);
               districtname1.setSelectedItem("--select district--");
               cityname1.setEditable(true);
               cityname1.setSelectedItem("--select city--");
               districtname1.setEnabled(true);
               cityname1.setEnabled(false);
         
               
               districtname1.addItemListener(this);
               
               
               
               }catch(Exception esql)
                       {
                      // JOptionPane.showMessageDialog(null,esql);
                       }
               
              }
               if(ie.getSource()==districtname1)
               {
                   
                   
               try{
                   
                   dist=districtname1.getSelectedItem().toString();
                   
                   dconn=DriverManager.getConnection(dburl,usr,pas);
                   String dissql="select * from districtnam where districtt='"+dist+"'";
               dps=myconn.prepareStatement(dissql);
               drs=dps.executeQuery();
               String disid=null;
               
               
               while(drs.next()){
                   
                    disid=drs.getString("did");
                    
                    
               }
                cityname1.removeAllItems();
                cityname1.setEditable(true);
               cityname1.setSelectedItem("--select city--");
               cityname1.setEnabled(true);
                   
                    String dsql="select * from citynam  c join districtnam di on c.did =di.did where di.did='"+disid+"'";
               dps=dconn.prepareStatement(dsql);
               drs=dps.executeQuery();
               while(drs.next()){
                   
                    String dname=drs.getString("cityy");
                   cityname1.addItem(dname);
                    
                    
               }
                   
                   
                   
               }catch(Exception fsql)
                   
               {
                   //JOptionPane.showMessageDialog(null," district error");
               }
               
           }
               
               
           if(ie.getSource()==statename)
           {
               
               stat=statename.getSelectedItem().toString();
               
               statename.setEditable(true);
         
            try{
               myconn=DriverManager.getConnection(dburl,usr,pas);
               String ssql="select * from statenam where statee='"+stat+"'";
               ps=myconn.prepareStatement(ssql);
               rs=ps.executeQuery();
               String id=null;
               
               while(rs.next()){
                   
                    id=rs.getString("sid");
                    
                   
               }
                districtname.removeAllItems();
                cityname.removeAllItems();
                   
                    String dsql="select * from statenam  s join districtnam d on s.sid =d.sid where d.sid='"+id+"'";
               ps=myconn.prepareStatement(dsql);
               rs=ps.executeQuery();
               while(rs.next()){
                   
                    String dname=rs.getString("districtt");
                   districtname.addItem(dname);
                  
                    
               }
               districtname.setEditable(true);
               districtname.setSelectedItem("--select district--");
               cityname.setEditable(true);
               cityname.setSelectedItem("--select city--");
               
               districtname.addItemListener(this);
               
               
               
               }catch(Exception esql)
                       {
                      // JOptionPane.showMessageDialog(null,esql);
                       }
               
              }
               if(ie.getSource()==districtname)
               {
                   
                   
               try{
                   
                   dist=districtname.getSelectedItem().toString();
                   
                   dconn=DriverManager.getConnection(dburl,usr,pas);
                   String dissql="select * from districtnam where districtt='"+dist+"'";
               dps=myconn.prepareStatement(dissql);
               drs=dps.executeQuery();
               String disid=null;
               
               
               while(drs.next()){
                   
                    disid=drs.getString("did");
                    
                    
               }
                cityname.removeAllItems();
                cityname.setEditable(true);
               cityname.setSelectedItem("--select city--");
                   
                    String dsql="select * from citynam  c join districtnam di on c.did =di.did where di.did='"+disid+"'";
               dps=dconn.prepareStatement(dsql);
               drs=dps.executeQuery();
               while(drs.next()){
                   
                    String dname=drs.getString("cityy");
                   cityname.addItem(dname);
                    
                    
               }
                   
                   
                   
               }catch(Exception fsql)
                   
               {
                   
               }
               
           }
         }
   
 }
