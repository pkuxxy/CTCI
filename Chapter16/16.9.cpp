#include<stdlib.h>
void* aligned_malloc(size_t length, size_t alignment)
{
	void* p1;
	void** p2;
	size_t offset = alignment -1 + sizeof(void*); 
	if((p1 = (void*)malloc(length+offset)) == NULL)
		return NULL;
	p2 = (void**)((((size_t)p1)+offset) & ~(alignment - 1));
	p2[-1] = p1;
	return p2;
}
void aligned_free(void* p)
{
	free(((void**)p)[-1]);
}