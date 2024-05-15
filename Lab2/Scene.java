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
            do {
                int x = RandomNumber.between(100, screenWidth - 150);
                int y = RandomNumber.between(100, screenHeight - 100);
                HorseColor randomColor = HorseColor.values()[RandomNumber.between(0, HorseColor.values().length - 1)];
                newHorse = new Horse(120, 50, x, y, randomColor.getColor());
            } while (doesIntersect(newHorse));
            horses.add(newHorse);
        }
    }

    private boolean doesIntersect(Horse newHorse) {
        for (Horse horse : horses) {
            if (!horse.doesNotIntersect(newHorse, 0)) {
                return true;
            }
        }
        return false;
    }

    public void draw() {
        for (Horse horse : horses) {
            horse.draw();
        }
    }
}