package com.mygdx.game.screens;

import com.badlogic.gdx.Screen;
import com.mygdx.game.Main;
import com.mygdx.game.engines.MyECSEngine;
import com.mygdx.game.systems.MovementSystem;
import com.mygdx.game.systems.RenderSystem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameScreen implements Screen {
    private Main game;
    private MyECSEngine engine;
    private RenderSystem renderSystem;
    private MovementSystem movementSystem;

    public GameScreen(Main game) {
        this.game = game;
        engine = new MyECSEngine();
        renderSystem = new RenderSystem(engine);
        movementSystem = new MovementSystem(engine);
        engine.addSystem(renderSystem);
        engine.addSystem(movementSystem);
    }


    @Override
    public void show() {
        for (int i = 0; i < 5; i++) {
            engine.createEntity(i * (100 + 5), 0, 100,100,false,false);
        }
        //Player
        engine.createEntity(0, -200, 256,256,false,true);
    }

    private void update(float delta) {
        engine.update(delta);
    }

    @Override
    public void render(float delta) {
        update(delta);
    }

    @Override
    public void resize(int width, int height) {
        renderSystem.getCamera().setToOrtho(false, width, height);
        renderSystem.getCamera().update();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
