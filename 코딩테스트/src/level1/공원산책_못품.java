package level1;

public class 공원산책_못품 {
    public static void main(String[] args) {
        String[] park = {"SOO","OOO","OOO"};
        String[] routes = {"E 2","S 2","W 1"};
        String[] index = new String[park.length];
        int[] startIdx = new int[2];
        String[] route = new String[routes.length];

        for(int i = 0 ; i < park.length; i++) {
            index = park[i].split("");
            for(int j = 0; j < index.length; j++) {
                if(index[j].equals("S")) {
                    startIdx[0] = i;
                    startIdx[1] = j;
                }
            }
        }

        for(int i = 0; i < routes.length; i++) {
            route = routes[i].split(" ");
                int distance = Integer.parseInt(route[1]);
            switch(route[0]){
                case "E":
                    if (startIdx[1] + distance <= index.length) {
                        startIdx[1] += distance;
                    }
                    continue;

                case "S":
                    if (startIdx[0] - distance <= park.length) {
                        startIdx[0] += distance;
                    }
                    continue;
                case "W":
                    if (startIdx[1] - distance >= 0) {
                        startIdx[1] -= distance;
                    }
                    continue;
                case "N":
                    if (startIdx[0] - distance >= 0) {
                        startIdx[0] -= distance;
                    }
                    continue;
            }
            System.out.println("?");
            System.out.println(startIdx[0] + " " + startIdx[1]);
        }
        System.out.println("최종:" + startIdx[0] + " " + startIdx[1]);
    }
}
