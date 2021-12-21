package project.colony

import project.ant.BaseAnt

abstract class BaseColony (AntNumb: Int) {
  var ants: List[BaseAnt] = createAnts()

  def run(): None = {
    /*
    Function that runs all ants to create solutions
     */
  }

  def createAnts(): List[BaseAnt] = {
    /*
    Function to place ants
     */
  }
}
