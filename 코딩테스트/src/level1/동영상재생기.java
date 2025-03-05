class 동영상재생기 {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";

        int video = timeswitch(video_len);
        int postime = timeswitch(pos);
        int opstarttime = timeswitch(op_start);
        int opendtime = timeswitch(op_end);

        for(int i = 0; i < commands.length; i++) {
            if(postime >= opstarttime && postime <= opendtime) {
                postime = opendtime;
            }
            if(commands[i].equals("next")) {
                postime += 10;
                if(postime > video) {
                    postime = video;
                }
            } else if(commands[i].equals("prev")) {
                postime -= 10;
                if(postime < 0) {
                    postime = 0;
                }
            }
            if(postime >= opstarttime && postime <= opendtime) {
                postime = opendtime;
            }
        }



        int minute = postime / 60;
        int second = postime % 60;
        String formatminute = minute < 10 ? "0" + minute : String.valueOf(minute);
        String formatsecond = second < 10 ? "0" + second : String.valueOf(second);
        answer = formatminute + ":" + formatsecond;
        return answer;
    }
    public int timeswitch(String time) {
        String[] parts = time.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        return minutes * 60 + seconds;
    }
}