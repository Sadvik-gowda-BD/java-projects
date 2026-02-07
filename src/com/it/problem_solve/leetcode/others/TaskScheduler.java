package com.it.problem_solve.leetcode.others;

import com.it.problem_solve.leetcode.lc150.HappyNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

//621. Task Scheduler
public class TaskScheduler {

    public static void main(String[] args) {

        char[] task = {'A', 'A', 'A', 'B', 'B', 'B'};

        solve(task, 3);
        System.out.println("-------------------------");
        solve2(task, 3);
    }

    public static int solve(char[] tasks, int n) {

        Map<Character, Integer> taskMap = new HashMap<>();
        for (char ch : tasks) {
            taskMap.put(ch, taskMap.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<TaskNode> pq = new PriorityQueue<>((o1, o2) -> o2.count - o1.count);

        for (Map.Entry<Character, Integer> es : taskMap.entrySet()) {
            pq.add(new TaskNode(es.getKey(), es.getValue(), 0));
        }

        int time = 0;
        Queue<TaskNode> parkedTask = new LinkedList<>();
        List<Character> res = new LinkedList<>();

        while (!pq.isEmpty() || !parkedTask.isEmpty()) {

            if (!parkedTask.isEmpty() && parkedTask.peek().nextSlot <= time) {
                pq.add(parkedTask.poll());
            }

            if (pq.isEmpty()) {
                res.add('#');
            } else {
                TaskNode task = pq.poll();
                res.add(task.ch);
                task.count--;
                if (task.count > 0) {
                    task.nextSlot = time + n + 1;
                    parkedTask.add(task);
                }
            }
            time++;
        }

        System.out.println(res);
        System.out.println(time);

        return time;
    }


    public static void solve2(char[] task, int n) {

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : task) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        Comparator<TaskNode> comp = (o1, o2) -> {
            if (o1.count == o2.count) {
                return o1.nextSlot - o2.nextSlot;
            }
            return o2.count - o1.count;
        };
        Queue<TaskNode> pq = new PriorityQueue<>(comp);

        for (Map.Entry<Character, Integer> es : map.entrySet()) {
            TaskNode tn = new TaskNode(es.getKey(), es.getValue(), 0);
            pq.add(tn);
        }

        List<Character> res = new ArrayList<>();

        while (!pq.isEmpty()) {
            List<TaskNode> ls = new ArrayList<>();
            int ind = res.size();
            boolean hasAdded = false;
            while (!pq.isEmpty()) {
                TaskNode node = pq.poll();
                if (node.nextSlot <= ind) {
                    res.add(node.ch);
                    hasAdded = true;
                    if (node.count > 1) {
                        node.count = node.count - 1;
                        node.nextSlot = node.nextSlot + n + 1;
                        ls.add(node);
                    }
                    break;
                }
                ls.add(node);
            }
            if (!hasAdded) {
                res.add('#');
            }
            pq.addAll(ls);
        }
        System.out.println(res.size());
        System.out.println(res);
    }

    static class TaskNode {
        public char ch;
        public int count;
        public int nextSlot;

        public TaskNode(char ch, int count, int nextSLot) {
            this.ch = ch;
            this.count = count;
            this.nextSlot = nextSLot;
        }
    }

}


