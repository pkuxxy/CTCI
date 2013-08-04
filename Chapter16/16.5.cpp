#include<iostream>
using namespace std;
const bool BIG_ENDIAN = false;
const bool LITTLE_ENDIAN = true;
bool is_little_endian()
{
	short int n = 1;
	char* p = (char*)&n;
	return (*p == 0)? BIG_ENDIAN:LITTLE_ENDIAN;
}
int main()
{
	cout<<is_little_endian()<<endl;
	system("pause");
	return 0;
}