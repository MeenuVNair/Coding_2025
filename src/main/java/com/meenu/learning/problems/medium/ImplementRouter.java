package com.meenu.learning.problems.medium;

import java.util.*;

/**
 * @author Meenu V. Nair
 * @created 20/09/25
 */

/*******  APPROACH ******************** 

 */

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity : 
 Space Complexity : 
 */

public class ImplementRouter {
    Map<List<Integer>, Integer> mpp = new HashMap<>(); // to track duplicates
    Queue<List<Integer>> queue = new LinkedList<>(); // to store packets in FIFO order
    Map<Integer, List<Integer>> timestamps = new HashMap<>(); // for timestamps tracking
    Map<Integer, Integer> st = new HashMap<>();
    int maxSize = 0; // maxSize allowed

    public Router(int memoryLimit) {
        maxSize = memoryLimit;
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        List<Integer> packet = Arrays.asList(source, destination, timestamp);
        // checking for duplicate
        if (mpp.containsKey(packet))
            return false;
        if (queue.size() == maxSize) { // remove the first element if queue is full
            List<Integer> res = queue.poll();
            mpp.remove(res);
            int temp = res.get(1);
            st.put(temp, st.getOrDefault(temp, 0) + 1);
        }
        queue.offer(packet);
        mpp.put(packet, 1);
        timestamps.computeIfAbsent(destination, k -> new ArrayList<>()).add(timestamp);
        return true;
    }

    public int[] forwardPacket() {
        if(queue.isEmpty()) return new int[0];
        List<Integer> res = queue.poll();
        mpp.remove(res);
        int temp = res.get(1);
        st.put(temp, st.getOrDefault(temp, 0) + 1);
        return new int[]{res.get(0), res.get(1), res.get(2)};
    }

    public int getCount(int destination, int startTime, int endTime) {
        if(!timestamps.containsKey(destination))
            return 0;
        List<Integer> p = timestamps.get(destination);
        int temp = st.getOrDefault(destination, 0);
        int right = lowerBound(p, startTime, temp);
        int left = upperBound(p, endTime, temp);
        return left - right;
    }

    private int lowerBound(List<Integer> p, int target, int start) {
        int l = start, r = p.size();
        while(l < r) {
            int mid = (l + r) / 2;
            if(p.get(mid) < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    private int upperBound(List<Integer> p, int target, int start) {
        int l = start, r = p.size();
        while(l < r) {
            int mid = (l + r) / 2;
            if(p.get(mid) <= target) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */

/*******  PROBLEM DESCRIPTION ******************** 
 Design a data structure that can efficiently manage data packets in a network router. Each data packet consists of the following attributes:

 source: A unique identifier for the machine that generated the packet.
 destination: A unique identifier for the target machine.
 timestamp: The time at which the packet arrived at the router.
 Implement the Router class:

 Router(int memoryLimit): Initializes the Router object with a fixed memory limit.

 memoryLimit is the maximum number of packets the router can store at any given time.
 If adding a new packet would exceed this limit, the oldest packet must be removed to free up space.
 bool addPacket(int source, int destination, int timestamp): Adds a packet with the given attributes to the router.

 A packet is considered a duplicate if another packet with the same source, destination, and timestamp already exists in the router.
 Return true if the packet is successfully added (i.e., it is not a duplicate); otherwise return false.
 int[] forwardPacket(): Forwards the next packet in FIFO (First In First Out) order.

 Remove the packet from storage.
 Return the packet as an array [source, destination, timestamp].
 If there are no packets to forward, return an empty array.
 int getCount(int destination, int startTime, int endTime):

 Returns the number of packets currently stored in the router (i.e., not yet forwarded) that have the specified destination and have timestamps in the inclusive range [startTime, endTime].
 Note that queries for addPacket will be made in increasing order of timestamp.



 Example 1:

 Input:
 ["Router", "addPacket", "addPacket", "addPacket", "addPacket", "addPacket", "forwardPacket", "addPacket", "getCount"]
 [[3], [1, 4, 90], [2, 5, 90], [1, 4, 90], [3, 5, 95], [4, 5, 105], [], [5, 2, 110], [5, 100, 110]]

 Output:
 [null, true, true, false, true, true, [2, 5, 90], true, 1]

 Explanation

 Router router = new Router(3); // Initialize Router with memoryLimit of 3.
 router.addPacket(1, 4, 90); // Packet is added. Return True.
 router.addPacket(2, 5, 90); // Packet is added. Return True.
 router.addPacket(1, 4, 90); // This is a duplicate packet. Return False.
 router.addPacket(3, 5, 95); // Packet is added. Return True
 router.addPacket(4, 5, 105); // Packet is added, [1, 4, 90] is removed as number of packets exceeds memoryLimit. Return True.
 router.forwardPacket(); // Return [2, 5, 90] and remove it from router.
 router.addPacket(5, 2, 110); // Packet is added. Return True.
 router.getCount(5, 100, 110); // The only packet with destination 5 and timestamp in the inclusive range [100, 110] is [4, 5, 105]. Return 1.
 Example 2:

 Input:
 ["Router", "addPacket", "forwardPacket", "forwardPacket"]
 [[2], [7, 4, 90], [], []]

 Output:
 [null, true, [7, 4, 90], []]

 Explanation

 Router router = new Router(2); // Initialize Router with memoryLimit of 2.
 router.addPacket(7, 4, 90); // Return True.
 router.forwardPacket(); // Return [7, 4, 90].
 router.forwardPacket(); // There are no packets left, return [].


 Constraints:

 2 <= memoryLimit <= 105
 1 <= source, destination <= 2 * 105
 1 <= timestamp <= 109
 1 <= startTime <= endTime <= 109
 At most 105 calls will be made to addPacket, forwardPacket, and getCount methods altogether.
 queries for addPacket will be made in increasing order of timestamp.

 Hint 1
 A deque can simulate the adding and forwarding of packets efficiently.
 Hint 2
 Use binary search for counting packets within a timestamp range.

 */
