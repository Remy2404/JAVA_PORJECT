package Random;

import java.awt.*;

public class EX_3_guess_heads_tails {

  public static final int SLEEP_TIME = 50;

  // class constants below

  // key movements
  public static final int KEY_SPACE = 32;
  public static final int KEY_PAGE_UP = 33;
  public static final int KEY_HOME = 36;
  public static final int KEY_LEFT_ARROW = 37;
  public static final int KEY_UP_ARROW = 38;
  public static final int KEY_RIGHT_ARROW = 39;
  public static final int KEY_DOWN_ARROW = 40;

  // panel size set here
  public static final int PANEL_WIDTH = 300;
  public static final int PANEL_HEIGHT = 300; 

  // The shooter 
  public static int SHOOTER_X;
  public static final int SHOOTER_Y = PANEL_HEIGHT - 30;
  public static final int SHOOTER_SIZE = 20;
  public static final int SHOOTER_INITIAL_X = 140;

  // The target
  public static int TARGET_X = 140;
  public static final int TARGET_Y = PANEL_HEIGHT - 280;
  public static final int TARGET_SIZE = 20;
  public static final int TARGET_INITIAL_X = 140;

  // The gun 
  public static int GUN_SIZE = 10;
  public static int Gun_Position_X = 0; 
  public static int Gun_Position_Y = PANEL_HEIGHT - GUN_SIZE;
  public static int Gun_Initial_X = 0;

  // The missile
  public static final int MISSILE_SIZE = 4;
  public static double MISSILE_SPEED = 0.1;
  public static double missileDeltaX = 0;        
  public static double missileDeltaY = 0;      
  public static int missilePositionX = PANEL_WIDTH / 2; 
  public static int missilePositionY = PANEL_HEIGHT - 25; 
  public static boolean missileActive;



  //color constants 
  public static final Color BACKGROUND_COLOR = Color.WHITE;
  public static final Color SHOOTER_COLOR = Color.RED;
  public static final Color TARGET_COLOR = Color.BLUE;
  public static final Color MISSILE_COLOR = Color.BLACK;


  //main method
  public static void main(String[] args) {
    DrawingPanel panel = new DrawingPanel();
    Graphics g = panel.getGraphics( ); 
    initialize();
    reset(g);
    startGame(panel, g);
  }

  //starts up the game and calls the methods
  public static void startGame(DrawingPanel panel, Graphics g) {

    for (int i = 0; i <= 10000; i++) {
      panel.sleep(50);

      drawAll(g);
      moveMissile(g, missileDeltaX);
      drawShooter(g, SHOOTER_COLOR);
      drawTarget(g, TARGET_COLOR);
      handleKeys(panel, g);

    }
  }

  // states my name and the project number in black
  public static void drawAll(Graphics g) {          
    g.setColor(Color.BLACK);      
    g.drawString("Project 2 by Kathryn Johnston", 10, 15);  
  } 

  public static void initialize(){
    SHOOTER_X = SHOOTER_INITIAL_X;
    missileActive = false;
  }


  //draws the shooter
  public static void drawShooter(Graphics g, Color c) {
    g.setColor(c);
    g.fillOval(SHOOTER_X, SHOOTER_Y, SHOOTER_SIZE, SHOOTER_SIZE);
    g.drawLine(Gun_Position_X + (SHOOTER_X + 10), Gun_Position_Y - 30, SHOOTER_X + 10, Gun_Position_Y - 10);
  }

  //draws the target
  public static void drawTarget(Graphics g, Color c) {
    g.setColor(c);
    g.fillOval(TARGET_X, TARGET_Y, TARGET_SIZE, TARGET_SIZE);
    g.drawLine(TARGET_X - 10, TARGET_Y + 30, TARGET_X + 30, TARGET_Y + 30); 
  }

  //input
  public static void handleKeys(DrawingPanel panel, Graphics g) {
    int keyCode = panel.getKeyCode();   
    if (keyCode == KEY_SPACE)
      reset(g);   
    else if (keyCode == KEY_RIGHT_ARROW){
      moveShooter(g, 1);
      moveMissile(g, 1);
    }
    else if (keyCode == KEY_LEFT_ARROW){
      moveShooter(g, -1);
      moveMissile(g, -1);
    }
    else if (keyCode == KEY_HOME)
      moveGun(g, -1);
    else if (keyCode == KEY_PAGE_UP)
      moveGun(g, 1);    
    else if (keyCode == KEY_UP_ARROW){       
      shootMissile(g);
      missileActive = true;
    }
  }

  // moves the shooter and re draws the background
  public static void moveShooter(Graphics g, int deltaX) {    
    drawShooter(g, BACKGROUND_COLOR);
    SHOOTER_X += deltaX;    
    if (SHOOTER_X < -SHOOTER_SIZE / 2)
      SHOOTER_X = -SHOOTER_SIZE / 2;
    if (SHOOTER_X >= PANEL_WIDTH - SHOOTER_SIZE / 2)
      SHOOTER_X = PANEL_WIDTH - SHOOTER_SIZE / 2 - 1;    
    drawShooter(g, SHOOTER_COLOR);
  }

  // moves the gun
  public static void moveGun(Graphics g, int deltaX) {    
    drawShooter(g, BACKGROUND_COLOR);
    Gun_Position_X += deltaX;    
    if (Gun_Position_X < -GUN_SIZE)
      Gun_Position_X = -GUN_SIZE;
    if (Gun_Position_X > PANEL_WIDTH - GUN_SIZE / 2)
      Gun_Position_X = PANEL_WIDTH - GUN_SIZE / 2 - 1;    
    drawShooter(g, SHOOTER_COLOR);
  }


  //fires the missile
  public static void shootMissile(Graphics g) {
    moveMissile(g, missileDeltaX);
    missilePositionY += missileDeltaY;    
    if (missilePositionY < -MISSILE_SIZE)
      missilePositionY = -MISSILE_SIZE;
    if (missilePositionY > PANEL_HEIGHT - MISSILE_SIZE / 2)
      missilePositionY = PANEL_HEIGHT - MISSILE_SIZE / 2 - 1;    
    drawMissile(g, MISSILE_COLOR);  

  }

  //moves the missile
  public static void moveMissile(Graphics g, double missileDeltaX) {
    drawMissile(g, BACKGROUND_COLOR);
    missilePositionX += missileDeltaX;    
    if (missilePositionX < -MISSILE_SIZE)
      missilePositionX = -MISSILE_SIZE;
    if (missilePositionX > PANEL_WIDTH - MISSILE_SIZE / 2)
      missilePositionX = PANEL_WIDTH - MISSILE_SIZE / 2 - 1;    
    drawMissile(g, MISSILE_COLOR);   
  }


  //draws the missile
  public static void drawMissile(Graphics g, Color c) {
    missilePositionX -= - missileDeltaY * MISSILE_SPEED;
    missilePositionY -= missileDeltaX * MISSILE_SPEED;   
    g.setColor(c);
    g.fillOval(missilePositionX, missilePositionY, MISSILE_SIZE, MISSILE_SIZE);  
  }

  // reset method. this will reset everything's position
  public static void reset(Graphics g) {
    g.setColor(BACKGROUND_COLOR);
    g.fillRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);
    SHOOTER_X = SHOOTER_INITIAL_X;
    Gun_Position_X = Gun_Initial_X;
    drawShooter(g, SHOOTER_COLOR);
  }    

}
