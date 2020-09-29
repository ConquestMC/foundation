package com.conquestmc.foundation.data;

public class DataObject<T>
{
    protected T id;

    public T getPrimaryKey()
    {
        return id;
    }
}