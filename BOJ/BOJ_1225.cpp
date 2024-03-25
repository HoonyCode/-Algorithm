#include <iostream>
#include <string>
using namespace std;



int main() {

	string a, b;

	cin >> a;

	if (a[0] == '0') {
		cout << 0 << endl;
		return 0;
	}

	cin >> b;

	long long answer = 0;

	for (char x : a) {
		for (char y : b) {
			answer += (x - '0') * (y - '0');
		}
	}

	cout << answer << endl;
	
	

	return 0;
}
