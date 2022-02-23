package pareto

/** Function that finds pareto front for minimization of criteria
  */
def getParetoFrontMin(data: List[List[Double]]): List[Boolean] = {
  val is_efficient = data.map(x => true).toArray
  for (i <- is_efficient.indices) {
    if (is_efficient(i)) {
      for (j <- is_efficient.indices) {
        if (is_efficient(j)) {
          is_efficient(j) =
            data(j).zip(data(i)).exists(pair => pair._1 < pair._2)
        }
      }
      is_efficient(i) = true
    }
  }
  is_efficient.toList
}
