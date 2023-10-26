import processing.core.PApplet;

import java.util.ArrayList;

public class Main extends PApplet {
    private ArrayList<Block> blocks;

    Square square;
    Launcher launch;

    public void settings(){
        size(600,600);
    }


    public void setup(){

       square = new Square();
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

        for (int i = 0; i < blocks.size(); i++) {
            Block b = blocks.get(i);
            rect(b.x, b.y, b.width, b.height);

            if(square.getTouched(b.x,b.width,b.y,b.height)){
                blocks.remove(b);
            }

        }

        fill(color(255,0,0));
        rect(square.x, square.y, square.radius, square.radius );
        square.move();
        square.inBounds();
        square.paddleBounce(launch.x, launch.width,launch.y , launch.height);

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

        if(square.outOfBounds()){
            GameOverScreen();
        }


    }

    public void GameOverScreen(){
        background(0);
        fill(color(255,255,255));
        text("GAME OVER", 250,300);
        textSize(30);
    }



    public static void main(String[] args) {
        PApplet.main("Main");
    }
}
