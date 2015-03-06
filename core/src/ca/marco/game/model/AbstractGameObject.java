package ca.marco.game.model;

import com.badlogic.gdx.math.Vector2 ;
import com.badlogic.gdx.physics.box2d.Body ;
import com.badlogic.gdx.physics.box2d.BodyDef ;

public abstract class AbstractGameObject
{

  protected Vector2 size ;
  protected float mass ;

  protected Body body ;
  protected BodyDef bodyDef ;
  
  public AbstractGameObject ( Vector2 position , Vector2 size , float mass )
  {
    bodyDef = new BodyDef ( ) ;
    bodyDef.position.set ( position ) ;
    
    this.size = size ;
    this.mass = mass ;
    
  }
  
  // Position
  
  public Vector2 getPosition ( ) 
  {
    return this.body.getPosition ( ) ;
  }
  
  public float getPositionX ( )
  {
    return this.body.getPosition ( ).x ;
  }
  
  public float getPositionY ( )
  {
    return this.body.getPosition ( ).y ;
  }
 
  // Mass
  
  public float getMass ( )
  {
    return this.mass ;
  }
  
  // Size
  
  public Vector2 getSize ( )
  {
    return this.size ;
  }
  
  public float getWidth ( )
  {
    return this.size.x ;
  }
  
  public float getHeight ( )
  {
    return this.size.y ;
  }
  
  public void setSize ( Vector2 size )
  {
    this.size = size ;
  }
  
  public void setWidth ( float width )
  {
    this.size.x = width ;
  }
  
  public void setHeight ( float height )
  {
    this.size.y = height ;
  }
  
  // Body
  
  public Body getBody ( )
  {
    return this.body ;
  }
  
  
}
