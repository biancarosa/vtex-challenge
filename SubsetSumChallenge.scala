/**
** Given a set, returns all subsets with the target sum.
** It is based on the Power Set math theory.
** Args should have at least the target sum (minimal runnable code: scala SubsetSumChallenge.scala 6)
*/
object SubsetSumChallenge {
  def calculatePowerSetSize(setSize: Int) : Int = {
    return math.pow(2, setSize.toDouble).toInt
  }

  def cleanSet(set : Array[Int], targetSum : Int) : Array[Int] = {
    var cleanSet = new Array[Int](0)
    for (x <- set) {
        if (x <= targetSum) {
            cleanSet = cleanSet :+ x
        }
    }
    return cleanSet
  }

  def main(args: Array[String]) {
    if (args.length < 1) {
        println("Target sum must be specified")
        return
    }

    val targetSum = args(0).toInt

    var set = new Array[Int](args.length - 1)
    for (i <- 1 until args.length) {
        set(i-1) = args(i).toInt
    }

    set = cleanSet(set, targetSum)
    val powerSetSize = calculatePowerSetSize(set.length)
    var outputs = 0
    for (i <- 0 until powerSetSize) {
        var powerSet = new Array[Int](0)
        var sum = 0
        // To retrieve the numbers on the PowerSet i, we loop through the whole set...
        for (j <- 0 until set.length) {
            //And if the number is "part" of this particular subset (bit is one for the position j) we add to the current power set
            var bitIsOne = i & (1<<j);
            if (bitIsOne > 0) {
                powerSet = powerSet :+ set(j)
                sum += set(j)
            }
        }
        if (sum == targetSum) {
            println (powerSet.mkString(","))
            outputs = outputs + 1
        }
    }
    if (outputs == 0) {
        println ("Couldn't find a subset with given target sum")
    }
  }
}
