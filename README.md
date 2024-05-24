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
- Utilized an ArrayList for multiple associations such as `dogs`.

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
