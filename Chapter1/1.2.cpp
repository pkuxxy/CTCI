#include<iostream>
using namespace std;
void reverse(char *str)
{
	if(!str)
		return;
	char *end=str;
	while(*end)
		end++;
	end--;
	char tmp;
	while(end > str)
	{
		tmp = *str;
		*str++ = *end;
		*end-- = tmp;
	}
}
int main()
{
	char str[]="abcd";
	reverse(str);
	cout<<str<<endl;
	system("pause");
	return 0;
}