
public class Recursion{

    //factorial iterative way using a loop
    public static long factorial(int n) {
        if (n < 0) {//i dont want to throw an exception=> give me anothe solution
            return Long.MIN_VALUE;
        }

        long res = 1;
        for (int i = 1; i <= n; i++) {
            res = res * i;
        }
        return res;
    }

    //Fcatorial recursive way
    public static long factorialR(int n) {
        if (n < 0) {//i dont want to throw an exception=> give me anothe solution
            return Long.MIN_VALUE;
        }
        if (n == 0) {
            return 1;
        } else {
            return (n * factorialR(n - 1));
        }
    }
    
    
    //power iterative way with positive power
    public static long power(int x, int n)
    {
        if (n < 0) {//we can do a throw  exception instead of this
            return Long.MIN_VALUE;
        }
        else if (n==0){
            return 1;
        }
        else{
            long res=1;
            for(int i=1; i<=n; i++)
            {
                res=res*x;
            }
            return res;
        }
    }
    
    //power in a recursive way
    public static long powerR(int x, int n)
    {
         if (n < 0) {//we can do a throw  exception instead of this
            return Long.MIN_VALUE;
        }
        else if (n==0){
            return 1;
        }
        else{
            return(x * powerR(x, (n-1) ));
        }
    }
    
    //power in a recursive squaring way
    public static long powerRS(int x, int n)
    {
        long y;
         if (n < 0) {//we can do a throw  exception instead of this
            return Long.MIN_VALUE;
        }
        else if (n==0){
            return 1;
        }
        else if((n%2) == 0){
            y=powerRS(x,(n/2));
            //return (powerRS(x,(n/2)) * powerRS(x,(n/2)));
            return (y * y);
        }
        else{
            y=powerRS(x,(n/2));
            return (x * y * y);
        }
    }
    
    //Fibonacci Recursive way : non linear recursion
    public static int FibR(int n)
    {
        if (n<0){
            return Integer.MIN_VALUE;
        }
        else if(n<=1){
            return 1;
        }
        else{
            return (FibR(n-1)+FibR(n-2));
        }
    }
    //generate the final result of the linearFib function
    public static int FinalFib(int n){
        int[] res=linearFib(n);
        return res[0];
    }
    
    //Fibonacci Recursive way : linear recursion
    public static int[] linearFib(int n){
        int[] res;
        if(n==1){
            res=new int[2];
            res[0]=1;
            res[1]=1;
        }
        else{
            res=linearFib(n-1);
            int temp=res[0]+res[1];//i+j
            res[1]= res[0];//res[1]=i
            res[0]=temp;//res[0]<=i+j
        }
        return res;
    }
    
     //Fibonacci iterative way 
    public static int Fib(int n)
    {
        if (n<0){
            return Integer.MIN_VALUE;
        }
        else if(n<=1){
            return 1;
        }
        else{
            int res0=1;
            int res1=1;
            int temp;
            for(int i=2; i<=n; i++)
            {
                temp=res0;
                res0=res1;
                res1=res1+temp;
            }
            return res1;
        }
    }
    
    //Hofstadter G sequence recursive way
    public static int G(int n) throws IllegalArgumentException{
        if (n<0) throw new IllegalArgumentException();
        else if(n==0){
            return 0;
        }
        else{
            return (n - G(G(n-1)));
        }
    }
    
    //reverse array recursive way
    public static void reverseR(int T[], int low, int high){
        int temp;
        if(low<high){
            temp=T[low];
            T[low]=T[high];
            T[high]=temp;
            reverseR(T, low+1, high-1);
        }
    }
        //reverse array iterative way: trabnsformation of the reverseR function
    public static void reverse(int T[], int low, int high){
        int temp;
        while(low<high){
            temp=T[low];
            T[low]=T[high];
            T[high]=temp;
            low++;
            high--;
        }
    }
    
    //sequential search for an elt in ana array
    public static int search(int T[], int x){
        int position=-1;
        for(int i=0; i<T.length; i++){
            if(T[i]==x){
                position=i;
                return position;
            }
        }
        return position;
    }
    
    //Binary search for an elt in a sorted array
    public static int Bsearch(int T[], int x, int low, int high){
        int position =-1;
        int mid;
        if(low>high){
            return -1;
        }
        else{
            mid=(low + high)/2;
            if(T[mid] == x){
                position=mid;
                return position;
            }
            else if (x>T[mid]){
                low=mid+1;
                return Bsearch(T, x, low, high);
            }
            else{
                high=mid-1;
                return Bsearch(T, x, low, high);
            }
        }
    }
    
    
    //Binary search for an elt in a sorted array
    public static int Bsearch2(int T[], int x, int low, int high){
        int position =-1;
        int mid;
        while(low<=high){
       
            mid=(low + high)/2;
            if(T[mid] == x){
                position=mid;
                return position;
            }
            else if (x>T[mid]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return position;
    }
    
    
    
    
    public static void main(String[] args) {
        System.out.println("Iterative Fib (5)=" +Fib(5));
        System.out.println("Recursive Fib (5)=" +FibR(5));
        System.out.println("Lilnear Recursive Fib (5)=" +FinalFib(5));
        System.out.println("2^5 =" + power(2,5));
        System.out.println("2^5 =" + powerR(2,5));
        System.out.println("2^5 =" + powerRS(2,5));
        int arr[]={1,2,3,4,10,30,34,40};
        int res=search(arr, 300);
        if(res==-1){
            System.out.println("Not found");
        }
        else {
            System.out.println("30 found at position "+res);
        }
        res=Bsearch(arr, 30, 0, (arr.length-1));
        if(res==-1){
            System.out.println("Not found");
        }
        else {
            System.out.println("30 found at position "+res);
        }
        res=Bsearch2(arr, 30, 0, (arr.length-1));
        if(res==-1){
            System.out.println("Not found");
        }
        else {
            System.out.println("30 found at position "+res);
        }
        
    }
    
    
}
