
## Create a linked list of numbers, write a function to print the numbers in the linked list. Write a function that will reverse the linked list, and print it.

## Ans 1. 
Let's go through this piece by piece.

## 1. The `Node` class — building block of the list

```java
class Node{
	int data;
	Node next;
	Node(int data){
		this.data = data;
		this.next = null;
	}
}
```

A linked list isn't one object — it's a chain of small objects, each holding:

- `data`: the actual value (an `int` here)
- `next`: a **reference to the next Node** in the chain (not a copy — a pointer to another `Node` object sitting somewhere in memory)

The constructor `Node(int data)` sets `this.data` to whatever value you pass in, and sets `next` to `null` — meaning "this node currently points to nothing." That makes sense: when you create a brand-new node, it isn't yet connected to anything else.

Think of each `Node` as a train car with a cargo box (`data`) and a coupler (`next`) that can hook onto the next car — or hang empty (`null`) if it's the last car.

## 2. `createLinkedList()` — building the chain

```java
static Node createLinkedList(){
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter number of nodes: ");
	int n = sc.nextInt();
	Node head = null;
	Node temp = null;
	for(int i=1; i<=n; i++){
		System.out.println("Enter data: ");
		int value = sc.nextInt();
		Node newNode = new Node(value);
		if(head == null){
			head = newNode;
			temp = head;
		}else{
			temp.next = newNode;
			temp = newNode;
		}
	}
	return head;
}
```

Two important variables:

- `head`: always points to the **first** node of the list. This is the only "entry point" — if you lose the reference to `head`, you lose the entire list, because there's no way to get back to earlier nodes (this list is singly linked).
- `temp`: a "cursor" that always points to the **last** node added so far, so we know where to attach the next one.

Walking through the loop for, say, n = 3 with values 10, 20, 30:

**Iteration 1 (value = 10):**

- `newNode` = Node(10), its `next` is `null`
- `head == null` is true (nothing exists yet), so:
    - `head = newNode` → head now points to Node(10)
    - `temp = head` → temp also points to Node(10)
- State: `head → [10|null]`, `temp → [10|null]` (same node)

**Iteration 2 (value = 20):**

- `newNode` = Node(20)
- `head == null` is now false, so we go to `else`:
    - `temp.next = newNode` → the node temp is pointing at (Node 10) gets its `next` set to Node(20). So Node(10) → Node(20).
    - `temp = newNode` → temp now moves forward to point at Node(20)
- State: `head → [10] → [20|null]`, `temp → [20]`

**Iteration 3 (value = 30):**

- `newNode` = Node(30)
- `else` branch again:
    - `temp.next = newNode` → Node(20)'s `next` becomes Node(30)
    - `temp = newNode` → temp now points to Node(30)
- State: `head → [10] → [20] → [30|null]`

So `temp` acts like a "tail pointer" that always trails behind, letting you attach new nodes in O(1) time instead of walking the whole list each time. Finally, `return head` hands back just the starting point — from there you can reach every other node by following `next`.

## 3. `printList(Node head)` — traversing the chain

```java
static void printList(Node head){
	Node temp = head;
	while(temp != null){
		System.out.print(temp.data + " ");
		temp = temp.next;
	}
	System.out.println();
}
```

Note: this method takes its own parameter `head`, so the `temp` here is a fresh local variable — it doesn't disturb the actual list.

- `temp = head` starts a cursor at the first node.
- The loop condition `temp != null` says "keep going as long as there's a node to look at."
- Each iteration: print `temp.data`, then move to the next node via `temp = temp.next`.
- When `temp` becomes `null` (we fell off the end of the list, since the last node's `next` was never set to anything else), the loop stops.

For our list: prints `10 20 30`.

## 4. `reverseList(Node head)` — the core trick

```java
static Node reverseList(Node head){
	Node prev = null;
	Node current = head;
	Node next = null;
	while(current != null){
		next = current.next;
		current.next = prev;
		prev = current;
		current = next;
	}
	return prev;
}
```

This is the classic **iterative pointer-reversal** technique. The idea: walk through the list once, and at each node, flip its `next` pointer to point _backward_ instead of forward.

You need **three pointers** simultaneously because once you overwrite `current.next`, you'd lose the rest of the list if you hadn't saved it first.

- `prev`: the node that should come _after_ `current` once reversed (starts as `null`, since the original head will become the new tail, pointing to nothing)
- `current`: the node we're currently processing
- `next`: a temporary "bookmark" holding onto the rest of the original list, so we don't lose it

Let's trace it with `head → [10] → [20] → [30|null]`:

**Before loop:** `prev = null`, `current = [10]`

**Iteration 1:**

- `next = current.next` → `next = [20]` (bookmark the rest of the list before we destroy the link)
- `current.next = prev` → Node(10)'s `next` becomes `null` (it's now the tail, since it was the original head)
- `prev = current` → `prev` moves up to `[10]`
- `current = next` → `current` moves up to `[20]`
- State: `[10|null]` ... `prev=[10]`, `current=[20]`

**Iteration 2:**

- `next = current.next` → `next = [30]`
- `current.next = prev` → Node(20)'s `next` becomes `[10]` → so now `[20] → [10] → null`
- `prev = current` → `prev = [20]`
- `current = next` → `current = [30]`

**Iteration 3:**

- `next = current.next` → `next = null` (30 was the last node)
- `current.next = prev` → Node(30)'s `next` becomes `[20]` → now `[30] → [20] → [10] → null`
- `prev = current` → `prev = [30]`
- `current = next` → `current = null`

**Loop ends** (`current == null`). Return `prev`, which is `[30]` — the new head of the reversed list: `30 → 20 → 10 → null`.

The key insight: at every step, `prev` is one node "behind" `current` in the _new_ direction, and by the time `current` walks off the end, `prev` has landed exactly on what used to be the last node — now the new head.

## 5. `main` — tying it together

```java
Node head = createLinkedList();
printList(head);
head = reverseList(head);
printList(head);
```

- Build the list, print it in original order.
- Call `reverseList(head)`, which returns the **new head** (previously the tail) — and reassign it to `head`, since the old `head` variable in `main` is now the _tail_ of the reversed list, not useful as an entry point anymore.
- Print again — now you see the reversed order.

One subtlety worth flagging: after reversal, the _original_ `head` node still exists and is reachable — it's just at the end of the list now, with `next = null`. Nothing is deleted; only the `next` pointers were rewired.

If you'd like, I can also show what happens if you try to print using the **old** `head` reference after reversing (a common source of confusion/bugs), or walk through an edge case like a list with 0 or 1 nodes.