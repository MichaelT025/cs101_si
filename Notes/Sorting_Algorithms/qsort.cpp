#include<vector>

using namespace std;

void swap(int &a, int &b){
    int temp=a;
    a=b;
    b=temp;
}

int partition(vector<int> &a, int lo, int hi){
        int partition=hi;
        int i=lo-1;
        for(int j=0;j<hi;j++){
            if(a[j]<partition){
                i++;
                swap(a[i], a[j]);
            }
        }
        swap(a[i+1], a[hi]);
        return i+1;
}


void quicksort(vector<int> &a){
    quicksort(a, 0, a.size() - 1);  
}

void quicksort(vector<int> &a, int lo, int hi){
    if(lo>=hi) return;
    int p=partition(a, lo, hi);
    quicksort(a, lo, p-1);
    quicksort(a, p+1, hi);
}

/*
Time complexity: 
Best case: O(nlogn)
Worst case: O(n^2)
Average case: O(nlogn)
Space complexity: O(logn)
Stable: No
Inplace: Yes
*/