package ca.marco.game.model;

import com.badlogic.gdx.graphics.Texture ;
import com.badlogic.gdx.math.Vector2 ;
import com.badlogic.gdx.physics.box2d.FixtureDef ;
import com.badlogic.gdx.physics.box2d.PolygonShape ;
import com.badlogic.gdx.physics.box2d.World ;

public class Player extends AbstractMovingImageObject
{
 

  public Player ( World world , Vector2 position, float mass, Vector2 velocity, Vector2 size , Texture image )
  {
    super ( world, position , mass, velocity, size , image ) ;
    
    PolygonShape polygon = new PolygonShape ( ) ;
    polygon.setAsBox ( size.x / 2, size.y / 2 ) ;

    FixtureDef fixture = new FixtureDef();
    fixture.shape = polygon;
    fixture.density = this.mass / (size.x * size.y); 
    fixture.friction = 0.4f;
    fixture.restitution = 0;
    
    this.body.createFixture ( fixture ) ;
    
    polygon.dispose ( ) ;
    
  }

}
