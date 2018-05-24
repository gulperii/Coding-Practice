import java.util.Scanner;
public class study{
	public static void main(String[] args) {
	int SENTINEL = -1;
System.out.print("Type a number (or " + SENTINEL + " to stop): ");
Scanner console = new Scanner(System.in);
int input = console.nextInt();
int min = input;
int max = input;
while (input != SENTINEL) {
    if (input < min) {
        min = input;
    } else if (input > max) {
        max = input;
    }

    System.out.print("Type a number (or " + SENTINEL + " to stop): ");
    input = console.nextInt();
}

if (min != SENTINEL) {
    System.out.println("Maximum was " + max);
    System.out.println("Minimum was " + min);
}
}
}
