Lab 04: A Wavefront Path Finder

In this lab you will write a program to solve a maze. You will be provided a maze/map and generate a solution using an algorithm called wavefront.

You will edit the wavefront function in wavefront.cpp/wavefront.h. Main (main.cpp) will call your function like this:

distance = wavefront(filename,startrow,startcol,endrow,endcol,ouput);

Your function will return the distance (steps)and also write a solution map to the stream named output. All other printing should go to std::cout -- again, only write the map to output (the checker reads this map and anything else will confuse it).

You can write to std::cout all you want.

You will read in a text file as a map (maze?) Here is an example:

####################

#.........##.......#

#...##.....##......#

#....##.....#......#

#.....##....#..#...#

#..#...##......#...#

#..#....##.....#...#

#..##....#.....#...#

#...#....###...#...#

#...##.....#...#...#

#..............#...#

####################

In the map file the pound character (#) will be used to represent an obstacle/wall. And a period(.) will be used to represent an open square.

From any open square you can move to an adjacent square (never diagonally, though).

Given a starting square(row,col) and an ending/target square(row,col) your function will find the shortest path from the start to the target, or maybe, report that no path exists.

You will also print one path (the shortest path may not be unique) using a single quote(') to retrace the steps. eg:

####################

#.''''''..##.......#

#.'.##.'''.##......#

#.'..##..''.#'''''.#

#.@...##..''#'.#.'.#

#..#...##..'''.#.'.#

#..#....##.....#.'.#

#..##....#.....#.'.#

#...#....###...#.'.#

#...##.....#...#.$.#

#..............#...#

####################

Shortest Path: 30

There is simple well-known algorithm (wavefront) to follow that uses a queue. The algorithm works as follows:

Initialize a queue with the starting square recording the distance as zero(0).

Repeat until the queue is empty or the target has been reached:

Dequeue a square and recover the distance of that square (distance matrix).

Enqueue unvisited adjacent open squares with distance+1, this will be the minimum distance to the square

Once the target has been found one can retrace the steps back to the start.

From the target find any adjacent square that has distance-1 and repeat until you are at distance zero (the start cell)

You have to work out some bookkeeping. You will have an array of strings to represent a map. A matrix of integers can be used to track visited squares and the distances. You might initialize all cells of this matrix with -1 as unvisited and then as you enqueue the cell you can update the value with a distance.

When you find the target this will matrix allow you to find the path back to the starting cell. Just follow the bread crumbs.

The only file you must edit is wavefront.cpp.