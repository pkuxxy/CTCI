#include<iostream>
#include<stack>
#include<vector>
using namespace std;
class SetOfStacks
{
private:
	const static int CAPACITY = 3;
	const static int NAN = -1000000000;
	vector<vector<int>> stacks;
public:
	void push(int data)
	{
		if(stacks.empty() || stacks[stacks.size()-1].size() == CAPACITY)
		{
			vector<int> newstack;
			stacks.push_back(newstack);
		}
		stacks[stacks.size()-1].push_back(data);
	}
	int pop()
	{
		if(stacks.empty())
		{
			cerr<<"The stack is empty!"<<endl;
			return NAN;
		}
		int data = stacks[stacks.size()-1].back();
		stacks[stacks.size()-1].pop_back();
		if(stacks[stacks.size()-1].empty())
			stacks.pop_back();
		return data;
	}
	int popAt(unsigned int index)
	{
		if(index < 0 || index >= stacks.size())
		{
			cerr<<"No such stack!"<<endl;
			return NAN;
		}
		int data = stacks[index].back();
		stacks[index].pop_back();
		for(unsigned i = index+1; i < stacks.size(); i++)
		{
			stacks[i-1].push_back(stacks[i].front());
			stacks[i].erase(stacks[i].begin());
		}
		if(stacks[stacks.size()-1].empty())
			stacks.pop_back();
		return data;
	}
	bool empty()
	{
		return stacks.empty();
	}
};
int main()
{
	SetOfStacks stacks;
	for(int i = 0; i < 10; i++)
	{
		cout<<"SetOfStacks.push("<<i<<");"<<endl;
		stacks.push(i);
	}
	while(!stacks.empty())
	{
		cout<<"SetOfStacks.pop() = "<<stacks.pop()<< ";"<<endl;
	}

	for(int i = 0; i < 10; i++)
	{
		cout<<"SetOfStacks.push("<<i<<");"<<endl;
		stacks.push(i);
	}
	while(!stacks.empty())
	{
		cout<<"SetOfStacks.popAt(" <<0 <<") = "<< stacks.popAt(0)<< ";"<<endl;
	}
	getchar();
}