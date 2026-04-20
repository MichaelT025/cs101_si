#include <iostream>
#include <string>
#include <vector>
#include <fstream>
#include <unordered_map>
#include "colormap.h"
#include <algorithm>

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
   return a->neighborsCount() > b->neighborsCount();
}

bool solve(vector<Country*>& countries, int idx){
   if(idx==countries.size()) return true;
   bool used[5]={false};
   Country* curr=countries[idx];

   // Mark any colors already used by neighboring countries.
   for(auto country: curr->getNeighbors()){
      used[country->getColor()]=true;
   }

   // Try each valid color for the current country.
   for(int c=1; c<5; c++){
      if(!used[c]){
         curr->setColor(c);

         // If the rest of the countries can be colored, we are done.
         if(solve(countries, idx+1)) return true;

         // Otherwise undo this choice and try the next color.
         curr->setColor(0);
      }
   }

   // No color worked for this country with the current earlier choices.
   return false;
}
string colormap(string input){
   vector<Country*> countries = parseMap(input);
   sort(countries.begin(), countries.end(), compareCountry);

   solve(countries, 0);

   vector<vector<char>> colors(5);
   for(Country* c: countries){
      colors[c->getColor()].push_back(c->getName());
   }

   string result = "";
   for(int i=1;i<5;i++){
      result+="Color "+to_string(i)+": ";
      for(char c: colors[i]){
         result+=string(1,c)+", ";
      }
      result.pop_back();
      result.pop_back();
      result+="\n";
   }
   return result;
}
