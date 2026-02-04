//
//  wavefront.cpp
// 

#include "wavefront.h"
/*
 You must complete this function.
 The rest is up to you. You may edit this file freely except for changing this function's signature..
 The filename is the name of the file containing the input map.
 startrow, startcol is the starting location.
 goalrow, goalcol is the target location.
 Print the solution map to the ostream output
 and return the distance of the path.
 */
int wavefront(std::string filename,int startrow,int startcol,int goalrow,int goalcol,std::ostream&output){
    int distance;
    //you can write to std::cout all you want
    std::cout << "Wavefront running" << endl;
    //only write the solution map to output
    output << "#######" << std::endl;
    output << "#.....#" << std::endl;
    output << "#.@'..#" << std::endl;
    output << "#..'..#" << std::endl;
    output << "#..''.#" << std::endl;
    output << "#...'.#" << std::endl;
    output << "#...$.#" << std::endl;
    output << "#.....#" << std::endl;
    output << "#######" << std::endl;
    distance = 6;
    return distance;
}