class 붕대감기 {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int succes = 0;
        int state = health;
        int attackIdx = attacks.length - 1;
        int idx = 0;
        for(int i = 1; i <= attacks[attackIdx][0]; i++) {
            if(i == attacks[idx][0]) {
                state -= attacks[idx][1];
                idx++;
                succes = 0;
                if(state <= 0) {
                    return -1;
                }
            } else {
                state += bandage[1];
                succes++;
                if(bandage[0] == succes) {
                    state += bandage[2];
                    succes = 0;
                }
            }

            if(state > health) {
                state = health;
            }
        }


        return state;
    }
}