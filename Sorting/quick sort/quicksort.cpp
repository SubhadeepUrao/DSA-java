#include <iostream>
#include <fstream>

using namespace std;

void swap(int *arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

int partition(int *arr, int lb, int ub) {
    int left = lb;
    int right = ub;
    int pivot = lb; // pivot is chosen as the 1st elem
    do {
        do {
            left++;
        } while(left < ub && arr[left] < arr[pivot]);
        do {
            right--;
        } while(right >= lb && arr[right] > arr[pivot]);

        if(left < right) swap(arr, left, right);
        
    } while(left < right);

    swap(arr, pivot, right);
    return right;
}


void quickSort(int *arr, int lb, int ub) {
    if(lb < ub - 1) {
        int pivot = partition(arr, lb, ub);
        quickSort(arr, lb, pivot);
        quickSort(arr, pivot + 1, ub);
    }
}

void print(int *arr, int size, ofstream &output) {
    for(int i = 0; i < size; i++)
        output << arr[i] << " ";
}


int main() {
    ifstream input("input.txt");
    if(!input.is_open()) {
        cerr << "Error opening input file!";
        return 1;
    }
    ofstream output("output.txt");
    if(!output.is_open()) {
        cerr << "Error opening output file!";
        return 1;
    }
    int num;
    int size = 0;
    while(input >> num) 
        size++;
    input.clear();
    input.seekg(0);
    int *arr = new int[size];
    int i = 0;
    while(input >> num) {
        arr[i] = num;
        i++;
    }

    quickSort(arr, 0, size);
    print(arr, size, output);
}