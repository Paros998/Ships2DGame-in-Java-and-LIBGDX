package com.ourshipsgame.hud;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.ourshipsgame.game.GameSettings;
import com.ourshipsgame.handlers.Constant;

public class Hud implements Constant {

    // Fields
    private GameImageButton gameMenuButton, repeatButton, playButton;
    public Table layoutTable;
    private Stage stage;
    private Skin skin;
    public GameSettings gameSettings;

    // Constructor
    public Hud(AssetManager manager) {
        skin = new Skin();
        skin = manager.get("core/assets/buttons/skins/rusty-robot/skin/rusty-robot-ui.json", Skin.class);

        stage = new Stage(new ScreenViewport());

        // Close button
        Texture[] buttonStyles = new Texture[2];
        buttonStyles[0] = manager.get("core/assets/ui/ui.hud/ui/global/modern/gear.png", Texture.class);
        buttonStyles[1] = manager.get("core/assets/ui/ui.hud/ui/global/modern/gear-press.png", Texture.class);

        Sprite[] buttonStylesSprites = new Sprite[2];

        setButtonsSprites(buttonStyles, buttonStylesSprites, 1.55f);

        gameMenuButton = new GameImageButton(GAME_WIDTH - 10, GAME_HEIGHT - 3, this, buttonStylesSprites);
        gameMenuButton.setOptionsListener();

        // Repeat button
        buttonStyles[0] = manager.get("core/assets/ui/reverse-button.png", Texture.class);
        buttonStyles[1] = manager.get("core/assets/ui/reverse-button-pressed.png", Texture.class);

        setButtonsSprites(buttonStyles, buttonStylesSprites, 6.5f);

        repeatButton = new GameImageButton(buttonStylesSprites);

        // Play button
        buttonStyles[0] = manager.get("core/assets/ui/ready-button.png", Texture.class);
        buttonStyles[1] = manager.get("core/assets/ui/ready-button-pressed.png", Texture.class);

        setButtonsSprites(buttonStyles, buttonStylesSprites, 6.5f);

        playButton = new GameImageButton(buttonStylesSprites);

        // Table for play, repeat buttons
        layoutTable = new Table();
        layoutTable.bottom();
        layoutTable.setFillParent(true);
        layoutTable.add(playButton).expandX().padLeft(830f).padBottom(8);
        layoutTable.add(repeatButton).expandX().padRight(830f).padBottom(8);

        stage.addActor(gameMenuButton);
        stage.addActor(layoutTable);
    }

    // Methods
    private void setButtonsSprites(Texture[] textures, Sprite[] sprites, float factor) {
        for(int i = 0; i < sprites.length; i++) {
            sprites[i] = new Sprite(textures[i]);
            sprites[i].setSize(sprites[i].getWidth() / factor, sprites[i].getHeight() / factor);
        }
    }

    public void update() {
        stage.act();
        stage.draw();
    }

    public void render(SpriteBatch batch) {
        // uiBar.getSprite().draw(batch);
    }

    // Getters
    public GameImageButton getRepeatButton() {
        return repeatButton;
    }

    public GameImageButton getPlayButton() {
        return playButton;
    }

    public Stage getStage() {
        return stage;
    }

    public Skin getSkin() {
        return skin;
    }

    public boolean isPasued() {
        return gameMenuButton.getGameMenuState();
    }
}
