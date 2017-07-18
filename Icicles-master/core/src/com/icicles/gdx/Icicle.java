package com.icicles.gdx;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import com.badlogic.gdx.math.Vector2;

public class Icicle {
    public static final String TAG = Icicle.class.getName();
    Vector2 position;
    private Vector2 velocity;
    public Icicle(Vector2 position){
        this.position=position;
        velocity=new Vector2(0,0);
    }

    public void update(float delta) {

        velocity.mulAdd(Constant.ICICLES_ACCELERATION, delta);
//        public Vector2 mulAdd (Vector2 vec, float scalar) {
//            this.x += vec.x * scalar;
//            this.y += vec.y * scalar;
//            return this;
//        }

        position.mulAdd(velocity, delta);
    }
    public void render(ShapeRenderer renderer){
        renderer.setColor(Constant.ICICLE_COLOR);
        renderer.set(ShapeRenderer.ShapeType.Filled);
        renderer.triangle(  position.x, position.y,
                position.x - Constant.ICICLES_WIDTH / 2, position.y + Constant.ICICLES_HEIGHT,
                position.x + Constant.ICICLES_WIDTH / 2, position.y + Constant.ICICLES_HEIGHT);
    }
}
