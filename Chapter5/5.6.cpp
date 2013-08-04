#include<iostream>
#include<string>
#include<string.h>
using namespace std;
int swapOddAndEven(int data)
{
	return ((data & 0xaaaaaaaa)>>1) | ((data & 0x55555555)<<1);
}
int main()
{
	int a = 10;
	cout<<swapOddAndEven(a)<<endl;
	getchar();
}