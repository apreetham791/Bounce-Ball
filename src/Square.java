public class Square {
      int  x,y ,xS, yS;

    int radius;

    public Square(){
        x= 300;
        y= 500;
        radius= 25;
        xS =2;
        yS =2;
    }


    //soon make it inherited
    public void move( ){
        x+=xS;
        y+=yS;
    }

    // soon make it inherited
    public void inBounds(){// make sure the Square stays in grid
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

//      if ( (frogX + 100 >= blueCarX && frogX <= blueCarX +90)) {
//        if (frogY +47 >= blueCarY && frogY <= blueCarY + 45){
//            frogX = 250;
//            frogY = 540;
//            LivesCounter --;
//        }
//    }

    public void paddleBounce(int xP, int width, int yP, int height ){
        if(x + radius >= xP && x <= xP + width ){
            if( y + radius >= yP && y <= yP + height){
                yS = yS * -1;
            }
        }
    }

    public boolean getTouched(int xP, int width, int yP, int height ){
        return (x + radius >= xP && x <= xP + width ) && (  y + radius >= yP && y <= yP + height );
    }





}
