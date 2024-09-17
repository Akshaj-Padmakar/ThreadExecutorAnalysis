package com.example.demo;

import java.util.List;
import java.util.AbstractMap.SimpleEntry;

public class DFSResult {
    private final List<Integer> postOrder;
    private final List<SimpleEntry<Integer, Integer>> edgeList;

    public DFSResult(List<Integer> postOrder, List<SimpleEntry<Integer, Integer>> edgeList) {
        this.postOrder = postOrder;
        this.edgeList = edgeList;
    }

    public List<Integer> getpostOrder() {
        return postOrder;
    }

    public List<SimpleEntry<Integer, Integer>> getEdgeList() {
        return edgeList;
    }

    @Override
    public String toString() {
        return "Post-order: " + postOrder + ", Edges: " + edgeList;
    }
}
