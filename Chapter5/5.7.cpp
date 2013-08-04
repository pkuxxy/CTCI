#include<iostream>
#include<string>
#include<string.h>
#include<vector>
using namespace std;
int getBit(int data, int col)
{
	return data & (1 << col);
}
int findMissing(vector<int>& v, int col)
{
	if(v.size() == 0)
		return 0;
	vector<int> indics0;
	vector<int> indics1;
	for(int i = 0; i < v.size(); i++)
	{
		if(getBit(v[i], col) == 0)
			indics0.push_back(v[i]);
		else
			indics1.push_back(v[i]);
	}
	if(indics0.size() <= indics1.size())
	{
		return (findMissing(indics0, col+1) << 1) | 0;
	}
	else
		return (findMissing(indics1, col+1) << 1) | 1;
}
int findMissing(int a[], int n)
{
	vector<int> v;
	for(int i = 0; i < n; i++)
	{
		v.push_back(a[i]);
	}
	return findMissing(v, 0);
}
int main()
{
	int a[] = {0,1,2,3,4,6,7,8,9};
	cout<<findMissing(a, 9)<<endl;
	getchar();
}