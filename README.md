# ACO Framework

---

### 1. Introduction:


ACO Framework is created for <b><i>"Inteligencja Obliczeniowa"</i></b> course on 
<i>University of Science and Technology in Cracow.</i>  
Created to effective solve Ant Colony Optimization problems in Scala. 
It's also prepared for multi objective optimization.

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
2. Used algorithm define all remaining parameters. Quick description:
- `increment` - defines value that will be added to pheromone table when ant pass selected edge
- `alpha` - power used in pheromone calculation as ![eqation](https://latex.codecogs.com/svg.image?pheromone^{alpha})
- `beta` - power used in distance heuristic as ![eqation](https://latex.codecogs.com/svg.image?%5Cfrac%7B1%7D%7Bdistance%5E%7Bbeta%7D%7D)
- `extinction` - percentage loss of pheromone value after each algorithm iteration
- `distanceWeights` - weights used to flatten distances in multi objective calculations
- `pheromoneWeights` - weights used to flatten pheromone values
- `antNumb` - number of ants used for optimization
- `iteration` - number of iterations that algorithm can evaluate

3. Run `Main.scala` to run algorithm, results will be printed in console.
This file only read the selected problem and map it into `BaseProblem` instance, 
that can be further evaluated.  

4. Prepared solutions offers algorithms:
- weighted sum - for distance and pheromone flattening
- tbd

5. Included problems:
- Berlin 52 - dataset with 52 dimensions (locations from Berlin) from 
[here](http://elib.zib.de/pub/mp-testdata/tsp/tsplib/tsp/berlin52.tsp).
- DIMACS 15 - dataset with 15 dimensions in 3 different objectives (a, b, c), you can find it 
[here](https://sites.google.com/site/kflorios/motsp)
- Lust 100 - dataset with 100 dimensions in 2 objectives (A, B), also from
[here](https://sites.google.com/site/kflorios/motsp)
- Paquete 100 - dataset with 100 dimensions in 2 objectives (A, B) [here](https://sites.google.com/site/kflorios/motsp)


---

#### Authors:
<p>Krzysztof Tylka-Suleja <i> Email: tylkasuleja@student.agh.edu.pl </i><br>
Tymoteusz Dobrzański <i> Email: tdobrzanski@student.agh.edu.pl </i><br></p>

In cooperation with:<br>
<p>Aleksander Byrski <i> Email: olekb@agh.edu.pl </i> <br>
Mateusz Starzec <i> Email: starzec.mateusz@gmail.com </i><br>
Grażyna Starzec <i> Email: gstarzec@agh.edu.pl </i><br></p>
