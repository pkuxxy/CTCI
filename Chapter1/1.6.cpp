/*
 * matrix.cpp
 *
 *  Created on: Jan 3, 2013
 *      Author: bjcoe
 */




#include<iostream>
using namespace std;
void rotate(int **m,int n)
{
	if(!m)
		return;
	int layerCount = n/2;
	for(int layer = 0 ;layer < layerCount; layer++)
	{
		int end = n - layer;
		for(int i = layer; i < end -1; i++)
		{
			int tmp = m[layer][i];
			m[layer][i] = m[end - i - 1][layer];
			m[end - i - 1][layer] = m[end - 1][end - i - 1];
			m[end - 1][end - i - 1] = m[i][end - 1];
			m[i][end - 1] = tmp;
		}
	}
}
void printMatrix(int **m, int n)
{
	for(int i = 0; i < n;i++)
	{
		for(int j = 0 ;j < n; j++)
		{
			cout<<m[i][j]<<" ";
		}
		cout<<endl;
	}
}
int main()
{
	int **m;
	m = new int *[5];
	for(int i = 0 ;i < 5 ;i ++)
	{
		m[i] = new int[5];
	}
	for(int i = 0; i < 5; i++)
	{
		for(int j = 0 ;j < 5; j++)
		{
			m[i][j] = j;
		}
	}
	printMatrix(m, 5);
	rotate(m,5);
	printMatrix(m,5);

	for(int i = 0 ;i < 5 ;i ++)
	{
		delete []m[i];
	}
	delete []m;
	return 0;
}
