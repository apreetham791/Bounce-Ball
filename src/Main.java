import processing.core.PApplet;

import java.util.ArrayList;

public class Main extends PApplet {
    private ArrayList<Block> blocks;

    int numOfBlocks;



    Ball ball;
    Launcher launch;


    public void settings(){
        size(600,600);
    }


    public void setup(){

       numOfBlocks = 100;

       ball = new Ball();
       launch = new Launcher();

       blocks = new ArrayList<>();

        for (int i = 0; i < 6 ; i++) {
            for (int j = 0; j < 6; j++) {

                blocks.add(new Block( (100 * i), (50 * j) ));
            }
        }







    }
    public void draw(){
        background(180);
        fill(color(0,255,0));
        for (Block b:blocks) {
            rect(b.x, b.y, b.width, b.height);
            ifCollided(b.x,b.y);
        }

        fill(color(255,0,0));
        ellipse(ball.x, ball.y, ball.radius, ball.radius );
        ball.move();
        ball.inBounds();

       fill(color(255, 163, 82));
       rect(launch.x, launch.y, launch.width, launch.height);
        if (keyPressed){
            if (key == CODED){
                if (keyCode == LEFT){
                    launch.x -= launch.xS;
                }
                if (keyCode == RIGHT){
                    launch.x += launch.xS;
                }
            }
        }
        launch.paddleBounds();


    }

    public void ifCollided( int x, int y){

        if( dist(ball.x,ball.y,x,y) <= ball.radius){
            ball.xS = ball.xS * -1;
            ball.yS= ball.yS* -1;
        }
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }
}
