package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class trung_ga {
	 Sprite trung;
	 Vector2 p_trung;
	 boolean Alive = false;
	public trung_ga(Texture img ,Vector2 p) {
		trung=new Sprite(img);
		p_trung=new Vector2(p.x,p.y);
		trung.setScale(1);
		
	}
	public void Update (float detalTime) {
		p_trung.y -= detalTime*200;
	}
	public void Draw(SpriteBatch batch) {
		
		//sprite.setRotation(angle);
		Update(Gdx.graphics.getDeltaTime());
		trung.setPosition(p_trung.x, p_trung.y);
		trung.draw(batch);
	

	}
	public void dispose() {
	    trung.getTexture().dispose();
	}

}
