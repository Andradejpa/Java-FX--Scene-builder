package musical;

public class Node   {

    private Node next;
    private Score info;

    public Node(Score s) {
        this.info = s;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Score getInfo() {
        return info;
    }

    public void setInfo(Score info) {
        this.info = info;
    }

}
