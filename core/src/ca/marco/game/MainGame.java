package ca.marco.game ;

import ca.marco.game.screens.GameScreen ;
import ca.marco.game.screens.MainMenu ;

import com.badlogic.gdx.Game ;
import com.badlogic.gdx.graphics.g2d.SpriteBatch ;

public class MainGame extends Game
{
  private SpriteBatch batch ;

  @ Override
  public void create ( )
  {
    batch = new SpriteBatch ( ) ;
    this.setScreen ( new GameScreen ( this ) );
  }

  @ Override
  public void render ( )
  {
    super.render ( ) ;
  }
  
  @ Override
  public void dispose ( )
  {
    batch.dispose ( ) ;
  }
}
