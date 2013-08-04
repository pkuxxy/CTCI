#include<iostream>
#include<string>
#include<string.h>
using namespace std;
int diffBitsCount(int a, int b)
{
	int ret = 0;
	int c = a ^ b;
	while(c)
	{
		ret++;
		c &= c-1;
	}
	return ret;
}
int main()
{
	int a = 31;
	int b = 14;
	cout<<diffBitsCount(a, b)<<endl;
	getchar();
}