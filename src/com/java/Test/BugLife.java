package com.java.Test;

import java.util.*;

/**
 * Created by BHUVKUMA on 05-May-15.
 */
public class BugLife {
    int[] color;
    ArrayList<Integer> [] graph;
    public static void main(String[] args){
        BugLife bugLife = new BugLife();
        Scanner scanner = new Scanner(System.in);

        int no_of_bugs, no_of_relationships, n1, n2;


        int no_of_test_case = scanner.nextInt();

        while(no_of_test_case-- > 0){


            no_of_bugs = scanner.nextInt();
            no_of_relationships = scanner.nextInt();

            bugLife.graph = new ArrayList[no_of_bugs+1];
            //ArrayList<LinkedList<Integer>> graph = new ArrayList<LinkedList<Integer>>();
            bugLife.color = new int[no_of_bugs+1];

            for (int i = 1; i < no_of_bugs+1; i++) {
                bugLife.graph[i] = new ArrayList<Integer>();
            }



            while (no_of_relationships-- > 0){
                n1 = scanner.nextInt();
                n2 = scanner.nextInt();

                bugLife.graph[n1].add(n2);
                bugLife.graph[n2].add(n1);

            }
            System.out.println("Scenario");

            boolean ok = true;

            for (int i = 1; i < no_of_bugs+1; i++) {
                if(bugLife.color[i] == 0 && !bugLife.clr(i, 1)){
                    ok = false;
                    break;
                }
            }
            if(ok){
                System.out.println("Ok");
            }
            else{
                System.out.println("Not Ok");
            }


        }
    }

    public boolean clr(int node, int c){
        if(this.color[node] != 0) return color[node] == c;
        int nc = (c ==1 ? 2: 1);
        color[node] = c;
        for(int p : graph[node]){
            if(!clr(node, nc)){
                return false;
            }
        }
        return true;
    }



}
