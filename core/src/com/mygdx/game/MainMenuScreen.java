/*package com.mygdx.game;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class MainMenuScreen implements Screen {
    private Stage stage;
    private SpriteBatch batch;
    private Texture startTexture;
    private Texture quitTexture;

    @Override
    public void show() {
        batch = new SpriteBatch();
        stage = new Stage();

        // Load hình ảnh cho nút Start và Quit
        startTexture = new Texture(Gdx.files.internal("startbutton.png"));
        quitTexture = new Texture(Gdx.files.internal("exit.jpg"));

        // Tạo nút Start
        TextureRegionDrawable startDrawable = new TextureRegionDrawable(startTexture);
        ImageButton startButton = new ImageButton(startDrawable);
        startButton.setPosition(100, 200);
        startButton.addListener(new ClickListener() {
            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
            	GameScreen newGame = new GameScreen();
            	Game game = (Game) Gdx.app.getApplicationListener();
            	game.setScreen(newGame);
            	
                
                // Chuyển đổi màn hình hiện tại sang MyGdxGame
                // Xử lý khi nhấn nút Start
                // Ví dụ: Chuyển đổi sang màn hình game chính
            }
        });
        stage.addActor(startButton);

        // Tạo nút Quit
        TextureRegionDrawable quitDrawable = new TextureRegionDrawable(quitTexture);
        ImageButton quitButton = new ImageButton(quitDrawable);
        quitButton.setPosition(100, 100);
        quitButton.addListener(new ClickListener() {
            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                // Xử lý khi nhấn nút Quit
                Gdx.app.exit();
            }
        });
        stage.addActor(quitButton);

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        batch.dispose();
        stage.dispose();
        startTexture.dispose();
        quitTexture.dispose();
    }
}
*/
package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class MainMenuScreen implements Screen {
    private Stage stage;
    private SpriteBatch batch;
    private Texture startTexture;
    private Texture quitTexture;
    private Game game;

    public MainMenuScreen(Game game) {
        this.game = game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        stage = new Stage();  
      
        Texture backgroundTexture = new Texture(Gdx.files.internal("BackGroundMenu.jpg"));
        Image backgroundImage = new Image(backgroundTexture);
        backgroundImage.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()); // Đảm bảo kích thước của background phù hợp với kích thước màn hình
        stage.addActor(backgroundImage);
        
        
        startTexture = new Texture(Gdx.files.internal("ButtonStart.png"));
        quitTexture = new Texture(Gdx.files.internal("ButtonQuit.png"));

     
      
        TextureRegionDrawable startDrawable = new TextureRegionDrawable(startTexture);
        ImageButton startButton = new ImageButton(startDrawable);
        startButton.setPosition(100, 200);
        startButton.addListener(new ClickListener() {
            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                GameScreen newGame = new GameScreen(game);
                game.setScreen(newGame);
            }
        });
        //stage.addActor(startButton);

        // Tạo nút Quit
        TextureRegionDrawable quitDrawable = new TextureRegionDrawable(quitTexture);
        ImageButton quitButton = new ImageButton(quitDrawable);
        quitButton.setPosition(100, 100);
        quitButton.addListener(new ClickListener() {
            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
          
                Gdx.app.exit();
            }
        });
        //stage.addActor(quitButton);

     // Tính toán vị trí y của các nút
        float startButtonY = (Gdx.graphics.getHeight() - startButton.getHeight()) / 2;
        float quitButtonY = (Gdx.graphics.getHeight() - quitButton.getHeight()) / 2 - 100; // Cách 100 pixel phía dưới nút Start
        float startButtonX = (Gdx.graphics.getWidth() - startButton.getWidth()) / 2;
        float quitButtonX = (Gdx.graphics.getWidth() - quitButton.getWidth()) / 2;
        // Đặt vị trí của các nút
        //startButton.setPosition(100, startButtonY);
        //quitButton.setPosition(100, quitButtonY);
        startButton.setPosition(startButtonX, startButtonY);
        quitButton.setPosition(quitButtonX, quitButtonY);
        
        stage.addActor(startButton);
        stage.addActor(quitButton);
        
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        batch.dispose();
        stage.dispose();
        startTexture.dispose();
        quitTexture.dispose();
    }
}

