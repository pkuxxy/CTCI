#include <iostream>
#include<math.h>
#include<queue>
#include<stack>
using namespace std;
class MyQueue
{
private:
	stack<int> s1;
	stack<int> s2;
public:
	void push(int data)
	{
		s1.push(data);
	}
	void pop()
	{
		if(s2.empty())
		{
			while(!s1.empty())
			{
				s2.push(s1.top());
				s1.pop();
			}
		}
		if(s2.empty())
		{
			cerr<<"The stack is empty!"<<endl;
			return;
		}
		s2.pop();
	}
	int front()
	{
		if(s2.empty())
		{
			while(!s1.empty())
			{
				s2.push(s1.top());
				s1.pop();
			}
		}
		if(s2.empty())
		{
			cerr<<"The stack is empty!"<<endl;
			return;
		}
		return s2.top();
	}
	bool empty()
	{
		while(!s1.empty())
		{
			s2.push(s1.top());
			s1.pop();
		}
		return s2.empty();
	}
}