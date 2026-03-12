#include <iostream>
#include <string>

#include "ContactInfo.h"

using namespace std;

Info::Info() {
    this->name = "No Name Set";
    this->value = "No Value Set";
    this->next = nullptr;
}

Info::Info(std::string name, std::string value, Info *next) {
    this->name = name;
    this->value = value;
    this->next = next;
}

Contact::Contact() {
    this->first = "No First Set";
    this->last = "No Last Set";
    this->next = nullptr;
    this->headInfoList = nullptr;
}

Contact::Contact(std::string first, std::string last, Contact *next) {
    this->first = first;
    this->last = last;
    this->next = next;
    this->headInfoList = nullptr;
}

ContactList::ContactList() {
    this->headContactList = nullptr;
    this->count = 0;
}

int ContactList::getCount() {
    return this->count;
}

Contact* findContact(Contact* headContactList, std::string first, std::string last){
    if(!headContactList) return nullptr;
    Contact* curr=headContactList;
    while(curr){
        if(curr->first==first&&curr->last==last){
            return curr;
        }
        curr=curr->next;
    }   
    return nullptr;
}

Info* findInfo(Info* headInfoList, string infoName){
    if(!headInfoList) return 0;
    Info* curr=headInfoList;
    while(curr){
        if(curr->name==infoName){
            return curr;
        }
        curr=curr->next;
    }
    return nullptr;
}
int compareContacts(const Contact* c1, const Contact* c2);
int compareInfo(const Info* i1, const Info* i2);


// print the specified contact and its information
// 1. return false and print nothing if the contact is not in the list
// 2. otherwise return true and print the contact
bool ContactList::printContact(std::ostream &os, std::string first, std::string last) {
    if(!headContactList) return false;
    Contact* curr = findContact(headContactList, first, last);
    if(!curr) return false;
    os<<"Contact Name: "<<curr->first<<" "<<curr->last<<endl;
    Info* infoCurr=curr->headInfoList;
         while(infoCurr){
            os<<"    "<<infoCurr->name<<" | "<<infoCurr->value<<endl;
            infoCurr=infoCurr->next;
         }
         return true;   
    }


// print all contacts and their information
// print nothing if the list is empty
void ContactList::print(std::ostream &os) {
    if(!headContactList) return;
    Contact* curr=headContactList;
    while(curr){
            printContact(os, curr->first, curr->last);
            curr=curr->next;
    }
}

// add a contact to the back of the list
// 1. return false and do nothing if the contact is already in the list
// 2. otherwise return true and add the contact to the back of the list
// - do not forget to update count
bool ContactList::addContact(std::string first, std::string last) {
    if(findContact(headContactList, first, last)) return false;

    Contact* newNode = new Contact(first, last);
    if(!headContactList){
        headContactList = newNode;
        count++;
        return true;
    }

    Contact* curr = headContactList;
    while(curr->next){
        curr = curr->next;
    }
    curr->next = newNode;
    count++;
    return true;
}

// add info to the back of a contact's info list
// 1. return false and do nothing if the contact is not in the list
// 2. if the infoName is already in the info list, update the infoValue and return true
// 3. otherwise add the info to the back of the contact's list and return true
bool ContactList::addInfo(std::string first, std::string last, std::string infoName, std::string infoVal) {
    Contact* contact = findContact(headContactList, first, last);
    if(!contact) return false;

    if(!contact->headInfoList){
        contact->headInfoList = new Info(infoName, infoVal);
        return true;
    }

    Info* curr = contact->headInfoList;
    while(curr){
        if(curr->name == infoName){
            curr->value = infoVal;
            return true;
        }
        if(!curr->next) break;
        curr = curr->next;
    }

    curr->next = new Info(infoName, infoVal);
    return true;
}

// add a contact to the list in ascending order by last name
//     if last names are equal, then order by first name ascending
// 1. return false and do nothing if the contact is already in the list
// 2. otherwise return true and add the contact to the list
// - do not forget to update count
// - compare strings with the built-in comparison operators: <, >, ==, etc.
// - a compare method/function is recommended
bool ContactList::addContactOrdered(std::string first, std::string last) {
    Contact* newNode = new Contact(first, last);

    if(!headContactList){
        headContactList = newNode;
        count++;
        return true;
    }

    if(compareContacts(newNode, headContactList) == 0){
        delete newNode;
        return false;
    }

    if(compareContacts(newNode, headContactList) < 0){
        newNode->next = headContactList;
        headContactList = newNode;
        count++;
        return true;
    }

    Contact* curr = headContactList;
    while(curr->next && compareContacts(newNode, curr->next) > 0){
        curr = curr->next;
    }

    if(curr->next && compareContacts(newNode, curr->next) == 0){
        delete newNode;
        return false;
    }

    newNode->next = curr->next;
    curr->next = newNode;
    count++;
    return true;
}

// add info to a contact's info list in ascending order by infoName
// 1. return false and do nothing if the contact is not in the list
// 2. if the infoName is already in the info list, update the infoValue and return true
// 3. otherwise add the info to the contact's list and return true
bool ContactList::addInfoOrdered(std::string first, std::string last, std::string infoName, std::string infoVal) {
    Contact* contact = findContact(headContactList,first, last);
    if(!contact) return false;

    Info* newNode = new Info(infoName, infoVal);

    if(!contact->headInfoList){
        contact->headInfoList = newNode;
        return true;
    }

    if(compareInfo(newNode, contact->headInfoList) == 0){
        contact->headInfoList->value = infoVal;
        delete newNode;
        return true;
    }

    if(compareInfo(newNode, contact->headInfoList) < 0){
        newNode->next = contact->headInfoList;
        contact->headInfoList = newNode;
        return true;
    }

    Info* curr = contact->headInfoList;
    while(curr->next && compareInfo(newNode, curr->next) > 0){
        curr = curr->next;
    }

    if(curr->next && compareInfo(newNode, curr->next) == 0){
        curr->next->value = infoVal;
        delete newNode;
        return true;
    }

    newNode->next = curr->next;
    curr->next = newNode;
    return true;
}

