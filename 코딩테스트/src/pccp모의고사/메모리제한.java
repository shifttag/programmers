import java.util.*;
class 메모리제한 {
    public String solution(String input_string) {
        String answer = "";
        for(int i = 0; i < input_string.length() - 2; i++) {
            String alpha = input_string.substring(i, i+1);
            String alphap = input_string.substring(i+1, i+2);
            for(int j = i + 2; j < input_string.length(); j++) {
                String beta = input_string.substring(j, j+1);
                if(alpha.equals(alphap)) {
                    continue;
                }
                if(alpha.equals(beta) && !answer.contains(alpha)) {
                    answer += alpha;
                    break;
                }
            }
        }
        List<String> arrToSort = new ArrayList<>();
        for(int i = 0; i < answer.length(); i++) {
            String gamma = answer.substring(i, i+1);
            arrToSort.add(gamma);
        }
        String[] stringArray = arrToSort.toArray(new String[0]);
        Arrays.sort(stringArray);


        StringBuilder sortedString = new StringBuilder();
        for (String s : stringArray) {
            sortedString.append(s);
        }
        if(sortedString.toString().equals("")) {
            return "N";
        }
        return sortedString.toString();

    }
}