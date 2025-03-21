# Submersible Probe Control API

This project implements a REST API for controlling a submersible probe used to explore the bottom of the sea. The probe is controlled via a set of commands, and it moves within a grid representing the ocean floor. The API allows the probe to move, turn, stay within grid boundaries, avoid obstacles, and print a summary of visited coordinates.

## Introduction

This API simulates the movement of a remotely controlled submersible probe on the ocean floor. The probe starts at a predefined position and direction. You can issue commands to move the probe forward and backward, turn it left or right, and keep track of the grid coordinates it has visited.

## Requirements

- **Grid Representation:** The ocean floor is represented by a grid with coordinates (x, y).
- **Initial Position:** The probe starts at position (0, 0) facing NORTH.
- **Movement:** The probe can move forward and backward based on its current facing direction.
- **Turning:** The probe can turn left or right 90 degrees.
- **Grid Boundaries:** The probe must stay within the grid boundaries.
- **Visited Coordinates:** The probe will track all the coordinates it visits.
- **Obstacle Handling:** The probe avoids obstacles, though this basic version does not implement obstacles directly (this could be added as a future feature).
