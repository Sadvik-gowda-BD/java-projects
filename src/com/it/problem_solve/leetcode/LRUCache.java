package com.it.problem_solve.leetcode;

import com.it.dsa.datastrucuture.stack.Node;

import java.util.HashMap;

class LRUCache {

    int capacity;
    HashMap<Integer, LRUNode> map;

    LRUNode head;
    LRUNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        head = new LRUNode(-1, -1);
        tail = new LRUNode(-1, -1);
        head.next = tail;
        tail.pre = head;
    }

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(3);

        cache.put(1, 11);
        cache.put(2, 22);
        cache.put(3, 33);
        cache.put(4, 44);
        cache.print();

        System.out.println("\n" + cache.map);
        System.out.println(cache.get(22));
        System.out.println();
        cache.print();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            LRUNode node = map.get(key);
            remove(node);
            addToHead(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            LRUNode node = map.get(key);
            node.val = value;
            remove(node);
            addToHead(node);
        } else {
            if (map.size() >= capacity) {
                LRUNode tailNode = tail.pre;
                remove(tailNode);
                map.remove(tailNode.key);
            }
            LRUNode node = new LRUNode(key, value);
            addToHead(node);
            map.put(key, node);
        }

    }

    private void addToHead(LRUNode node) {

        LRUNode currHead = head.next;

        if (currHead == node) {
            return;
        }

        head.next = node;
        node.pre = head;
        node.next = currHead;
        currHead.pre = node;
    }

    private void remove(LRUNode node) {

        LRUNode preNode = node.pre;
        LRUNode nextNode = node.next;

        preNode.next = nextNode;
        nextNode.pre = preNode;
    }

    private void print() {

        LRUNode node = head;

        while (node != null) {
            System.out.print(node.val + "-->");
            node = node.next;
        }

    }

    class LRUNode {

        int key;
        int val;
        LRUNode next;
        LRUNode pre;

        public LRUNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

}

