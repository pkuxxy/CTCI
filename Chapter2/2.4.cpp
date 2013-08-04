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
Node *addList(Node *head1, Node *head2)
{
	//if(head1 == NULL || head2 == NULL)
	Node *p1 = head1;
	Node *p2 = head2;
	List list;
	int carry = 0,sum;
	while(p1 != NULL && p2 != NULL)
	{
		sum = p1->data + p2->data + carry;
		carry = sum / 10;
		sum %= 10;
		list.append(sum);
		p1 = p1->next;
		p2 = p2->next;
	}
	if(p1 == NULL)
		p1 = p2;
	while(p1)
	{
		sum = p1->data + carry;
		carry = sum / 10;
		sum %= 10;
		list.append(sum);
		p1 ->next;
	}
	if(carry > 0)
		list.append(carry);
	return list.head;

		
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
	List list1;
	list1.append(1);
	list1.append(2);
	list1.append(3);
	list1.append(4);
	list1.append(5);

	List list2;
	list2.append(9);
	list2.append(9);
	list2.append(9);
	list2.append(9);
	list2.append(9);

	printList(list1.head);
	printList(list2.head);
	Node *sum = addList(list1.head,list2.head);
	printList(sum);
	system("pause");
	return 0;
}