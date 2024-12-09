package Stack;


public class Node<T>
{
    private T    data; 
    private Node<T> next; 
    public Node(T dataPortion, Node<T> nextNode)
    {
       data = dataPortion;
       next = nextNode;
    } 
    public Node(T dataPortion)
    {
       this(dataPortion, null);
    } 
    public T getData()
    {
       return data;
    } 
    public Node<T> getNextNode()
    {
       return next;
    } 
    public void setData(T newData)
    {
       data = newData;
    }
    public void setNextNode(Node<T> nextNode)
    {
       next = nextNode;
    } 
} 