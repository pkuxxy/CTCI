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
void removeDup(Node *head)
{
	if(!head)
		return;
	Node *pre = head;
	Node *tail = head->next;
	while(tail)
	{
		Node *cur = head;
		while(cur != tail)
		{
			if(cur->data == tail->data)
			{
				Node *tmp = tail->next;
				pre->next = tmp;
				delete tail;
				tail = tmp;
				break;
			}
			cur = cur->next;
		}
		if(cur == tail)
		{
			pre = tail;
			tail = tail->next;
		}
	}
}
void printList(Node *head)
{
	Node *cur = head;
	while(cur)
	{
		cout<<cur->data<<" ";
		cur = cur->next;
	}
	cout<<endl<<endl;
}
int main()
{
	List list;
	list.append(1);
	list.append(2);
	list.append(2);
	list.append(3);
	list.append(3);
	printList(list.head);
	removeDup(list.head);
	printList(list.head);
	system("pause");
	return 0;
}