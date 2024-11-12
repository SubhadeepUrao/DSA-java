#include <iostream>
#include <fstream>
using namespace std;

void swap(int *arr, int &i, int &j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

void selectionSort(int *arr, int &size) {
    for(int i = 0; i < size-1; i++) {
        int min = i;
        int j;
        for(j = i+1; j < size; j++) {
            if(arr[j] < arr[min])
                min = j;
        }
        swap(arr, i, min);
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
    while(input >> num) {
        size++;
    }
    input.clear();
    input.seekg(0);
    int *arr = new int[size];
    int i = 0;
    while(input >> num) {
        arr[i] = num;
        i++;
    }

    selectionSort(arr, size);
    print(output, arr, size);
    input.close();
    output.close();

}