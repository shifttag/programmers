class pcce09 {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int billmin = Math.min(bill[0], bill[1]);
        int billmax = Math.max(bill[0], bill[1]);
        int walletmin = Math.min(wallet[0], wallet[1]);
        int walletmax = Math.max(wallet[0], wallet[1]);

        while(billmin > walletmin || billmax > walletmax) {
            if(bill[0] > bill[1]) {
                bill[0] = bill[0] / 2;
            } else {
                bill[1] = bill[1] / 2;
            }
            billmin = Math.min(bill[0], bill[1]);
            billmax = Math.max(bill[0], bill[1]);
            answer++;
        }
        return answer;
    }
}