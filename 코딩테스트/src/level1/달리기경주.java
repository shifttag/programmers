import java.util.*;

class 달리기경주 {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for(int i = 0; i < callings.length; i++) {
            Integer index = map.get(callings[i]);

            if(index == 0) continue;

            String temp = players[index - 1];
            players[index - 1] = players[index];
            players[index] = temp;

            map.put(players[index], index);
            map.put(players[index - 1], index - 1);
        }

        return players;
    }
}