# 🧱 Java Peer-to-Peer Blockchain

Anthirium : A peer-to-peer blockchain implementation in Java. This project demonstrates basic concepts of blockchain such as block creation, proof of work, peer-to-peer communication, and chain validation using socket programming.

---

## 🚀 Features

- Create and add new blocks with proof-of-work
- Broadcast blocks to peer nodes via TCP sockets
- Validate entire blockchain on receiving peer
- Dynamically adjust mining difficulty based on mined blocks
- Multithreaded peer server and handler

---

## 🛠 Requirements

- Java 8 or higher
- Maven (for build)
- Terminal access

---

## 📦 Setup

1. **Clone the repository:**

   ```bash
   git clone https://github.com/your-username/java-blockchain.git
   cd java-blockchain
   

   ```
2. **Run the Miners
   ```bash
   mvn clean package

   java -cp target/BlockChain-1.0-SNAPSHOT.jar org.example.Main 5009 5001 5002
   java -cp target/BlockChain-1.0-SNAPSHOT.jar org.example.Main 5001 5009 5002
   java -cp target/BlockChain-1.0-SNAPSHOT.jar org.example.Main 5002 5009 5002
   ```

3.HURRAYY ANTHIRIUM IS UP..


## 📦 Future Goals
   - Running on cloud
   - Making it complete decentralized
   - Increasing Security concerns
   - Cyrpto Introduction



   

