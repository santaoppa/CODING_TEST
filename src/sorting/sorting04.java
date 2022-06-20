package sorting;

public class sorting04 {
    public static final int MAX_VALUE = 9;

    public static void main(String[] args) {
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2};
        int[] cnt = new int[MAX_VALUE + 1];

        for (int i = 0; i < arr.length; i++) {
            cnt[arr[i]] += 1; // 각 데이터에 해당하는 인덱스의 값 증가
        }
        for (int i = 0; i <= MAX_VALUE; i++) {
            for (int j = 0; j < cnt[i]; j++) {
                System.out.print(i + " ");
            }
        }
    }
}