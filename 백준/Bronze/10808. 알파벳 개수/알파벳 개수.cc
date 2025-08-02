/******************************************************************************

                              Online C++ Compiler.
               Code, Compile, Run and Debug C++ program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <iostream>
using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    string str;
    cin>>str;
    
    
    for(char a='a';a<='z';a++){
        int cnt =0;
        for(auto c: str){
            if(a==c) cnt++;
        }
        cout<<cnt<<' ';
    }

    return 0;
}