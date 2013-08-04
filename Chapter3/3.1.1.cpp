#include<iostream>
using namespace std;
const int stack_size = 100;
const int buffer_size = stack_size * 3;
int buffer[buffer_size];
int top[3] = {-1,-1,-1};
bool push(int stack_num, int data)
{
	if( stack_num < 0 || stack_num > 2)
	{
		cerr<<"Stack number "<<stack_num<<" is invalid!"<<endl;
		return false;
	}
	if(top[stack_num] > (stack_size -1))
	{
		cerr<<"Stack "<<stack_num<<" is full!"<<endl;
		return false;
	}
	int index = stack_num * stack_size + (++top[stack_num]);
	buffer[index] = data;
	return true;
}

bool pop(int stack_num, int &data)
{
	if( stack_num < 0 || stack_num > 2)
	{
		cerr<<"Stack number "<<stack_num<<" is invalid!"<<endl;
		return false;
	}
	if(top[stack_num] < 0)
	{
		cerr<<"Stack "<<stack_num<<" is empty!"<<endl;
		return false;
	}
	int index = stack_num * stack_size + (top[stack_num]--);
	data = buffer[index];
	return true;
}

bool peek(int stack_num, int &data)
{
	if( stack_num < 0 || stack_num > 2)
	{
		cerr<<"Stack number "<<stack_num<<" is invalid!"<<endl;
		return false;
	}
	if(top[stack_num] < 0)
	{
		cerr<<"Stack "<<stack_num<<" is empty!"<<endl;
		return false;
	}
	int index = stack_num * stack_size + top[stack_num];
	data = buffer[index];
	return true;
}

bool isEmpty(int stack_num)
{
	if( stack_num < 0 || stack_num > 2)
	{
		cerr<<"Stack number "<<stack_num<<" is invalid!"<<endl;
		return false;
	}
	if(top[stack_num] < 0)
		return true;
	return false;
}
int main()
{
	push(1,1);
	push(1,2);
	push(1,3);
	int data;
	if(pop(1,data))
		cout<<data<<endl;
	if(peek(1,data))
		cout<<data<<endl;
	system("pause");
	return 0;

}