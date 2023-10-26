public class GameItem {


    int x,y , width, height, xS, yS;


    public GameItem ( int  x, int y , int  width,  int  height, int xS,int yS){
        this.x= x;
        this.y= y;
        this.width=width;
        this.height =height;
        this.xS =xS;
        this.yS =yS;

    }

    public void move( ){
    }

    public  double Dist(int x , int y , int x2, int y2){
        int xDist = x2 -x;
        int yDist = y2 -y;
        return Math.sqrt(xDist*xDist + yDist*yDist);
    }
}
