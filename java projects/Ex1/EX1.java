import java.util.*;
class EX1
{
    static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args)
    {
        System.out.print("Please insert a number: ");
        int num = in.nextInt();
        int sumOfDigits = Q1(num);
        System.out.println(sumOfDigits);
        System.out.print("Please insert a number: ");
        int num1 = in.nextInt();
        int mugzam = Q2(num1);
        if (mugzam==1)
            System.out.println(true);
        if (mugzam==-1)
            System.out.println(false);
        Q3();
        System.out.println();
        Q4();
    }
    
    // Calculates the sum of the digits in the number iteratively
    public static int Q1(int num)
    {
        int sum =0;
        if (num<0)
            num *= -1;
        while (num != 0)
        {
            sum += num%10;
            num /= 10;
        }
        if(sum >= 10)
            return Q1(sum);
        return sum;
    }
    
    //Check if the number is "mugzam"
    public static int Q2(int num)
    {
        int sumMugzam = 0;
        if (num<0)
            num *= -1;
        while (num != 0)
        {
            sumMugzam += (num%10) * (num%10);
            num /= 10;
        }  
        if(sumMugzam==1)
            return 1;
        if(sumMugzam==4)
            return -1;
        return Q2(sumMugzam);
    }
      
    //Check if the number is palindrome
    public static void Q3()
    {
        System.out.print("Please insert a number: ");
        int num = in.nextInt();
        int sameNum = num;
        int count = 0;
        int i = 0;
        boolean check = true;
        while (sameNum != 0)
        {
            count++;
            sameNum /= 10;
        }
        int[] arr = new int[count];
        while(num != 0)
        {
            arr[i] = num%10;
            num /= 10;
            i++;
        }
        for (int j = 0; j < arr.length; j++)
        {
            if (arr[j] != arr[arr.length-j-1])
            check = false;
        }
        System.out.print(check);
    }
      
    //Calculates the winner spot in the Josephus problem
    public static void Q4()
    {
        System.out.print("Please insert a number: ");
        int num = in.nextInt();
        int sameNum = num;
        int x = 0;
        int win = 0;
        int count = 0;
        if (checkIfPowerOf2(num) == true)
            System.out.print(1);
        else
        {
            while(sameNum > 1)
            {
            count ++;
            sameNum /= 2;
            }
            x = num - (int)Math.pow(2, count);
            win = 2*x+1;
            System.out.print(win);
        }
    }
      
    //funqtion for Q4 solution
    private static boolean checkIfPowerOf2(int num)
    {
        if(num<=0)
            return false; 
        while(num > 1)
        {
            if(num % 2 != 0)
                return false;
            num /= 2;
        }
        return true;
    }
     
}