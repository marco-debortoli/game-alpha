package ca.marco.game.model;

import com.badlogic.gdx.math.Vector2 ;

public abstract class AbstractGameObject
{

  protected Vector2 position ;
  protected Vector2 size ;
  protected float mass ;
  
  public AbstractGameObject ( )
  {
    this.position = new Vector2 ( 0 , 0 ) ;
    this.mass = 0 ;
  }
  
  public AbstractGameObject ( Vector2 position , float mass, Vector2 size )
  {
    this.position = position ;
    this.mass = mass ;
    this.size = size ;
  }
  
  // Position
  
  public Vector2 getPosition ( ) 
  {
    return this.position ;
  }
  
  public float getPositionX ( )
  {
    return this.position.x ;
  }
  
  public float getPositionY ( )
  {
    return this.position.y ;
  }
  
  public void setPosition ( Vector2 new_position )
  {
    this.position = new_position ;
  }
  
  public void setPositionX ( float new_position )
  {
    this.position.x = new_position ;
  }
  
  public void setPositionY ( float new_position )
  {
    this.position.y = new_position ;
  }
  
  // Mass
  
  public float getMass ( )
  {
    return this.mass ;
  }
  
  public void setMass ( float mass )
  {
    this.mass = mass ;
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
  
}
