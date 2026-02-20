

void merge(vector<int> &a, int lo, int mid, int hi){
    int lsize=mid-lo+1;
    int rsize=hi-mid;
    vector<int> left(lsize);
    vector<int> right(rsize);
    //populate left 
    for(int i=0;i<lsize;i++){
        left[i]=a[lo+i];
    } 
    for(int i=0;i<rsize;i++){
        right[i]=a[mi+i+1]
    }
    //populate right
    int i=0,j=0,k=lo;
    while(i<lsize && j<rsize){
        if(left[i]<=right[j]){
            a[k]=left[i];
            i++;
        }
        else{
            a[k]=right[j];
            j++;
        }
        k++;   
    }
    while(i<lsize){
        a[k]=a[i++];
        k++;
    }
    while(j<rsize){
        a[k]=a[j++];
        k++;
    }
}

void divide(vector<int> &a, int lo, int hi){
    if(lo>=hi) return;
    int mi=lo+(hi-lo)/2
    divide(a, lo, mid);
    divide(a, mid+1, hi);
    merge(a, lo, mid, hi);
}


void mergeSort(vector<int> &a){
    divide(a, 0, a.size()-1);
}

/*
Time complecxity: O(nlogn) <- always
Spcae complexity: O(n)
Stable: Yes
Inplace: No
*/