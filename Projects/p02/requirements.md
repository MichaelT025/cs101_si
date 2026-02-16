# Overview

In this project, you will use linked lists to maintain contacts and their information. You will complete the `contactList` class, which wraps a linked list of contacts where each `contact` has a linked list of `Info`.

# Classes

There are three classes with the following information:

```cpp
class Info {
    string name;
    string value;
    Info *next;
}

class Contact {
    string first;
    string last;
    Contact *next;
    Info *headInfoList;
}

class ContactList {
    Contact *headContactList;
    int count;
}
```

For example:

| ContactList | | | | |
|-------------|---|---|---|---|
| **count: 4** | | | | |
| **headContactList: ↓** | | | | |
| first: Wanda<br>last: Maximoff<br>headInfoList→<br>next: ↓ | nullptr | | | |
| first: Peter<br>last: Parker<br>headInfoList→<br>next: ↓ | name: alias<br>value: Spider-Man<br>next: → | name: color<br>value: red-and-blue<br>next: → | nullptr | |
| first: Natasha<br>last: Romanoff<br>headInfoList→<br>next: ↓ | name: alias<br>value: BlackWidow<br>next: → | name: birthday<br>value: December-3-1984<br>next: → | name: email<br>value: black.widow@avengers.com<br>next: → | nullptr |
| first: Tony<br>last: Stark<br>headInfoList→<br>next: ↓ | name: alias<br>value: IronMan<br>next: → | name: color<br>value: red-and-gold<br>next: → | nullptr | |
| nullptr | | | | |

# Files

This project consists of three files:

1. **main.cpp** - The interface that prompts for and performs actions.
2. **ContactInfo.h** - Definitions of classes.
3. **ContactInfo.cpp** - Implementation of the class methods in `ContactInfo.h`.

- To compile this project, use `g++ -Wall main.cpp ContactInfo.cpp`.

You can download the templates below under **Submission Instructions**. Complete the class methods in `contactInfo.cpp`. You are allowed to modify `ContactInfo.h` and add additional methods to the classes. You are encouraged to write more methods and functions than those listed, but you **must not change** the class names or the method signatures already defined.

# Approach

It is recommended to complete this project one method at a time, working from the easiest to the hardest. Each will be graded individually.

- **(1)** `addContact`, `addInfo`, `printContact`, `print`
- **(2)** `addContactOrdered` and `addInfoOrdered`
- **(3)** `removeInfo` and `removeContact`
- **(4)** `destructor`, `copyConstructor`, `operator=`

Think about helper methods/functions you can write. What actions need to be repeated? What methods could be broken into several smaller methods? What methods can you call inside other methods to help solve the problem? The `destructor` needs to remove. The `copyConstructor` and `operator=` need to add, etc.

Develop incrementally, test often.

# Notes

- Format your output **exactly** as the example.
- Do not include libraries other than `iostream` and `string`.

# Testing

- Assume valid inputs.
- To speedup testing, you can enter all commands in an input file and redirect the program input from the file: `./a.out < test1.txt`
- `./a.out < test1.txt > output.txt` will redirect output to the file `output.txt`.
- To make results easier to read, you can add the command-line argument `no`: `./a.out no < test1.txt`
- Be sure to test your program thoroughly and check edge cases.
- When testing the program, an `addContact` will not be combined with an `addContactOrdered` or an `addInfo` with an `addInfoOrdered` in the same test case.
- A sample execution of the program is below to build the linked lists as illustrated in the example above.

# Example

## test1.txt

```
addContactOrdered Tony Stark
addContactOrdered Peter Parker
addContactOrdered Natasha Romanoff
addContactOrdered Wanda Maximoff
addInfoOrdered Tony Stark alias IronMan
addInfoOrdered Tony Stark color red-and-gold
addInfoOrdered Peter Parker alias Spider-Man
addInfoOrdered Peter Parker color red-and-blue
addInfoOrdered Natasha Romanoff birthday December-3-1984
addInfoOrdered Natasha Romanoff email black.widow@avengers.com
addInfoOrdered Natasha Romanoff alias BlackWidow
print
quit
```

```
$ ./a.out no < test1.txt
Contact Name: Wanda Maximoff
Contact Name: Peter Parker
    alias | Spider-Man
    color | red-and-blue
Contact Name: Natasha Romanoff
    alias | BlackWidow
    birthday | December-3-1984
    email | black.widow@avengers.com
Contact Name: Tony Stark
    alias | IronMan
    color | red-and-gold
```
