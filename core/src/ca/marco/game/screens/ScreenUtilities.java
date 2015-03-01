package ca.marco.game.screens;

import ca.marco.game.MainGame ;

import com.badlogic.gdx.Gdx ;
import com.badlogic.gdx.Screen ;
import com.badlogic.gdx.files.FileHandle ;
import com.badlogic.gdx.graphics.g2d.BitmapFont ;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator ;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter ;
import com.badlogic.gdx.math.Vector2 ;
import com.badlogic.gdx.scenes.scene2d.actions.AlphaAction ;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction ;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction ;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton ;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton.ImageTextButtonStyle ;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable ;

public class ScreenUtilities
{

  // Generate a font generator using a Gdx FileHandle
  public static FreeTypeFontGenerator getFontGenerator ( FileHandle font ) 
  {
    return new FreeTypeFontGenerator ( font ) ;
  }
  
  // Generate a font generator using an internal file path
  public static FreeTypeFontGenerator getFontGenerator ( String font )
  {
    return new FreeTypeFontGenerator ( Gdx.files.internal ( font ) ) ;
  }
  
  // Creates a font parameter
  public static FreeTypeFontParameter getFontParameter ( )
  {
    return new FreeTypeFontParameter ( ) ;
  }
  
  // Creates a font parameter and sets the size
  // Parameter fontSize -> size of the font
  public static FreeTypeFontParameter getFontParameter ( int fontSize )
  {
    FreeTypeFontParameter parameter = new FreeTypeFontParameter ( ) ;
    parameter.size = fontSize ;
    
    return parameter ;
  }
  
  // Generate a ImageTextButtonStyle
  public static ImageTextButtonStyle getImageTextButtonStyle ( Drawable buttonUp , 
      Drawable buttonDown , BitmapFont generatedFont )
  {
    ImageTextButtonStyle style = new ImageTextButtonStyle ( ) ;
    style.up = buttonUp ;
    style.down = buttonDown ;
    style.font = generatedFont ;
    
    return style ;
  }
  
  // Generate a ImageTextButton
  public static ImageTextButton getImageTextButton ( String text , ImageTextButtonStyle style ,
      Vector2 position , Vector2 size )
  {
    ImageTextButton button = new ImageTextButton ( text , style ) ;
    button.setSize ( size.x , size.y );
    button.setPosition ( position.x , position.y );
    
    return button ;
  }
  
  // Fade out action
  public static AlphaAction getFadeOut ( float time )
  {
    AlphaAction fadeOutAction = new AlphaAction ( ) ;
    fadeOutAction.setDuration ( time ) ;
    fadeOutAction.setAlpha ( 0f ) ;
    
    return fadeOutAction ;
  }
  
  // Fade out action to new screen
  public static SequenceAction getFadeOutToScreen ( final MainGame game , final Screen newScreen, float time )
  {
    AlphaAction fadeOutAction = new AlphaAction ( ) ;
    fadeOutAction.setDuration ( time ) ;
    fadeOutAction.setAlpha ( 0f ) ;
    
    RunnableAction screenAction = new RunnableAction ( ) ;
    
    screenAction.setRunnable ( new Runnable ( )
    {
      public void run ( )
      {
        game.setScreen ( newScreen ) ;
      }
      
    } ) ;
    
    SequenceAction sequenceAction = new SequenceAction ( ) ;
    sequenceAction.addAction ( fadeOutAction );
    sequenceAction.addAction ( screenAction );
    
    return sequenceAction ;
  }
  
}
