package ca.marco.game.screens;

import ca.marco.game.MainGame ;

import com.badlogic.gdx.Gdx ;
import com.badlogic.gdx.Screen ;
import com.badlogic.gdx.graphics.GL20 ;

public class SinglePlayerScreen implements Screen
{
  
  private MainGame game ;

  public SinglePlayerScreen ( MainGame game )
  {
    this.game = game ;
  }
  
  @ Override
  public void show ( )
  {

  }

  @ Override
  public void render ( float delta )
  {    
    Gdx.graphics.getGL20 ( ).glClearColor ( 0 , 0, 0 , 1 ) ;
    Gdx.graphics.getGL20 ( ).glClear ( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT ) ;


  }

  @ Override
  public void resize ( int width , int height )
  {

  }

  @ Override
  public void pause ( )
  {

  }

  @ Override
  public void resume ( )
  {

  }

  @ Override
  public void hide ( )
  {

  }

  @ Override
  public void dispose ( )
  {
    
  }

}
