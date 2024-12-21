package hse.homework;

import hse.homework.elevator.Elevator;
import hse.homework.elevator.GreedyElevatorQueue;
import hse.homework.elevator.QueueGenerator;

public class Main {
    public static void main(String args[]) {

        GreedyElevatorQueue greedyElevatorQueue = new GreedyElevatorQueue();
        QueueGenerator queueGenerator = new QueueGenerator(25, 10, 30, greedyElevatorQueue);

        Elevator elevator1 = new Elevator(greedyElevatorQueue, 12);
        Elevator elevator2 = new Elevator(greedyElevatorQueue, 5);
        Elevator elevator3 = new Elevator(greedyElevatorQueue, 20);

        elevator1.start();
        elevator2.start();
        elevator3.start();
        queueGenerator.start();


    }
}
