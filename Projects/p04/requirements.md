# 20.12 Project 4: Map Coloring

Testing is complete. Please alert me if you encounter problems.

Construct a 4 coloring of a map such that no two neighboring countries have the same color. For this project you will read in a map encoded as a text file. An example Follows:

```
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
~AABBBBBCCDDEFGGG~~HHIHHJJJJKK~
~~ABBBBBCCDDEfGGGGHHHIIHHJJKK~
~AAAAALLLLLEMMMMHHHHHHHHHHHHH~
~AAAA~~LLLLEMMM~~HHHHHHHHHHH~
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```

- `~` Are not part of any country and do not have to be colored.
- Countries will be marked A though Z.

While a 4 coloring of the map might look like:jnk;b

```
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
~3311111443341333311131122233~
~3311111443341333311131122233~
~3333332222242222211111111111~
~3333332222242222211111111111~
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```

You are asked to produce a string in the following format:

```
Color 1: B, F, H
Color 2: J, L, M
Color 3: A, D, G, K
Color 4: C, E
```

The grading engine will parse this string to verify your coloring. Valid colorings are not unique.

You must implement the following function:

```cpp
std::string colormap(std::string filename)
```

The input is the name of a file (eg "map.txt") and you return the coloring described above.

The rest of your design is up to you.