import processing.core.PApplet;

public class Launcher extends PApplet {

    int x, y , width , height, xS;

    public Launcher ( ){
        x = 250;
        y = 550;
        width= 100;
        height = 30;
        xS = 3;
    }


    public void paddleBounds( ){
        if (x >= 600-width){
            xS = -xS;
        } else if (x <= 0){
            xS = -xS;
        }
    }



}
