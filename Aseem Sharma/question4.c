//This program finds the product of the greatest common divisors(gcd) of all possible subsets of an array.The time complexity of this program is O(n^2).  

#include<stdio.h>


//This function finds the greatest common divisor(gcd) of two numbers 
int gcd(int a,int b)
{
	int g;
	if(a==b)
		return a;
	else if(a<b)
	{ 
		for(int i=a;i>0;i--)
		{
			if(a%i==0 && b%i==0)
			{
				g=i;
				break;
			}
		}
		return g;
	}
	else if(a>b)
	{
		for(int i=b;i>0;i--)
		{
			if(a%i==0 && b%i==0)
			{
				g=i;
				break;
			}
		}
		return g;
	}
}
//This function calls gcd() function recursively to find gcd of more than two numbers 
int findgcd(int A[], int i,int j)
{
	for(int k=i;k<=j;k++)
	{
		if(i==j)
			return A[i];
		else if(j-i==1)
			return gcd(A[i],A[j]);
		else if(j-i>1)
		{
			int g=gcd(A[i],A[i+1]);
			for(int k=i+2;k<=j;k++)
			{
				int g=gcd(g,A[k]);
			}
			return g;
		}

	}
}

//This function passes the indexes of subsets to the function findgcd()
void subset(int A[],int n)
{ 
	int g=1;
	for(int i=0;i<n;i++)
	{
		for(int j=i;j<n;j++)
		{
		  g*=findgcd(A,i,j);	
		}

	}
	printf("%d",g);
}

//This is the main function
//variable 't' contains no of test cases
//variable 'n' contains the size of the array   
//'A' is an integer array
void main()
{ 
	int t,n,A[1000];
	scanf("%d",&t);
	for(int i=0;i<t;i++)
	{
		scanf("%d",&n);
		for(int i=0;i<n;i++)
		{
			scanf("%d",&A[i]);
		}
		subset(A,n);
	}
}
