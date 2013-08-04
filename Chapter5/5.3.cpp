#include<iostream>
#include<string>
#include<string.h>
using namespace std;
string toBinaryString(int data)
{
	string ret;
	while(data > 0)
	{
		char bit = (data & 1) + '0';
		ret.insert(0, 1, bit);
		data >>= 1;
	}
	return ret;
}
void swap(string& str, int i, int j)
{
	char tmp = str[i];
	str[i] = str[j];
	str[j] = tmp;
}
void reverse(string& str, int start, int end)
{
	while(start < end)
	{
		char tmp = str[start];
		str[start] = str[end];
		str[end] = str[start];
		start++;
		end--;
	}
}
int bstrToInt(string& str)
{
	int ret = 0;
	for(int i = 0; i < str.size(); i++)
	{
		ret *= 2;
		ret += str[i] - '0';
	}
	return ret;
}
int getNext(int data)
{
	string bstr = toBinaryString(data);
	bool find = false;
	int index0 = 0;
	int index1 = 0;
	int i;
	for(i = (int)bstr.size()-1; i >= 0; i--)
	{
		if(bstr[i] == '1' && !find)
		{
			find = true;
			index1 = i;
		}
		if(bstr[i] == '0' && find)
		{
			index0 = i;
			break;
		}
	}
	if(i < 0)
	{
		if(bstr.size() < 32)
		{
			bstr.insert(0, 1, '0');
			index0 = 0;
			index1 += 1;
		}
		else
		{
			cerr<<"The data is the bigest, no next num!"<<endl;
			return 0;
		}
	}
	swap(bstr, index0, index1);
	reverse(bstr, index0+1, bstr.size()-1);
	return bstrToInt(bstr);
}
int getPre(int data)
{
	string bstr = toBinaryString(data);
	bool find = false;
	int index0 = 0;
	int index1 = 0;
	int i;
	for(i = (int)bstr.size()-1; i >= 0; i--)
	{
		if(bstr[i] == '0' && !find)
		{
			find = true;
			index0 = i;
		}
		if(bstr[i] == '1' && find)
		{
			index1 = i;
			break;
		}
	}
	if(i < 0)
	{
		cerr<<"The data is the bigest, no next num!"<<endl;
		return 0;
	}
	swap(bstr, index0, index1);
	reverse(bstr, index1+1, bstr.size()-1);
	return bstrToInt(bstr);
}
int main()
{
	int data = 6;
	cout<<getNext(data)<<endl;
	cout<<getPre(data)<<endl;
	getchar();
}