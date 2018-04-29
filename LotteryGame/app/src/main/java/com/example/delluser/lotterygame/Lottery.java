package com.example.delluser.lotterygame;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Conor Griffin on 29/04/2018.
 */

public class Lottery {

    // pick from random numbers and return - sorted
    // each number unique
    // howMany - the number of numbers to pick
    // max - the largest number than can be picked
    public static int[] GetNumbers(int howMany, int max) throws  Exception {
        if(howMany > 0){
            if(max > howMany){
                // create array of ints
                int[] numbers = new int[howMany];

                // random generator
                Random r = new Random();

                // draw each number randomly
                // no duplicates
                for(int i = 0; i < howMany; i++){
                    int numberDrawn;

                    // pick a random number between 0 and max
                    boolean finished = false;
                    do{
                        numberDrawn = r.nextInt(max) + 1;
                        // finished if not 0 and not already drawn
                        if(numberDrawn != 0){
                            boolean alreadyDrawn = false;

                            // check if previously drawn
                            // no 2 numbers can be the same
                            for(int j = 0; j < i; j++){
                                if(numbers[j] == numberDrawn){
                                    alreadyDrawn = true;
                                    break;
                                }
                            }
                            // if not alreadyDrawn add to numbers array
                            if(!alreadyDrawn){
                                numbers[i] = numberDrawn;
                                finished = true;
                            }
                        }
                    }
                    while(!finished);
                }
                // sort numbers and return numbers
                Arrays.sort(numbers);
                return numbers;
            }
            else{
                throw new Exception("Invalid Input");
            }
        }
        else{
            throw new Exception("Invalid Input");
        }
    }
}
