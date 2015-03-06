package ca.marco.game.model;

import com.badlogic.gdx.math.Vector2 ;
import com.badlogic.gdx.physics.box2d.BodyDef ;
import com.badlogic.gdx.physics.box2d.World ;

public abstract class AbstractStaticObject extends AbstractGameObject
{
  public AbstractStaticObject ( World world , Vector2 position, Vector2 size , float mass )
  {
    super ( position , size , mass ) ;

    bodyDef.type = BodyDef.BodyType.StaticBody ;
    
  }
  
}
