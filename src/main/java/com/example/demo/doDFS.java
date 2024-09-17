package com.example.demo;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

class doDFS implements Callable<DFSResult> {
    private final TreeNode root;
    private final int treeId;

    public doDFS(TreeNode root, int treeId) {
        this.root = root;
        this.treeId = treeId;
    }

    @Override
    public DFSResult call() {
        // Get the current thread's name
        String threadName = Thread.currentThread().getName();
        System.out.println("Tree " + treeId + " DFS started by thread: " + threadName);

        List<Integer> postOrder = new ArrayList<>();
        List<SimpleEntry<Integer, Integer>> edgeList = new ArrayList<>();
        dfs(root, postOrder, edgeList);

        return new DFSResult(postOrder, edgeList);
    }

    private void dfs(TreeNode node, List<Integer> postOrder, List<SimpleEntry<Integer, Integer>> edgeList) {
        if (node == null) return;

        for (TreeNode child : node.children) {
            SimpleEntry<Integer, Integer> edge = new SimpleEntry<>(node.value, child.value);
            edgeList.add(edge);

            dfs(child, postOrder, edgeList);
        }
        postOrder.add(node.value);
    }
}
