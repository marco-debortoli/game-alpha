package ca.marco.game.screens ;

import box2dLight.PointLight ;
import box2dLight.RayHandler ;
import ca.marco.game.MainGame ;

import com.badlogic.gdx.Gdx ;
import com.badlogic.gdx.Screen ;
import com.badlogic.gdx.graphics.Color ;
import com.badlogic.gdx.graphics.GL20 ;
import com.badlogic.gdx.graphics.Texture ;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator ;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter ;
import com.badlogic.gdx.math.Vector2 ;
import com.badlogic.gdx.physics.box2d.World ;
import com.badlogic.gdx.scenes.scene2d.Stage ;
import com.badlogic.gdx.scenes.scene2d.ui.Image ;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton ;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton.ImageTextButtonStyle ;
import com.badlogic.gdx.scenes.scene2d.ui.Skin ;
import com.badlogic.gdx.utils.Scaling ;
import com.badlogic.gdx.utils.viewport.StretchViewport ;

public class MainMenu implements Screen
{

  private MainGame game ;
  private Stage stage , buttonStage ;

  private Image imageBackground ;
  private Image moon ;
  private Image foreground, ufo , character;
  
  private Skin skin ;
  
  private ImageTextButton singleButton, multiButton , optionsButton ;

  private FreeTypeFontGenerator generator ;
  private FreeTypeFontParameter parameter ;

  private RayHandler rayHandler ;
  private World world ;

  public MainMenu ( MainGame game )
  {
    this.game = game ;
  }

  @ Override
  public void show ( )
  {
    // Stage setup
    stage = new Stage ( new StretchViewport ( game.SCREEN_X , game.SCREEN_Y ) ) ;
    
    buttonStage = new Stage ( new StretchViewport ( game.SCREEN_X , game.SCREEN_Y ) ) ;
    Gdx.input.setInputProcessor ( buttonStage ) ;

    // Skin
    skin = new Skin ( ) ;
    skin.add ( "button_up" , new Texture ( Gdx.files.internal ( "main_menu/green_button00.png" ) ) );
    skin.add ( "button_down" , new Texture ( Gdx.files.internal ( "main_menu/green_button01.png" ) ) );
    
    // Fonts
    generator = new FreeTypeFontGenerator ( Gdx.files.internal ( "fonts/font_1.ttf" ) ) ;
    parameter = new FreeTypeFontParameter ( ) ;
    parameter.size = 36 ;

    // Background Image
    imageBackground = new Image (
        new Texture ( Gdx.files.internal ( "main_menu/background_1.png" ) ) ) ;
    
    imageBackground.setSize ( stage.getViewport ( ).getWorldWidth ( ) , stage.getViewport ( ).getWorldHeight ( ) );
    
    // Moon
    moon = new Image ( new Texture ( Gdx.files.internal ( "main_menu/moon_full.png" ) ) ) ;
    moon.setScaling ( Scaling.fill ) ;
    moon.setPosition ( 1000 - moon.getWidth ( ) / 2 , 
        stage.getViewport ( ).getWorldHeight ( ) - ( 135 + moon.getHeight ( ) / 2 ) );
    
    moon.setSize ( stage.getViewport ( ).getWorldWidth ( ) / 15.06f , stage.getViewport ( ).getWorldHeight ( ) / 9.03f );
    
    // Foreground
    foreground = new Image ( new Texture ( Gdx.files.internal ( "main_menu/level.png" ) ) ) ;
    foreground.setScaling ( Scaling.fill );
    foreground.setWidth ( stage.getViewport ( ).getWorldWidth ( ) );
    foreground.setPosition ( 0 , 50 );
    
    // UFO
    ufo = new Image ( new Texture ( Gdx.files.internal ( "main_menu/ufocrash.png" ) ) ) ;
    ufo.setPosition ( 70 , 50 );
    
    // Character
    character = new Image ( new Texture ( Gdx.files.internal ( "main_menu/p1_front.png" ) ) ) ;
    character.setPosition ( ufo.getX ( ) + ufo.getWidth ( ) + 50 , 70 );
    
    // Buttons
    ImageTextButtonStyle button_style = new ImageTextButtonStyle ( ) ;
    button_style.up = skin.getDrawable ( "button_up" );
    button_style.down = skin.getDrawable ( "button_down" ) ;
    button_style.font = generator.generateFont ( parameter ) ;
    
    singleButton = new ImageTextButton ( "Single Player" , button_style ) ;
    singleButton.setPosition ( 0 , 625 );
    singleButton.setSize ( 400 , 100 );
    
    multiButton = new ImageTextButton ( "Multi Player" , button_style ) ;
    multiButton.setPosition ( 0 , 500 );
    multiButton.setSize ( 400 , 100 );
    
    optionsButton = new ImageTextButton ( "Options" , button_style ) ;
    optionsButton.setPosition ( 0 , 375 );
    optionsButton.setSize ( 300 , 100 );

    // Add the actors
    stage.addActor ( imageBackground ) ;
    stage.addActor ( moon ) ;
    stage.addActor ( foreground );
    stage.addActor ( ufo ) ;
    stage.addActor ( character );
    
    buttonStage.addActor ( singleButton ) ;
    buttonStage.addActor ( multiButton );
    buttonStage.addActor ( optionsButton );
    
    // Box2D stuff (for lighting)

    world = new World ( new Vector2 ( 0 , 0 ) , false ) ;

    rayHandler = new RayHandler ( world ) ;

    rayHandler.setAmbientLight ( 0.05f ) ;

    PointLight light = new PointLight ( rayHandler , 25 ) ;
    light.setDistance ( 750 ) ;
    light.setPosition ( moon.getX ( ) + moon.getWidth ( ) / 2 , moon.getY ( ) + moon.getHeight ( ) / 2 ) ;
    light.setXray ( true ) ;
    
    PointLight greenLight = new PointLight( rayHandler , 250 ) ;
    greenLight.setPosition ( ufo.getX ( ) + ufo.getWidth ( ) / 2 , ufo.getY( ) + ufo.getHeight ( ) / 2 );
    greenLight.setColor ( new Color( 76/255f, 153/255f, 0, 0.75f) );
    greenLight.setDistance ( 750 );
  }

  @ Override
  public void render ( float delta )
  {
    Gdx.graphics.getGL20 ( ).glClearColor ( 49 / 255f , 67 / 255f , 102 / 255f , 0.5f ) ;
    Gdx.graphics.getGL20 ( ).glClear ( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT ) ;

    world.step ( delta , 8 , 3 ) ;
    rayHandler.setCombinedMatrix ( stage.getCamera ( ).combined ) ;

    stage.act ( delta ) ;
    stage.draw ( ) ;

    rayHandler.updateAndRender ( ) ;
    
    buttonStage.act ( delta );
    buttonStage.draw ( );
  }

  @ Override
  public void resize ( int width , int height )
  {
    stage.getViewport ( ).update ( width , height , true ) ;
    buttonStage.getViewport ( ).update ( width, height, true ) ;

  }

  @ Override
  public void pause ( )
  {
    // Do nothing

  }

  @ Override
  public void resume ( )
  {
    // Do nothing

  }

  @ Override
  public void hide ( )
  {
    // Do nothing

  }

  @ Override
  public void dispose ( )
  {
    stage.dispose ( ) ;
    rayHandler.dispose ( ) ;
    world.dispose ( ) ;
    skin.dispose ( );

  }

}
