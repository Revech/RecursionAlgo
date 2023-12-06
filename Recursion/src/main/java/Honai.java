
public class Honai {
    public static int step = 1;
    public static void moveDisks(int n, char src, char dest, char aux) {
        if (n == 1) {
            System.out.println(step++ + ": Move Disk 1 from " + src + " to " + dest);
        } else {
            // aux becomes the destination in the first step
            moveDisks(n - 1, src, aux, dest);
            System.out.println(step++ + ": Move Disk " + n + " from " + src + " to " + dest);
            // aux becomes the source in the next step
            moveDisks(n - 1, aux, dest, src);
        }
    }
    
    public static void main(String[] args) {
        moveDisks(20,'A','C','B');
    }
}
