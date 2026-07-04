package Interview;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private final int capacity;
    private final Map<Integer, Node> cache;
    private final DoublyLinkedList list;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.list = new DoublyLinkedList();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;

        Node node = cache.get(key);
        list.moveToFront(node); // Mark as recently used
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node existingNode = cache.get(key);
            existingNode.value = value;
            list.moveToFront(existingNode); // Mark as recently used
        } else {
            if (cache.size() == capacity) {
                Node lruNode = list.removeLast();
                cache.remove(lruNode.key); // Remove from map
            }
            Node newNode = new Node(key, value);
            list.addFirst(newNode);
            cache.put(key, newNode);
        }
    }

    // Doubly Linked List to manage order of usage
    private static class DoublyLinkedList {
        private final Node head, tail;

        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        void moveToFront(Node node) {
            remove(node);
            addFirst(node);
        }

        Node removeLast() {
            if (tail.prev == head) return null;
            Node lru = tail.prev;
            remove(lru);
            return lru;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    // Node class for doubly linked list
    private static class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 10);
        lruCache.put(2, 20);
        System.out.println(lruCache.get(1)); // 10 (1 is most recently used)
        lruCache.put(3, 30); // Removes key 2 (LRU)
        System.out.println(lruCache.get(2)); // -1 (Not found)
        lruCache.put(4, 40); // Removes key 1 (LRU)
        System.out.println(lruCache.get(1)); // -1 (Not found)
        System.out.println(lruCache.get(3)); // 30
        System.out.println(lruCache.get(4)); // 40
    }
}
