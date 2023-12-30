## Final Review on Data Structure and Algorithm


#### Overview
- ##### Data structure
    -	Array
    -	Link-List
    -	Stack
    -	Queue
    -	Heap
    -	Tree
    -	HashMap
    -	Graphs

- ##### Algorithm
    -	Time complexity
    -	Recursion
    -	Sorting
    -	Mathematical induction

#### Array
-	Array is a basic Data structure that can help us finish various kinds of structures. The most significant feature of Array is the index. From 0 – n – 1 to represent 1 – n.
-	Normally, if we have the index, the search efficiency will be `O(1)`. And if we don’t have the index, and we want search an element in arrays, the time complexity will be `O(n)` when condition is worst. 
-	By using Array, we can finish many other Data stuctures.

<br>

#### LinkList
- Just like arrays, link list is also a great data structure that can help us finish other data structures. They are basic ones.
- The building process of Link list is simple.
    ```python
    class Node:
        def __init__(self):
            self.elm = None
            self.next = None
    class LList:
        def __init__(self):
            self.head = self.dummy = Node(None)
    ```
    You can see that we use 2 classes to define a link list, and we will use it in the following part too since for the link-list and other structures made of link-list, nodes are necessary.
- The array and link list have their different advantages. For link list, if we want search some, we need go along the line to get the answer but if we want to insert or delete something, the operations are easier than arrays since what we need to do is change the point but we need to move lots of elements in arrays.
- Actually, we don't have too much operations about the 2 structures, they are basis and core for the following parts, so let's begin.

#### Stack
- Stack is a traditional structure which we can use it to finish lots of things.
- The most significant feature of Stack is **First in Last out**. So now, check how can we build a Stack using array and list link.
    ```python
    #array implementation
    class Astack:

    def __init__(self):
       self.a = []
    def __bool__(self):
       return self.a != []
    def push(self, x):
       self.a.append(x)
    def pop(self):
       x = self.top()
       del self.a[-1]
       return x
    ```
- We can see that there are 4 main functions of Stack. The first
 is build a Stack, second is check is the stack is empty or not, the third one is add the element at the toppest position of Stack, the fourth is pop the toppest one in Stack.
