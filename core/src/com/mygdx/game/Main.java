package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.mygdx.game.screens.GameScreen;

public class Main extends Game {

    @Override
    public void create() {
        setScreen(new GameScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
