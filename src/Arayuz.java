import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.ArrayList;
import javax.imageio.*;

public class Arayuz extends JComponent {
    Graphics d;
    public String[] matris[] = new String[14][11];
    public int can = 0;
    public int ctrl = 0;
    public int x = 351;
    public int y = 351;
    public int tx=(x - 51) / 50;
    public int ty=(y-101)/50;
    int secim = 0;
    String[][] gidilen = new String[11][14];
    public ArrayList<String> hero_tut = new ArrayList();
    public ArrayList<String> kapi_tut = new ArrayList();
    public ArrayList<Karakter> olustur = new ArrayList<>();

    public void setList(ArrayList hero_tut, ArrayList kapi_tut) {
        this.hero_tut = hero_tut;
        this.kapi_tut = kapi_tut;
    }

    public void setSecim(int secim) {
        this.secim = secim;

    }

    public void moveRight() {
        x = x + 50;
        if (x > 701) {
            x = x - 50;
        } else if (matris[((y - 50) / 50 - 1)][(x - 50) / 50].equals("0")) {
            x = x - 50;
        }
        tx=(x - 51) / 50;
        ty=(y-101)/50;
        repaint();
        yakalama();
        repaint();
    }

    public void moveLeft() {
        x = x - 50;
        if (x < 51) {
            x = x + 50;
        } else if (matris[((y - 50) / 50 - 1)][(x - 50) / 50].equals("0")) {
            x = x + 50;
        }
        tx=(x - 51) / 50;
        ty=(y-101)/50;
        repaint();
        yakalama();
        repaint();
    }

    public void moveDown() {
        y = y + 50;

        if (y > 601) {
            y = y - 50;
        } else if (matris[((y - 50) / 50 - 1)][(x - 50) / 50].equals("0")) {
            y = y - 50;
        }
        tx=(x - 51) / 50;
        ty=(y-101)/50;
        repaint();
        yakalama();
        repaint();
    }

    public void moveUp() {
        y = y - 50;
        if (y < 101) {
            y = y + 50;
        } else if (matris[((y - 50) / 50 - 1)][(x - 50) / 50].equals("0")) {
            y = y + 50;
        }
        tx=(x - 51) / 50;
        ty=(y-101)/50;
        repaint();
        yakalama();
        repaint();
    }

    BufferedImage img;
    BufferedImage img1;
    BufferedImage img2;
    BufferedImage img3;
    BufferedImage img4;
    BufferedImage img5;
    BufferedImage img6;
    BufferedImage img7;
    BufferedImage imgKarakter;
    BufferedImage img8;
    public void paint(Graphics a) {
        this.d = a;

        System.out.println(tx+" "+ty);
        for (int p = 0; p < 11; p++) {
            for (int f = 0; f < 14; f++) {
                gidilen[p][f] = "0";
            }
        }
        for (int i = 50; i < 800; i += 50) {
            a.drawLine(i, 100, i, 650);
        }
        for (int i = 100; i < 700; i += 50) {
            a.drawLine(50, i, 750, i);
        }
        a.setColor(Color.black);

        for (int k = 0; k < 11; k++) {
            for (int l = 0; l < 14; l++) {
                if (matris[k][l].equals("0")) {

                    a.fillRect(((l + 1) * 50), 50 + ((k + 1) * 50), 50, 50);
                }

            }
        }enKısaYolBas();
        karakterOlustur();

        Karakter hero = new Karakter();
        if (this.secim == 1) {
            imgKarakter = img1;
            MasterYoda hero1 = new MasterYoda();
            hero1.setAd("MasterYoda");
            hero1.setTur("İyi");
            can = 6;
            hero = hero1;
        }
        if (this.secim == 2) {
            imgKarakter = img3;
            LukeSkywalker hero1 = new LukeSkywalker();
            hero1.setAd("MasterYoda");
            hero1.setTur("İyi");
            hero1.setCan(6);
            can = 3;
            hero = hero1;
        }
        a.drawImage(img, 751, 541, null);
        a.drawImage(imgKarakter, x, y, null);
        canciz();
    }

    public Arayuz() {
        try {
            img = ImageIO.read(new File("icon.png"));
            img1 = ImageIO.read(new File("yoda.png"));
            img2 = ImageIO.read(new File("can.png"));
            img3 = ImageIO.read(new File("luke.png"));
            img4 = ImageIO.read(new File("darth.png"));
            img5 = ImageIO.read(new File("kylo.png"));
            img6 = ImageIO.read(new File("storm.png"));
            img7 = ImageIO.read(new File("lost.png"));
            img8 = ImageIO.read(new File("win.png"));


        } catch (IOException e) {
        }

    }

