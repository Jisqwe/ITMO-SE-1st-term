#include <iostream>

using namespace std;
int area(int a, int b){
    return a * b;
}
int perimetr(int a, int b){
    return (a + b) * 2;
}
int delta(int a, int b){
  return (abs(a - b));
}
int main(){
    int a, b;
    cin >> a >> b;
    cout << area(a, b) << endl;
    cout << perimetr(a, b) << endl;
}