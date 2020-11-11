public class Karakter {
    private String Ad;
    private String Tur;
    Lokasyon konum=new Lokasyon();
    int x_yol;
     int y_yol;
    public Karakter(){

    }
    public String getAd(){
        return Ad;
    }
    public void setAd(String Ad){
        this.Ad=Ad;
    }
    public String getTur(){
        return Tur;
    }
    public void setTur(String Tur){
        this.Tur=Tur;
    }
    public int getYolx()
    {
        return (x_yol);
    }

    public int getYoly(){
        return (y_yol);
    }
}


