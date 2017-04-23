package com.java.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BasicGraph {
    private Integer                     v;
    private Map<Integer, List<Integer>> adj;
    private Integer                     height;
    private Integer                     result;


    public static void main(String[] args) {
        //Integer v = scanner.nextInt();
        Integer v = 4;

        //Construct graph
        BasicGraph basicGraph = new BasicGraph(v);

        //Add adj
        basicGraph.addEdge(2,3);
        basicGraph.addEdge(3,4);
        basicGraph.addEdge(3,5);

        //Integer height = scanner.nextInt();
        Integer height = 2;
        basicGraph.setHeight(height);

        // DFS on all nodes
        basicGraph.firstSolution();

        //DFS on leaves
        basicGraph.secondSolution();
    }

    public void firstSolution(){
        for (Map.Entry<Integer, List<Integer>> entry: adj.entrySet()) {
            DFS(entry.getKey());
        }
        System.out.println("First Answer is : " + result);
    }

    public void secondSolution(){
        Set<Integer> results = new HashSet<>();
        adj.forEach((k,v) -> results.add(k));

        for (Integer leaf : findLeaves()){
            results.retainAll(DFS(leaf));
        }
        System.out.println("Second Answer is : " + results.size() + " " + results);
    }

    public Set<Integer> findLeaves(){
        Set<Integer> leaves = new HashSet<>();
        for (Map.Entry<Integer, List<Integer>> entry: adj.entrySet()) {
            if(entry.getValue() != null && entry.getValue().size() == 1){
                leaves.add(entry.getKey());
            }
        }
        return leaves;
    }

    public Set<Integer> DFS(Integer node){
        Map<Integer, Boolean> visited = new HashMap<>();
        Set<Integer> possibleNodes = new HashSet<>();
        possibleNodes.add(node);
        Integer distance = 0;
        DFSInternal(node, visited, distance, possibleNodes);
        return possibleNodes;
    }

    public void DFSInternal(Integer node, Map<Integer, Boolean> visited, Integer distance, Set<Integer> possibleNodes){
        visited.put(node, true);
        distance++;
        for (Integer element : adj.get(node)){
            if(visited.get(element) == null || !visited.get(element)){
                if(distance <= height) {
                    possibleNodes.add(element);
                    DFSInternal(element, visited, distance, possibleNodes);
                } else {
                    result--;
                    return;
                }
            }
        }
    }

    public BasicGraph(Integer v) {
        this.v = v;
        result = v;
        adj = new HashMap<>();
    }

    public void addEdge(Integer source, Integer destination){
        adj.computeIfAbsent(source, k -> new LinkedList<>()).add(destination);
        adj.computeIfAbsent(destination, k -> new LinkedList<>()).add(source);
    }

    /*public Set<Integer> BFS(Integer node, Integer distance){
        List<Integer> queue = new LinkedList<>();
        queue.addAll(adj.get(node));
        Set<Integer> possibleNodes = new HashSet<>();
        while (queue.size() > 0 && distance <= height){
            BFSInternal(distance, queue, possibleNodes);
            distance++;
        }
        return possibleNodes;
    }

    public void BFSInternal(Integer distance, List<Integer> queue, Set<Integer> possibleNodes){
        Integer element = queue.remove(0);
        possibleNodes.add(element);
        queue.addAll(adj.get(element));
    }*/

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}
