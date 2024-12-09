package Stack;

import java.util.ArrayList;

public class Stack<T> implements StackInterface<T> 
{
    private ArrayList<T> stackList;

    public Stack() 
    {
        stackList = new ArrayList<>();
    }

    @Override
    public void push(T newEntry) 
    {
        stackList.add(newEntry);
    }

    @Override
    public T pop() throws EmptyStackException 
    {
        if (isEmpty()) 
        {
            throw new EmptyStackException("Cannot pop from an empty stack");
        }
        return stackList.remove(stackList.size() - 1);
    }

    @Override
    public T peek() throws EmptyStackException 
    {
        if (isEmpty()) 
        {
            throw new EmptyStackException("Cannot peek an empty stack");
        }
        return stackList.get(stackList.size() - 1);
    }

    @Override
    public boolean isEmpty() 
    {
        return stackList.isEmpty();
    }

    @Override
    public void clear() 
    {
        stackList.clear();
    }

    @Override
    public void display() 
    {
        
    }

    public int getSize() 
    {
        return stackList.size();
    }

    public T get(int index) 
    {
        return stackList.get(index);
    }
}