#include <vector>

using namespace std;

//implements maxheap

void heapify(vector<int>& arr, int i){
    int left_child= 2*i+1; //2i for 1-indexed
    int right_child= 2*i+2; //2i+1 for 1-indexed
    int largest=i;
    //point to the larger value
    if(arr[left_child]>arr[largest]){
        largest=left_child;
    }
    if(arr[right_child]>arr[largest]){
        largest=right_child;
    }
    //swap parent with largest child
    if(largest!=i){
        swap(arr[i], arr[largest]);

        //fix the heap after swap
        heapify(arr, largest);
    }
}



void buildMaxHeap(vector<int>& arr){
    //start at the lowest non-leaf node
    for(int i=arr.size()/2-1;i>=0;i--){
        heapify(arr, i);
    }
}
void extract_max(vector<int>& arr){
    //extract the max element(root) and place it at the end of the array
    for(int i=arr.size()-1;i>0;i--){
        swap(arr[0], arr[i]);
        heapify(arr, i);
    }
}


void heapSort(vector<int>& arr){
    //first build the heap tree
    buildMaxHeap(arr);
    //then extract max from heap tree
    extract_max(arr);
}

/*
Time Complexity: 
Best case: O(nlogn)
Worst case: O(nlogn)
Average case: O(nlogn)
Space Complexity: O(1)
Stable: No
Inplace: Yes

*/