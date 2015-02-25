package ca.marco.game.model;

import com.badlogic.gdx.graphics.Texture ;
import com.badlogic.gdx.math.Vector2 ;

public class AbstractMovingImageObject extends AbstractMovingObject
{
  
  protected Texture image ;
  
  public AbstractMovingImageObject ( Vector2 position , float mass , Vector2 size, Texture image )
  {
    super ( position , mass , size ) ;
    this.image = image ;
  }
  
  public AbstractMovingImageObject ( Vector2 position , float mass , Vector2 size , Vector2 force , 
      Vector2 velocity, Vector2 acceleration , Texture image )
  {
    super ( position , mass , size , force , velocity , acceleration ) ;
    this.image = image ;
  }
  
  public Texture getImage ( )
  {
    return this.image ;
  }
  
  public void setImage ( Texture image )
  {
    this.image = image ;
  }
  
}
