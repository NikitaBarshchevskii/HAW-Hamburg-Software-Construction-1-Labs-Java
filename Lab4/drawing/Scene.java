package drawing;

import horse.Horse;
import horse.HorseColor;
import randomNumber.RandomNumber;
import rectangle.LocatedRectangle;
import state.*;
import tree.Tree;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Scene {
	private ArrayList<Horse> horses;
	private ArrayList<Tree> trees;
	private ArrayList<HorseColor> horseColors;
	private ArrayList<Integer> horseSizes;
	private Random random = new Random();
	private int numberOfTrees = 10;

	private int numberOfHorses;
	private State graphicsState;
	private boolean drawHorses;
	private boolean drawForest;
	private int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
	private int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;


	public Scene(int numberOfHorses, ArrayList<Integer> sizeCoef, ArrayList<HorseColor> colorCoef, boolean drawHorses, boolean drawForest) {
		horses = new ArrayList<>();
		trees = new ArrayList<>();
		horseColors = new ArrayList<>();
		horseSizes = new ArrayList<>();
		for (HorseColor color : colorCoef) {
			horseColors.add(color);
		}
		for (Integer size : sizeCoef) {
			horseSizes.add(size);
		}
		this.numberOfHorses = numberOfHorses;
		graphicsState = EmptyState.getInstance(this);
		setGraphicsState(graphicsState, drawHorses, drawForest);
		createTrees(numberOfTrees, screenWidth, screenHeight);
		createHorses(numberOfHorses, horseSizes, horseColors, screenWidth, screenHeight);
	}

	public void reset(int numberOfHorses, ArrayList<Integer> sizeCoef, ArrayList<HorseColor> colorCoef, boolean drawHorses, boolean drawForest) {
		horses.clear();
		trees.clear();
		horseColors.clear();
		horseSizes.clear();
		for (HorseColor color : colorCoef) {
			horseColors.add(color);
		}
		for (Integer size : sizeCoef) {
			horseSizes.add(size);
		}
		this.numberOfHorses = numberOfHorses;
		setGraphicsState(graphicsState, drawHorses, drawForest);
		System.out.println(this.graphicsState.toString());
		this.graphicsState.apply();
		//createTrees(numberOfTrees, screenWidth, (int)(screenHeight * 0.3));
		//createHorses(numberOfHorses, horseSizes, horseColors, screenWidth, screenHeight);
	}

	private void setGraphicsState(State state, boolean drawHorses, boolean drawForest) {
		if (drawHorses && drawForest) {
			graphicsState = this.graphicsState.getNatureState();
		} else if (drawHorses) {
			graphicsState = this.graphicsState.getHorseState();
		} else if (drawForest) {
			graphicsState = this.graphicsState.getTreeState();
		} else {
			graphicsState = this.graphicsState.getEmptyState();
		}
	}

	public Scene getScene() {
		return this;
	}
	public ArrayList<Horse> getHorses() {
		return horses;
	}

	public ArrayList<Tree> getTrees() {
		return trees;
	}

	public int getNumberOfTrees() {
		return numberOfTrees;
	}

	public int getNumberOfHorses() {
		return numberOfHorses;
	}

	public int getScreenWidth() {
		return screenWidth;
	}

	public int getScreenHeight() {
		return screenHeight;
	}

	public ArrayList<HorseColor> getHorseColors() {
		return horseColors;
	}

	public ArrayList<Integer> getHorseSizes() {
		return horseSizes;
	}

	public void createTrees(int numberOfTrees, int screenWidth, int screenHeight) {
		for (int i = 0; i < numberOfTrees; i++) {
			Tree newTree;
			int trials = 100;
			int trialCounter = 0;
			do {
				int x = RandomNumber.between(100, (int)(screenWidth * 0.8));
				int y = RandomNumber.between(100, (int)(screenHeight * 0.3));
				Point newPoint = new Point(x, y);
				newTree = new Tree(50, 50, newPoint);
				trialCounter++;
			} while (doesIntersect(newTree) && trialCounter < trials);
			if (trialCounter < trials) {
				trees.add(newTree);
			}
		}
	}
	public void createHorses(int numberOfHorses, ArrayList<Integer> sizeCoef, ArrayList<HorseColor> colorCoef, int screenWidth, int screenHeight) {
		for (int i = 0; i < numberOfHorses; i++) {
			Horse newHorse;
			int sizeCoefficient;
			int trials = 100;
			int trialCounter = 0;
			do {
				int x = RandomNumber.between(100, (int)(screenWidth * 0.8));
				int y = RandomNumber.between((int)(screenHeight * 0.35), (int)(screenHeight * 0.85));
				sizeCoefficient = sizeCoef.get(random.nextInt(sizeCoef.size()));
				Point newPoint = new Point(x, y);
				HorseColor randomColor = colorCoef.get(random.nextInt(colorCoef.size())); // Select a random color from colorCoef
				newHorse = new Horse(30 * sizeCoefficient, (int) (12.5 * sizeCoefficient), newPoint,
						randomColor.getColor());
				trialCounter++;
			} while (doesIntersect(newHorse) && trialCounter < trials);
			if ( trialCounter < trials ) {
				horses.add(newHorse);
			}
		}
	}

	public <T extends LocatedRectangle> boolean doesIntersect(T newObj) {
		boolean flag = false;
		ArrayList<T> objects;
		if (newObj instanceof Tree) {
			objects = (ArrayList<T>) trees;
		} else if (newObj instanceof Horse) {
			objects = (ArrayList<T>) horses;
		} else {
			return false;
		}
		for (T obj : objects) {
			if (!obj.doesNotIntersect(newObj, 0)) {
				flag = true;
			}
		}
		return flag;
	}

	public void draw() {
		for (Tree tree : trees) {
			tree.draw();
		}
		for (Horse horse : horses) {
			horse.draw();
		}
	}

	public void drawHorses(){
		for (Horse horse : horses) {
			horse.draw();
		}
	}

	public void drawTrees(){
		for (Tree tree : trees) {
			tree.draw();
		}
	}
}