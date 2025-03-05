import java.util.*;

class 멘델의완두콩 {
    public String[] solution(int[][] queries) {
        int maxRow = 0;
        for (int[] query: queries) {
            maxRow = Math.max(maxRow, query[0]);
        }
        int col = (int) Math.pow(4, maxRow-1);
        String [][] beanlist = new String[maxRow][col];

        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < col; j++) {
                beanlist[i][j] = "";
            }
        }

        beanlist[0][0] = "Rr";
        for(int i = 0; i < maxRow - 1; i++) {
            for(int j = 0; j < (int) Math.pow(4, i); j++) {
                if(beanlist[i][j].equals("Rr")) {
                    beanlist[i+1][j*4] = "RR";
                    beanlist[i+1][j*4+1] = "Rr";
                    beanlist[i+1][j*4+2] = "Rr";
                    beanlist[i+1][j*4+3] = "rr";
                }
                if(beanlist[i][j].equals("RR")) {
                    for(int k = 0; k < 4; k++) {
                        beanlist[i+1][j*4+k] = "RR";
                    }
                }
                if(beanlist[i][j].equals("rr")) {
                    for(int k = 0; k < 4; k++) {
                        beanlist[i+1][j*4+k] = "rr";
                    }
                }
            }
        }

        String[] answer = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int row = queries[i][0] - 1;
            int colIndex = queries[i][1] - 1;
            answer[i] = beanlist[row][colIndex];
        }




        return answer;
    }
}






/*
-- 정답

import java.util.*;

class Solution {
    public String[] solution(int[][] queries) {
        String[] answer = new String[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int row = queries[i][0];
            int colIndex = queries[i][1];
            answer[i] = calculateValue(row, colIndex);
        }

        return answer;
    }

    private String calculateValue(int row, int colIndex) {
        // row가 1일 때 초기 값 설정
        if (row == 1) {
            return "Rr";
        }

        // 상위 행의 값 계산
        int parentRow = row - 1;
        int parentIndex = (colIndex - 1) / 4;
        String parentValue = calculateValue(parentRow, parentIndex + 1);

        // 현재 위치의 값 결정
        int positionInParent = (colIndex - 1) % 4;
        if ("Rr".equals(parentValue)) {
            switch (positionInParent) {
                case 0:
                    return "RR";
                case 1:
                case 2:
                    return "Rr";
                case 3:
                    return "rr";
            }
        } else if ("RR".equals(parentValue)) {
            return "RR";
        } else if ("rr".equals(parentValue)) {
            return "rr";
        }

        return ""; // 예외 상황 처리
    }
}






*/