#include<iostream>
#include<cstring>
using namespace std;
bool isSubstring(string s, string d)
{
	if(s.find(d) != string::npos)
		return true;
	return false;
}
bool isRotation(string s, string d)
{
	int len = s.length();
	if(len == d.length() && len > 0)
	{
		string ss = s.append(s);
		return isSubstring(ss, d);
	}
	return false;
}
int main()
{
	string s = "abcde";
	string d = "cdeab";
	cout<<isRotation(s,d)<<endl;
	system("pause");
	return 0;
}
