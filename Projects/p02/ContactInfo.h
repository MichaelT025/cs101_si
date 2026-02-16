#ifndef _ContactInfo_H_
#define _ContactInfo_H_

#include <iostream>
#include <string>

class Info {
public:
    std::string name;
    std::string value;
    Info *next;

    Info();
    Info(const Info &src);
    Info(std::string name, std::string value, Info *next = nullptr);
};

class Contact {
public:
    std::string first;
    std::string last;
    Contact *next;
    Info *headInfoList;

    Contact();
    ~Contact();
    Contact(const Contact *src);
    Contact(std::string first, std::string last, Contact *next = nullptr);
};

class ContactList {
private:
    Contact *headContactList;
    int count;
public:
    ContactList();

    int getCount();
    
    bool printContact(std::ostream &os, std::string first, std::string last);
    void print(std::ostream &os);

    bool addContact(std::string first, std::string last);
    bool addInfo(std::string first, std::string last, std::string infoName, std::string infoVal);

    bool addContactOrdered(std::string first, std::string last);
    bool addInfoOrdered(std::string first, std::string last, std::string infoName, std::string infoVal);
    
    bool removeContact(std::string first, std::string last);
    bool removeInfo(std::string first, std::string last, std::string infoName);

    ~ContactList();
    ContactList(const ContactList &src);
    const ContactList &operator=(const ContactList &src);
    void clear();
};

#endif
