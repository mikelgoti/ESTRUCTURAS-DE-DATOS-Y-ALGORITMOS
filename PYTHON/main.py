class Node:
    def __init__(self, data: int):
        self.data = data
        self.next = next

    def __str__(self):
        return str(self.data)


class Scll:
    def __init__(self, name: str):
        self.name = name
        self.head = None
        self.tail = None
        self.size = 0

    def printlist(self):
        print(self.name)
        temp = self.head

        while temp is not None:
            if temp.next is None:
                print(str(temp))
                break
            else:
                print(str(temp) + " -> ", end='')
                temp = temp.next

    def addnode(self, data):

        node = Node(data)
        node.next = self.head
        self.head = node

        if self.size == 0:
            self.tail = self.head

        self.size += 1


lista = Scll("milista")

lista.addnode(1)
lista.addnode(2)

lista.printlist()
