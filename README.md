# CS101 SI Materials

This repository contains Supplemental Instruction (SI) materials for **CS101: Introduction to Computer Science**, including labs, projects, reference code, and practice exercises.

---

## Quick Start

**Already know Git?** Clone and go:

```bash
git clone https://github.com/MichaelT025/cs101_si.git
cd cs101_si
```

**New to Git?** See [Getting Started with Git](#getting-started-with-git) below.

---

## What's Inside

| Folder | Contents |
|--------|----------|
| `Labs/` | Lab assignments and solutions (Lab04, Lab05, Lab07, Lab08) |
| `Projects/` | Project reference code (p01, p02, p03) |
| `Notes/` | Course notes and reference materials |
| `sessions/` | SI session examples and practice problems |
| `Some_java/` | Additional Java examples |

---

## Running the Code

### Labs (C++)

**Lab 04 - Wavefront Pathfinding:**
```bash
g++ -o lab4 Labs/Lab04/wavefront.cpp Labs/Lab04/main.cpp
cd Labs/Lab04 && ./lab4
```

**Lab 08 - Binary Encoder/Decoder:**
```bash
cd Labs/Lab08
javac BinaryEncoderDecoder.java
java Main
```

### Projects

**Project 01 - Infix to RPN:**
```bash
cd Projects/p01
g++ -o p01 main.cpp
./p01
```

**Project 03 - Huffman Encoding/Decoding:**
```bash
cd Projects/p03
javac Main.java HuffmanCoding.java HuffmanNode.java PriorityQueue.java
java Main
```

**Project 02 - Contact List:**
```bash
cd Projects/p02
g++ -o p02 ContactInfo.cpp main.cpp
./p02
```

---

## Getting Started with Git

### 1) Install Git

**Windows**
- Download from <https://git-scm.com/download/win>
- Use default install options
- Open **Git Bash** or **PowerShell** when done

**macOS**
```bash
xcode-select --install
```

**Linux (Ubuntu/Debian)**
```bash
sudo apt update
sudo apt install git -y
```

### 2) Verify Installation

```bash
git --version
```

### 3) Clone This Repository

```bash
git clone https://github.com/MichaelT025/cs101_si.git
cd cs101_si
```

### 4) Configure Git (One-Time Setup)

```bash
git config --global user.name "Your Name"
git config --global user.email "you@example.com"
```

### 5) Keep Updated

Before each SI session, get the latest materials:

```bash
git pull
```

### 6) Common Git Commands

```bash
git status          # See what changed
git log --oneline   # View recent updates
```

### 7) Open in VS Code

```bash
code .
```

Or open VS Code manually → **File → Open Folder** → select `cs101_si`.

### Troubleshooting

| Issue | Solution |
|-------|----------|
| `git: command not found` | Restart your terminal or reinstall Git |
| `fatal: not a git repository` | Make sure you ran `cd cs101_si` |
| Clone fails | Check your internet connection and verify the URL |

---

## Repository Structure

```
cs101_si/
├── Labs/
│   ├── Lab04/              # Wavefront pathfinding (C++)
│   ├── Lab05/              # Binary Search Tree basics (Java)
│   ├── Lab07/              # BST with iterator (Java)
│   └── Lab08/              # Binary Encoder/Decoder (Java)
├── Projects/
│   ├── p01/                # Infix to RPN converter (C++)
│   │   └── Solution/
│   ├── p02/                # Contact list (C++)
│   │   └── Solution/
│   └── p03/                # Huffman Encoding/Decoding (Java)
│       └── Solution/
├── Notes/                  # Reference materials
├── sessions/               # SI session code
└── Some_java/              # Extra Java examples
```

---

## For Students

These materials are provided for your reference and practice. If you have questions:

- Attend scheduled SI sessions
- Visit office hours
- Reach out via GroupMe

---

## Note

This is my personal working repository for CS101 SI duties. Contributions are not accepted—students are welcome to clone and reference materials for their own learning.

---

**Languages & Tools:** C++, Java, Git, VS Code

