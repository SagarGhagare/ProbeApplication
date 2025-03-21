# Submersible Probe Control API

This project implements a REST API for controlling a submersible probe used to explore the bottom of the sea. The probe is controlled via a set of commands, and it moves within a grid representing the ocean floor. The API allows the probe to move, turn, stay within grid boundaries, avoid obstacles, and print a summary of visited coordinates.

## Table of Contents
1. [Introduction](#introduction)
2. [Requirements](#requirements)
3. [API Endpoints](#api-endpoints)
4. [Setup](#setup)
5. [Usage](#usage)
6. [Example Commands](#example-commands)
7. [License](#license)

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

## API Endpoints

### `POST /probe/command`

This endpoint receives a list of commands to control the probe.

**Request Body:**
```json
[
  {"action": "MOVE", "direction": "FORWARD"},
  {"action": "TURN", "direction": "RIGHT"},
  {"action": "MOVE", "direction": "FORWARD"}
]

Response:
json
{
  "message": "Probe processed all commands."
}

GET /probe/status
This endpoint retrieves the current status of the probe, including the current position and all visited coordinates.

Response:

json
{
  "status": "Current Position: 1, 1, facing EAST, Visited Coordinates: 0,0, 1,1"
}

Setup

Prerequisites
Java 17 or higher
Maven 3.8 or higher

Steps to Run
Clone the repository:

bash
git clone https://github.com/your-repository/probe-control-api.git
cd probe-control-api
Build the project using Maven:

bash
mvn clean install
Run the Spring Boot application:

bash
mvn spring-boot:run
The application will start running on http://localhost:8080.

Usage
1. Sending Commands to the Probe
To send a series of commands to the probe, use a POST request to /probe/command. You can use tools like Postman, cURL, or any HTTP client.

Example:

bash
curl -X POST http://localhost:8080/probe/command \
   -H "Content-Type: application/json" \
   -d '[{"action": "MOVE", "direction": "FORWARD"}, {"action": "TURN", "direction": "RIGHT"}, {"action": "MOVE", "direction": "FORWARD"}]'
This will move the probe forward, turn it right, and then move it forward again.

2. Getting the Probe Status
To get the current status of the probe, including its position and visited coordinates, send a GET request to /probe/status.

Example:
bash
curl http://localhost:8080/probe/status
This will return the current position and the list of coordinates the probe has visited.

Example Commands
Move Forward:

json
{"action": "MOVE", "direction": "FORWARD"}
Move Backward:

json
{"action": "MOVE", "direction": "BACKWARD"}
Turn Left:

json
{"action": "TURN", "direction": "LEFT"}
Turn Right:

json
{"action": "TURN", "direction": "RIGHT"}
Get Probe Status (Visited Coordinates):

bash
GET /probe/status