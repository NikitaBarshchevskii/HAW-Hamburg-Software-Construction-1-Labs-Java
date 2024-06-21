package state;

import drawing.Scene;

public class TreeState extends State {
    private static TreeState instance;

    private TreeState(Scene scene) {
        this.scene = scene;
        trees = this;
    }

    public static TreeState getInstance(Scene scene) {
        if (instance == null) {
            instance = new TreeState(scene);
        }
        return instance;
    }

    @Override
    public void apply() {
        this.scene.createTrees(this.scene.getNumberOfTrees(), this.scene.getScreenWidth(), this.scene.getScreenHeight());
    }

    @Override
    public String toString() {
        return "TreeState";
    }

    @Override
    public State getHorseState() {
        return HorseState.getInstance(scene);
    }

    @Override
    public State getNatureState() {
        return NatureState.getInstance(scene);
    }

    @Override
    public State getTreeState() {
        return this;
    }

    @Override
    public State getEmptyState() {
        return EmptyState.getInstance(scene);
    }
}