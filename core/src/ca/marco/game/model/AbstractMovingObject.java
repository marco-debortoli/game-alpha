package ca.marco.game.model;

import com.badlogic.gdx.math.Vector2 ;

public abstract class AbstractMovingObject extends AbstractGameObject
{
  protected Vector2 force ;
  protected Vector2 velocity ;
  protected Vector2 acceleration ;
  
  protected boolean jump ;
  
  protected static float VELOCITY_SCALE = 3f ;
  
  public AbstractMovingObject ( Vector2 position, float mass , Vector2 size )
  {
    super ( position , mass, size ) ;
    this.force = new Vector2 ( 0, 0 ) ;
    this.velocity = new Vector2 ( 0, 0 ) ;
    this.acceleration = new Vector2 ( 0 , 0 ) ;
    this.jump = false ;
  }
  
  public AbstractMovingObject ( Vector2 position , float mass, Vector2 size, Vector2 force, Vector2 velocity, Vector2 acceleration )
  {
    super ( position, mass, size ) ;
    this.force = force ;
    this.velocity = velocity ;
    this.acceleration = acceleration ;
    this.jump = false ;
  }
  
  // Forces
  
  public Vector2 getNetForce ( )
  {
    return this.force ;
  }
  
  public void setForce ( Vector2 force )
  {
    this.force = force ;
  }
  
  public void addForce ( Vector2 force )
  {
    this.force = this.force.add ( force ) ;
  }
  
  public void subtractForce ( Vector2 force )
  {
    this.force = this.force.sub ( force ) ;
  }
  
  public void zeroForce ( )
  {
    this.force = new Vector2 ( 0, 0 ) ;
  }
  
  public void updateForce ( )
  {
    if ( this.jump )
    {
      this.force = this.force.sub ( new Vector2 ( 0 , 100000 ) ) ;
      this.jump = false ;
    }
  }
  
  // Acceleration
  
  public Vector2 getAcceleration ( )
  {
    return this.acceleration ;
  }
  
  public void setAcceleration ( Vector2 accel )
  {
    this.acceleration = accel ;
  }
  
  public void addAcceleration ( Vector2 accel )
  {
    this.acceleration = this.acceleration.add ( accel ) ;
  }
  
  public void subtractAcceleration ( Vector2 accel )
  {
    this.acceleration = this.acceleration.sub ( accel ) ;
  }
  
  public void zeroAcceleration ( )
  {
    this.acceleration = new Vector2 ( 0 , 0 ) ;
  }
  
  public void updateAcceleration ( float time )
  {
    // Always have 0 acceleration in the x direction
    this.acceleration.x = 0 ;
    
    this.acceleration.y = this.force.y / this.mass ;
    
  }
  
  // Velocity
  // Assume constant x velocity
  
  public Vector2 getVelocity ( )
  {
    return this.velocity ;
  }
  
  public void setVelocity ( Vector2 velocity )
  {
    this.velocity = velocity ;
  }
  
  public void addVelocity ( Vector2 velocity )
  {
    this.velocity = this.velocity.add ( velocity ) ;
  }
  
  public void subtractVelocity ( Vector2 velocity )
  {
    this.velocity = this.velocity.sub ( velocity ) ;
  }
  
  public void zeroVelocity ( Vector2 velocity )
  {
    this.velocity = new Vector2 ( 0, 0 ) ;
  }
  
  public void updateVelocity ( float time )
  {
    // X velocity does not change (unless changed to zero)
    
    // Y velocity changes with respect to acceleration
    this.velocity.y = this.velocity.y + this.acceleration.y * time ;
  }
  
  // Update position
  
  public void updatePosition ( float time )
  {
    this.position.x = this.position.x + ( this.velocity.x * VELOCITY_SCALE * time ) ;
    this.position.y = this.position.y + ( this.velocity.y * VELOCITY_SCALE * time ) ;
  }
  
  // Jump
  
  public boolean getJump ( )
  {
    return this.jump ;
  }
  
  public void setJump ( boolean jump )
  {
    this.jump = jump ;
  }
  
}
