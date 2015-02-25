package ca.marco.game.world;

import com.badlogic.gdx.Gdx ;
import com.badlogic.gdx.graphics.Texture ;
import com.badlogic.gdx.math.Vector2 ;

import ca.marco.game.model.Player ;

public class SingleWorld
{

  private Player player ;
  private Texture playerImage ;
  private Vector2 playerStartPosition, playerVelocity, playerAcceleration, playerSize ;
  private Vector2 playerForce ;
  private float playerMass ;
  
  private float gravity ;
  
  public SingleWorld ( )
  {
    
    // World parameters
    
    gravity = -20f ;
    
    // Create the player
    
    playerMass = 50 ;
    playerImage = new Texture ( "character/p1_front.png" ) ;
    playerStartPosition = new Vector2 ( 50, 50 ) ;
    playerVelocity = new Vector2 ( 0 , 0 ) ;
    playerForce = new Vector2 ( 0 , 0 ) ;
    playerAcceleration = new Vector2 ( 0 , 0 ) ;
    playerSize = new Vector2 ( 70 , 69 ) ;
    
    player = new Player (playerStartPosition, playerMass, playerSize,
        playerForce, playerVelocity, playerAcceleration, playerImage) ;
  }
  
  public void update ( float delta ) 
  {
    // Update world parameters first
    
    // Update player
    player.update ( delta );
  }
  
  public Player getPlayer ( )
  {
    return this.player ;
  }
  
}
