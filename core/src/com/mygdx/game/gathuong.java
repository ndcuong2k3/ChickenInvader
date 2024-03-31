package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;

public class gathuong extends ga{

	private long startTime;
	ArrayList<trung_ga> trungs=new ArrayList<trung_ga>();float time=0f;int i=0;
	private float centerX;
    private float centerY;
    private float radius;
    private float angle;
	
	/*public gathuong(Vector2 _position, Texture img,String a1,String a2,String a3,float x) {
		super(_position, img,x,a1,a2,a3);
		// TODO Auto-generated constructor stub
		 //startTime = TimeUtils.nanoTime();
		 
		 
		
		
	}
	*/
    

    public gathuong(Vector2 _position, Texture img, String a1, String a2, String a3, float x) {
        super(_position, img, x, a1, a2, a3);
        centerX = _position.x;
        centerY = _position.y;
        radius = 200; // Bán kính của hình chữ X
        angle = 0; // Góc bắt đầu
    }
    
	public void updatePosition9(float deltaTime) {
        super.updatePosition(deltaTime);
        // Tính toán tọa độ mới dựa trên hình chữ X
        float x = centerX + radius * MathUtils.cosDeg(angle);
        float y = centerY + radius * MathUtils.sinDeg(angle);
        position.set(x, y);
        // Tăng góc dần dần để di chuyển theo hình chữ X
        angle += 1; // Điều chỉnh tốc độ quay của hình chữ X bằng cách thay đổi giá trị này
    }
	
	
	
	public void draw(SpriteBatch batch) {
		
		super.draw(batch);
	//	de_Trung(texture1, batch);
		  time += Gdx.graphics.getDeltaTime();
		   trungs.removeIf(bullet ->( bullet.p_trung.y < 0||bullet.p_trung.y >Gdx.graphics.getHeight()||bullet.p_trung.x < 0||bullet.p_trung.x > Gdx.graphics.getWidth()));
//	       if(Gdx.input.isButtonJustPressed(0)) {
	       if(time>=MathUtils.random(3,6)) {
	    	   if(MathUtils.randomBoolean()) {
	    		   
	    	   
	    	   trungs.add(new trung_ga(new Texture("trung_ga.png"), position));
	    	   
	    			 time =0;
	    	   }
	       
	       }
		
		for (trung_ga trung : trungs) {
	        if (true) {
	            trung.Draw(batch);
	        }
	    }
		
	}
	public void updatePosition(float deltaTime) {
		super.updatePosition(deltaTime);
	}
	
	public void updatePosition1(float deltaTime) {
		//super.updatePosition(deltaTime);
	     position.x+=300*deltaTime;
	 	super.elapsedTime += deltaTime;
       super.currentFrame = animation.getKeyFrame(elapsedTime, true);

       
   
    	        
		
	}
	public void updatePosition2(float deltaTime) {
		//super.updatePosition(deltaTime);
	     position.x-=300*deltaTime;
	     super.elapsedTime += deltaTime;
	       super.currentFrame = animation.getKeyFrame(elapsedTime, true);
	    	             
		
	}
	public void updatePosition3(float deltaTime) {
		//super.updatePosition(deltaTime);
	     position.y-=300*deltaTime;
	     super.elapsedTime += deltaTime;
	       super.currentFrame = animation.getKeyFrame(elapsedTime, true);
	    	             
		
	}
	float dt2=0;	
	/*
	public void updatePosition4(float deltaTime) {
		//super.updatePosition(deltaTime);
		long currentTime = TimeUtils.nanoTime();
        float elapsedSeconds = (currentTime - time) / 1_000_000_000.0f;

	   /* if(deltaTime > 0.005f)
	    	dt2=deltaTime;
	    if(deltaTime > 0.01f)
	    	dt2=deltaTime;
	    	
	     if(elapsedSeconds>2.0f) {
	    		System.out.println("DeltaTime: " + deltaTime);
	    	 position.y-=100*deltaTime;
	    	 position.x+=100*deltaTime;
	     }else {
	    	 position.y+=100*deltaTime;
	    	 position.x+=100*deltaTime;
	     }
	     super.elapsedTime += deltaTime;
	       super.currentFrame = animation.getKeyFrame(elapsedTime, true);
	    	             
		
	}*/
	 public void updatePosition4(float deltaTime) {
		 long currentTime = TimeUtils.nanoTime();
	        float elapsedSeconds = (currentTime - startTime) / 1_000_000_000.0f;

	        // Kiểm tra điều kiện sau mỗi 2 giây
	        if (elapsedSeconds > 2.0f) {
	            // Reset thời điểm startTime
	            startTime = TimeUtils.nanoTime();

	            // Thực hiện đoạn code trong if sau mỗi 2 giây
	            position.y -= 100 * deltaTime;
	            position.x += 100 * deltaTime;
	        } else {
	            // Thực hiện đoạn code trong else trong trường hợp còn dưới 2 giây
	            position.y += 100 * deltaTime;
	            position.x += 100 * deltaTime;
	        }

	        super.elapsedTime += deltaTime;
	        super.currentFrame = animation.getKeyFrame(elapsedTime, true);
	    }
	 public void updatePosition5(float deltaTime) {
		 long currentTime = TimeUtils.nanoTime();
	        float elapsedSeconds = (currentTime - startTime) / 1_000_000_000.0f;

	        // Kiểm tra điều kiện sau mỗi 2 giây
	        if (elapsedSeconds > 2.0f) {
	            // Reset thời điểm startTime
	            startTime = TimeUtils.nanoTime();

	            // Thực hiện đoạn code trong if sau mỗi 2 giây
	            position.y -= 100 * deltaTime;
	            position.x += 100 * deltaTime;
	        } else {
	            // Thực hiện đoạn code trong else trong trường hợp còn dưới 2 giây
	            position.y += 100 * deltaTime;
	            position.x -= 100 * deltaTime;
	        }

	        super.elapsedTime += deltaTime;
	        super.currentFrame = animation.getKeyFrame(elapsedTime, true);
	    }
//	 public void de_Trung (Texture trung,SpriteBatch batch) {
//		 time += Gdx.graphics.getDeltaTime();
//		  float time2 =0f;
//		  if(time >=2f&&Alive==true) {
//			  
//			  if(i<5) {
//				  trungs[i] = new trung_ga(new Texture("trung_ga.png"), position);
//				  trungs[i].Alive=true;
//				 // trungs[i].Draw(batch);
//				  i++;
//				  time2=time;
//				  
//			  }
//			
//			  
//	
//			  
//				time =0;
//		  }
//		  
//		  
//		 return;
//	 }
	 
	 public void update_trung(SpriteBatch batch) {
			for (trung_ga trungg : trungs) {
		        if (true) {
		            trungg.Draw(batch);
		        }
	 }
}
}
	
	
	
	

