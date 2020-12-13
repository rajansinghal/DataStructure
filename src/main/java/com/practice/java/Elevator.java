package com.practice.java;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


//https://www.javastructures.com/design/elevator
public class Elevator {

    private int location = 0;
    private Direction direction = Direction.UP;
    private State state = State.IDLE;
    private Door door = Door.CLOSED;
    private boolean reprocessing = false;

    public Comparator<Request> upComparator = new Comparator<Request>() {
        public int compare(Request u1, Request u2) {
            return u1.floor.compareTo(u2.floor);
        }
    };

    public Comparator<Request> downComparator = upComparator.reversed();

    private Queue<Request> upQueue = new PriorityQueue<>(upComparator);
    private Queue<Request> currentQueue = upQueue;
    private Queue<Request> downQueue = new PriorityQueue<>(downComparator);
    private JobQueue currentJobQueue = new JobQueue(currentQueue);
    private Request currentRequest;

    public void addJob(Request rq) {
        if (state == State.IDLE) {
            System.out.println("Added current queue job -- lift state is - " + state + " location is - " + location
                    + " to move to floor - " + rq.floor);
            state = State.MOVING;
            currentJobQueue.addWithOutListener(rq);
        } else {
            if (rq.floor >= location && direction == Direction.UP) {
                System.out.println("Added current queue job -- lift state is - " + state + "location is - " + location
                        + " to move to floor - " + rq.floor);
                currentJobQueue.addWithListener(rq);
            } else if (rq.floor < location && direction == Direction.UP) {
                upQueue.add(rq);
                System.out.println("Added upqueue job -- lift state is - " + state + "location is - " + location
                        + " to move to floor - " + rq.floor);
                System.out.println("request added to upqueue");
            }
            if (rq.floor <= location && direction == Direction.DOWN) {
                System.out.println("Added current queue job -- lift state is - " + state + "location is - " + location
                        + " to move to floor - " + rq.floor);
                currentJobQueue.addWithListener(rq);
            } else if (rq.floor > location && direction == Direction.DOWN) {
                downQueue.add(rq);
                System.out.println("Added downQueue job -- lift state is - " + state + "location is - " + location
                        + " to move to floor - " + rq.floor);
                System.out.println("request added to downqueue");
            }
        }

    }

    public void processLiftJob() {
        while (true) {
            if (reprocessing) {
                // New request added in queue. add old request again and restart
                // process job
                reprocessing = false;
                currentJobQueue.addWithOutListener(currentRequest);

            }
            if (!currentJobQueue.isEmpty()) {
                currentRequest = (Request) currentJobQueue.poll();
                if (currentRequest != null) {
                    if (currentRequest.floor > location) {
                        this.direction = Direction.UP;
                    } else {
                        this.direction = Direction.DOWN;
                    }
                    System.out.println("Current Queue job--The Lift is starting to move - " + this.direction
                            + " from floor -" + location + " to floor - " + currentRequest.floor);
                    //goToFloor(currentRequest);
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            } else if (!upQueue.isEmpty() || !downQueue.isEmpty()) {
                getNextQueueJobs();
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                this.state = State.IDLE;
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private void getNextQueueJobs() {
        System.out.println("TAKING NEW JOBS FROM UP OR DOWN QUEUE");
        if (!upQueue.isEmpty() && !downQueue.isEmpty()) {
            if (getLowestTimeUpQueue() > getLowestTimeDownQueue()) {
                this.direction = Direction.UP;
                currentJobQueue = new JobQueue(upQueue);
                upQueue = new PriorityQueue<>(upComparator);
            } else {
                this.direction = Direction.DOWN;
                currentJobQueue = new JobQueue(downQueue);
                // currentQueue = downQueue;
                downQueue = new PriorityQueue<>(downComparator);
            }
        } else if (!upQueue.isEmpty()) {
            this.direction = Direction.UP;
            currentJobQueue = new JobQueue(upQueue);
        } else {
            this.direction = Direction.DOWN;
            currentJobQueue = new JobQueue(downQueue);
        }
    }

    private long getLowestTimeUpQueue() {
        long lowest = Long.MAX_VALUE;
        for (Request r : upQueue) {
            if (r.time < lowest)
                lowest = r.time;
        }
        return lowest;
    }

    private long getLowestTimeDownQueue() {
        long lowest = Long.MAX_VALUE;
        for (Request r : downQueue) {
            if (r.time < lowest)
                lowest = r.time;
        }
        return lowest;
    }

    public static void main(String[] args) {

        Elevator elevator = new Elevator();
        ProcessJobWorker processJobWorker = new ProcessJobWorker(elevator);
        Thread t2 = new Thread(processJobWorker);
        t2.start();

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Request requestToBeMadeFromInsideLift1 = new Request(5);
        Request requestMadeFromFloor1 = new Request(System.currentTimeMillis(), 1, Direction.UP,requestToBeMadeFromInsideLift1);
        new Thread(new AddJobWorker(elevator, requestMadeFromFloor1)).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Request requestToBeMadeFromInsideLift2 = new Request(4);
        Request requestMadeFromFloor2 = new Request(System.currentTimeMillis(), 3, Direction.UP,requestToBeMadeFromInsideLift2);
        new Thread(new AddJobWorker(elevator, requestMadeFromFloor2)).start();

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Request requestToBeMadeFromInsideLift3 = new Request(1);
        Request requestMadeFromFloor3 = new Request(System.currentTimeMillis(), 4, Direction.DOWN,requestToBeMadeFromInsideLift3);
        new Thread(new AddJobWorker(elevator, requestMadeFromFloor3)).start();

        /*
         * new Thread(new AddJobWorker(elevator,new
         * Request(System.currentTimeMillis(), 3 ))).start();
         *
         * try { Thread.sleep(200); } catch (InterruptedException e) { // TODO
         * Auto-generated catch block e.printStackTrace(); }
         *
         * new Thread(new AddJobWorker(elevator,new
         * Request(System.currentTimeMillis(), 1 ))).start();
         */

    }

}

enum Door {

    OPEN, CLOSED

}

enum Direction {

    UP, DOWN

}
 class JobQueue extends PriorityQueue {
    private Queue<Request> jobQueue;

    public JobQueue(Queue<Request> jobQueue) {
        this.jobQueue = jobQueue;
    }

    public  void addWithOutListener(Request rq){
        jobQueue.add(rq);
    }

    public void addWithListener(Request rq){
        jobQueue.add(rq);
    }


}


class AddJobWorker implements Runnable {

    private Elevator elevator;
    private Request request;

    AddJobWorker(Elevator elevator, Request request) {
        this.elevator = elevator;
        this.request = request;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        elevator.addJob(request);
    }

}

class ProcessJobWorker implements Runnable {

    private Elevator elevator;

    ProcessJobWorker(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void run() {
        elevator.processLiftJob();

    }

}

class Request {
    public Long time;
    public Integer floor;
    private Direction direction;
    private Request request;

    public Request(Integer floor) {
        this.time = null;
        this.floor = floor;
        this.direction = null;
        this.request = null;
    }

    public Request(long time, Integer floor, Direction direction, Request request) {
        this.time = time;
        this.floor = floor;
        this.direction = direction;
        this.request = request;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

}

enum State {

    MOVING, STOPPED, IDLE

}