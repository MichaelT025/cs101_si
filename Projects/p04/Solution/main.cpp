#include <iostream>
#include <string>
#include <sstream>
#include "colormap.h"
using namespace std;

int main() {

   /* you may modify for testing. */
   std::string mapname;
   std::cin >> mapname;
   std::string mapkey = colormap((mapname+".txt"));
   std::cout << mapkey;
   
   return 0;
}
