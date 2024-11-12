#include <iostream>
#include <fstream>
using namespace std;

void merge(int *arr, int lb, int mid, int ub) {
    int i = lb;
    int j = mid;
    int k = 0;
    int *aux = new int[ub - lb];

    while(i < mid && j < ub) {
        if(arr[i] < arr[j]) {
            aux[k] = arr[i];
            i++;
            k++;
        }
        else {
            aux[k] = arr[j];
            j++;
            k++;
        }
    }
    while(i < mid) {
        aux[k] = arr[i];
        i++;
        k++;
    }
    while(j < ub) {
        aux[k] = arr[j];
        j++;
        k++;
    }
    for(i = lb, k = 0; i < ub; i++, k++) {
        arr[i] = aux[k];
    }

    delete[] aux;
}

void mergeSort(int *arr, int lb, int ub) {
    if(lb < ub - 1) {
        int mid = (lb + ub) / 2;
        mergeSort(arr, lb, mid);
        mergeSort(arr, mid, ub);
        merge(arr, lb, mid, ub);
    }
}

void print(ofstream &output, int *arr, int &size) {
    for(int i = 0; i < size; i++) {
        output << arr[i] << " ";
    }
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

    mergeSort(arr, 0, size);
    print(output, arr, size);

    input.close();
    output.close();
}