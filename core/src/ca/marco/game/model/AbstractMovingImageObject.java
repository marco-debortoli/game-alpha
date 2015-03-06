package ca.marco.game.model;

import com.badlogic.gdx.graphics.Texture ;
import com.badlogic.gdx.math.Vector2 ;
import com.badlogic.gdx.physics.box2d.World ;

public class AbstractMovingImageObject extends AbstractMovingObject
{
  
  protected Texture image ;
  
  public AbstractMovingImageObject ( World world , Vector2 position , float mass, Vector2 velocity, Vector2 size, Texture image )
  {
    super ( world, position , size , mass, velocity ) ;
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
