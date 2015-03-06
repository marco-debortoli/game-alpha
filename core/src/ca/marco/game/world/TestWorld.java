package ca.marco.game.world;

import box2dLight.PointLight ;
import box2dLight.RayHandler ;
import ca.marco.game.MainGame ;
import ca.marco.game.model.Player ;

import com.badlogic.gdx.graphics.OrthographicCamera ;
import com.badlogic.gdx.graphics.Texture ;
import com.badlogic.gdx.maps.tiled.TiledMap ;
import com.badlogic.gdx.maps.tiled.TmxMapLoader ;
import com.badlogic.gdx.math.Vector2 ;
import com.badlogic.gdx.physics.box2d.Body ;
import com.badlogic.gdx.physics.box2d.BodyDef ;
import com.badlogic.gdx.physics.box2d.PolygonShape ;
import com.badlogic.gdx.physics.box2d.World ;
import com.badlogic.gdx.utils.Array ;
import com.badlogic.gdx.utils.viewport.StretchViewport ;

public class TestWorld
{

  private Player player ;
  private Texture playerImage ;
  private Vector2 playerStartPosition, playerSize ;
  private float playerMass ;
  
  private final Vector2 gravity = new Vector2 ( 0, -9.81f ) ;
  private World world ;
  
  private MainGame game ;
  private BodyDef groundBodyDef ;
  private Body groundBody ;
  private RayHandler rayHandler ;
  
  private StretchViewport viewport ;
  
  private TmxMapLoader loader ;
  private TiledMap map ;
  
  public TestWorld ( MainGame game_input )
  {
    
    this.game = game_input ;
    
    viewport = new StretchViewport ( game.ABSOLUTE_SCREEN_X , game.ABSOLUTE_SCREEN_Y ) ;
    viewport.setCamera ( new OrthographicCamera ( game.BOX2D_X , game.BOX2D_Y ) );
    
    // Create the Box2D world
    world = new World ( gravity , false ) ;

    // Create the player
    
    playerMass = 45 ;
    playerImage = new Texture ( "main_menu/p1_front.png" ) ;
    playerStartPosition = new Vector2 ( 50 * game.BOX2D_SCALE, 90 * game.BOX2D_SCALE ) ;
    playerSize = new Vector2 ( 65 * game.BOX2D_SCALE , 90 * game.BOX2D_SCALE ) ;
    
    Vector2 playerVelocity = new Vector2 ( 0 , 0 ) ;
    
    player = new Player ( world, playerStartPosition , playerMass , playerVelocity , playerSize , playerImage ) ;

    // Ground
    
    groundBodyDef = new BodyDef ( ) ;

    groundBodyDef.position.set ( new Vector2 ( 0 , -game.BOX2D_Y / 2  ) ) ;

    groundBody = world.createBody ( groundBodyDef ) ;

    PolygonShape groundBox = new PolygonShape ( ) ;

    groundBox.setAsBox ( viewport.getWorldWidth ( ) , 0.5f ) ;

    groundBody.createFixture ( groundBox , 0.0f ) ;

    groundBox.dispose ( ) ;
    
    // Lights
    rayHandler = new RayHandler ( world ) ;
    rayHandler.setAmbientLight ( 0.75f ) ;

    PointLight light = new PointLight ( rayHandler , 25 ) ;
    light.setDistance ( 750 * game.BOX2D_SCALE ) ;
    light.setPosition ( 80 * game.BOX2D_SCALE , 20 * game.BOX2D_SCALE ) ;
    //light.setXray ( true ) ;
    
    // Tiled map test
    
    loader = new TmxMapLoader ( ) ;
    map = loader.load ( "maps/level.tmx" ) ;
    
    Array<Body> bodies = MapBodyBuilder.buildMap ( map , 70f , world ) ;

    
  }
  
  public void update ( float delta ) 
  {
    
    
    // Update player
  }
  
  public Player getPlayer ( )
  {
    return this.player ;
  }
  
  public World getWorld ( )
  {
    return this.world ;
  }
  
  public StretchViewport getViewport ( )
  {
    return this.viewport ;
  }
  
  public World getPhysicsWorld ( )
  {
    return this.world ;
  }
  
  public RayHandler getRayHandler ( )
  {
    return this.rayHandler ;
  }
  
  public TiledMap getMap ( )
  {
    return this.map ;
  }

}
