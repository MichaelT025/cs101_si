#include <vector>

using namespace std;
void swap(int &a, int &b){
    int temp=a;
    a=b;
    b=temp;
}

void bubblesort(vector<int> &a){
    for(int i=0;i<a.size();i++){
        for(int j=0;j<a.size()-i-1;j++){
            if(a[j]>a[j+1]) swap(a[j], a[j+1]);
        }
    }
}

/*
Time complexity: 
- Best case: O(n) - when array is already sorted
- Average case: O(n^2)
- Worst case: O(n^2) - when array is reverse sorted
Space complexity: O(1)
Stable: Yes
Inplace: Yes
*/