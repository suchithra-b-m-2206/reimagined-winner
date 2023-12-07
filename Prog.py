class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class LinkedList:
    def __init__(self):
        self.head = None

    def append(self, data):
        new_node = Node(data)
        if not self.head:
            self.head = new_node
            return
        last_node = self.head
        while last_node.next:
            last_node = last_node.next
        last_node.next = new_node

    def find_nth_element(self, n):
        current_node = self.head
        count = 0

        while current_node:
            if count == n:
                return current_node.data
            count += 1
            current_node = current_node.next

        # If n is greater than the length of the linked list
        return "Index out of range"

# Example usage:
linked_list = LinkedList()
linked_list.append(1)
linked_list.append(2)
linked_list.append(3)
linked_list.append(4)

n = 2  # Replace with the desired value of n
result = linked_list.find_nth_element(n)
print(f"The {n}th element is: {result}")
