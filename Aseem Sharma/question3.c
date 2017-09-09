//This program implements an algorithm of a magic trick.The time complexity of this program is O(n^3).

#include<stdio.h>
#include<string.h>
//This is a function to reverse an array from index i to n
void reverse(int L[],int n,int i)
{
	while(i<n-1)
	{
		int temp=L[i];
		L[i]=L[n-1];
		L[n-1]=temp;
		i++;
		n--;
	}
}

//This is the main function
//'L' is an array that contains a list of integers
//'a','b','c' are integer variables
//variable 'n' is the size of the list
//variable 't' denotes no of test cases  
int main()
{
	int L[1000];
	int a,b,c,n,t;
	char s[1000];
	scanf("%d",&t);
	for(int i=0;i<t;i++)
	{	
		scanf("%d",&n);
		for(int i=0;i<n;i++)
		{
			scanf("%d",&L[i]);
		}
		scanf("%d",&a);
		scanf("%d",&b);
		scanf("%d",&c);
		scanf("%s",s);
		for(int i=0;i<n;i++)
		{
			if(s[i]=='R')
			reverse(L,n,i);                            //Call to reverse() function
			else if(s[i]=='A')
			{
				for(int j=i;j<n;j++)
				{
					L[j]=L[j]+a;		   //adding 'a' to all the values of the array 'L' after index 'i'	
				}
			}
			else if(s[i]=='M')
			{
				for(int j=i;j<n;j++)
				{
					L[j]=L[j]*b;		    //multiplying 'b' to all the values of the array 'L' after index 'i'
				}
			}
		}

		for(int i=0;i<n;i++)
		{
			L[i]=L[i]%c;  				   //Moduling all the values of 'L' by 'c'
		}
		for(int i=0;i<n;i++)
		{
			printf("%d",L[i]);
		}
	}
}
