package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class dan {
	public Sprite sprite_bullet;public Vector2 p_bullet;
	public float speed_bullet =950;
	public dan(Texture img,Vector2 p) {
		p_bullet=new Vector2(p.x,p.y);
		sprite_bullet=new Sprite(img);
		sprite_bullet.setScale(0.8f);
	}
	
	public void Draw(SpriteBatch batch) {
	
		//sprite.setRotation(angle);
		
		sprite_bullet.setPosition(p_bullet.x, p_bullet.y);
		sprite_bullet.draw(batch);
	

	}
	public void Update (float detalTime) {
		p_bullet.y += detalTime*speed_bullet;
	}
	
	
}
