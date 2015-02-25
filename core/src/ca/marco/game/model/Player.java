package ca.marco.game.model;

import com.badlogic.gdx.graphics.Texture ;
import com.badlogic.gdx.math.Vector2 ;

public class Player extends AbstractMovingImageObject
{

  public Player ( Vector2 position, float mass, Vector2 size , Texture image )
  {
    super ( position , mass, size , image ) ;
  }
  
  public Player ( Vector2 position , float mass, Vector2 size , 
      Vector2 force , Vector2 velocity , Vector2 acceleration , Texture image )
  {
    super ( position , mass, size , force , velocity, acceleration , image ) ;
  }
  
  public void update ( float time ) 
  {
    
    this.updateAcceleration ( time ) ;
    
    // Update velocity
    this.updateVelocity ( time ) ;
    
    // Update position
    this.updatePosition ( time ) ;
    
    // Forces don't need updating
    this.updateForce ( ) ;
    
  }

}
