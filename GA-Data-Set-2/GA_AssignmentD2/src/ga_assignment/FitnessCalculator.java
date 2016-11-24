/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ga_assignment;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author RickyL
 */
public class FitnessCalculator {

    public void fitnessCalculator(Individual gene, Rule[] rules) throws FileNotFoundException {

        int fitness = 0;
        String geno = gene.getGene();
        GeneticAlgorithm ga = new GeneticAlgorithm();
        char[] geneArray;
        geneArray = new char[ga.N];

        int j = 0;
        int pivot = 6;
        int splitOutput = 0;

        // turns gene into array
        for (int i = 0; i < ga.N; i++) {

            char c = geno.charAt(i);
            geneArray[i] = c;
        }

        for (Rule r : rules) {
            pivot = 6;
            j = 0;

        for (int k = 0; k < 10; k++) {
            
            char[] splitGene;
            splitGene = new char[6];
            int counter = 0;

            //splits gene array into parts
            for (j = j; j < ga.N; j++) {
                if (j == pivot) {
                    int a = Character.getNumericValue(geneArray[j]);
                    splitOutput = a;
                    j++;
                    break;
                } else {
                    splitGene[counter] = geneArray[j];
                    counter++;
                }

            }
            //converts splitGene to String
            String geneString = new String(splitGene);
            pivot = pivot + 7;

            // comparison against rule set    
                    String condition = r.getCondition();
                    int output = r.getOutput();
                    char[] charArray = condition.toCharArray();
                    
                    int matches = 0;
                    
                    // make two readable
                    String twoo = "2";
                    char two = twoo.charAt(0);
                    

                    // tests gene bits against condition bits
                    for (int d = 0; d < 6; d++) {
                if(charArray[d] == splitGene[d] || splitGene[d] == two){
                    matches++;
                }
            }
  
                    // if condition DOES match rule set
                    if (matches == 6) {
                        //if condition is met in rule set, test output
                        if (output == splitOutput || output == 2) {
                            fitness++;
                            gene.setFitness(fitness);
                            break;
                        }
                       break;
                    }
                   
                }
            }
        }

    }


