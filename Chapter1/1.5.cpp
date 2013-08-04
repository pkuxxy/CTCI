#include<iostream>
using namespace std;
#define MAX_LEN 1000
char d[MAX_LEN];
char *replaceSpace(char *s)
{
	if(!s)
		return NULL;
	int len = strlen(s);
	int spaceCount = 0;
	for(int i = 0 ;i < len ;i++)
	{
		if(s[i] == ' ')
			spaceCount ++;
	}
	int newLen = len + spaceCount * 2 + 1;
	if(newLen > MAX_LEN)
		return NULL;
	int tail = 0;
	for(int i = 0 ;i < len ;i++)
	{
		if(s[i] == ' ')
		{
			d[tail++] = '%';
			d[tail++] = '2';
			d[tail++] = '0';
		}
		else
			d[tail++] = s[i];
	}
	d[tail] = '\0';
	return d;
}
int main()
{
	char str[] = "I am a student";
	char *d = replaceSpace(str);
	if(d)
		cout<<replaceSpace(str)<<endl;
	system("pause");
	return 0;
}