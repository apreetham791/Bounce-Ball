
import processing.core.PApplet;

import java.io.*;
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

        for (int i = 0; i < blocks.size(); i++) {
            Block b = blocks.get(i);
            fill(color(0,255,0));
            rect(b.x, b.y, b.width, b.height);

            if(square.getTouched(b.x,b.width,b.y,b.height)){
                blocks.remove(b);
            }
        }

        fill(color(255,0,0));
        rect(square.x, square.y, square.size, square.size);
        square.move();
        square.inBounds();
        square.paddleBounce(launch.x, launch.width,launch.y , launch.height);

        fill(color(255, 163, 82));
        rect(launch.x, launch.y, launch.width, launch.height);
        launch.paddleBounds();

        //this is buggy
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

    @Override
    public void keyReleased() {
        if(key == 's'){
            try {
                PrintWriter out = new PrintWriter(new FileWriter("src/saveGame.txt"));
                for (int i = 0; i < blocks.size() ; i++) {
                    Block b = blocks.get(i);
                    out.println(b.x + ", " + b.y);
                }
                out.close();
            } catch (IOException e) {
               e.printStackTrace();
            }
        }

        if(key == 'l'){
            try {
                BufferedReader in = new BufferedReader(new FileReader("src/saveGame.txt"));
                blocks.clear();
                String line;
                while ( (line = in.readLine() ) != null){
                    String [] vals = line.split(", ");
                    int x = Integer.parseInt(vals[0]);
                    int y = Integer.parseInt(vals[1]);

                    Block b = new Block(x,y);
                    blocks.add(b);
                }
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }
}
