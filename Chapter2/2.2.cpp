#include<iostream>
using namespace std;
class Node
{
public :
	int data;
	Node *next;
	Node(int data)
	{
		this->data = data;
		next = NULL;
	}
};
class List
{
public:
	Node *head;
	List()
	{
		head = NULL;
	}
	Node *append(int data)
	{
		if(!head)
			head = new Node(data);
		else
		{
			Node *cur = head;
			while(cur->next != NULL)
				cur = cur->next;
			cur->next = new Node(data);
		}
		return head;
	}
};
int listLength(Node *head)
{
	Node *cur = head;
	int len = 0;
	while(cur)
	{
		len++;
		cur = cur->next;
	}
	return len;
}
Node *nthToLast1(Node *head, int n)
{
	if(n < 1)
		return NULL;
	int len = listLength(head);
	if(len < n)
		return NULL;
	int step = len - n;
	Node *p = head;
	while(step--)
	{
		p = p->next;
	}
	return p;
}
Node *nthToLast2(Node *head, int n)
{
	if(!head || n < 1)
		return NULL;
	Node *p1 = head;
	Node *p2 = head;
	n--;
	while(n--)
	{
		if(!p2)
			return NULL;
		p2 = p2->next;
	}
	while(p2->next != NULL)
	{
		p1 = p1->next;
		p2 = p2->next;
	}
	return p1;
		
}

int main()
{
	List list;
	list.append(1);
	list.append(2);
	list.append(3);
	list.append(4);
	list.append(5);
	cout<<(nthToLast1(list.head, 2))->data<<endl;
	cout<<(nthToLast2(list.head, 2))->data<<endl;
	system("pause");
	return 0;
}