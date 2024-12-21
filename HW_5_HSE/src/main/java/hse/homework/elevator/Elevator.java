package hse.homework.elevator;

import java.util.TreeSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Elevator extends Thread {
    static final Logger Logger = LogManager.getLogger(Elevator.class.getName());

    private GreedyElevatorQueue greedyElevatorQueue;
    private Integer currentFloor;
    private Integer targetFloor;
    private TreeSet<Integer> elevatorLocalQueue;
    private boolean hasArrived = false;

    public Elevator(GreedyElevatorQueue greedyElevatorQueue, Integer currentFloor) {
        this.greedyElevatorQueue = greedyElevatorQueue;
        this.currentFloor = currentFloor;
        this.targetFloor = currentFloor;
        this.elevatorLocalQueue = new TreeSet<>();

    }

    public void run() {
        while (true) {
            updateLocalQueue();
            setTargetFloor();
            move();
            checkTargetFloor();
        }
    }

    private void move() {
        if (currentFloor < targetFloor) {
            ++currentFloor;
            Logger.info(getElevatorName() + " Moving up to floor: " + currentFloor);

        } else if (currentFloor > targetFloor) {
            --currentFloor;
            Logger.info(getElevatorName() + " Moving down to floor: " + currentFloor);
        }


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Logger.warn(getElevatorName() + " has broken. Please call emergency!");
        }

    }

    private void setTargetFloor() {

        if (!elevatorLocalQueue.isEmpty()) {
            if (targetFloor != elevatorLocalQueue.first()) {
                targetFloor = elevatorLocalQueue.first();
                hasArrived = false;
                Logger.info("\n" + getElevatorName() + " local queue: " + elevatorLocalQueue + "\n");
            }
        }
    }

    private void checkTargetFloor() {

        if (currentFloor == targetFloor && !hasArrived) {
            Logger.info(getElevatorName() + " Arrived to floor: " + targetFloor);
            hasArrived = true;
            elevatorLocalQueue.remove(currentFloor);
            Logger.info("\n" + getElevatorName() + " local queue: " + elevatorLocalQueue + "\n");
        }

    }

    private void updateLocalQueue() {
        Integer result;
        Integer maxFloor;

        if (!elevatorLocalQueue.isEmpty()) {
            maxFloor = elevatorLocalQueue.last();
        } else {
            maxFloor = currentFloor;
        }

        result = greedyElevatorQueue.get(currentFloor, maxFloor);

        if (result != null) {
            elevatorLocalQueue.add(result);
            Logger.info("\n" + getElevatorName() + " local queue: " + elevatorLocalQueue + "\n");
        }
    }


    private String getElevatorName() {
        return "[Elevator " + Thread.currentThread().getId() + "]";
    }


}
