package rockpaperscissors;

import java.util.ArrayList;
import java.util.Comparator;


public class RPS_Comparator implements Comparator<RPS_Player> {
    
    public static final int NTHROW = 10;
    
    @Override public int compare(RPS_Player a, RPS_Player b) {
        
        System.out.println(a.getStudentName() + " vs. " + b.getStudentName());
        
        int wina = 0;
        int winb = 0;
        int tie = 0;
        int diff = 0;
        ArrayList<Integer> prev_a = new ArrayList<>(0);
        ArrayList<Integer> prev_b = new ArrayList<>(0);
        for (int kt = 0; kt < NTHROW; kt++) {
            //System.out.println(kt);
            int a_sel = a.makeSelection(prev_b);
            int b_sel = b.makeSelection(prev_a);
            
            //System.out.println(a_sel + "," + b_sel);
            
            prev_a.add(a_sel);
            prev_b.add(b_sel);
            switch (a_sel) {
                case RPS_Player.ROCK :
                    switch (b_sel) {
                        case RPS_Player.ROCK : tie++; break;
                        case RPS_Player.PAPER : winb++; break;
                        case RPS_Player.SCISSOR : wina++; break;
                        default : break;
                    }
                    break;
                case RPS_Player.PAPER :
                    switch (b_sel) {
                        case RPS_Player.ROCK : wina++; break;
                        case RPS_Player.PAPER : tie++; break;
                        case RPS_Player.SCISSOR : winb++; break;
                        default : break;
                    }
                    break;
                case RPS_Player.SCISSOR :
                    switch (b_sel) {
                        case RPS_Player.ROCK : winb++; break;
                        case RPS_Player.PAPER : wina++; break;
                        case RPS_Player.SCISSOR : tie++; break;
                        default : break;
                    }
                    break;
                default : break;
            }
        }
        

        System.out.println("Number of times a won :: "+wina);
        System.out.println("Number of times b won :: "+winb);
        System.out.println("Number of ties ::"+tie);
        System.out.println("a wins: " + (((double) wina)/NTHROW) + "%");
        System.out.println("b wins: " + (((double) winb)/NTHROW) + "%");
        System.out.println("  ties: " + (((double) tie)/NTHROW) + "%");
        
        if (wina > winb) {
        	System.out.println(a.getStudentName() + "is the winner of this league!");
        	diff = wina - winb;
        }
        else if (wina < winb) {
        	System.out.println(b.getStudentName() + "is the winner of this league!");
        	diff = winb - wina;
        }
        else {
            System.out.println("Tie");
        }
        
        return diff;
        
        
        
    }
    
    
}
