#include<iostream>
using namespace std;
void removeDup(char *str)
{
	if(!str)
		return;
	int len = strlen(str);
	if(len < 2)
		return;
	int tail = 1;
	int i,j;
	for(i = 1;i<len;i++)
	{
		for(j = 0;j<tail;j++)
		{
			if(str[i] == str[j])
				break;
		}
		if(j == tail)
		{
			str[tail] = str[i];
			tail ++;
		}
	}
	str[tail] = '\0';
}
int main()
{
	char a1[] = "abcd";
	removeDup(a1);
	cout<<"a1 = "<<a1<<endl;

	char a2[] = "aaaa";
	removeDup(a2);
	cout<<"a2 = "<<a2<<endl;

	char a3[] = "aabb";
	removeDup(a3);
	cout<<"a3 = "<<a3<<endl;

	char a4[] = "abab";
	removeDup(a4);
	cout<<"a4 = "<<a4<<endl;

	char a5[] = "a";
	removeDup(a5);
	cout<<"a5 = "<<a5<<endl;

	char *a6 = NULL;
	removeDup(a6);
	if(a6)
		cout<<"a6 = "<<a6<<endl;
	system("pause");
	return 0;
}