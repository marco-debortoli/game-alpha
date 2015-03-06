package ca.marco.game.model;

import com.badlogic.gdx.graphics.Texture ;
import com.badlogic.gdx.math.Vector2 ;
import com.badlogic.gdx.physics.box2d.World ;

public abstract class AbstractStaticImageObject extends AbstractStaticObject
{
  
  private Texture image ;

  public AbstractStaticImageObject ( World world , Vector2 position , Vector2 size , float mass , Texture image )
  {
    super ( world , position , size , mass ) ;
    this.image = image ;
  }
  
  public Texture getImage ( )
  {
    return this.image ;
  }

}
