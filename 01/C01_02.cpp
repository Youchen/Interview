//
//  main.cpp
//  _02
//
//  Created by Youchen Ren on 9/15/14.
//  Copyright (c) 2014 Youchen Ren. All rights reserved.
//

#include <iostream>
#include <string>
#include <cstring>
using namespace std;

void reverse(char* str) {
    char* end = str;
    char temp;
    if (str) {
        while (*end) {
            ++end;
        }
        --end;
        while (str < end) {
            temp = *str;
            *str = *end;
            *end = temp;
            ++str;
            --end;
        }
    }
}

int main(int argc, const char * argv[]) {

    string str = "Hello World!";
    
//    char* charP = str;
    char* charP = (char *)alloca(str.size() + 1);
    memcpy(charP, str.c_str(), str.size() + 1);

    reverse(charP);
    cout << *charP << endl;
    
    return 0;
}

