#include<iostream>
using namespace std;
int bitSubString(int n, int m, int i, int j)
{
	int mask = 0xffffffff << (j + 1);
	mask = mask | ((1 << i) - 1);
	return ((n & mask) | (m << i));
}
int main()
{
	int n = 0x00000400;							//100 0000 0000
	int m = 0x00000015;							//10101
	cout<<"0x"<<hex<<bitSubString(n, m, 2, 6)<<endl;	//100 0101 0100
	return 0;
}
