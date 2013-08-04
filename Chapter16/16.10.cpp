#include<stdlib.h>
int** my2DAlloc(int rows, int cols)
{
	int fstD = rows * sizeof(int*);
	int sndD = rows * cols * sizeof(int);
	int** arr = (int**)malloc(fstD + sndD);
	int* offset = (int*)(arr + fstD);
	for(int i = 0; i < rows; i++)
	{
		arr[i] = offset + i * cols;
	}
	return arr;
}