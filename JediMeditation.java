import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class JediMeditation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        String[] jedi = new String[N];
        String line = in.nextLine();
        String line2 = in.nextLine();
        String[] jediTokens = line2.split(" ");
        Queue<String> queueMasters = new LinkedList<>();
        Queue<String> queueKnights = new LinkedList<>();
        Queue<String> queuePadwans = new LinkedList<>();
        for (int i = 0; i < jedi.length; i++) {
            jedi[i] = jediTokens[i];
            if(jedi[i].contains("M")){
                queueMasters.offer(jedi[i]);
            }else if(jedi[i].contains("K")){
                queueKnights.offer(jedi[i]);
            }else if(jedi[i].contains("P")){
                queuePadwans.offer(jedi[i]);
            }
        }

        while(queueMasters.peek() != null){
            System.out.print(queueMasters.poll() + " ");
        }

        while(queueKnights.peek() != null){
            System.out.print(queueKnights.poll() + " ");
        }

        while(queuePadwans.peek() != null){
            System.out.print(queuePadwans.poll() + " ");
        }
    }
}
