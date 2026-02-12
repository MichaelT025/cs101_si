#include <vector>


void S_sort(vector<int> &a){
    int n = a.size();
    for (int i = 0; i < n - 1; ++i) {
        int minIdx = i;
        for (int j = i + 1; j < n; ++j) {
            if (a[j] < a[minIdx]) {
                minIdx = j;
            }
        }
        if (minIdx != i) {
            int temp = a[i];
            a[i] = a[minIdx];
            a[minIdx] = temp;
        }
    }
    
}

/*
Time complexity: O(n^2) <- always
Space complexity: O(1)
Stable: No
Inplace: Yes
*/