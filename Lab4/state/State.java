package state;

import drawing.Scene;

public abstract class State {
    protected Scene scene;
    protected static EmptyState empty;
    protected static HorseState horses;
    protected static NatureState nature;
    protected static TreeState trees;
    public abstract void apply();
    public abstract String toString();
    public abstract State getHorseState();
    public abstract State getNatureState();
    public abstract State getTreeState();
    public abstract State getEmptyState();
}