#include<iostream>
using namespace std;
void setZero(int **matrix, int m, int n)
{
	if(!matrix)
		return;
	int *row = new int[m];
	int *col = new int[n];
	memset(row, 0, m * sizeof(int));
	memset(col, 0, n * sizeof(int));
	int i,j;
	for(i = 0 ;i < m ;i++)
	{
		for(j = 0 ;j < n ;j++)
		{
			if(matrix[i][j] == 0)
			{
				row[i] = 1;
				col[j] = 1;
			}
		}
	}
	for(i = 0; i < m; i++)
	{
		for(j = 0 ; j < n; j++)
		{
			if(row[i] == 1 || col[j] == 1)
				matrix[i][j] = 0;
		}
	}
	delete []row;
	delete []col;
}

void printMatrix(int **matrix, int m, int n)
{
	for(int i = 0; i < m;i++)
	{
		for(int j = 0 ;j < n; j++)
		{
			cout<<matrix[i][j]<<" ";
		}
		cout<<endl;
	}
	cout<<endl;
}

int main()
{
	int **matrix;
	matrix = new int *[5];
	for(int i = 0 ;i < 5 ;i ++)
	{
		matrix[i] = new int[6];
	}
	for(int i = 0; i < 5; i++)
	{
		for(int j = 0 ;j < 6; j++)
		{
			matrix[i][j] = 1;
		}
	}
	matrix[1][2] = 0;
	matrix[3][5] = 0;

	printMatrix(matrix, 5, 6);
	setZero(matrix, 5, 6);
	printMatrix(matrix, 5, 6);

	for(int i = 0 ;i < 5 ;i ++)
	{
		delete [] matrix[i];
	}
	delete [] matrix;

	return 0;
}
