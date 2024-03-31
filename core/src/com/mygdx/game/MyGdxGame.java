package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends Game {
    SpriteBatch batch;
    float elapsedTime = 0;
    int dem = 0;
    Texture img, img2, imgga, backgroundTexture;
    int NumWidth_ga = 7;
    int NumHeight_ga = 2;
    int spacing_ga = 120;
    player play;
    ga[] gas = new ga[20];
    int demturn1 = 0;
    private Sound chickendeath;

    turn2 t2;

    Sprite backgroundSprite;

    @Override
    public void create() {
        // Set màn hình mặc định cho trò chơi là MainMenuScreen
        //setScreen(new MainMenuScreen());
    	setScreen(new MainMenuScreen(this));
    }
}