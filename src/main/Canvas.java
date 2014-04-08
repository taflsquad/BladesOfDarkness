package main;

/**
 *  Design inspired by silveira
 *  
 *  @author bitNiKC
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

enum Tile {
		JOE01, JOE02, JOE03, JOE04, JOE05, JOE06, PHIL01, PHIL02, PHIL03, PHIL04, ROCKROAD01, GRASSYROCK01, GRASSYROCK02, GRASSYROCK03, COBBLESTONE1, COBBLESTONE2,
		JOE07, JOE08, JOE09, JOE10, JOE11, JOE12, PHIL05, PHIL06, PHIL07, PHIL08, ROCKROAD02, GRASSYROCK04, GRASSYROCK05, GRASSYROCK06, COBBLESTONE3, COBBLESTONE4,
		JOE13, JOE14, JOE15, JOE16, JOE17, JOE18, PHIL09, PHIL10, PHIL11, PHIL12, ROCKROAD03, GRASSYROCK07, GRASSYROCK08, GRASSYROCK09, COBBLESTONE5, COBBLESTONE6,
		JOE19, JOE20, JOE21, JOE22, JOE23, JOE24, PHIL13, PHIL14, PHIL15, PHIL16, MOSSY_LR, ROCKYCOBBLE1, ROCKYCOBBLE2, ROCKYCOBBLE3, COBBLESTONE7, COBBLESTONE8,
		JOE25, JOE26, JOE27, JOE28, JOE29, JOE30, PHIL17, PHIL18, PHIL19, PHIL20, MOSSY_RL, ROCKYCOBBLE4, ROCKYCOBBLE5, ROCKYCOBBLE6, GRASS1, GRASS2,
		JOE31, JOE32, JOE33, JOE34, JOE35, JOE36, PHIL21, PHIL22, PHIL23, PHIL24, GRASS_LONG01, ROCKYCOBBLE7, ROCKYCOBBLE8, ROCKYCOBBLE9, GRASS3, GRASS4,
		JOE37, JOE38, JOE39, JOE40, JOE41, JOE42, PHIL25, PHIL26, PHIL27, PHIL28, GRASS_LONG02, STONEROAD01, STONEROAD02, STONEROAD03, GRASSYROCK10, GRASSYROCK11,
		MAX01, MAX02, MAX03, MAX04, FIRE1, FIRE2, GRASS_LONG03, GRASS_LONG04, ROCKROAD04, ROCKROAD05, ROCKROAD06, STONEROAD04, STONEROAD05, STONEROAD06, GRASSYROCK12, GRASSYROCK13,
		MAX05, MAX06, MAX07, MAX08, FIRE3, FIRE4, GRASS_LONG05, GRASS_LONG06, ROCKROAD07, ROCKROAD08, ROCKROAD09, STONEROAD07, STONEROAD08, STONEROAD09, GRASSYROCK14, GRASSYROCK15,
		MAX09, MAX10, MAX11, MAX12, GRASS_LONG07, GRASS_LONG08, GRASS_LONG09, FLOWER1, ROCKROAD10, ROCKROAD11, ROCKROAD12, GRASSYROCK18, GRASSYROCK19, GRASSYROCK20, GRASSYROCK16, GRASSYROCK17,
		MAX13, MAX14, MAX15, MAX16, GRASS_LONG10, GRASS_LONG11, GRASS_LONG12, FLOWER2, FLOWER3, ROCKROAD13, ROCKROAD14, GRASSYROCK21, GRASSYROCK22, GRASSYROCK23, CAVE01, CAVE02,
		MAX17, MAX18, MAX19, MAX20, GRASS_LONG13, GRASS_LONG14, GRASS_LONG15, STONEROAD10, STONEROAD11, ROCKROAD15, ROCKROAD16, GRASSYROCK24, GRASSYROCK25, GRASSYROCK26, CAVE03, CAVE04,
		TED01, TED02, TED03, TED04, BIGTREE01, BIGTREE02, BIGTREE03, STONEROAD12, STONEROAD13, MIDTREE01, MIDTREE02, BOULDERL1, SMALLSTONE, BOULDERR1, CAVE05, CAVE06,
		TED05, TED06, TED07, TED08, BIGTREE04, BIGTREE05, BIGTREE06, SMALLTREE01, SMALLTREE02, MIDTREE03, MIDTREE04, BOULDERL2, BOULDERDARK1, BOULDERR2, CAVE07, CAVE08,
		TED09, TED10, TED11, TED12, BIGTREE07, BIGTREE08, BIGTREE09, SMALLTREE03, SMALLTREE04, MIDTREE05, MIDTREE06, BOULDERBRIGHT1, BOULDERDARK2, STATUE1, WELL1, WELL2,
		TED13, TED14, TED15, TED16, BIGTREE10, BIGTREE11, BIGTREE12, SMALLTREE05, SMALLTREE06, MIDTREE07, MIDTREE08, BOULDERBRIGHT2, BIGBOULDER, STATUE2, WELL3, WELL4;
		
}

enum DefaultMap {
	JOE, JOE_LARGE, BLADES_OF_DARKNESS;
}

public class Canvas extends JPanel{
    private static final int tW = 32; // tile width
    private static final int tH = 32; // tile height
    private static final Tile joe[][] =
    {{Tile.JOE01, Tile.JOE02, Tile.JOE03, Tile.JOE04, Tile.JOE05, Tile.JOE06},
   	 {Tile.JOE07, Tile.JOE08, Tile.JOE09, Tile.JOE10, Tile.JOE11, Tile.JOE12},
	 {Tile.JOE13, Tile.JOE14, Tile.JOE15, Tile.JOE16, Tile.JOE17, Tile.JOE18},
	 {Tile.JOE19, Tile.JOE20, Tile.JOE21, Tile.JOE22, Tile.JOE23, Tile.JOE24},
	 {Tile.JOE25, Tile.JOE26, Tile.JOE27, Tile.JOE28, Tile.JOE29, Tile.JOE30},
	 {Tile.JOE31, Tile.JOE32, Tile.JOE33, Tile.JOE34, Tile.JOE35, Tile.JOE36},
	 {Tile.JOE37, Tile.JOE38, Tile.JOE39, Tile.JOE40, Tile.JOE41, Tile.JOE42}};
    private static final Tile bladesOfDarkness[][] =
    {{Tile.JOE01, Tile.JOE02, Tile.JOE03, Tile.JOE04, Tile.JOE03, Tile.JOE04, Tile.JOE03, Tile.JOE04, Tile.JOE03, Tile.JOE04, Tile.JOE03, Tile.JOE04, Tile.JOE05, Tile.JOE06},
   	 {Tile.JOE07, Tile.JOE08, Tile.JOE09, Tile.JOE10, Tile.JOE09, Tile.JOE10, Tile.JOE09, Tile.JOE10, Tile.JOE09, Tile.JOE10, Tile.JOE09, Tile.JOE10, Tile.JOE11, Tile.JOE12},
	 {Tile.JOE13, Tile.JOE14, Tile.JOE15, Tile.JOE16, Tile.JOE15, Tile.JOE16, Tile.JOE15, Tile.JOE16, Tile.JOE15, Tile.JOE16, Tile.JOE15, Tile.JOE16, Tile.JOE17, Tile.JOE18},
	 {Tile.JOE19, Tile.JOE20, Tile.JOE21, Tile.JOE22, Tile.JOE21, Tile.JOE22, Tile.JOE21, Tile.JOE22, Tile.JOE21, Tile.JOE22, Tile.JOE21, Tile.JOE22, Tile.JOE23, Tile.JOE24},
	 {Tile.JOE13, Tile.JOE14, Tile.JOE15, Tile.JOE16, Tile.JOE15, Tile.JOE16, Tile.JOE15, Tile.JOE16, Tile.JOE15, Tile.JOE16, Tile.JOE15, Tile.JOE16, Tile.JOE17, Tile.JOE18},
	 {Tile.JOE19, Tile.JOE20, Tile.JOE21, Tile.JOE22, Tile.JOE21, Tile.JOE22, Tile.JOE21, Tile.JOE22, Tile.JOE21, Tile.JOE22, Tile.JOE21, Tile.JOE22, Tile.JOE23, Tile.JOE24},
	 {Tile.JOE13, Tile.JOE14, Tile.JOE15, Tile.JOE16, Tile.JOE15, Tile.JOE16, Tile.JOE15, Tile.JOE16, Tile.JOE15, Tile.JOE16, Tile.JOE15, Tile.JOE16, Tile.JOE17, Tile.JOE18},
	 {Tile.JOE19, Tile.JOE20, Tile.JOE21, Tile.JOE22, Tile.JOE21, Tile.JOE22, Tile.JOE21, Tile.JOE22, Tile.JOE21, Tile.JOE22, Tile.JOE21, Tile.JOE22, Tile.JOE23, Tile.JOE24},
	 {Tile.JOE13, Tile.JOE14, Tile.JOE15, Tile.JOE16, Tile.JOE15, Tile.JOE16, Tile.JOE15, Tile.JOE16, Tile.JOE15, Tile.JOE16, Tile.JOE15, Tile.JOE16, Tile.JOE17, Tile.JOE18},
	 {Tile.JOE19, Tile.JOE20, Tile.JOE21, Tile.JOE22, Tile.JOE21, Tile.JOE22, Tile.JOE21, Tile.JOE22, Tile.JOE21, Tile.JOE22, Tile.JOE21, Tile.JOE22, Tile.JOE23, Tile.JOE24},
	 {Tile.JOE13, Tile.JOE14, Tile.JOE15, Tile.JOE16, Tile.JOE15, Tile.JOE16, Tile.JOE15, Tile.JOE16, Tile.JOE15, Tile.JOE16, Tile.JOE15, Tile.JOE16, Tile.JOE17, Tile.JOE18},
	 {Tile.JOE19, Tile.JOE20, Tile.JOE21, Tile.JOE22, Tile.JOE21, Tile.JOE22, Tile.JOE21, Tile.JOE22, Tile.JOE21, Tile.JOE22, Tile.JOE21, Tile.JOE22, Tile.JOE23, Tile.JOE24},
	 {Tile.JOE25, Tile.JOE26, Tile.JOE27, Tile.JOE28, Tile.JOE27, Tile.JOE28, Tile.JOE27, Tile.JOE28, Tile.JOE27, Tile.JOE28, Tile.JOE27, Tile.JOE28, Tile.JOE29, Tile.JOE30},
	 {Tile.JOE31, Tile.JOE32, Tile.JOE33, Tile.JOE34, Tile.JOE33, Tile.JOE34, Tile.JOE33, Tile.JOE34, Tile.JOE33, Tile.JOE34, Tile.JOE33, Tile.JOE34, Tile.JOE35, Tile.JOE36},
	 {Tile.JOE37, Tile.JOE38, Tile.JOE39, Tile.JOE40, Tile.JOE39, Tile.JOE40, Tile.JOE39, Tile.JOE40, Tile.JOE39, Tile.JOE40, Tile.JOE39, Tile.JOE40, Tile.JOE41, Tile.JOE42}};
    private static final Tile joeLarge[][] =
    {{Tile.JOE01, Tile.JOE02, Tile.JOE03, Tile.JOE04, Tile.JOE05, Tile.JOE06},
   	 {Tile.JOE07, Tile.JOE08, Tile.JOE09, Tile.JOE10, Tile.JOE11, Tile.JOE12},
	 {Tile.JOE13, Tile.JOE14, Tile.JOE15, Tile.JOE16, Tile.JOE17, Tile.JOE18},
	 {Tile.JOE19, Tile.JOE20, Tile.JOE21, Tile.JOE22, Tile.JOE23, Tile.JOE24},
	 {Tile.JOE25, Tile.JOE26, Tile.JOE27, Tile.JOE28, Tile.JOE29, Tile.JOE30},
	 {Tile.JOE13, Tile.JOE14, Tile.JOE15, Tile.JOE16, Tile.JOE17, Tile.JOE18},
	 {Tile.JOE19, Tile.JOE20, Tile.JOE21, Tile.JOE22, Tile.JOE23, Tile.JOE24},
	 {Tile.JOE25, Tile.JOE26, Tile.JOE27, Tile.JOE28, Tile.JOE29, Tile.JOE30},
	 {Tile.JOE13, Tile.JOE14, Tile.JOE15, Tile.JOE16, Tile.JOE17, Tile.JOE18},
	 {Tile.JOE19, Tile.JOE20, Tile.JOE21, Tile.JOE22, Tile.JOE23, Tile.JOE24},
	 {Tile.JOE25, Tile.JOE26, Tile.JOE27, Tile.JOE28, Tile.JOE29, Tile.JOE30},
	 {Tile.JOE31, Tile.JOE32, Tile.JOE33, Tile.JOE34, Tile.JOE35, Tile.JOE36},
	 {Tile.JOE37, Tile.JOE38, Tile.JOE39, Tile.JOE40, Tile.JOE41, Tile.JOE42}};
    private static Tile map[][] = null;
    
    private Image tileset;
    
    private Canvas() {
    	tileset = Toolkit.getDefaultToolkit().getImage("res/tiles.png");
    }
    
    public Canvas(DefaultMap dm) {
    	this();
    	map = predeterminedMap(dm);
    }
    
    public int getMapWidth() {
    	return tH*map[0].length;
    }
    
    public int getMapHeight() {
    	return tW*map.length;
    }
    
    protected Tile[][] predeterminedMap(DefaultMap dm) {
		switch (dm) {
		case JOE:
			return joe;

		case JOE_LARGE:
			return joeLarge;


		case BLADES_OF_DARKNESS:
			return bladesOfDarkness;

		default:
			JOptionPane.showMessageDialog(getParent(), "No such map");
			return null;
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		int mW = map[0].length;	// map width
		int mH = map.length; 	// map height
		super.paintComponent(g);
		//g.setColor(Color.magenta);
		//g.fillRect(0, 0, getWidth(), getHeight());
		
		for (int i=0; i<mW; i++)
			for (int j=0; j<mH; j++)
				drawTile(g, map[j][i], i*tW, j*tH);
	}
	
	protected void drawTile(Graphics g, Tile t, int x, int y) {
		// map Tile from the tileset
		int mx = t.ordinal()%16;
		int my = t.ordinal()/16;
		g.drawImage(tileset, x, y, x+tW, y+tH,
				mx*tW, my*tH, mx*tW+tW, my*tH+tH, this);
	}
    
    
}
