package ca.marco.game.screens;

import com.badlogic.gdx.Game ;
import com.badlogic.gdx.Gdx ;
import com.badlogic.gdx.Screen ;
import com.badlogic.gdx.graphics.GL20 ;
import com.badlogic.gdx.graphics.Texture ;
import com.badlogic.gdx.scenes.scene2d.Stage ;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction ;
import com.badlogic.gdx.scenes.scene2d.ui.Image ;
import com.badlogic.gdx.utils.viewport.ExtendViewport ;

public class MainMenu implements Screen
{
  
  private Game game ;
  private Stage stage ;
  
  private Image image_background ;

  public MainMenu ( Game game )
  {
    this.game = game ;
  }
  
  @ Override
  public void show ( )
  {
    this.stage = new Stage(new ExtendViewport(Gdx.graphics.getWidth ( ), Gdx.graphics.getHeight ( ))) ;
    Gdx.input.setInputProcessor ( stage ) ;
    
    // Instantiate Actors
    image_background = new Image(new Texture("backgrounds/background_3.png")) ;
    image_background.setFillParent ( true );
    
    // Actions
    MoveToAction moveAction = new MoveToAction ( ) ;
    moveAction.setPosition ( 250 , 250 );
    moveAction.setDuration ( 5 );
    
    // stage.addAction ( moveAction );
    
    stage.addActor ( image_background );
    
    
  }

  @ Override
  public void render ( float delta )
  {
    Gdx.gl.glClear ( GL20.GL_COLOR_BUFFER_BIT ) ;
    stage.act ( delta ) ;
    stage.draw ( ) ;
    
  }

  @ Override
  public void resize ( int width , int height )
  {
    stage.getViewport ( ).update ( width , height , true );
    
  }

  @ Override
  public void pause ( )
  {
    // TODO Auto-generated method stub
    
  }

  @ Override
  public void resume ( )
  {
    // TODO Auto-generated method stub
    
  }

  @ Override
  public void hide ( )
  {
    // TODO Auto-generated method stub
    
  }

  @ Override
  public void dispose ( )
  {
    stage.dispose ( );
    
  }
  
}
