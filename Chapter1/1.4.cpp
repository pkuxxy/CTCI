#include<iostream>
using namespace std;
bool isAnagram(char *s1, char *s2)
{
	if(s1 == NULL && s2 == NULL)
		return true;
	else if (s1 == NULL || s2 == NULL)
		return false;
	int len1 = strlen(s1);
	int len2 = strlen(s2);
	if(len1 != len2)
		return false;

	int ch[256];
	memset(ch,0,256*sizeof(int));
	int i;
	for(i = 0 ;i < len1;i++)
	{
		ch[s1[i]]++;
	}
	for(i = 0 ;i < len2;i++)
	{
		ch[s2[i]]--;
		if(ch[s2[i]] < 0)
			return false;
	}
	return true;
}
int main()
{
	char a[] = "abcdefg";
	char b[] = "bdfaceg";
	cout<<isAnagram(a,b)<<endl;
	system("pause");
	return 0;
}