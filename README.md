# Computer Network Lab Programs

This repository contains Java and TCL programs for Computer Network (BCS502) Lab.

## [Lab 1: CRC Check](lab01/lab01.java)

Write a Java program for error detection using CRC-CCITT (16-bits). The program calculates and verifies a Cyclic Redundancy Check (CRC) for digital data using binary division by a generator polynomial, demonstrating error detection during transmission.

## [Lab 2: Sliding Window](lab02/lab02.java)

Write a Java program for implementing the sliding window protocol in the data link layer. The program simulates sending and acknowledging multiple packets while managing window size and sliding, ensuring reliable and efficient flow control.

## [Lab 3: Bellman-Ford](lab03/lab03.java)

Write a Java program for finding the shortest path between vertices using the Bellman-Ford algorithm. The program computes shortest paths in weighted graphs from a source to all vertices and also detects negative edge cycles.

## [Lab 4: File Transfer](lab04)

Write Java programs for implementing Client-Server via TCP/IP sockets for file transfer. The client requests a file from the server, and the server transfers it back if available, demonstrating basic client-server communication.

## [Lab 5: Datagram Socket](lab05)

Write Java programs using datagram sockets for client-server communication. The server sends messages to the client, and the client displays the received messages on its side, demonstrating connectionless communication using UDP sockets.

## [Lab 6: RSA Cryptosystem](lab06/lab06.java)

Write a Java program for implementing the RSA public key cryptosystem. The program generates keys, encrypts a plaintext message using the public key, and decrypts the ciphertext using the private key, demonstrating secure communication.

## [Lab 7: Leaky Bucket](lab07/lab07.java)

Write a Java program for congestion control using the leaky bucket algorithm. The program simulates packet transmission control by regulating data flow and preventing network congestion, illustrating traffic shaping and rate-limiting mechanisms.

## [Lab 8: Point-to-Point Network](lab08/lab08.tcl)

Write a TCL program to implement a three-node point-to-point network with duplex links. The program demonstrates basic network topology creation and bidirectional communication setup between nodes.

## [Lab 9: Ping Transmission](lab09/lab09.tcl)

Write a TCL program to implement transmission of ping messages between network nodes. The program simulates the ICMP echo request and reply mechanism, verifying connectivity between nodes in a simulated network.

## [Lab 10: Ethernet LAN](lab10/lab10.tcl)

Write a TCL program to implement an Ethernet LAN using multiple nodes. The program creates a local area network (LAN) setup where nodes communicate through a shared medium, demonstrating basic Ethernet communication and topology.
