import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException{
        Scanner scan=new Scanner(System.in);
        ArrayList<String>hero_tut = new ArrayList<>();
        ArrayList<String>kapi_tut=new ArrayList<>();
        System.out.println("Master Yoda için 1 ,Luke Skywalker için 2 ye basınız:");
        int secim=scan.nextInt();
        Oyun pencere=new Oyun();


        File harita=new File("Harita.txt");
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(harita));
        String satir;
        String hero[];
        String hero1[];
        String kapi[];
        satir = reader.readLine();
        String a[][] = new String[14][11];
        int i=0,j=0;
        while (satir!=null) {
            if(satir.contains(":")){
                hero=satir.split(":",2);
                hero1=hero[1].split(",",2);
                kapi=hero[1].split(":",2);
                hero_tut.add(hero1[0]);
                kapi_tut.add(kapi[1]);


            }
            if(satir.contains("0")){
                a[j]=satir.split("\t",15);
                j++;
            }


            satir = reader.readLine();
        }
        pencere.draw.setList(hero_tut,kapi_tut);
        pencere.setSecim(secim);
        pencere.setMatris(a);

        pencere.setTitle("Star Wars");
        pencere.setResizable(false);
        pencere.setSize(1080, 960);
        pencere.setMinimumSize(new Dimension(1080, 960));
        pencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pencere.getContentPane().add(pencere.draw);
        pencere.pack();

        pencere.setVisible(true);
        
     }
}
