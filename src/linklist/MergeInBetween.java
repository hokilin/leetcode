package linklist;

/**
 * @author linhuankai
 * @date 2021/1/17 22:53
 * 1669. 合并两个链表
 * 给你两个链表list1 和list2，它们包含的元素分别为n 个和m 个。
 * <p>
 * 请你将list1中第a个节点到第b个节点删除，并将list2接在被删除节点的位置。
 */
public class MergeInBetween {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int index = 0;
        ListNode aNode = null;
        ListNode bNode = null;
        for (ListNode current1 = list1; current1 != null; current1 = current1.next) {
            if (index == a - 1) {
                aNode = current1;
            }
            if (index == b + 1) {
                bNode = current1;
                break;
            }
            index++;
        }
        assert aNode != null;
        aNode.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = bNode;
        return list1;
    }

}
