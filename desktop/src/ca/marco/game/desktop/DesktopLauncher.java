package ca.marco.game.desktop ;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication ;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration ;
import ca.marco.game.MainGame ;

public class DesktopLauncher
{
  public static void main ( String [ ] arg )
  {
    LwjglApplicationConfiguration config = new LwjglApplicationConfiguration ( ) ;
    config.width = 1280 ;
    config.height = 768 ;
    config.resizable = false ;
    new LwjglApplication ( new MainGame ( ) , config ) ;
  }
}
