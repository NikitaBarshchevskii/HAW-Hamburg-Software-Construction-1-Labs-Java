package state;

import drawing.Scene;
import horse.HorseColor;

import java.util.ArrayList;

public class NatureState extends State {
    private static NatureState instance;
    private NatureState(Scene scene) {
        this.scene = scene;
        nature = this;
    }

    public static NatureState getInstance(Scene scene) {
        if (instance == null) {
            instance = new NatureState(scene);
        }
        return instance;
    }

    @Override
    public void apply() {
        this.scene.createTrees(this.scene.getNumberOfTrees(), this.scene.getScreenWidth(), this.scene.getScreenHeight());
        this.scene.createHorses(this.scene.getNumberOfHorses(), this.scene.getHorseSizes(), this.scene.getHorseColors(), this.scene.getScreenWidth(), this.scene.getScreenHeight());
    }

    @Override
    public String toString() {
        return "NatureState";
    }

    @Override
    public State getHorseState() {
        return HorseState.getInstance(scene);
    }

    @Override
    public State getNatureState() {
        return this;
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