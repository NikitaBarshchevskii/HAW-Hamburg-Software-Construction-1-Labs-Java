# HAW-Hamburg-Software-Construction-2-Labs-Java
This repository contains my solutions and projects from the Software Construction 2 labs at HAW Hamburg, focusing on Java programming.
## Lab 1
<details><summary>Description</summary>
In Lab 1 the task was to create several classes which combined represent an animal (a horse in my case). The following requirements were followed:
- Identified at least 10 parts of the animal and described their relationships.
- Created a UML class diagram illustrating the domain.
- Implemented classes for each identified object, providing relevant properties, constructors, and drawAt(int left, int bottom) methods in accordance with the UML diagram.
- Developed a main animal class with a drawAt(int left, int bottom) method to manage drawing of its constituent parts. Each part class has its own drawAt(int left, int bottom) method to render itself.
- Evaluated the output to ensure alignment with expectations, determining optimal points for combining object components.
- Ensured code conformity with prescribed code conventions, promoting readability and clarity.
</details>
<details><summary>Results</summary>

![изображение](https://github.com/NikitaBarshchevskii/HAW-Hamburg-Software-Construction-2-Labs-Java/assets/47278408/6df29a63-fa4d-45d3-9438-00fc7e46cacf)

The following image was created using Java graphics tools:

![изображение](https://github.com/NikitaBarshchevskii/HAW-Hamburg-Software-Construction-2-Labs-Java/assets/47278408/6a6ec5d3-a17f-48ad-93fd-5cf2e3f324f1)
</details>

## Lab 2
<details><summary>Description</summary>
  
### Task 1: Code Improvement
### What was Done:
- Implemented a class hierarchy for animal definition with a minimum of 10 classes and a depth of at least 3.
- Ensured each class has a constructor initializing all properties.
- Maintained similar-sized classes.
- Introduced meaningful constants and variables, eliminating magic values.
- Verified proper functionality of `drawAt` methods to allow drawing animals at different positions.

### Task 2: Associations
### What was Done:
- Identified aggregates and composites, providing comments for each object-property.
- Created a `Scene` class to aggregate multiple domain instances.
- Utilized an ArrayList for multiple associations such as `horses`.

### Task 3: Interfaces
### What was Done:
- Implemented the `LocatedRectangle` interface in the main class of the domain.
- Utilized the `intersects` method from `LocatedRectangle` to check object intersections.

### Task 4: Inheritance
### What was Done:
- Established superclass-subclass relationships within the domain.

### Task 5: Object Variations
### What was Done:
- Implemented overloaded `draw` methods considering different object details.
- Utilized different draw methods for scene instances.
- Incorporated a random number generator for object variation.
</details>
<details><summary>Results</summary>

![изображение](https://github.com/NikitaBarshchevskii/HAW-Hamburg-Software-Construction-2-Labs-Java/assets/47278408/8b83a2f1-5790-440a-85c8-1aafbbabb7c7)

The following image was created using Java graphics tools:

![изображение](https://github.com/NikitaBarshchevskii/HAW-Hamburg-Software-Construction-2-Labs-Java/assets/47278408/0f20d29e-9ee6-4265-845a-1a608fc67d55)
</details>

## Lab 3
<details><summary>Description</summary>
  
### Task 1: Vary Your Domain Objects

### Objective: Introduce visual variations for your domain objects, such as different colors, sizes, and shapes.
### Implementation:
- Used interfaces and inheritance hierarchies to manage variations.
- Introduced new methods to support visual variations specific to the animal, such as poses, clothing, and accessories.
- Ensured unique variations distinct from those used by other groups.
- Updated the UML class diagram to reflect these changes.
### Results:
- Depicted multiple objects with various visual attributes.
- Stored these objects in an ArrayList within the Scene class, each positioned differently.

### Task 2: Graphical User Interface for Controlling Variations

### Objective: Develop a GUI to control the variations of the domain objects.
### Implementation:
- Added a panel with buttons for modifying object depictions, employing other GUI components like sliders or input fields as needed.
- Utilized JLabel to provide labels near GUI elements for better user experience.
- Sketched the GUI design and updated the UML diagram accordingly.
- Enhanced the DrawingTool class (or its subclass extending JFrame) to include these GUI elements.
- Introduced new methods to initialize the GUI elements and override actionPerformed(ActionEvent e) for handling actions (see Task 3).
### Results:
- Created a responsive GUI that allows users to interactively control the visual attributes of the domain objects.

### Task 3: GUI in Action

### Objective: 
- Implement the functionality to bring the GUI to life.
### Implementation:
- Extended the actionPerformed(ActionEvent e) method in DrawingTool to handle GUI actions.
- Used setters of domain classes to modify object depictions based on user actions.
- Made the Scene class the entry point for all visual changes, ensuring it has the necessary properties and methods (getters and setters).
- Implemented methods to update the screen when the user interacts with the GUI, ensuring the graphics are refreshed appropriately.
- Example actions included methods like setHouses() and switchOnLights(), which modify the scene based on user input.

### Results:
- Achieved a fully functional GUI where user interactions dynamically alter the visual representation of domain objects.
</details>

<details><summary>Results</summary>
The following images were created using Java graphics tools:
![изображение](https://github.com/NikitaBarshchevskii/HAW-Hamburg-Software-Construction-2-Labs-Java/assets/47278408/cf918481-db2c-4d07-90ad-0299ea85d1e2)

  The following image was created using Java graphics tools:

![изображение](https://github.com/NikitaBarshchevskii/HAW-Hamburg-Software-Construction-2-Labs-Java/assets/47278408/b9cdcaba-1313-4d8f-aba0-8934b7e525b7)

</details>
