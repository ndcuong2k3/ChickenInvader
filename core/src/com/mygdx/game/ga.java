package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
public class ga {
	public Vector2 position;
	public Sprite sprite;
	float elapsedTime = 0f;
    TextureRegion currentFrame;
	
	float randomValue;
	float randomValue2;
	int i = 0;
	int j=0,z=0;
	public boolean Alive =  false;
    private Vector2 velocity; // Tốc độ di chuyển
    
    
    public Vector2 getPosition() {
        return position;
    }
    
    public float getWidth() {
        return sprite.getWidth();
    }
    
    public float getHeight() {
        return sprite.getHeight();
    }
    
	SpriteBatch spriteBatch;
    Texture texture1, texture2, texture3;
    Animation<TextureRegion> animation;
	public ga(Vector2 _position,Texture img,float a,String a1,String a2,String a3) {
		
		position = _position;
		sprite = new Sprite(img);
		sprite.setScale(a);
		
		 //spriteBatch = new SpriteBatch();
	        texture1 = new Texture(a1);
	        texture2 = new Texture(a2);
	        texture3 = new Texture(a3);

	        Array<TextureRegion> frames = new Array<TextureRegion>();
	        frames.add(new TextureRegion(texture1));
	        frames.add(new TextureRegion(texture2));
	        frames.add(new TextureRegion(texture3));
	        float frameduration = 0.08f;
	        animation = new Animation<TextureRegion>(frameduration, frames);
	        position = _position;
	        currentFrame = animation.getKeyFrame(elapsedTime, true);
	}
	
	public void draw(SpriteBatch batch) {
		sprite.setRegion(currentFrame);
		sprite.setPosition(position.x, position.y);
		sprite.draw(batch);
		
	}

	public void updatePosition(float deltaTime) {
        // Cập nhật vị trí dựa trên tốc độ và thời gian giữa các frame
		
		
		if (i==0) {
			
			if (MathUtils.randomBoolean()) {
			    // Chọn khoảng [-500, -400]
			    randomValue = MathUtils.random(-200, 0);
			} else {
			    // Chọn khoảng [400, 500]
			    randomValue = MathUtils.random(0, 200);
			}
			
			
			if (MathUtils.randomBoolean()) {
			    // Chọn khoảng [-500, -400]
			    randomValue2 = MathUtils.random(-200, -0);
			} else {
			    // Chọn khoảng [400, 500]
			    randomValue2 = MathUtils.random(0, 200);
			}
			
	        position.x += randomValue * deltaTime*0.7f;
	        position.y += randomValue2 * deltaTime*0.7f;
	        j++;
	        i++;
		}
		else {
			 position.x += randomValue * deltaTime;
		        position.y += randomValue2 * deltaTime;
		        j++;
		        if(j>=0) {
		        	i=0;
		        	j=0;
		        }
		}
		
		
		if(position.x- (sprite.getWidth()*sprite.getScaleX()/2) <-120) {z++;
			randomValue = MathUtils.random(100, 200);
		}
		if(position.x+ (sprite.getWidth()*sprite.getScaleX()/2) >Gdx.graphics.getWidth()-50) randomValue = MathUtils.random(-200, -100) ;z++;
		if(position.y- (sprite.getHeight()*sprite.getScaleX()/2) <-70) randomValue2 = MathUtils.random(100, 200);z++;
		if(position.y+ (sprite.getHeight()*sprite.getScaleX()/2) >Gdx.graphics.getHeight()-50) randomValue2 = MathUtils.random(-200, -100);z++;
		
		if(z>0) {
			  position.x += randomValue * deltaTime;
		        position.y += randomValue2 * deltaTime;
		        j++;
		        i++;
		}
		
		elapsedTime += deltaTime;
        currentFrame = animation.getKeyFrame(elapsedTime, true);
        
        // Điều kiện kiểm tra sự sống/còn tồn tại của đối tượng "ga"
        
    }

    public void setVelocity(float vx, float vy) {
        // Thiết lập tốc độ di chuyển
        velocity.set(   MathUtils.random(20, 50), MathUtils.random(20, 50));
    }
    
    public void dispose () {
		
		
	}

	public void setPosition(float clamp, float clamp2) {
		// TODO Auto-generated method stub
		 if (clamp < 0) {
		        position.x = 0; // Nếu giá trị clamp nhỏ hơn 0, đặt vị trí x bằng 0
		    } else if (clamp > Gdx.graphics.getWidth()) {
		        position.x = Gdx.graphics.getWidth(); // Nếu giá trị clamp vượt quá chiều rộng của màn hình, đặt vị trí x bằng chiều rộng của màn hình
		    } else {
		        position.x = clamp; // Nếu không, đặt vị trí x bằng giá trị clamp
		    }

		    // Đảm bảo rằng giá trị vị trí mới không vượt quá ranh giới (clamp2) đã chỉ định
		    if (clamp2 < 0) {
		        position.y = 0; // Nếu giá trị clamp2 nhỏ hơn 0, đặt vị trí y bằng 0
		    } else if (clamp2 > Gdx.graphics.getHeight()) {
		        position.y = Gdx.graphics.getHeight(); // Nếu giá trị clamp2 vượt quá chiều cao của màn hình, đặt vị trí y bằng chiều cao của màn hình
		    } else {
		        position.y = clamp2; // Nếu không, đặt vị trí y bằng giá trị clamp2
		    }
	}
}
