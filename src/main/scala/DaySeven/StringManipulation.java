package DaySeven;

public class StringManipulation {
    static int WaysToSolve(String input) {
        assert(input.charAt(0) != '0');
        int res = input.length();
        for(int i=0;i<input.length()-1;i++){
            if(input.charAt(i) =='1') res +=1;
            else if(input.charAt(i) == '2') {
                if(input.charAt(i+1) <= 6) res +=1;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(WaysToSolve("14296"));
    }
}
