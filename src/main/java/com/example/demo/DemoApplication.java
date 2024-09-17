package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) throws Exception {
        List<TreeNode> trees = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            trees.add(TreeGen.generateTree(10));
        }

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(20);

        List<Future<DFSResult>> futures = new ArrayList<>();

        for (int i = 0; i < trees.size(); i++) {
            doDFS task = new doDFS(trees.get(i), i);

            Future<DFSResult> future = executorService.schedule(task, 0, TimeUnit.SECONDS);

            futures.add(future);
        }
        Thread.sleep(1000);
        for (Future<DFSResult> future : futures) {
            DFSResult result = future.get();
            System.out.println("Result: " + result);
        }

        executorService.shutdown();
    }
}
