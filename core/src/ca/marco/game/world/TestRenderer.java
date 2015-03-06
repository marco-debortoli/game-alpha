package ca.marco.game.world;

import ca.marco.game.MainGame ;
import ca.marco.game.input.MyInputProcessor ;
import ca.marco.game.model.Player ;

import com.badlogic.gdx.Gdx ;
import com.badlogic.gdx.graphics.GL20 ;
import com.badlogic.gdx.graphics.OrthographicCamera ;
import com.badlogic.gdx.graphics.g2d.SpriteBatch ;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer ;
import com.badlogic.gdx.math.Vector3 ;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer ;

public class TestRenderer
{
  
  private SpriteBatch batch ;
  private TestWorld world ;
  private Player player ;
  
  private Box2DDebugRenderer debugRenderer ;
  private MainGame game ;
  
  private OrthogonalTiledMapRenderer renderer ;
  
  public TestRenderer ( TestWorld world , MainGame game )
  {
    this.batch = new SpriteBatch ( ) ;
    this.world = world ;
    this.game = game ;
    
    debugRenderer = new Box2DDebugRenderer();
    
    Gdx.input.setInputProcessor ( new MyInputProcessor ( world ) );
    renderer = new OrthogonalTiledMapRenderer( world.getMap ( ), 1/70f ) ;

    
  }
  
  public void render ( float delta ) 
  {
    
    player = world.getPlayer ( ) ;

    world.getViewport ( ).getCamera ( ).position.x = player.getPositionX ( ) ;
    world.getViewport ( ).getCamera ( ).position.y = player.getPositionY ( ) + 2 ;
    
    world.getViewport ( ).getCamera ( ).update ( ) ;
    
    batch.setProjectionMatrix ( world.getViewport ( ).getCamera ( ).combined );
    world.getRayHandler ( ).setCombinedMatrix ( world.getViewport ( ).getCamera ( ).combined  ) ;
    
    Gdx.graphics.getGL20().glClearColor( 0, 0, 0, 1 );
    Gdx.graphics.getGL20().glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
    
    // Update world parameters first
    renderer.setView ( ( OrthographicCamera ) world.getViewport ( ).getCamera ( ) );
    renderer.render ( );
    
    debugRenderer.render ( world.getPhysicsWorld ( ) , world.getViewport ( ).getCamera ( ).combined );
    
    batch.begin ( );

    batch.draw ( player.getImage ( ) , player.getPositionX ( ) - player.getWidth ( ) / 2, player.getPositionY ( ) - player.getHeight ( ) / 2, 
        player.getWidth ( ) , player.getHeight ( ) );
    
    batch.end ( );
    
    //world.getRayHandler ( ).updateAndRender ( ) ;
    
    world.getPhysicsWorld ( ).step ( delta , game.VELOCITY_ITERATIONS , game.POSITION_ITERATIONS );
    
  }
  
  public void dispose ( )
  {
    this.batch.dispose ( );
  }
}
