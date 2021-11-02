class Solution {

    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        Node cur = head;
        while (cur != null) {
            if (cur.child != null) {
                Node next = cur.next;
                Node child = flatten(cur.child);
                cur.next = child;
                child.prev = cur;
                cur.child = null;
                if (next != null) {
                    while (child.next != null) {
                        child = child.next;
                    }
                    child.next = next;
                    next.prev = child;
                }
                cur = next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
