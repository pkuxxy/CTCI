#include<iostream>
using namespace std;
bool isUniqueStr1(char str[])
{
	int len = strlen(str);
	for(int i = 0;i<len;i++)
	{
		for(int j = i+1;j<len;j++)
		{
			if(str[i] == str[j])
				return false;
		}
	}
	return true;
}
bool isUniqueStr2(char str[])
{
	int len = strlen(str);
	char tag[32];
	memset(tag,0,sizeof(char) * 32);
	for(int i = 0;i<len;i++)
	{
		if(tag[str[i]/8] & (1<<str[i]%8))
			return false;
		tag[str[i]/8] |= 1<<str[i]%8;
	}
	return true;
}
int main()
{
	char str[] = "abcdefgb";
	cout<<isUniqueStr1(str)<<endl;
	cout<<isUniqueStr2(str)<<endl;
	system("pause");
}