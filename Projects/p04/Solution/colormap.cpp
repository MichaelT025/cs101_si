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
};

vector<Country*> parseMap(string input){
   ifstream file(input);
   if (!file.is_open()) {
    cerr << "Error: Could not open file " << input << endl;
    return {};
   }
   unordered_map<char, Country*> chartoCountry;
   Country* curr=nullptr;
   char c;
   while (file.get(c)) {
      if (c != '~' && c != '\n' && chartoCountry.find(c)==chartoCountry.end()){
         curr= new Country(c);
         chartoCountry[c]= curr;
      }
   }
   file.close();
   file.open(input);
   vector<Country*> adj_list;
   for(auto it=chartoCountry.begin(); it!=chartoCountry.end();it++){

   }

   return {};
}

string colormap(string input){
   vector<Country*> countries = parseMap(input);
   return "TODO";
}
