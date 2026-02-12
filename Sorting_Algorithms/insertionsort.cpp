#include <vector>

void I_sort(vector<int> &a){
    for(int i = 1; i < a.size(); i++){
     int key = a[i]; 
     for(int j = i - 1; j >= 0 && a[j] > key; j--){
         a[j + 1] = a[j];
     } 
     a[j + 1] = key;
    }    
}
/*
Time Complexity: 
- Best Case: O(n) - when array is already sorted
- Average Case: O(n^2)
- Worst Case: O(n^2) - when array is reverse sorted
Space Complexity: O(1)
Stable: Yes
Inplace: Yes
*/
