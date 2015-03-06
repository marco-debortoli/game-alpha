package ca.marco.game ;

import ca.marco.game.screens.MainMenu ;

import com.badlogic.gdx.Game ;

public class MainGame extends Game
{
  
  public final int ABSOLUTE_SCREEN_X = 1280 ;
  public final int ABSOLUTE_SCREEN_Y = 768 ;
  
  public final int VELOCITY_ITERATIONS = 8 ;
  public final int POSITION_ITERATIONS = 3 ;
  
  public final float BOX2D_SCALE = 0.01f ;
  
  public final float BOX2D_X = ABSOLUTE_SCREEN_X * BOX2D_SCALE ;
  public final float BOX2D_Y = ABSOLUTE_SCREEN_Y * BOX2D_SCALE ;

  @ Override
  public void create ( )
  {
    this.setScreen ( new MainMenu ( this ) );
  }

  @ Override
  public void render ( )
  {
    super.render ( ) ;
  }
  
  @ Override
  public void dispose ( )
  {
  }
}
