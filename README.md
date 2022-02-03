# ACO Framework

---

### 1. Introduction:


ACO Framework is created for <b><i>"Inteligencja Obliczeniowa"</i></b> course on 
<i>University of Science and Technology in Cracow.</i>  
Created to effective solve Ant Colony Optimization problems in scala
Framework for Ant Colony Optimization in Scala.

---

### 2. Implemented solutions:

Currently, there are implemented algorithms for:
1. Single Objective Ant Colony Optimization named `Tsp` for Travelling Salesman Problem
2. Multi Objective Ant Colony Optimization maned `Mtsp` also for TSP kind of problems

<b> Architecture Diagram: </b><br>
![Architecture Diagram](/architecture.png)

<p>All abstract classes are named with pattern `Base___.scala`, those classes inform user
about functions that must be implemented to run algorithm.</p>

---

### 3. Usage:

Needed steps:
1. Use `config.yaml` file to determine problem files. Example:  

```
problem:
  - mtsp//dimacs_15_a.tsp <br>
  - mtsp//dimacs_15_b.tsp <br>
  - mtsp//dimacs_15_c.tsp <br>
```
2. `Main.scala` define all remaining parameters



---

#### Authors:
<p>Krzysztof Tylka-Suleja <i> Email: tylkasuleja@student.agh.edu.pl </i><br>
Tymoteusz Dobrzański <i> Email: tdobrzanski@student.agh.edu.pl </i><br></p>

In cooperation with:<br>
<p>Aleksander Byrski <i> Email: olekb@agh.edu.pl </i> <br>
Mateusz Starzec <i> Email: starzec.mateusz@gmail.com </i><br>
Grażyna Starzec <i> Email: gstarzec@agh.edu.pl </i><br></p>
