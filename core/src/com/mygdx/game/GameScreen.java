package com.mygdx.game;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class GameScreen implements Screen {
	private Game game;
	SpriteBatch batch;float elapsedTime = 0;int dem=0;
	float time = 0;float time2 =0;
	Texture img ,img2,imgga,backgroundTexture;
	int NumWidth_ga = 7;
	int NumHeight_ga=2;
	int spacing_ga=120;
	player play;
	ga[] gas  =new ga[20];
	int demturn1=0;
	private Sound chickendeath;
	private Sound nhacnen;
	trung_doi_dan trung_laze_do;
	
	
	   turn2 t2;
	
	
	Sprite backgroundSprite;
	private Music backgroundMusic;
	private BitmapFont font;
   
 
	
	// GameScreen(Game game) {
	 //       this.game = game;
	  //  }
//	private Texture resizeTexture(Texture originalTexture, int newWidth, int newHeight) {
//        int originalWidth = originalTexture.getWidth();
//        int originalHeight = originalTexture.getHeight();
//
//        float widthRatio = (float) newWidth / originalWidth;
//        float heightRatio = (float) newHeight / originalHeight;
//        
//        return new Texture(originalTexture, (int) (originalWidth * widthRatio), (int) (originalHeight * heightRatio));
//    }
	
	



	public GameScreen(Game game2) {
		this.game = game2;
		create();
		  font = new BitmapFont();
	        font.setColor(Color.WHITE); // Màu của văn bản
	        font.getData().setScale(2); // Tăng kích thước của văn bản (tuỳ chọn)
	        
	        //score = 0;
	}
	public void create () {
	    backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
	    backgroundMusic.setVolume(0.2f);
        // Loop nhạc (nếu bạn muốn nó phát liên tục)
        backgroundMusic.setLooping(true);
        // Play nhạc
        backgroundMusic.play();
		 backgroundTexture = new Texture("back3.jpg"
		 		+ ""
		 		+ "");
		 
		 
		 
//		 SpriteBatch spriteBatch = new SpriteBatch();
//		 spriteBatch.begin();
//		 spriteBatch.draw(backgroundTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//		 spriteBatch.end();
		 
		batch = new SpriteBatch();
		img = new Texture("phicochiendau.png");
		img2 = new Texture("danlua.png");
		imgga = new Texture("3. Gà con.png");
	   play = new player(img,img2);
	   
	   
	   
	   trung_laze_do=new trung_doi_dan(new Texture("trung_laze_do.png"),new Vector2( MathUtils.random(100, 700),800) );
	   
	   
	   
	   int i=0;
	  
	   for(int y=0;y<20;y++) {
		   
			   Vector2 position = new Vector2(0,0);

			   
			   position.x=MathUtils.random(100, 1100);
			   position.y=800;
			   
			   gas[i]=new ga(position, imgga,0.4f,"gacon-1.png","gacon-2.png","gacon-3.png");i++;
			  
		   
	   }
	   

	  
	   
	t2=new turn2(play, batch);
		t2.tao8(400,300);
		//t2.tao5(100,500);
		t2.tao6(400, 400);
		t2.tao7(400, 400);
	   //t2.tao0();
	  // t2.tao1(-200,500);
	   //t2.tao2(1800,500 );
	 //  t2.tao3(-100, 100);
	  // t2.tao4(1000, 100);
	   
	   
	   chickendeath = Gdx.audio.newSound(Gdx.files.internal("chickendeath.mp3"));
	   
	   
	}
	

	
	public void render() {
	    ScreenUtils.clear(1, 0, 0, 1);
	    Gdx.gl.glClearColor(0, 0, 0, 1);
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	    
	    batch.begin();
	    batch.draw(backgroundTexture, 0, 0);
	    
	    time2 += Gdx.graphics.getDeltaTime();
	    if (time2 >= 4f) {
	        play.score += 5;
	        time2 = 0;
	    }
	    
	    time += Gdx.graphics.getDeltaTime();
	    font.draw(batch, "Score: " + play.score, 20, Gdx.graphics.getHeight() - 20);
	    font.draw(batch, "Lives: " + play.live, 20, Gdx.graphics.getHeight() - 50);
	    play.Draw(batch);
	    
	    if (!play.gameOver) {
	        t2.xuat7(); // Chỉ render turn 10
	        
	        if (trung_laze_do.Alive) {
	            trung_laze_do.Draw(batch);
	        }
	        
	        if (play.sprite.getBoundingRectangle().overlaps(trung_laze_do.trung.getBoundingRectangle())) {
	            play.dan = new Texture("dan_laze_do.png");
	            trung_laze_do.Alive = false;
	        }
	    } else {
	        // Render game over screen
	        String gameOverText = String.valueOf(Gdx.graphics.getDeltaTime());
	        float textX = 330; // Thay thế YourXPosition bằng vị trí X mong muốn
	        float textY = 200; // Thay thế YourYPosition bằng vị trí Y mong muốn
	        batch.draw(new TextureRegion(new Texture("gameover.jpg")), textX, textY);
	    }
	    
	    batch.end();
	}

	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}

	@Override
	public void show() {
		create();
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		render();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		dispose();
		// TODO Auto-generated method stub
		
	}
}
