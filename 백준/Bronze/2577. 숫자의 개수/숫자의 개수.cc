/******************************************************************************

                              Online C++ Compiler.
               Code, Compile, Run and Debug C++ program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <iostream>
#include <stdio.h>
using namespace std;

int num[10];
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int a,b,c;

    
    cin >> a >> b >> c;
    int ans = a*b*c;
    int quo=ans;
    
    while(quo>0){
        int c = quo%10;
        quo = quo/10;
        //printf(" %d \n",c);
        num[c]++;
    }
    
    for(int i=0;i<10;i++){
        cout << num[i] << '\n';
    }
    
    return 0;
}