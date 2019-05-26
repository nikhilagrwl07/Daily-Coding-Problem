package main.java;

public class PermutationOfArray {
    public static void main(String[] args) {
        String input = "ABC";
        permute(input, 0 , input.length()-1);
    }


    private static void permute(String str, int l, int r)
    {
        if (l == r)
            System.out.println(str);
        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);  // Step #1
                permute(str, l+1, r);   // Step #2
//                str = swap(str,l,i); // Step #3 - not required as we are generating new string in step #1
            }
        }
    }

    public static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
