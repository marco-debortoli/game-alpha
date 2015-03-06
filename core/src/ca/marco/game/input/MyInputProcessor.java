package ca.marco.game.input ;

import ca.marco.game.model.Player ;
import ca.marco.game.world.TestWorld ;

import com.badlogic.gdx.Input.Keys ;
import com.badlogic.gdx.InputProcessor ;
import com.badlogic.gdx.math.Vector2 ;

public class MyInputProcessor implements InputProcessor
{

  private Player player ;
  private TestWorld world ;

  public MyInputProcessor ( TestWorld world )
  {
    this.player = world.getPlayer ( ) ;
    this.world = world ;
    
  }

  @ Override
  public boolean keyDown ( int keycode )
  {
    if ( keycode == Keys.RIGHT && player.getBody ( ).getLinearVelocity ( ).x < 50 )
    {
      this.player.getBody ( ).applyLinearImpulse ( new Vector2 ( 50 , 0 ) , player.getBody ( ).getWorldCenter ( )  , true );
      System.out.println ( "HERE" );
    }

    return false ;
  }

  @ Override
  public boolean keyUp ( int keycode )
  {
    if ( keycode == Keys.SPACE )
    {
      float impulse = player.getBody ( ).getMass ( ) * 10 ;
      
      player.getBody ( ).applyLinearImpulse ( new Vector2 ( 0 , impulse ) ,
          player.getBody ( ).getWorldCenter ( ) , true ) ;

    }

    return true ;
  }

  @ Override
  public boolean keyTyped ( char character )
  {
    return false ;
  }

  @ Override
  public boolean touchDown ( int x , int y , int pointer , int button )
  {
    return false ;
  }

  @ Override
  public boolean touchUp ( int x , int y , int pointer , int button )
  {
    float impulse = player.getBody ( ).getMass ( ) * 10 ;
    
    player.getBody ( ).applyLinearImpulse ( new Vector2 ( 0 , impulse ) ,
        player.getBody ( ).getWorldCenter ( ) , true ) ;
    
    return true ;
  }

  @ Override
  public boolean touchDragged ( int x , int y , int pointer )
  {
    return false ;
  }

  @ Override
  public boolean mouseMoved ( int x , int y )
  {
    return false ;
  }

  @ Override
  public boolean scrolled ( int amount )
  {
    return false ;
  }
}
