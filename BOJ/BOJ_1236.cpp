#include <iostream>
#include <string>

using namespace std;


int main() {

	int row, col;

	cin >> row >> col;

	char map[51][51] = { '.', };



	for (int i = 0; i < row; i++) {
		for (int j = 0; j < col; j++) {
			cin >> map[i][j];
		}
	}

	
	int r = 0, c = 0;

	bool flag;
	for (int i = 0; i < row; i++) {
		flag = true;
		for (int j = 0; j < col; j++) {
			if (map[i][j] == 'X') {
				flag = false;
				break;
			}
		}
		if (flag) {
			r++;
		}
	}

	for (int i = 0; i < col; i++) {
		flag = true;
		for (int j = 0; j < row; j++) {
			if (map[j][i] == 'X') {
				flag = false;
				break;
			}
		}
		if (flag) {
			c++;
		}
	}

	cout << max(r, c) << endl;

	return 0;
}