package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Component
public class TreeGen {
    public static TreeNode generateTree(int nodeCount) {
        if (nodeCount <= 0) {
            throw new IllegalArgumentException("Node count must be greater than 0");
        }

        TreeNode root = new TreeNode(1);
        List<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(root);

        Random random = new Random();

        for (int i = 2; i <= nodeCount; i++) {
            TreeNode newNode = new TreeNode(i);
            TreeNode randomParent = nodeList.get(random.nextInt(nodeList.size()));

            randomParent.addChild(newNode);
            nodeList.add(newNode);
        }

        return root;
    }
}
