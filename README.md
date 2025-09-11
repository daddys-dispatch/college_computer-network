# Computer Network Lab Exercises

This repository contains Java programs and solutions for core computer network lab experiments.

---

## Lab 1: CRC Check (Error Detecting Code)

**Aim:**  
Implement error detecting code using CRC-CCITT (16-bits).

**Description:**  
A Java program to calculate and verify a Cyclic Redundancy Check (CRC) for error detection in digital data. The CRC is computed using binary division by a generator polynomial and used to detect transmission errors.

**Features:**  
- Appends CRC remainder to transmitted data.
- Checks received data for errors.
- Demonstrates bitwise logic and CRC division process.

---

## Lab 2: Sliding Window Protocol

**Aim:**  
Implement the sliding window protocol in the data link layer.

**Description:**  
A Java simulation of the sliding window protocol for flow control in packet transmission. It efficiently handles sending multiple packets and receiving acknowledgments, ensuring reliable data transfer.

**Features:**  
- Simulates sending and acknowledging multiple packets.
- Manages window size and sliding mechanism.
- Demonstrates flow control used in real-world protocols.

---

## Lab 3: Bellman-Ford Algorithm (Shortest Path)

**Aim:**  
Find the shortest path between vertices using the Bellman-Ford algorithm.

**Description:**  
A Java implementation of the Bellman-Ford algorithm, which calculates shortest paths in weighted graphs and detects negative edge cycles.

**Features:**  
- Accepts weighted adjacency matrix as input.
- Computes shortest distance from the source to all vertices.
- Detects negative cycles in the network.

---

## Lab 4: Client-Server File Transfer

**Aim:**  
Implement a client-server program using TCP/IP sockets for file transfer.

**Description:**  
A Java client-server system where the client sends a request to the server for a file, and the server transfers the file content back if available, using TCP sockets.

**Features:**  
- Server handles one file transfer per run.
- Client requests and saves the file with progress output.
- Clear console messages for all transfer stages.

---

## Repository Structure

- [`lab01.java`](lab01.java) — CRC check implementation  
- [`lab02.java`](lab02.java) — Sliding window protocol simulation  
- [`lab03.java`](lab03.java) — Bellman-Ford shortest path algorithm  
- [`lab04/Server.java`](lab04/Server.java) — Server code for client-server file transfer  
- [`lab04/Client.java`](lab04/Client.java) — Client code for client-server file transfer  
- [GitHub Repo Link](https://github.com/daddys-dispatch/college_computer-network)

---

Explore each lab file for code and outputs. Contributions and feedback are welcome!
