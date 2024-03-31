package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;


public class player {
	int DemBullet=0;
	float bulletSpeedX ;float bulletSpeedY ;int i=0;
	  public ArrayList<Sprite> listBullet;
	  public ArrayList<Vector2> listVector;
	public float shootingAngle = 0.0f;
	public float elapsedTime = 0.0f;
	public float rotationSpeed = 30.0f;
	public float angle = 0.0f;
	public Vector2 p;
	public Vector2 p_bullet;
	public Sprite sprite;
	public Sprite sprite_bullet;
	public float speed =250;
	public float speed_bullet =950;
	public boolean gameOver =false;
	Texture dan;
	private Sound gun  = Gdx.audio.newSound(Gdx.files.internal("gun.mp3"));
	
	ArrayList<dan> dans;
	int score = 10;
	int live = 5;
public player(Texture img,Texture img2) {
	listBullet = new ArrayList<Sprite>();
	listVector=new ArrayList<Vector2>();
	dan = img2;
	dans = new ArrayList<dan>();
	
	sprite =new Sprite(img);
	sprite.setScale(0.8f);
	sprite_bullet=new Sprite(img2);
	sprite_bullet.setScale(1);
	
	//sprite.setColor(color);
	for(int i=0;i<10;i++)

	p=new Vector2(Gdx.graphics.getWidth()/2,sprite.getScaleY()*sprite.getHeight()/3);
	p_bullet=new Vector2(0,10000);
	
}

public void Update (float detalTime) {
//	float bulletSpeedX = 0;float bulletSpeedY = 0;
	
	if(Gdx.input.isButtonJustPressed(1)||Gdx.input.isKeyPressed(Keys.SPACE)) { 
		if(score>0) { 

        gun.play(0.2f);
	    dans.add(new dan(dan,p));
		p_bullet.x=p.x+sprite.getWidth()/2-sprite_bullet.getWidth()/2;
		
		
		
		p_bullet.y=p.y+sprite.getHeight();
		
		listVector.add(p_bullet);
		
		
        Sprite newBullet = new Sprite(sprite_bullet);
        newBullet.setPosition(p_bullet.x,p_bullet.y);
        listBullet.add(newBullet);
        score--;}
		
		
		
//		  bulletSpeedX =MathUtils.degreesToRadians * speed_bullet * MathUtils.cosDeg(shootingAngle+90);
//		     bulletSpeedY =MathUtils.degreesToRadians * speed_bullet * MathUtils.sinDeg(shootingAngle+90);
//		    sprite_bullet.setRotation(angle);
//		    p_bullet.x = p.x+bulletSpeedX*5+sprite.getWidth()/2;
//		    p_bullet.y = p.y+bulletSpeedY*6+30;
//		    i++;
		    // Thiết lập vận tốc cho viên đạn
//		    p_bullet.x += bulletSpeedX;
//		    p_bullet.y += bulletSpeedY;
	}
	
	if(Gdx.input.isKeyPressed(Keys.A)) p.x-=detalTime*speed*1.9;
	if(Gdx.input.isKeyPressed(Keys.D)) p.x+=detalTime*speed*1.9;
	if(Gdx.input.isKeyPressed(Keys.W)) p.y+=detalTime*speed*1.9;
	if(Gdx.input.isKeyPressed(Keys.S)) p.y-=detalTime*speed*1.9;
	if(p.x- (sprite.getWidth()*sprite.getScaleX()/2) <-100) p.x=sprite.getWidth()*sprite.getScaleX()/2-100;
	if(p.x+ (sprite.getWidth()*sprite.getScaleX()/2) >Gdx.graphics.getWidth()-60) p.x=Gdx.graphics.getWidth()-sprite.getWidth()*sprite.getScaleX()/2-60;
	if(p.y- (sprite.getHeight()*sprite.getScaleX()/2) <-140) p.y=sprite.getHeight()*sprite.getScaleX()/2-140;
	if(p.y+ (sprite.getHeight()*sprite.getScaleX()/2) >Gdx.graphics.getHeight()-150) p.y=Gdx.graphics.getHeight()-sprite.getHeight()*sprite.getScaleX()/2-150;

//    p_bullet.y+=bulletSpeedY*detalTime*speed_bullet/10;    
//	p_bullet.x +=bulletSpeedX* detalTime*speed_bullet/10;
   p_bullet.y += detalTime*speed_bullet;
    
//    
//    for (int i = 0; i < listBullet.size(); i++) {
//    	Vector2 v2= listVector.get(i);
//    	v2.y+=detalTime*speed_bullet;
//        Sprite bullet = listBullet.get(i);
//     //   listBullet.get(i).setPosition(listVector.get(i).x,listVector.get(i).y);
//	     
//       // bullet.y += deltaTime * speed_bullet;
//        // Kiểm tra và xử lý các điều kiện liên quan đến đạn (ví dụ: va chạm)
//        // ...
//
//        // Nếu đạn đã đi quá màn hình, hủy nó
//        if (bullet.getY() > Gdx.graphics.getHeight()) {
//        	 listVector.remove(i);
//            listBullet.remove(i);
//           
//            i--; // Đảm bảo không bỏ qua phần tử tiếp theo
//        }
//        }
   for (dan bullet : dans) {
       bullet.Update(detalTime);
   }
   dans.removeIf(bullet -> bullet.p_bullet.y > Gdx.graphics.getHeight());
    elapsedTime += detalTime;
    angle = (elapsedTime * rotationSpeed) % 360;
    shootingAngle = angle;
    if (angle < 0) {
        angle += 360;
    }
    
}

	public void Draw(SpriteBatch batch) {
		Update(Gdx.graphics.getDeltaTime());
		sprite.setPosition(p.x, p.y);
		sprite.draw(batch);
		//sprite.setRotation(angle);
	//	sprite_bullet.setPosition(p_bullet.x, p_bullet.y);
		//sprite_bullet.draw(batch);
		
//		 for (int i = 0; i < listBullet.size(); i++) {
//		       Sprite bullet = listBullet.get(i);
//		      // listBullet.get(i).setPosition(listVector.get(i).x,listVector.get(i).y);
//		       listBullet.get(i).draw(batch);
//		    }
		for (dan bullet : dans) {
            bullet.Draw(batch);
        }
	}
}
