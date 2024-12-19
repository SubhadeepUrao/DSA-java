// Given an array A[] that stores all number from 1 to N (both inclusive and sorted) and K queries.

// The task is to do the following operations on array elements :

// 1. UNION X Z : Perform union of X and Z i.e. parent of Z will become the parent of X.
// 2. FIND X: Find the ultimate parent of X and print it.

// Note: Initially all are the parent of themselves.The ultimate parent is the topmost node such that par[node]=node.

class GfG {
    int find(int A[], int X) {
        while (A[X] != X)
            X = A[X];
        return X;
    }

    void unionSet(int A[], int X, int Z) {
        int representativeOfX = find(A, X);
        int representativeOfZ = find(A, Z);
        A[representativeOfX] = representativeOfZ;
    }
}