// remove the contact and its info from the list
// 1. return false and do nothing if the contact is not in the list
// 2. otherwise return true and remove the contact and its info
// - do not forget to update count
bool ContactList::removeContact(std::string first, std::string last) {
    if(!headContactList) return false;

    if(headContactList->first == first && headContactList->last == last){
        Contact* toDelete = headContactList;
        headContactList = headContactList->next;
        delete toDelete;
        count--;
        return true;
    }

    Contact* prev = headContactList;
    Contact* curr = headContactList->next;
    while(curr){
        if(curr->first==first && curr->last==last){
            prev->next=curr->next;
            delete curr;
            count--;
            return true;
        }
        prev=curr;
        curr=curr->next;
    }
    return false;
}

// remove the info from a contact's info list
// 1. return false and do nothing if the contact is not in the list
// 2. return false and do nothing if the info is not in the contact's info list
// 3. otherwise return true and remove the info from the contact's list
bool ContactList::removeInfo(std::string first, std::string last, std::string infoName) {
    Contact* contact = findContact(headContactList, first, last);
    if(!contact) return false;
    if(!contact->headInfoList) return false;

    if(contact->headInfoList->name == infoName){
        Info* toDelete = contact->headInfoList;
        contact->headInfoList = contact->headInfoList->next;
        delete toDelete;
        return true;
    }

    Info* prev = contact->headInfoList;
    Info* infoCurr = contact->headInfoList->next;
    while(infoCurr){
        if(infoCurr->name == infoName){
            prev->next = infoCurr->next;
            delete infoCurr;
            return true;
        }
        prev = infoCurr;
        infoCurr = infoCurr->next;
    }
    return false;
}

// destroy the list by removing all contacts and their infos
ContactList::~ContactList() {
    if(!headContactList) return;
    clear();
}

// deep copy the source list
// - do not forget to update count
ContactList::ContactList(const ContactList &src) {
    headContactList = nullptr;
    count = 0;

    Contact* source = src.headContactList;
    Contact* tail = nullptr;
    while(source){
        Contact* newContact = new Contact(source->first, source->last);
        if(!headContactList){
            headContactList = newContact;
            tail = newContact;
        }
        else {
            tail->next = newContact;
            tail = newContact;
        }

        Info* infoSource = source->headInfoList;
        Info* infoTail = nullptr;
        while(infoSource){
            Info* newInfo = new Info(infoSource->name, infoSource->value);
            if(!newContact->headInfoList){
                newContact->headInfoList = newInfo;
                infoTail = newInfo;
            }
            else {
                infoTail->next = newInfo;
                infoTail = newInfo;
            }
            infoSource = infoSource->next;
        }

        count++;
        source = source->next;
    }
}

// remove all contacts and their info then deep copy the source list
// - do not forget to update count
const ContactList &ContactList::operator=(const ContactList &src) {
    if (this != &src) {
        clear();

        Contact* source = src.headContactList;
        Contact* tail = nullptr;
        while(source){
            Contact* newContact = new Contact(source->first, source->last);
            if(!headContactList){
                headContactList = newContact;
                tail = newContact;
            }
            else {
                tail->next = newContact;
                tail = newContact;
            }

            Info* infoSource = source->headInfoList;
            Info* infoTail = nullptr;
            while(infoSource){
                Info* newInfo = new Info(infoSource->name, infoSource->value);
                if(!newContact->headInfoList){
                    newContact->headInfoList = newInfo;
                    infoTail = newInfo;
                }
                else {
                    infoTail->next = newInfo;
                    infoTail = newInfo;
                }
                infoSource = infoSource->next;
            }

            count++;
            source = source->next;
        }
    }  
    return *this;
}

Contact::~Contact(){
    if(!headInfoList) return;
    Info* curr=headInfoList;
    Info dummy;
    dummy.next=curr;
    Info* prev=&dummy;
    while(curr){
        prev=curr;
        curr=curr->next;
        delete prev;
    }

}

Contact::Contact(const Contact* src){
    this->first = src ? src->first : "No First Set";
    this->last = src ? src->last : "No Last Set";
    this->next = nullptr;
    this->headInfoList = nullptr;

    if(!src || !src->headInfoList) return;

    Info* source = src->headInfoList;
    Info* tail = nullptr;
    while(source){
        Info* newNode = new Info(source->name, source->value);
        if(!headInfoList){
            headInfoList = newNode;
            tail = newNode;
        }
        else {
            tail->next = newNode;
            tail = newNode;
        }
        source = source->next;
    }
}

void ContactList::clear(){
    Contact* curr=headContactList;
    while(curr){
        Contact* after=curr->next;
        delete curr;
        curr=after;
    }
    headContactList=nullptr;
    count=0;
}

int compareContacts(const Contact* a, const Contact* b) {
    if(a->last < b->last) return -1;
    if(a->last > b->last) return 1;
    if(a->first < b->first) return -1;
    if(a->first > b->first) return 1;
    return 0;
}

int compareInfo(const Info* a, const Info* b) {
    if(a->name < b->name) return -1;
    if(a->name > b->name) return 1;
    return 0;
}