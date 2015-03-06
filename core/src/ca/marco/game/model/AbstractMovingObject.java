package ca.marco.game.model;

import com.badlogic.gdx.math.Vector2 ;
import com.badlogic.gdx.physics.box2d.BodyDef ;
import com.badlogic.gdx.physics.box2d.World ;

public abstract class AbstractMovingObject extends AbstractGameObject
{

  public AbstractMovingObject ( World world , Vector2 position, Vector2 size , float mass , Vector2 velocity )
  {
    super ( position , size , mass ) ;

    bodyDef.type = BodyDef.BodyType.DynamicBody ;
    
    this.body = world.createBody ( bodyDef ) ;
    this.body.setLinearVelocity ( velocity );
    
    
  }
  
  // Fill in velocity, impulse and things ( don't want to use getBody ( ) )
  

}
