//
//  wavefront.cpp
// 

#include "wavefront.h"
#include <queue>
#include <vector>
#include <string>
#include <iostream>

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
    int distance=0;
    //you can write to std::cout all you want
    std::cout << "Wavefront running" << std::endl;
    //only write the solution map to output
    std::vector<std::string> map;
    std::ifstream file(filename);

    if (!file.is_open()) {
        std::cerr << "Error: Could not open file " << filename << std::endl;
        return -1;
    }

    std::string line;
    while (std::getline(file, line)) {
        map.push_back(line);
    }

    file.close();

    //creating matrix to track distance
    int rows=map.size();
    int cols=map[0].size();
    std::vector<std::vector<int>> distanceMatrix(rows, std::vector<int>(cols, -1));
    //directions ^,v,<-,->
    int dr[]={-1,1,0,0};
    int dc[]={0,0,-1,1};
    
    std::queue<std::pair<int, int>> visited;
    visited.push({startrow, startcol});
    distanceMatrix[startrow][startcol] = 0;
    
    while (!visited.empty()) {
        auto[r,c]=visited.front(); visited.pop();

        if (r == goalrow && c == goalcol) {
            distance = distanceMatrix[r][c];
            break;
        }
        
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && map[nr][nc] =='.' && distanceMatrix[nr][nc] == -1) {
                distanceMatrix[nr][nc] = distanceMatrix[r][c] + 1;
                visited.push({nr, nc});
            }
        }
    }
    //backtrack (look for entries with value one less than current cell)
    
    int r=goalrow, c=goalcol;
    
    map[r][c]='$'; //mark goal
    
    while(distanceMatrix[r][c]!=0){
        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            if(nr>=0 && nr<rows && nc>=0 && nc<cols && distanceMatrix[nr][nc]==distanceMatrix[r][c]-1){
                r=nr;
                c=nc;
                if(distanceMatrix[r][c]!=0) map[r][c]='\'';
                break;
            }
        }    
    }
    if(distanceMatrix[goalrow][goalcol]==-1) return -1;
    map[startrow][startcol]='@'; //mark start


    for (auto row : map) {
        output << row << std::endl;
    }
    return distance;
}