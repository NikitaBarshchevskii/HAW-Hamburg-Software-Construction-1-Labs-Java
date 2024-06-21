package state;

import drawing.Scene;
import horse.HorseColor;

import java.util.ArrayList;

public class HorseState extends State {
    private static HorseState instance;
    private HorseState(Scene scene) {
        this.scene = scene;
        horses = this;
    }

    public static HorseState getInstance(Scene scene) {
        if (instance == null) {
            instance = new HorseState(scene);
        }
        return instance;
    }

    @Override
    public void apply() {
        this.scene.createHorses(this.scene.getNumberOfHorses(), this.scene.getHorseSizes(), this.scene.getHorseColors(), this.scene.getScreenWidth(), this.scene.getScreenHeight());
    }

    @Override
    public String toString() {
        return "HorseState";
    }

    @Override
    public State getHorseState() {
        return this;
    }

    @Override
    public State getNatureState() {
        return NatureState.getInstance(scene);
    }

    @Override
    public State getTreeState() {
        return TreeState.getInstance(scene);
    }

    @Override
    public State getEmptyState() {
        return EmptyState.getInstance(scene);
    }
}