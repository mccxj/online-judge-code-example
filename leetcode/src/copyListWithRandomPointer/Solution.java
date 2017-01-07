package copyListWithRandomPointer;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a linked list, determine if it has a cycle in it.
 * <p/>
 * Follow up:
 * Can you solve it without using extra space?
 */
public class Solution {
    private Map<RandomListNode, RandomListNode> maps = new HashMap<RandomListNode, RandomListNode>();

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode node = new RandomListNode(head.label);
        maps.put(head, node);

        if (head.random != null) {
            RandomListNode random = maps.get(head.random);
            if (random != null) {
                node.random = random;
            } else {
                node.random = copyRandomList(head.random);
            }
        }

        if (head.next != null) {
            RandomListNode next = maps.get(head.next);
            if (next != null) {
                node.next = next;
            } else {
                node.next = copyRandomList(head.next);
            }
        }

        return node;
    }
}
