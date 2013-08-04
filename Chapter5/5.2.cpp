#include<iostream>
#include<string>
#include<string.h>
using namespace std;
string binaryString(string& str)
{
	string::size_type index = str.find('.');
	int intpart = 0;
	double decpart = 0;
	if(index == string::npos)
	{
		intpart = atoi(str.c_str());
	}
	else
	{
		intpart = atoi(str.substr(0,index).c_str());
		decpart = atof(str.substr(index).c_str());
	}
	string intstr;
	string decstr;
	while(intpart > 0)
	{
		char num = intpart % 2 + '0';
		intstr.insert(0, 1, num);
		intpart >>= 1;
	}
	while(decstr.size() < 32 && decpart > 0)
	{
		decpart *= 2;
		if(decpart >= 1)
		{
			decstr.append("1");
			decpart -= 1;
		}
		else
			decstr.append("0");
	}
	return intstr+"."+decstr;
}
int main()
{
	string str = "3.5";
	cout<<binaryString(str)<<endl;
	getchar();
}