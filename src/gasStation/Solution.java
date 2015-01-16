package gasStation;

/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * <p/>
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * <p/>
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * <p/>
 * Note:
 * The solution is guaranteed to be unique.
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0) {
            return -1;
        }

        for (int i = 0; i < gas.length; ) {
            int left = 0;
            int startpos = i;
            int endpos = startpos;
            while (left + gas[endpos] - cost[endpos] >= 0) {
                left += gas[endpos] - cost[endpos];
                endpos++;
                if (endpos == gas.length) {
                    endpos = 0;
                }

                if (endpos == startpos) {
                    return startpos;
                }
            }

            if (endpos < startpos) {
                return -1;
            }
            i = endpos + 1;
        }
        return -1;
    }
}
