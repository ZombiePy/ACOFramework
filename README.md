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
<code>
problem:
  - mtsp//dimacs_15_a.tsp
  - mtsp//dimacs_15_b.tsp
  - mtsp//dimacs_15_c.tsp
  </code>
2. `Main.scala` define all remaining parameters



---

#### Authors:
<p><i>Krzysztof Tylka-Suleja <tylkasuleja@student.agh.edu.pl><br>
Tymoteusz Dobrzański <tdobrzanski@student.agh.edu.pl><br></i></p>

In cooperation with:<br>
<p><i>Aleksander Byrski <olekb@agh.edu.pl><br>
Mateusz Starzec <starzec.mateusz@gmail.com><br>
Grażyna Starzec <gstarzec@agh.edu.pl><br></i></p>