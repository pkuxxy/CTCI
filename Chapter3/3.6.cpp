#include <iostream>
#include<math.h>
#include<queue>
#include<stack>
using namespace std;
void sortStack(stack<int>& s)
{
	stack<int> tmp;
	while(!s.empty())
	{
		int top = s.top();
		s.pop();
		if(tmp.empty() || top <= tmp.top())
		{
			tmp.push(top);
		}
		else
		{
			while(!tmp.empty() && top > tmp.top())
			{
				s.push(tmp.top());
				tmp.pop();
			}
			tmp.push(top);
		}
	}
	while(!tmp.empty())
	{
		s.push(tmp.top());
		tmp.pop();
	}
}
void printStack(stack<int> s)
{
	while(!s.empty())
	{
		cout<<s.top()<<" ";
		s.pop();
	}
	cout<<endl;
}
int main()
{
	stack<int> s;
	s.push(5);
	s.push(4);
	s.push(9);
	s.push(3);
	s.push(7);
	s.push(6);
	sortStack(s);
	printStack(s);
	getchar();
}