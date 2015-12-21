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

    for (i <- 0 until powerSetSize) {
        var powerSet = new Array[Int](0)
        var sum = 0
        for (j <- 0 until set.length) {
            val a = i & (1<<j);
            if (a > 0) {
                powerSet = powerSet :+ set(j)
                sum += set(j)
            }
        }
        if (sum == targetSum) {
            println (powerSet.mkString(","))
        }
    }
  }
}
