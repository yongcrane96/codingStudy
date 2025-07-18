class Squared {

    public static int solution(int[] fire, int[][] humans, int k){
        int answer = 0;

        long fireX = fire[0];
        long fireY = fire[1];
        long radiusSquared = (long) k * k ; //반지름 제곱근, 드론 알림 반경 k의 제곱 , 이 거리보다 가까우면 알림을 보낼 수 있음

        for(int[] human : humans){
            long humanX = human[0];
            long humanY = human[1];

            long dx = humanX - fireX;
            long dy = humanY - fireY;

            long distanceSquared = dx * dx + dy * dy; // 배달원과 요청 지점 사이 거리의 제곱 (배달원이 얼마나 떨어져 있는가?)

            if(distanceSquared < radiusSquared){
                answer++;
            }

        }
        return answer;
    }



    public static void main(String[] args) {
        int[] fire = {0, 0}; // 드론 요청 시점
        int[][] humans = {
                {-100, 200}, {50, 50}, {400, -300},
                {450, -100}, {1500, 500}, {-300, 600},
                {0, -550}, {1100, 0}, {-640, 30},
                {10, 80}, {10, -100}
        }; // 배달원 위치
        int k = 500; // 반경 500m

        System.out.println(solution(fire, humans, k));
    }
}
