# CS101 TA Materials

This repository contains teaching assistant materials for **CS101**, including labs, projects, reference code, and supplementary resources used to support students.

## Course Overview

CS101 covers foundational computer science concepts, including:

- Introduction to programming concepts and syntax
- Control structures and flow control
- Functions and modular programming
- Data types and structures
- Debugging and testing techniques
- Problem-solving and algorithmic thinking

## Repository Structure

```
cs101_si/
├── Labs/                           # Lab assignments and solutions
│   ├── Lab04/                      # Wavefront pathfinding algorithm
│   │   ├── main.cpp
│   │   ├── wavefront.cpp
│   │   ├── wavefront.h
│   │   ├── wavefrontT.cpp
│   │   ├── map1.txt
│   │   ├── map2.txt
│   │   ├── map3.txt
│   │   ├── map4.txt
│   │   └── req.md
│   ├── Lab05/                      # Binary Search Tree (BST) basics
│   │   ├── BinaryTree.java         # BST template
│   │   ├── BinaryTree_s.java       # BST implementation with insert/find
│   │   ├── Node.java               # Tree node class
│   │   ├── Main.java               # Test cases
│   │   └── req.md
│   ├── Lab07/                      # Binary Search Tree with iterator
│   │   ├── BinarySearchTree.java   # BST with iterator implementation
│   │   ├── BinarySearchTree_T.java # BST test cases
│   │   ├── Iterator.java           # Iterator interface
│   │   ├── Queue.java              # Queue implementation
│   │   ├── Stack.java              # Stack implementation
│   │   ├── Main.java               # Test driver
│   │   └── req.md
│   └── Lab08/                      # Binary Encoder/Decoder
│       ├── BinaryEncoderDecoder.java
│       ├── BinaryEncoderDecoderT.java
│       ├── BinaryEncoderDecoder_2.java
│       ├── Main.java
│       └── req.md
│
├── Notes/                          # Course notes and reference materials
│   ├── Building_Trees_From_Traversals/
│   ├── Non_recursive_traversal/
│   ├── Sorting_Algorithms/
│   └── Traversal/
│
├── Projects/                       # Project specifications and code
│   ├── p01/                        # Infix to RPN converter
│   │   ├── main.cpp
│   │   ├── main2.cpp
│   │   └── mainT.cpp
│   └── p02/                        # Contact list 
│       ├── ContactInfo.h
│       ├── ContactInfo.cpp
│       ├── main.cpp
│       └── requirements.md
│
├── sessions/                       # SI session reference materials
│   ├── basics/                     # Fundamental concepts
│   │   └── classes.cpp             # C++ classes starter
│   └── sorting/                    # Sorting algorithms
│       └── quicksort.cpp           # Quicksort implementation
│
├── Some_java/                      # Java reference code
│   └── helloworld.java
│
├── .gitignore                      # Git ignore rules
└── README.md                       # This file
```

### Recent Additions
- **Lab 04:** Implementation of the Wavefront pathfinding algorithm.
- **Project 01:** Infix to Reverse Polish Notation (RPN) converter and evaluator.
- **Project 02:** Linked-list based contact manager with ordered insert, removal, printing, and deep-copy operations.

### Example: Running Lab Code
```bash
# Compile and run a typical lab exercise (language-specific)
g++ -o lab1 Labs/lab1/solution.cpp
./lab1
```

### Example: Running Project
```bash
# Navigate to project directory and follow instructions
cd Projects/project1
# See README in each project folder for specific build/run steps
```

## Getting Started with Git

If you have never used Git before, follow these steps.

### 1) Install Git

1. **Windows**
   - Download Git for Windows: <https://git-scm.com/download/win>
   - Run the installer default options are fine.
   - Open **Git Bash** or **PowerShell** after install.

2. **macOS**
   - Option A (recommended): install Xcode Command Line Tools:
     ```bash
     xcode-select --install
     ```
   - Option B: install from <https://git-scm.com/download/mac>

3. **Linux (Ubuntu/Debian)**
   ```bash
   sudo apt update
   sudo apt install git -y
   ```

### 2) Verify Git is installed

Run:

```bash
git --version
```

If installed, you should see something like `git version 2.x.x`.

### 3) Clone this repository

```bash
git clone https://github.com/MichaelT025/cs101_si.git
cd cs101_si
```

### 4) (Recommended) Configure your name and email once

```bash
git config --global user.name "Your Name"
git config --global user.email "you@example.com"
```

Check your settings:

```bash
git config --list
```

### 5) Keep your local copy updated

Before studying, get the newest version:

```bash
git pull
```

### 6) Basic commands you may need

```bash
git status      # Shows changed files
git pull        # Gets latest updates from GitHub
git log --oneline -n 10  # Shows recent commits
```

### 7) Common issues

1. **`git: command not found`**
   - Git is not installed, or terminal was open during install.
   - Reinstall Git and restart terminal.

2. **Permission/authentication errors on clone/pull**
   - Confirm internet connection.
   - Make sure repository URL is exactly:
     `https://github.com/MichaelT025/cs101_si.git`

3. **`fatal: not a git repository`**
   - You are not inside the cloned folder.
   - Run `cd cs101_si` first.

### 8) Open the materials

After cloning, open the folder in VS Code:

```bash
code .
```

If `code` command is not available, open VS Code manually and choose **File -> Open Folder...** then select `cs101_si`.

## For Students

Materials here are provided as-is for reference and learning purposes. If you have questions or need clarification:

- Attend office hours
- Attend scheduled SI sessions
- Reach out via GroupMe

## Note

This is my personal working repository for CS101 TA duties. Contributions are not accepted—this repo is maintained solely for my use, though students are welcome to clone and reference materials.

## Languages & Tools

- **OS:** Ubuntu (primary development environment)
- **Languages:** [C++, Java]
- **Tools:** [Git, VS Code, WSL, Cygwin]

---


