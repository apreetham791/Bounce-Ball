public class Ball{
     int x,y ,xS, yS;

    int radius;

    public Ball (){
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



    public double dist ( int x , int y , int x2, int y2){
        int xDist = x2 -x;
        int yDist = y2 -y;
        return Math.sqrt(xDist*xDist + yDist*yDist);
    }

    // soon make it inherited
    public void inBounds(){// make sure the ball stays in grid
        if(x > 590 || x < 5){
          xS = xS * -1;
        }
        if(y > 590 || y < 5){
            yS = yS* -1;
        }
    }


}
