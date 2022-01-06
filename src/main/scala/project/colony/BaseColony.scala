package project.colony

import project.ant.BaseAnt

abstract class BaseColony (ant_numb: Int) {
  var ants: List[BaseAnt] = createAnts()

  def run() = {
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
