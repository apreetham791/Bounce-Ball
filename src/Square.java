public class Square {
      int  x,y ,xS, yS;

    int size;

    public Square(){
        x= 300;
        y= 500;
        size = 25;
        xS =2;
        yS =2;
    }



    public void move( ){
        x+=xS;
        y+=yS;
    }

    // soon make it inherited
    public void inBounds(){
        if(x > 583 || x < 2){
          xS = xS * -1;
        }
        if( y < 2){
            yS = yS* -1;
        }
    }

    public boolean outOfBounds(){
       return y > 583;
    }


    public void paddleBounce(int xP, int width, int yP, int height ){
        if(x + size >= xP && x <= xP + width ){
            if( y + size >= yP && y <= yP + height){
                yS = yS * -1;
            }
        }
    }

    public boolean getTouched(int xP, int width, int yP, int height ){
        return (x + size >= xP && x <= xP + width ) && (  y + size >= yP && y <= yP + height );
    }





}
