package state;

import drawing.Scene;

public class EmptyState extends State{
    private static EmptyState instance;

    private EmptyState(Scene scene){
        this.scene = scene;
        empty = this;
        //clear everything
    }

    public static EmptyState getInstance(Scene scene){
        if (instance == null){
            instance = new EmptyState(scene);
        }
        return instance;
    }

    @Override
    public void apply() {
        //clear everything
    }

    @Override
    public String toString() {
        return "EmptyState";
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
        return TreeState.getInstance(scene);
    }

    @Override
    public State getEmptyState() {
        return this;
    }
}
