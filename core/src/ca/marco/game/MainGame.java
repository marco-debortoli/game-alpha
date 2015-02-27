package ca.marco.game ;

import ca.marco.game.screens.MainMenu ;

import com.badlogic.gdx.Game ;

public class MainGame extends Game
{
  
  public final int SCREEN_X = 1280 ;
  public final int SCREEN_Y = 768 ;

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
