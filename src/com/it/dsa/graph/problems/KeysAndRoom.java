package com.it.dsa.graph.problems;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//841. Keys and Rooms
public class KeysAndRoom {

    public static void main(String[] args) {

    }

    public boolean solve(List<List<Integer>> rooms) {

        int V = rooms.size();
        boolean[] vis = new boolean[V];

        vis[0] = true;

        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while (!q.isEmpty()){

            int node = q.poll();

            for (int neighNode: rooms.get(node)){

                if(!vis[neighNode]){
                    vis[neighNode] = true;
                    q.add(neighNode);
                }
            }
        }

        for(boolean bool: vis){
            if(!bool){
                return false;
            }

        }
        return true;
    }
}
