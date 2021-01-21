package org.launchcode.techjobs.console;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by LaunchCode
 */
public class TechJobs {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        // Initialize our field map with key/name pairs
        HashMap<String, String> columnChoices = new HashMap<>();
        columnChoices.put("core competency", "Skill");
        columnChoices.put("employer", "Employer");
        columnChoices.put("location", "Location");
        columnChoices.put("position type", "Position Type");
        columnChoices.put("all", "All");

        // Top-level menu options
        HashMap<String, String> actionChoices = new HashMap<>();
        actionChoices.put("search", "Search");
        actionChoices.put("list", "List");

        System.out.println("Welcome to LaunchCode's TechJobs App!");

        // Allow the user to search until they manually quit
        while (true) {

            String actionChoice = getUserSelection("View jobs by:", actionChoices);

            if (actionChoice.equals("list")) {

                String columnChoice = getUserSelection("List", columnChoices);

                if (columnChoice.equals("all")) {
                    printJobs(JobData.findAll());
                } else {

                    ArrayList<String> results = JobData.findAll(columnChoice);

                    System.out.println("\n*** All " + columnChoices.get(columnChoice) + " Values ***");

                    // Print list of skills, employers, etc
                    for (String item : results) {
                        System.out.println(item);
                    }
                }

            } else { // choice is "search"

                // How does the user want to search (e.g. by skill or employer)
                String searchField = getUserSelection("Search by:", columnChoices);

                // What is their search term?
                System.out.println("\nSearch term: ");
                String searchTerm = in.nextLine();

                if (searchField.equals("all")) {
                    System.out.println("Search all fields not yet implemented.");
                } else {
                    printJobs(JobData.findByColumnAndValue(searchField, searchTerm));
                }
            }
        }
    }

    // ﻿Returns the key of the selected item from the choices Dictionary
    private static String getUserSelection(String menuHeader, HashMap<String, String> choices) {

        Integer choiceIdx;
        Boolean validChoice = false;
        String[] choiceKeys = new String[choices.size()];

        // Put the choices in an ordered structure so we can
        // associate an integer with each one
        Integer i = 0;
        for (String choiceKey : choices.keySet()) {
            choiceKeys[i] = choiceKey;
            i++;
        }

        do {

            System.out.println("\n" + menuHeader);

            // Print available choices
            for (Integer j = 0; j < choiceKeys.length; j++) {
                System.out.println("" + j + " - " + choices.get(choiceKeys[j]));
            }

            choiceIdx = in.nextInt();
            in.nextLine();

            // Validate user's input
            if (choiceIdx < 0 || choiceIdx >= choiceKeys.length) {
                System.out.println("Invalid choice. Try again.");
            } else {
                validChoice = true;
            }

        } while (!validChoice);

        return choiceKeys[choiceIdx];
    }

    // Print a list of jobs
    private static void printJobs(ArrayList<HashMap<String, String>> someJobs) {

        for (HashMap<String, String> job : someJobs) {

            for (Map.Entry<String, String> entry : job.entrySet()) {
                System.out.println(  (entry.getKey() + ": " + entry.getValue()) );

                String searchJob = in.nextLine();
                System.out.println(searchJob);

                if(searchJob.equals(entry.getValue())){
                        System.out.println("it works");
                    }else {
                       System.out.println("None found, try another search");
                   }
            }

        }
    }
}


            //         System.out.println("****\n" + job.entrySet() + ": " + "****");
 //           System.out.println("****\n" + job.values() + ": " + "****");
//            System.out.println("*****");
//            System.out.println( "Core Competency: " + job.get("core competency"));
//            System.out.println( "Employer: " + job.get("employer" ));
//            System.out.println( "Location: " + job.get("location" ));
//            System.out.println( "Position Type: " + job.get("position type"));
//            System.out.println("*****");


           // for (Map.Entry<String, String> entry : job.entrySet()) {

//                         ArrayList<HashMap<String, String>> job = someJobs;
//
//                          for (int i = 0; i < job.size(); i++) { //with line 115 this prints out an array
//
//                              System.out.print(job.get(i));
                //               System.out.println("****\n"+job.entrySet()+"\n****");
               // String jobField = getUserSelection("Search by:", columnChoices);
  //              if (entry.getValue()) {
                                  //System.out.println("****\n" + entry + "\n****");
                   // System.out.println(  (entry.getKey() + ": " + entry.getValue()) );
//
 //                  } else {
//                        System.out.println("None found, try another search");
//                    }
//                }
                    //System.out.println("printJobs is not implemented yet");

//                }
//
//            }
//        }
//    }
//}


//(!entry.getValue().equals(entry))
//(searchJob.equals(entry.getValue()))