import java.awt.*;

public class DarthVader extends Karakter{
    public DarthVader(){

    }
    public void enKisaYol(int x,int y,Graphics a,int b,int c){
        if(x>b){
            a.setColor(Color.red);
            a.fillRect(b,c,x-b,50);
        }if(b>x){
            a.setColor(Color.red);
            a.fillRect(x,c,b-x,50);
        }
        if(y>c){
            a.setColor(Color.red);
            a.fillRect(x,c,50,y-c);
        }if(y<c){
            a.setColor(Color.red);
            a.fillRect(x,y+50,50,c-y);
        }
    }


}
