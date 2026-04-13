#include <iostream>
#include <map>
#include <queue>
#include <string>
#include <sstream>
#include <vector>
#include <fstream>
#include <unordered_map>
#include "colormap.h"
#include <unordered_set>

using namespace std;

class Country{
   char name;
   int color;
   vector<Country*> neighbors;
   public:
   Country(char c){
      this->name= c;
      this->color = 0;
   }
   char getName(){
      return this->name;
   }
   int setColor(int c){
      this->color = c;
      return this->color;
   }
   int getColor(){
      return this->color;
   }
   vector<Country*> getNeighbors(){
      return this->neighbors;
   }
   void addNeighhbor(Country* a){
      for (Country* n : neighbors) //Check for duplicates
         if (n == a) return;
      neighbors.push_back(a);
   }
   int neighborsCount(){
      return this->neighbors.size();
   }
};

vector<Country*> parseMap(string input){
   ifstream file(input);
   if (!file.is_open()) {
    cerr << "Error: Could not open file " << input << endl;
    return {};
   }
   unordered_map<char, Country*> chartoCountry;
   vector<Country*> adj_list;
   string row, prev_row;

   while (getline(file, row)) {
      for (int col = 0; col < (int)row.size(); col++) {
         char c = row[col];
         if (c == '~') continue;

         if (chartoCountry.find(c) == chartoCountry.end()) {
            chartoCountry[c] = new Country(c);
            adj_list.push_back(chartoCountry[c]);
         }

         // horizontal neighbor to the right
         if (col + 1 < (int)row.size() && row[col+1] != '~' && row[col+1] != c) {
            char r = row[col+1];
            
            if (chartoCountry.find(r) == chartoCountry.end()) {
               chartoCountry[r] = new Country(r);
               adj_list.push_back(chartoCountry[r]);
            }
            chartoCountry[c]->addNeighhbor(chartoCountry[r]);
            chartoCountry[r]->addNeighhbor(chartoCountry[c]);
         }

         // vertical neighbor above
         if (!prev_row.empty() && prev_row[col] != '~' && prev_row[col] != c) {
            char u = prev_row[col];
            chartoCountry[c]->addNeighhbor(chartoCountry[u]);
            chartoCountry[u]->addNeighhbor(chartoCountry[c]);
         }
      }
      prev_row = row;
   }

   return adj_list;
}

bool compareCountry(Country* a, Country* b){
   return a->neighborsCount() < b->neighborsCount();
}

string colormap(string input){
   vector<Country*> countries = parseMap(input);
   priority_queue<Country*, vector<Country*>, decltype(&compareCountry)> maxHeap(compareCountry);
   for(Country* c: countries)
      maxHeap.push(c);

   
   vector<vector<char>> colors(5);
   while(!maxHeap.empty()){
      Country* curr= maxHeap.top(); maxHeap.pop();
      bool used[5]={false};
      for(Country* n: curr->getNeighbors()){
         int currcolor=n->getColor();
         if(currcolor!=0) used[currcolor]=true;
      }
      for(int c=1;c<5;c++){
         if(!used[c]){
            curr->setColor(c);
            break;
         }
      }
      colors[curr->getColor()].push_back(curr->getName());
   }

   string result = "";
   for(int i=1;i<5;i++){
      result+="Color "+to_string(i)+": ";
      for(char c: colors[i]){
         result+=string(1,c)+", ";
      }
      if (!colors[i].empty()) {
         result = result.substr(0, result.length() - 2);
      }
      result+="\n";
   }
   return result;
}
