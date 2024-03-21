package Random;
public class Ex_1_Ramdom_range {
    public static void main(String[] args) {
       int[] Freq = new int [11];
        for(int i=0 ; i<30; i++){
       int  num = 1+ (int) (Math.random()*10);
        Freq[num]++;
        }
      // print the freq of the numbers
    for (int number =1 ; number < Freq.length; number++){
        int freq_v =Freq[number];
        System.out.println("Number\t " + (number)+"occurs "+freq_v + "time ");
    }
    }
}


