package hse.homework.elevator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.TreeSet;

public class GreedyElevatorQueue {
    static final Logger Logger = LogManager.getLogger(GreedyElevatorQueue.class.getName());

    private TreeSet<Integer> globalElevatorQueue;

    public GreedyElevatorQueue() {
        this.globalElevatorQueue = new TreeSet<>();
    }

    public Integer get(Integer minFloor, Integer maxFloor) {
        Integer result = null;
        synchronized (globalElevatorQueue) {
            if (!globalElevatorQueue.isEmpty()) {
                Integer getPassingFloor = getPassingFloor(minFloor, maxFloor);
                // Пытаемся найти попутный этаж, иначе едем куда ближе.
                if (getPassingFloor != null) {
                    result = getPassingFloor;
                } else {
                    result = getNearestFloor(minFloor, maxFloor);
                }
            }

            if (result != null) {
                Logger.info("\n[GreedyElevatorQueue] Floor: " + result + " taken by elevator");
                globalElevatorQueue.remove(result);
                Logger.info("[GreedyElevatorQueue] globalQueue: " + globalElevatorQueue + "\n");
            }

            return result;
        }
    }

    public void add(TreeSet<Integer> additionalQueue) {
        synchronized (globalElevatorQueue) {
            if (!additionalQueue.isEmpty()) {
                this.globalElevatorQueue.addAll(additionalQueue);
                Logger.info("\n [GreedyElevatorQueue] globalQueue updated: " + globalElevatorQueue + "\n");
            }
        }
    }

    private Integer getPassingFloor(Integer minFloor, Integer maxFloor) {
        Integer result = null;

        // Если нам по пути, то выбираем ближайший попутный этаж из очереди вызовов
        if (minFloor <= globalElevatorQueue.last() || maxFloor >= globalElevatorQueue.first()) {
            for (Integer floor : globalElevatorQueue) {
                if (floor >= minFloor && floor <= maxFloor) {
                    // Ура, нашли попутный этаж!
                    result = floor;
                    break;
                }
            }
        }

        return result;
    }

    private Integer getNearestFloor(Integer minFloor, Integer maxFloor) {
        int downFloors = Math.abs(minFloor - globalElevatorQueue.first());
        int upFloors = Math.abs(maxFloor - globalElevatorQueue.last());
        Integer result = null;

        // Ищем, куда ехать ближе.
        if (downFloors > upFloors) {
            // Едем наверх, ищем ближайщий этаж вверху
            for (Integer floor : globalElevatorQueue) {
                if (floor > maxFloor) {
                    // Ура, нашли попутный этаж!
                    result = floor;
                    break;
                }
            }
        } else {
            // Едем вниз, ищем ближайший этаж внизу
            for (Integer floor : globalElevatorQueue) {
                if (floor < minFloor) {
                    result = floor;
                }
                else {
                    // Ура, нашли попутный этаж!
                    break;
                }
            }
        }
        // Если ближайшие этажи не найдены - берем крайний
        if (result == null) {
            if (downFloors > upFloors) {
                result = globalElevatorQueue.last();
            }
            else {
                result = globalElevatorQueue.first();
            }

        }
        return result;
    }
}
