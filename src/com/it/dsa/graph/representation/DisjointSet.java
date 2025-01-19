package com.it.dsa.graph.representation;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {

    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n) {
        //taken n+1 size, so it works for both 0 and 1 based index
        for (int i = 0; i <= n; i++) {
            parent.add(i); //initially parent by itself
            rank.add(0); //initially height will be 0
            size.add(1); //initially each node size is 1 (itself node)
        }
    }

    public int findParent(int node) {
        if (parent.get(node) == node) {
            return node;
        }

        int ultiParent = findParent(parent.get(node));
        parent.set(node, ultiParent);
        return parent.get(node);
    }

    public void unionBySize(int u, int v) {

        int parentU = findParent(u);
        int parentV = findParent(v);

        if (parentU == parentV) {
            //do nothing, we can say cycle detected
            return;
        }

        if (size.get(parentU) < size.get(parentV)) {
            //attach parentU to parentV and increase the size of parentV
            parent.set(parentU, parentV);
            size.set(parentV, size.get(parentU) + size.get(parentV));
        } else {
            parent.set(parentV, parentU);
            size.set(parentU, size.get(parentU) + size.get(parentV));
        }
    }

    public boolean isUVSameComponent(int u, int v) {
        return findParent(u) == findParent(v);
    }

    public void unionByRank(int u, int v) {

        int parentU = findParent(u);
        int parentV = findParent(v);

        if (parentU == parentV) {
            //do nothing, we can say cycle detected
            return;
        }

        //attach smaller graph to larger, so maximum nodes takes less time while finding parent
        if (rank.get(parentU) < rank.get(parentV)) {
            //parentV is bigger size so attach U to V, and parentV will be the parent for U;
            parent.set(parentU, parentV);
        } else if (rank.get(parentV) < rank.get(parentU)) {
            parent.set(parentV, parentU);
        } else {
            //We can attach any one  to any the increase the rank
            parent.set(parentV, parentU);
            Integer rankU = rank.get(parentU);
            rank.set(parentU, rankU + 1);
        }
    }
}


class Main {
    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);
        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);

        // if 3 and 7 same or not
        if (ds.findParent(3) == ds.findParent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");

        ds.unionByRank(3, 7);
        if (ds.findParent(3) == ds.findParent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");
    }
}
