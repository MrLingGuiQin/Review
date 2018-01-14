// IListAidlInterface.aidl
package com.example.ling.aidlservice;
import  com.example.ling.aidlservice.Person;

// Declare any non-default types here with import statements

interface IListAidlInterface {
// 自定义类型参数需要in / out 表示输入还是输出
List<Person> addPerson( in Person person);
}
