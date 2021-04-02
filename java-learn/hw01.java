public class hw01 {
    private static int max(int [] num){
        int i=0;
        while( ! if_max(num, i)){
            if (i>=num.length-1){
                break;
            }
            i+=1;
        }
        return num[i];
    }
    private  static boolean if_max(int [] num, int a) {
        int i=0;
        while(num[a]>=num[i]&& i<num.length){
            i+=1;
            if (i>num.length-1) {
                break;
            }
        }
        if (i==num.length){
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        int[] num=new int[args.length];
        for (int i = 0; i < args.length; i++)
        {
            num[i]=Integer.parseInt(args[i]);
        }
        System.out.println(max(num));
    }
}