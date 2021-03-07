package com.ourshipsgame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class MenuGlobalElements implements Screen {

    public Game game;
    public GameObject menuTexture;
    public Skin skin;

    private int direction = 0;

    public MenuGlobalElements(Game game) {
        this.game = game;
        menuTexture = new GameObject("core/assets/backgroundtextures/paperTextOld.png", 0, 0, true);
        skin = new Skin(Gdx.files.internal("core/assets/buttons/skins/rusty-robot/skin/rusty-robot-ui.json"));
    }
    
    // Menu methods
    public void moveMenu(float deltaTime) {
        if ((menuTexture.x <= 0) && (direction == 0)) {
            if (menuTexture.x <= -119)
                direction = 1;
            menuTexture.moveTexture(-20 * deltaTime);
        }

        if ((menuTexture.x >= -120) && (direction == 1)) {
            if (menuTexture.x >= -1)
                direction = 0;
            menuTexture.moveTexture(20 * deltaTime);
        }
    }

    @Override
    public void show() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void render(float delta) {
        // TODO Auto-generated method stub
        
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
        // TODO Auto-generated method stub
        
    }

    @Override
    public void dispose() {
        skin.dispose();
    }
}
