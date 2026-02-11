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
│   │   ├── map1.txt
│   │   ├── map2.txt
│   │   └── ...
│   └── Lab05/                      # Binary Search Tree (BST)
│       ├── BinaryTree.java         # BST template
│       ├── BinaryTree_s.java       # BST implementation with insert/find
│       ├── Main.java               # Test cases
│       ├── Node.java               # Tree node class
│       └── req.md                  # Lab requirements
│
├── Projects/                       # Project specifications and code
│   └── p01/                        # Infix to RPN converter
│       ├── main.cpp
│       ├── main2.cpp
│       └── mainT.cpp
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

## Usage

Students can clone this repository to access reference materials and examples:

```bash
git clone https://github.com/MichaelT025/cs101_si.git
cd cs101_si
```

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

*Last updated: February 2026*

