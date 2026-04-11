#include <iostream>
#include <map>
#include <string>
#include <sstream>
#include <vector>
#include <fstream>
#include <unordered_map>
#include "colormap.h"

using namespace std;

class Country{
   char name;
   int color;
   vector<Country*> neighbors;
   public:
   Country(char c){
      this->name= c;
   }
   char getName(){
      return this->name;
   }
   void addNeighhbor(Country* a){
      for (Country* n : neighbors) //Check for duplicates
         if (n == a) return;
      neighbors.push_back(a);
   }
   ~Country(){
      for (Country* n : neighbors) {
         delete n;
      }
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

string colormap(string input){
   vector<Country*> countries = parseMap(input);
   return "TODO";
}
