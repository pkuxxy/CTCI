#include<iostream>
using namespace std;
const int stack_size = 100;
const int buffer_size = stack_size * 3;
class StackNode
{
public:
	int previous;
	int data;
};

class FreeListNode
{
public:
	int index;
	FreeListNode *next;
	FreeListNode(int index)
	{
		this->index = index;
		next = NULL;
	}
};

class FreeList
{
public:
	FreeListNode *head;
	FreeList()
	{
		head = NULL;
	}
	FreeListNode *append(int index)
	{
		if(!head)
			head = new FreeListNode(index);
		else
		{
			FreeListNode *cur = head;
			while(cur->next != NULL)
				cur = cur->next;
			cur->next = new FreeListNode(index);
		}
		return head;
	}
	int pop()
	{
		if(! isEmpty())
		{
			FreeListNode *first = head;
			head = head->next;
			int index = first->index;
			delete first;
			return index;
		}
		else
			return NULL;
	}
	bool isEmpty()
	{
		return head == NULL;
	}
};

StackNode buffer[buffer_size];
int top[3] = {-1,-1,-1};
FreeList freelist;
int indexUsed = 0;

void initFreeList()
{
	for(int i = 0 ;i < buffer_size; i++)
	{
		freelist.append(i);
	}
}
bool push(int stack_num, int data)
{
	if( stack_num < 0 || stack_num > 2)
	{
		cerr<<"Stack number "<<stack_num<<" is invalid!"<<endl;
		return false;
	}
	if(freelist.isEmpty())
	{
		cerr<<"Stack "<<stack_num<<" is full!"<<endl;
		return false;
	}
	int alloc = freelist.pop();
	int pre = top[stack_num];
	top[stack_num] = alloc;
	buffer[top[stack_num]].previous = pre;
	buffer[top[stack_num]].data = data;
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
	data = buffer[top[stack_num]].data;
	int free = top[stack_num];
	top[stack_num] = buffer[top[stack_num]].previous;
	freelist.append(free);
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
	data = buffer[top[stack_num]].data;
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
	initFreeList();
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