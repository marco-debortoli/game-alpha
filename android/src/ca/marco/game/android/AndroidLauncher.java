package ca.marco.game.android ;

import android.os.Bundle ;

import com.badlogic.gdx.backends.android.AndroidApplication ;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration ;
import ca.marco.game.MainGame ;

public class AndroidLauncher extends AndroidApplication
{
  @ Override
  protected void onCreate ( Bundle savedInstanceState )
  {
    super.onCreate ( savedInstanceState ) ;
    AndroidApplicationConfiguration config = new AndroidApplicationConfiguration ( ) ;

    config.hideStatusBar = true ;
    config.useImmersiveMode = true ;
    
    initialize ( new MainGame ( ) , config ) ;
  }
}
