#include <iostream>
#include <fstream>

using namespace std;

void swap(int *arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}
void recInsert(int *arr, int pos) {
    if(pos == 0 || arr[pos-1] <= arr[pos]) return;

    swap(arr, pos-1, pos);
    recInsert(arr, pos-1);
}

void insertionSort(int *arr, int pos) {
    if(pos <= 1) return;

    insertionSort(arr, pos-1);
    recInsert(arr, pos-1);
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

    insertionSort(arr, size);
    print(arr, size, output);
}