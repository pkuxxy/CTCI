#include<iostream>
#include<cstring>
#include<fstream>
using namespace std;
void printLaskKLines()
{
	const int k = 10;
	char queue[k][1024];
	ifstream in("input.txt");
	int line = 0;
	while(in.good() && !in.eof())
	{
		in.getline(queue[line%k], 1024);
		line ++;
	}
	int start, count;
	if(line < k)
	{
		start = 0;
		count = line;
	}
	else
	{
		start = line % k;
		count = k;
	}
	for(int i = 0; i < count; i++)
	{
		cout<<queue[(start+i)%k]<<endl;
	}
	
}