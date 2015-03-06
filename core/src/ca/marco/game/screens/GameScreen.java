package ca.marco.game.screens;

import ca.marco.game.MainGame ;
import ca.marco.game.world.TestRenderer ;
import ca.marco.game.world.TestWorld ;

import com.badlogic.gdx.Screen ;

public class GameScreen implements Screen
{
  
  private MainGame game ;
  private TestRenderer renderer ;
  private TestWorld world ;
  
  public GameScreen ( MainGame game )
  {
    this.game = game ;
  }

  @ Override
  public void show ( )
  {
    // When the screen is switched to this one
    // Start music
    // Create game objects
    
    world = new TestWorld ( game ) ;
    this.renderer = new TestRenderer ( world , game ) ;
    
  }

  @ Override
  public void render ( float delta )
  {
   // this.world.update ( delta ) ;
    this.renderer.render ( delta );
    
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
