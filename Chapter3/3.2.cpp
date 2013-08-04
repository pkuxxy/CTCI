#include<iostream>
using namespace std;
const int stack_size = 100;
class StackWithMin
{
private:
	int data[stack_size];
	int min[stack_size];
	int topData;
	int topMin;
public:
	StackWithMin()
	{
		topData = -1;
		topMin = -1;
	}
	void push(int data)
	{
		if(topData > stack_size - 1)
		{
			cerr<<"Stack is full!"<<endl;
			return;
		}
		topData ++;
		this->data[topData] = data;
		if(topMin >= 0 && min[topMin] < data)
			return;
		topMin ++;
		min[topMin] = data;
	}
	int pop()
	{
		if(topData < 0 )
		{
			cerr<<"Stack is empty!"<<endl;
			return -1;
		}

		int data = this->data[topData];
		topData --;
		if(min[topMin] >= data)
			topMin --;
		return data;
	}
	int getMin()
	{
		if(topMin < 0)
		{
			cerr<<"Stack is empty!"<<endl;
			return -1;
		}
		return min[topMin];
	}
};

int main()
{
	StackWithMin stack;
	stack.push(4);
	stack.push(5);
	stack.push(2);
	stack.push(7);
	cout<<stack.getMin()<<endl;
	cout<<stack.pop()<<endl;
	cout<<stack.getMin()<<endl;
	cout<<stack.pop()<<endl;
	cout<<stack.getMin()<<endl;
	system("pause");
	return 0;
}