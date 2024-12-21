package hse.homework.elevator;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.TreeSet;

public class QueueGenerator extends Thread{
    static final Logger Logger = LogManager.getLogger(QueueGenerator.class.getName());

    private static int minFloor = 1;
    private int maxFloor;
    private int batchSize;
    private int delay;
    private GreedyElevatorQueue greedyElevatorQueue;

    public QueueGenerator(int maxFloor, int batchSize, int delay, GreedyElevatorQueue greedyElevatorQueue) {
        this.maxFloor = maxFloor;
        this.batchSize = batchSize;
        this.delay = delay;
        this.greedyElevatorQueue = greedyElevatorQueue;
    }

    public Integer getRandomFloor() {
        return (int) ((Math.random() * (maxFloor - minFloor)) + minFloor);
    }

    public void run() {
        while (true) {
            TreeSet<Integer> result = new TreeSet<>();

            while (result.size() < batchSize) {
                result.add(getRandomFloor());
            }

            greedyElevatorQueue.add(result);
            result.clear();

            try {
                Thread.sleep(1000 * delay);
            } catch (InterruptedException e) {
                Logger.error("Someone has broken the buttion! Call police!");
            }
        }
    }
}
