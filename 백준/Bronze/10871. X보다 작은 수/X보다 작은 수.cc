/******************************************************************************

                              Online C++ Compiler.
               Code, Compile, Run and Debug C++ program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <iostream>

int main()
{
    int x,y,num;
    std::cin>>x>>y;
    
    for(int i=0;i<x;i++){
         std::cin>>num;
        if(num<y){
              std::cout<<num<<' ';
        }
      
    }
    //std::cout<<"Hello World";

    return 0;
}