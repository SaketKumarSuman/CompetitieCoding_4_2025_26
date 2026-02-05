#include <bits/stdc++.h>
using namespace std;

int main() {
    int n;
    cin >> n; 
    vector<int> arr(n);

    for (int i = 0; i < n; i++) {
        cin >> arr[i]; 
    }


    int initialOnes = 0;
    for (int x : arr) {
        if (x == 1) initialOnes++;
    }
    vector<int> transformed(n);
    for (int i = 0; i < n; i++) {
        if (arr[i] == 0) transformed[i] = 1;
        else transformed[i] = -1;
    }

    int maxGain = INT_MIN;
    int current = 0;
    for (int val : transformed) {
        current = max(val, current + val);
        maxGain = max(maxGain, current);
    }

    if (initialOnes == n) {
        cout << n - 1 << endl; 
    } else {
        cout << initialOnes + maxGain << endl; 
    }

    return 0;
}