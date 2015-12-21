def calculatePowerSetSize = { originalSet ->
    return 2.power(originalSet.size())
}

def cleanSet = { originalSet, targetSum ->
    return originalSet.findAll {it <= targetSum}
}


if (this.args.length < 1) {
  println "Target sum must be specified"
  return
}

def targetSum = this.args[0] as int
def set = this.args[1..(this.args.size()-1)].collect { it as int }

set = cleanSet(set, targetSum)
def powerSetSize = calculatePowerSetSize(set)

for (int i = 0; i < powerSetSize; ++i) {
    def powerSet = []
    for (int j = 0; j < set.size(); ++j) {
        if (i & (1<<j)) {
            powerSet += set[j];
        }
    }
    if (powerSet.sum() == targetSum) {
        println powerSet.join(',')
    }
}
