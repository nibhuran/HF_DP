package com.java.Test;

import java.util.Scanner;

public class Oz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        Integer[] graph = new Integer[m+1];
        for (int i = 1; i <= m; i++) {
            int des = scanner.nextInt();
            if(des != 0) {
                graph[i] = des;
            }
        }
        int k = scanner.nextInt();
        for (int i = 0; i < k; i++) {
            int query = scanner.nextInt();
            int node = scanner.nextInt();
            if(query == 1){
                boolean[] visited = new boolean[m + 1];
                int source = node;
                while(true){
                    if(graph[source] == null || graph[source] == 0){
                        System.out.println(source);
                        break;
                    } else if(visited[source]){
                        System.out.println("LOOP");
                        break;
                    } else if(graph[source] != 0 && !visited[source]){
                        visited[source] = true;
                        source = graph[source];
                        continue;
                    }
                }
            } else {
                graph[node] = 0;
            }
        }
    }
}
