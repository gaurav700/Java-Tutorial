// package-private abstract class (no 'public' per spec)
abstract class ListItem {
    // protected fields as required
    protected ListItem rightLink;
    protected ListItem leftLink;
    protected Object value;

    // public constructor
    public ListItem(Object value) {
        this.value = value;
    }

    // package-private abstract methods
    abstract ListItem next();
    abstract ListItem setNext(ListItem item);
    abstract ListItem previous();
    abstract ListItem setPrevious(ListItem item);
    abstract int compareTo(ListItem item);

    // public getters/setters
    public Object getValue() {
        return this.value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}

// package-private concrete class
class Node extends ListItem {

    // public constructor
    public Node(Object value) {
        super(value);
    }

    // package-private overrides
    @Override
    ListItem next() {
        return this.rightLink;
    }

    @Override
    ListItem setNext(ListItem item) {
        this.rightLink = item;
        return this.rightLink;
    }

    @Override
    ListItem previous() {
        return this.leftLink;
    }

    @Override
    ListItem setPrevious(ListItem item) {
        this.leftLink = item;
        return this.leftLink;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    int compareTo(ListItem other) {
        if (other == null) return 1;

        Object a = this.value;
        Object b = other.value;

        if (a == null && b == null) return 0;
        if (a == null) return -1;
        if (b == null) return 1;

        // Prefer Comparable comparison if compatible, else fall back to toString
        if (a instanceof Comparable && a.getClass().isInstance(b)) {
            return ((Comparable) a).compareTo(b);
        }
        return a.toString().compareTo(b.toString());
    }
}

// package-private interface (no 'public')
interface NodeList {
    // interface methods are abstract; implementations will be public
    ListItem getRoot();
    boolean addItem(ListItem item);
    boolean removeItem(ListItem item);
    void traverse(ListItem root);
}

// package-private concrete class
class MyLinkedList implements NodeList {

    // private field as required
    private ListItem root;

    // public constructor
    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    // public methods (interface)
    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (newItem == null) return false;

        if (this.root == null) {
            this.root = newItem;
            return true;
        }

        ListItem current = this.root;
        while (current != null) {
            int cmp = current.compareTo(newItem);

            if (cmp == 0) {
                // duplicate: do not add
                return false;
            } else if (cmp > 0) {
                // newItem < current -> insert before current
                ListItem prev = current.previous();

                newItem.setNext(current);
                newItem.setPrevious(prev);

                if (prev != null) {
                    prev.setNext(newItem);
                } else {
                    // inserting at head
                    this.root = newItem;
                }
                current.setPrevious(newItem);
                return true;
            } else {
                // newItem > current -> move right
                if (current.next() == null) {
                    // append at end
                    current.setNext(newItem);
                    newItem.setPrevious(current);
                    return true;
                }
                current = current.next();
            }
        }
        return false; // should not reach here
    }

    @Override
    public boolean removeItem(ListItem item) {
        if (item == null || this.root == null) return false;

        ListItem current = this.root;

        while (current != null) {
            int cmp = current.compareTo(item);

            if (cmp == 0) {
                // remove current
                ListItem prev = current.previous();
                ListItem next = current.next();

                if (prev == null) {
                    // removing head
                    this.root = next;
                    if (this.root != null) this.root.setPrevious(null);
                } else {
                    prev.setNext(next);
                    if (next != null) next.setPrevious(prev);
                }
                return true;
            } else if (cmp < 0) {
                // item is greater -> go right
                current = current.next();
            } else {
                // item is less -> not found in sorted list
                return false;
            }
        }
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if (root == null) {
            System.out.println("The list is empty");
            return;
        }
        ListItem current = root;
        while (current != null) {
            System.out.println(current.getValue());
            current = current.next();
        }
    }
}

// package-private concrete class
class SearchTree implements NodeList {

    // private root field
    private ListItem root;

    // public constructor
    public SearchTree(ListItem root) {
        this.root = root;
    }

    // public methods (interface)
    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (newItem == null) return false;

        if (this.root == null) {
            this.root = newItem;
            return true;
        }

        ListItem current = this.root;

        while (true) {
            int cmp = current.compareTo(newItem);

            if (cmp == 0) {
                // duplicate: do not add
                return false;
            } else if (cmp > 0) {
                // newItem < current -> go left (previous)
                if (current.previous() != null) {
                    current = current.previous();
                } else {
                    current.setPrevious(newItem);
                    return true;
                }
            } else {
                // newItem > current -> go right (next)
                if (current.next() != null) {
                    current = current.next();
                } else {
                    current.setNext(newItem);
                    return true;
                }
            }
        }
    }

    @Override
    public boolean removeItem(ListItem item) {
        if (item == null || this.root == null) return false;

        ListItem current = this.root;
        ListItem parent = null;

        while (current != null) {
            int cmp = current.compareTo(item);

            if (cmp == 0) {
                performRemoval(current, parent);
                return true;
            } else if (cmp > 0) {
                // item < current -> go left
                parent = current;
                current = current.previous();
            } else {
                // item > current -> go right
                parent = current;
                current = current.next();
            }
        }
        return false;
    }

    // private helper as required
    private void performRemoval(ListItem item, ListItem parent) {
        // Case 1: node has two children
        if (item.previous() != null && item.next() != null) {
            // Find smallest in right subtree (inorder successor)
            ListItem successorParent = item;
            ListItem successor = item.next();
            while (successor.previous() != null) {
                successorParent = successor;
                successor = successor.previous();
            }
            // Copy successor's value into item
            item.setValue(successor.getValue());
            // Remove successor node (it has at most one right child)
            performRemoval(successor, successorParent);
            return;
        }

        // Case 2 & 3: node has at most one child
        ListItem child = (item.previous() != null) ? item.previous() : item.next();

        if (parent == null) {
            // Removing the root
            this.root = child;
        } else if (parent.previous() == item) {
            parent.setPrevious(child);
        } else if (parent.next() == item) {
            parent.setNext(child);
        }
    }

    @Override
    public void traverse(ListItem root) {
        if (root == null) {
            System.out.println("The list is empty");
            return;
        }
        // inorder: left -> node -> right
        if (root.previous() != null) {
            traverse(root.previous());
        }
        System.out.println(root.getValue());
        if (root.next() != null) {
            traverse(root.next());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // test data (as Strings; works with your compareTo)
        String[] data = {"5","1","3","7","3","9","0"};

        // --- Linked List ---
        MyLinkedList list = new MyLinkedList(null);
        for (String s : data) {
            System.out.printf("LL add %-2s -> %s%n", s, list.addItem(new Node(s)));
        }

        System.out.println("\nLinkedList traverse:");
        list.traverse(list.getRoot());

        System.out.println("\nLinkedList remove 3 and 9:");
        System.out.println("removed 3 -> " + list.removeItem(new Node("3")));
        System.out.println("removed 9 -> " + list.removeItem(new Node("9")));
        list.traverse(list.getRoot());

        // --- Binary Search Tree ---
        SearchTree tree = new SearchTree(null);
        for (String s : data) {
            System.out.printf("BST add %-2s -> %s%n", s, tree.addItem(new Node(s)));
        }

        System.out.println("\nBST inorder traverse:");
        tree.traverse(tree.getRoot());

        System.out.println("\nBST remove 5 (root), 0, 7:");
        System.out.println("removed 5 -> " + tree.removeItem(new Node("5")));
        System.out.println("removed 0 -> " + tree.removeItem(new Node("0")));
        System.out.println("removed 7 -> " + tree.removeItem(new Node("7")));
        tree.traverse(tree.getRoot());
    }
}

