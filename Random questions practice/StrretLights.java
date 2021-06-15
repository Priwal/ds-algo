
//paytm question
/*One of the streets in your city has a total of L street lights. Each light i covers the street from
Xi to Yi distance. Find the length of street covered with light.
Input Specification:
input1: L, denoting the number of street lights.
input2: An array of L* 2 elements. For each row i, (Xi, Yi) denote that the
street light i covers the distance from Xi to Yi.
Output Specification:
Your function should return the length of the street covered with light.
Example 1:
input1: 1,
input2: {{5,10 } }
Output: 5*/
public class StrretLights {

    public static void main(String[] args)

    {

        int[][] arr = { { 1, 4 }, { 7, 10 }, { 11, 13 }, { 16, 17 }, { 17, 18 } };
        int sum = 0, diff = 0;
        for (int i = 0; i < arr.length; i++)

        {
            sum = sum + (arr[i][1] - arr[i][0]);
            if (i < arr.length - 1) {
                if (arr[i][1] > arr[i + 1][0] || arr[i][1] - arr[i + 1][0] == -1) {
                    diff += arr[i][1] - arr[i + 1][0];
                }

            }
        }
        System.out.println(sum - diff);
    }
}
