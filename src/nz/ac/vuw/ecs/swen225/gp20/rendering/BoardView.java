package nz.ac.vuw.ecs.swen225.gp20.rendering;


import nz.ac.vuw.ecs.swen225.gp20.maze.*;

import javax.swing.*;
import java.awt.*;

public class BoardView extends JComponent {

    private Maze m;
    private Tile[][] tiles;
    private int blockSize =40;

    public BoardView(Maze m){
        this.m = m;
        m = BoardRig.lesson1();
        tiles = m.getTiles();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawWholeBoard(g);
        drawWindowedBoard(g);
    }

    public void drawWholeBoard(Graphics g){
        for(int row=0; row<tiles.length; row++){
            for(int col = 0; col<tiles[row].length; col++){
                Tile t = m.getTileAt(row,col);
                g.drawImage(getToolkit().getImage(t.getFilename()), col*blockSize, row*blockSize, blockSize, blockSize, this);
                if(t instanceof PathTile){
                    PathTile pt = (PathTile)t;
                    if(!pt.getContainedEntities().isEmpty()){
                        for(Containable c: pt.getContainedEntities()){
                            g.drawImage(getToolkit().getImage(c.getFilename()), col * blockSize, row * blockSize, blockSize, blockSize, this);
                        }
                    }
                }
            }
        }
    }

    public void drawWindowedBoard(Graphics g){
        int chapRow = m.getChap().getContainer().getRow();
        int chapCol = m.getChap().getContainer().getCol();

        System.out.printf("%d ,%d\n",chapRow, chapCol);
    }
}
