package horse;

import java.awt.*;
import java.util.ArrayList;

public class Scene {
	private ArrayList<Horse> horses;

	public Scene(int numberOfHorses) {
		horses = new ArrayList<>();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;

		for (int i = 0; i < numberOfHorses; i++) {
			Horse newHorse;
			int sizeCoefficient;
			int trials = 100;
			int trialCounter = 0;
			do {
				int x = RandomNumber.between(100, (int)(screenWidth * 0.8));
				int y = RandomNumber.between(100, (int)(screenHeight * 0.85));
				sizeCoefficient = RandomNumber.between(1, 5);
				Point newPoint = new Point(x, y);
				HorseColor randomColor = HorseColor.values()[RandomNumber.between(0, HorseColor.values().length - 1)];
				newHorse = new Horse(30 * sizeCoefficient, (int) (12.5 * sizeCoefficient), newPoint,
						randomColor.getColor());
				trialCounter++;
			} while (doesIntersect(newHorse) && trialCounter < trials);
			if ( trialCounter < trials ) {
				horses.add(newHorse);
			}
		}
	}

	public void reset(int numberOfHorses) {
		horses.clear();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;

		for (int i = 0; i < numberOfHorses; i++) {
			Horse newHorse;
			int sizeCoefficient;
			do {
				int x = RandomNumber.between(100, (int)(screenWidth * 0.8));
				int y = RandomNumber.between(100, (int)(screenHeight * 0.85));
				sizeCoefficient = RandomNumber.between(1, 5);
				Point newPoint = new Point(x, y);
				HorseColor randomColor = HorseColor.values()[RandomNumber.between(0, HorseColor.values().length - 1)];
				newHorse = new Horse(30 * sizeCoefficient, (int) (12.5 * sizeCoefficient), newPoint,
						randomColor.getColor());
			} while (doesIntersect(newHorse));
			horses.add(newHorse);
		}
	}

	public boolean doesIntersect(Horse newHorse) {
		boolean flag = false;
		for (Horse horse : horses) {
			if (!horse.doesNotIntersect(newHorse, 0)) {
				flag = true;
			}
		}
		return flag;
	}

	public void draw() {
		for (Horse horse : horses) {
			horse.draw();
		}
	}
}