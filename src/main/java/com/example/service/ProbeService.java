package com.example.service;

import com.example.model.Command;
import com.example.model.Probe;
import org.springframework.stereotype.Service;

@Service
public class ProbeService {

    private Probe probe = new Probe(0, 0, "NORTH");

    public String processCommand(Command command) {
        switch (command.getAction()) {
            case "MOVE":
                moveProbe(command.getDirection());
                break;
            case "TURN":
                turnProbe(command.getDirection());
                break;
            default:
                return "Invalid Command";
        }
        return String.format("Probe moved to: %d, %d facing %s", probe.getX(), probe.getY(), probe.getDirection());
    }

    public Probe getProbeStatus() {
        return probe;
    }

    private void moveProbe(String direction) {
        switch (direction) {
            case "FORWARD":
                move(1);
                break;
            case "BACKWARD":
                move(-1);
                break;
            default:
                break;
        }
    }

    private void move(int step) {
        switch (probe.getDirection()) {
            case "NORTH":
                probe.setY(probe.getY() + step);
                break;
            case "SOUTH":
                probe.setY(probe.getY() - step);
                break;
            case "EAST":
                probe.setX(probe.getX() + step);
                break;
            case "WEST":
                probe.setX(probe.getX() - step);
                break;
            default:
                break;
        }
    }

    private void turnProbe(String direction) {
        String newDirection = null;
        switch (probe.getDirection()) {
            case "NORTH":
                newDirection = (direction.equals("LEFT")) ? "WEST" : "EAST";
                break;
            case "EAST":
                newDirection = (direction.equals("LEFT")) ? "NORTH" : "SOUTH";
                break;
            case "SOUTH":
                newDirection = (direction.equals("LEFT")) ? "EAST" : "WEST";
                break;
            case "WEST":
                newDirection = (direction.equals("LEFT")) ? "SOUTH" : "NORTH";
                break;
            default:
                break;
        }

        if (newDirection != null) {
            probe.setDirection(newDirection);
        }
    }
}