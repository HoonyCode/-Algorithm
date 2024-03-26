#include <iostream>
#include <string>

using namespace std;


int main() {

	string a, b;

	cin >> a >> b;

	int result[100] = { 0, };

	int idx = a.length() - 1;
	for (int i = 99; i > -1; i--) {
		if (idx < 0) break;
		result[i] = (a[idx] - '0');
		idx--;
	}

	idx = b.length() - 1;
	int temp = 0;
	int add = 0;
	for (int i = 99; i > -1; i--) {
		if (idx > -1) {
			temp = b[idx] - '0';
		}

		int sum = result[i] + temp + add;
		if (sum == 0) {
			add = 0;
			result[i] = 0;
		}
		else if (sum == 1) {
			result[i] = 1;
			add = 0;
		}
		else if (sum == 2) {
			result[i] = 0;
			add = 1;
		}
		else if (sum == 3) {
			result[i] = 1;
			add = 1;
		}
		idx--;
		temp = 0;
	}

	bool flag = false;
	for (int i = 0; i < 100; i++) {
		
		if (flag == false && result[i] == 1) {
			flag = true;
		}
		
		if (flag) {
			cout << result[i];
		}
	}

	if (flag == false) {
		cout << 0;
	}
	cout << endl;

	

	return 0;
}