#include <iostream>
#include <fstream>
using namespace std;

void swap(int *arr, int i, int &j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

void bubbleSort(int *arr, int &size) {
    for(int i = 0; i < size-1; i++) {
        bool flag = true;
        for(int j = 1; j < size - i; j++) {
            if(arr[j-1] > arr[j]) {
                flag = false;
                swap(arr, j-1, j);
            }
        }
        if(flag) return;
    }
}

void print(ofstream &output, int *arr, int size) {
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
    
    bubbleSort(arr, size);
    print(output, arr, size);

    input.close();
    output.close();
}