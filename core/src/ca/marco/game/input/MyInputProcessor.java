package ca.marco.game.input;

import ca.marco.game.model.Player ;
import ca.marco.game.world.SingleWorld ;

import com.badlogic.gdx.Input.Keys ;
import com.badlogic.gdx.InputProcessor ;
import com.badlogic.gdx.math.Vector2 ;

public class MyInputProcessor implements InputProcessor {
  
  private Player player ;
  
  public MyInputProcessor ( SingleWorld player )
  {
    this.player = player.getPlayer ( ) ;
  }
  
  @Override
  public boolean keyDown (int keycode) {
     return false;
  }

  @Override
  public boolean keyUp (int keycode) 
  {
     if ( keycode == Keys.SPACE )
     {
       player.addForce ( new Vector2 ( 0 , 100000 ) ) ;
       player.setJump ( true ) ;
     }
     
     return true ;
  }

  @Override
  public boolean keyTyped (char character) {
     return false;
  }

  @Override
  public boolean touchDown (int x, int y, int pointer, int button) {
     return false;
  }

  @Override
  public boolean touchUp (int x, int y, int pointer, int button) {
     return false;
  }

  @Override
  public boolean touchDragged (int x, int y, int pointer) {
     return false;
  }

  @Override
  public boolean mouseMoved (int x, int y) {
     return false;
  }

  @Override
  public boolean scrolled (int amount) {
     return false;
  }
}