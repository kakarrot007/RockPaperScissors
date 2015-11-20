package rockpaperscissors;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author malehr
 */
public class RPS_RANDOM implements RPS_Player {
    
    public Random randgen;
    
    public RPS_RANDOM() {
        randgen = new Random();
    }
    
    @Override public int makeSelection(ArrayList<Integer> prev) {
        return randgen.nextInt(3);
    }
    
    @Override public String getStudentName() {
        return "Dr. Maleh, Pure Random Strategy";
    }
    
}