    public Dimension getPreferredSize() {
        if (img == null) {
            return new Dimension(100, 100);
        } else {
            return new Dimension(img.getWidth(null), img.getHeight(null));
        }
    }

    public static void main(String[] args) {

        JFrame f = new JFrame("Load Image Sample");

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        f.add(new Arayuz());
        f.pack();

        f.setVisible(true);
    }

    public void karakterOlustur() {
        int lok[] = new int[2];
        for (int i = 0; i < hero_tut.size(); i++) {
            if (hero_tut.get(i).equals("Stormtrooper")) {
                Stormtrooper tmp = new Stormtrooper();
                tmp.setAd("Stormtrooper");
                tmp.setTur("Kötü");
                lok = kapibul(kapi_tut.get(i));
                tmp.konum.setX(lok[1]);
                tmp.konum.setY(lok[0]);
                d.drawImage(img6, lok[1], lok[0], null);
                olustur.add(tmp);
            } else if (hero_tut.get(i).equals("DarthVader")) {
                DarthVader tmp = new DarthVader();
                tmp.setAd("DarthVader");
                tmp.setTur("Kötü");
                lok = kapibul(kapi_tut.get(i));
                tmp.konum.setX(lok[1]);
                tmp.konum.setY(lok[0]);
                d.drawImage(img4, lok[1], lok[0], null);
                olustur.add(tmp);
            }
            if (hero_tut.get(i).equals("KyloRen")) {
                KyloRen tmp = new KyloRen();
                tmp.setAd("KyloRen");
                tmp.setTur("Kötü");
                lok = kapibul(kapi_tut.get(i));
                tmp.konum.setX(lok[1]);
                tmp.konum.setY(lok[0]);
                d.drawImage(img5, tmp.konum.getX(), tmp.konum.getY(), null);
                olustur.add(tmp);

            }
        }
    }

    public int[] kapibul(String kapi) {
        int lok[] = new int[2];
        if (kapi.equals("A")) {
            lok[0] = 351;
            lok[1] = 51;

        }
        if (kapi.equals("B")) {
            lok[0] = 101;
            lok[1] = 251;
        }
        if (kapi.equals("C")) {
            lok[0] = 101;
            lok[1] = 651;
        }
        if (kapi.equals("D")) {
            lok[0] = 351;
            lok[1] = 701;
        }
        if (kapi.equals("E")) {
            lok[0] = 601;
            lok[1] = 251;
        }
        return lok;
    }

    public int yakalama() {
        for (int i = 0; i < olustur.size(); i++) {
            if (olustur.get(i).konum.getX() == x && y == olustur.get(i).konum.getY()) {
                x = 351;
                y = 351;
                ctrl++;
                break;
            }

        }


        return ctrl;
    }

    public void canciz() {
        if (x == 701 && y == 551) {
            d.drawImage(img8, 100, 0, null);
        }
        if (can - ctrl <= 0) {
            d.setColor(Color.white);
            repaint();
            d.drawImage(img7, 0, 51, null);
        } else {
            for (int i = 0; i < can - ctrl; i++) {

                d.drawImage(img2, 620 + (i * 70), 20, null);
            }
        }
    }

    public void enKısaYolBas() {
        for (int i = 0; i < olustur.size(); i++) {
            if (olustur.get(i).getAd().equals("KyloRen")) {
                KyloRen deneme = new KyloRen();
                int tutx=(olustur.get(i).konum.getX()-51)/50;
                int tuty=(olustur.get(i).konum.getY()-101)/50;

                deneme.hesapla(matris, gidilen, tuty, tutx, ty, tx, Integer.MAX_VALUE, 0,d);
                int min = deneme.enKisaYol(matris, gidilen, tuty, tutx, ty, tx, Integer.MAX_VALUE, 0,d);
            } else if (olustur.get(i).getAd().equals("Stormtrooper")) {
                Stormtrooper deneme = new Stormtrooper();
                int tutx=(olustur.get(i).konum.getX()-51)/50;
                int tuty=(olustur.get(i).konum.getY()-101)/50;

                deneme.hesapla(matris, gidilen, tuty, tutx, ty, tx, Integer.MAX_VALUE, 0,d);
                int min = deneme.enKisaYol(matris, gidilen, tuty, tutx, ty, tx, Integer.MAX_VALUE, 0,d);


            }else if(olustur.get(i).getAd().equals("DarthVader")){
                DarthVader deneme = new DarthVader();
                deneme.enKisaYol(x,y,d,olustur.get(i).konum.getX(),olustur.get(i).konum.getY());
            }

        }

    }

}
