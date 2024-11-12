#include <iostream>
#include <fstream>

using namespace std;

void swap(int *arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}
int recBubbleSort(int *arr, int pos) {
    if(pos == 0) return pos;
    
    int max = recBubbleSort(arr, pos-1);
    return arr[pos] > arr[max] ? pos : max;

}

void bubbleSort(int *arr, int pos) {
    for(int i = pos-1; i > 0; i--) {
        int max = recBubbleSort(arr, i);
        swap(arr, i, max);
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

    bubbleSort(arr, size);
    print(arr, size, output);
}