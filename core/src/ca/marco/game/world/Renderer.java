package ca.marco.game.world;

import ca.marco.game.input.MyInputProcessor ;
import ca.marco.game.model.Player ;

import com.badlogic.gdx.Gdx ;
import com.badlogic.gdx.graphics.GL20 ;
import com.badlogic.gdx.graphics.OrthographicCamera ;
import com.badlogic.gdx.graphics.g2d.SpriteBatch ;

public class Renderer
{
  
  private SpriteBatch batch ;
  private SingleWorld world ;
  private Player player ;
  
  private OrthographicCamera camera ;
  
  public Renderer ( SingleWorld world )
  {
    this.batch = new SpriteBatch ( ) ;
    this.world = world ;
    
    camera = new OrthographicCamera ();
    camera.setToOrtho(false, Gdx.graphics.getWidth ( ) , Gdx.graphics.getHeight ( ) );
    camera.update();
    
    Gdx.input.setInputProcessor ( new MyInputProcessor ( world ) );
    
  }
  
  public void render ( ) 
  {
    
    player = world.getPlayer ( ) ;
    
    camera.update ( ) ;
    
    //System.out.println ( player.getNetForce ( ) ) ;
    
    batch.setProjectionMatrix ( camera.combined );
    
    Gdx.graphics.getGL20().glClearColor( 0, 0, 0, 1 );
    Gdx.graphics.getGL20().glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
    
    this.batch.begin ( );
    
    this.batch.draw ( player.getImage ( ) , player.getPositionX ( ) , player.getPositionY ( ) );
    
    this.batch.end ( );
    
  }
  
  public void dispose ( )
  {
    this.batch.dispose ( );
  }
}
