#include<iostream>
#include<stack>
#include<vector>
using namespace std;
class Tower:public stack<int>
{
private:
	int index;
public:
	Tower(int i)
	{
		index = i;
	}
	void push(int data)
	{
		if(!this->empty() && this->top() <= data)
		{
			cerr<<"Can't push!"<<endl;
			return;
		}
		stack<int>::push(data);
	}
	void moveTopTo(Tower& dest)
	{
		if(this->empty())
		{
			cerr<<"This stack is empty!"<<endl;
			return;
		}
		dest.push(this->top());
		this->pop();
		cout<<"Move plate from Tower "<<index<<" to Tower "<<dest.index<<"."<<endl;
	}
	void moveDisks(int n, Tower& dest, Tower& tmp)
	{
		if(n < 1)
			return;
		moveDisks(n-1, tmp, dest);
		moveTopTo(dest);
		tmp.moveDisks(n-1,dest,*this);
	}
};
int main()
{
	vector<Tower> v;
	for(int i = 1; i <= 3; i++)
	{
		v.push_back(Tower(i));
	}
	int n = 4;
	for(int i = n; i >= 1; i--)
	{
		v[0].push(i);
	}
	v[0].moveDisks(n, v[2], v[1]);
	getchar();
}