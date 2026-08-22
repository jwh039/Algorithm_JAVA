package Programmers.q150369;

// 택배 배달과 수거하기

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int far_delivery = findFarIndex(deliveries, deliveries.length-1);
        int far_pickup = findFarIndex(pickups, pickups.length-1);
        
        while(far_delivery>=0 || far_pickup>=0) {
            int dist = (far_delivery > far_pickup)? far_delivery : far_pickup;
            answer += (2*(dist+1));
            int truck = cap;
            // 배달
            while(truck > 0 && far_delivery >= 0) {
                if(deliveries[far_delivery] >= truck) {
                    deliveries[far_delivery] -= truck;
                    truck = 0;
                    far_delivery = findFarIndex(deliveries, far_delivery);
                } else {
                    truck -= deliveries[far_delivery];
                    deliveries[far_delivery] = 0;
                    far_delivery = findFarIndex(deliveries, far_delivery);
                }
            }
            truck = 0;
            // 수거
            while(truck < cap && far_pickup >= 0) {
                if(pickups[far_pickup] >= (cap-truck)) {
                    pickups[far_pickup] -= (cap-truck);
                    truck = cap;
                    far_pickup = findFarIndex(pickups, far_pickup);
                } else {
                    truck += pickups[far_pickup];
                    pickups[far_pickup] = 0;
                    far_pickup = findFarIndex(pickups, far_pickup);
                }
            }
        }
        return answer;
    }
    
    private int findFarIndex(int[] array, int index) {
        for(int res=index; res>=0; res--) {
            if(array[res] > 0) return res;
        }
        return -1;
    }
}