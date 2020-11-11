import java.awt.*;


public class KyloRen extends Karakter{

    static int sayac = 0;
    public static int tut=0;

    public static String[][] gidilen_tut = new String[11][14];

    public static int enKisaYol(String harita[][], String gidilen[][], int i, int j, int x, int y, int min, int uzaklık, Graphics a)
    {

        if (i == x && j == y)
        {
            if(uzaklık<=min)
            {
                sayac++;
                gidilen_tut = gidilen;

                if(tut==sayac) {
                    for (int p = 0; p < 11; p++) {
                        for (int f = 0; f < 14; f++) {
                            if (gidilen_tut[p][f].equals("1")) {
                                a.setColor(Color.red);
                                a.fillRect(51 + (50 * f), 101 + (50 * p), 50, 50);
                            }
                        }
                    }
                }
            }
            return Integer.min(uzaklık, min);
        }

        gidilen[i][j] = "1";



        if (HaritaKontrol(i + 1, j) && YolKontrol(harita, gidilen, i + 1, j)) {
            min = enKisaYol(harita, gidilen, i + 1, j, x, y, min, uzaklık + 1,a);
        }


        if (HaritaKontrol(i, j + 1) && YolKontrol(harita, gidilen, i, j + 1)) {
            min = enKisaYol(harita, gidilen, i, j + 1, x, y, min, uzaklık + 1,a);
        }


        if (HaritaKontrol(i - 1, j) && YolKontrol(harita, gidilen, i - 1, j)) {
            min = enKisaYol(harita, gidilen, i - 1, j, x, y, min, uzaklık + 1,a);
        }


        if (HaritaKontrol(i, j - 1) && YolKontrol(harita, gidilen, i, j - 1)) {
            min = enKisaYol(harita, gidilen, i, j - 1, x, y, min, uzaklık + 1,a);
        }
        gidilen[i][j] = "0";
        return min;
    }
    private static boolean YolKontrol(String harita[][], String gidilen[][], int x, int y)
    {
        return !(harita[x][y].equals("0")|| gidilen[x][y].equals("1"));
    }

    // geçerli bir konum değil ise false döndür
    private static boolean HaritaKontrol(int x, int y)
    {
        return (x < 11 && y < 14 && x >= 0 && y >= 0);
    }
    public static int hesapla(String[][] harita, String[][] gidilen, int i, int j, int x, int y, int min, int uzaklık, Graphics a){

        if (i == x && j == y)
        {
            if(uzaklık<=min)
            {
                gidilen_tut = gidilen;

                tut=tut+1;

            }
            return Integer.min(uzaklık, min);
        }

        gidilen[i][j] = "1";



        if (HaritaKontrol(i + 1, j) && YolKontrol(harita, gidilen, i + 1, j)) {
            min = hesapla(harita, gidilen, i + 1, j, x, y, min, uzaklık + 1,a);
        }


        if (HaritaKontrol(i, j + 1) && YolKontrol(harita, gidilen, i, j + 1)) {
            min = hesapla(harita, gidilen, i, j + 1, x, y, min, uzaklık + 1,a);
        }


        if (HaritaKontrol(i - 1, j) && YolKontrol(harita, gidilen, i - 1, j)) {
            min = hesapla(harita, gidilen, i - 1, j, x, y, min, uzaklık + 1,a);
        }


        if (HaritaKontrol(i, j - 1) && YolKontrol(harita, gidilen, i, j - 1)) {
            min = hesapla(harita, gidilen, i, j - 1, x, y, min, uzaklık + 1,a);
        }
        gidilen[i][j] = "0";


        return min;
    }


}
