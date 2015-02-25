package ca.marco.game.screens;

import ca.marco.game.world.Renderer ;
import ca.marco.game.world.SingleWorld ;

import com.badlogic.gdx.Game ;
import com.badlogic.gdx.Screen ;

public class GameScreen implements Screen
{
  
  private Game game ;
  private Renderer renderer ;
  private SingleWorld world ;
  
  public GameScreen ( Game game )
  {
    this.game = game ;
  }

  @ Override
  public void show ( )
  {
    // When the screen is switched to this one
    // Start music
    // Create game objects
    
    world = new SingleWorld ( ) ;
    this.renderer = new Renderer ( world ) ;
    
  }

  @ Override
  public void render ( float delta )
  {
    this.world.update ( delta ) ;
    this.renderer.render ( );
    
  }

  @ Override
  public void resize ( int width , int height )
  {
    // Change camera maybe
    
  }

  @ Override
  public void pause ( )
  {
    // Don't update game, instead render pause screen
    
  }

  @ Override
  public void resume ( )
  {
    // Do nothing
    
  }

  @ Override
  public void hide ( )
  {
    // Remove stuff
    
  }

  @ Override
  public void dispose ( )
  {
    // Dispose of stuff
    
  }

}
