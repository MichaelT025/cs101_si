#include <vector>

using namespace std;

void swap(int &a, int &b){
    int temp=a;
    a=b;
    b=temp;
}

int partition(vector<int> &a, int lo, int hi){
    int pivot=a[hi];
    int i=lo-1;
    for(int j=0;j<hi-1;j++){
        if(a[j]<=pivot){
            i++;
            swap(a[i], a[j]);
        }
    }
    swap(a[++i], a[hi]);
    return i;
}

void quicksort(vector<int> &a, int lo, int hi){
    if(hi<=lo) return;
    int p=partition(a, lo, hi);
    quicksort(a, lo, p-1);
    quicksort(a, p+1, hi);
    
}

void quicksort(vector<int> &a){
    quicksort(a, 0, a.size() - 1);   
}

//Time complexity: O(nlogn)
//Space complexity: O(logn)