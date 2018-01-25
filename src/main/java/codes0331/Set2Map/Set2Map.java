package codes0331.Set2Map;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

class SimpleEntry<K, V> implements Map.Entry<K, V>, java.io.Serializable
{
    
    private final K key;
    
    private V value;
    
    public SimpleEntry(K key, V value)
    {
        super();
        this.key = key;
        this.value = value;
    }
    
    public SimpleEntry(Map.Entry<? extends K, ? extends V> entry)
    {
        this.key = entry.getKey();
        this.value = entry.getValue();
    }
    
    @Override
    public K getKey()
    {
        return key;
    }
    
    @Override
    public V getValue()
    {
        return value;
    }
    
    @Override
    public V setValue(V value)
    {
        V oldValue = this.value;
        this.value = value;
        return oldValue;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (obj.getClass() == SimpleEntry.class)
        {
            SimpleEntry se = (SimpleEntry)obj;
            return se.getKey().equals(getKey());
        }
        return false;
    }
    
    @Override
    public int hashCode()
    {
        return key == null ? 0 : key.hashCode();
    }
    
    @Override
    public String toString()
    {
        return key + "=" + value;
    }
}

public class Set2Map<K, V> extends HashSet<SimpleEntry<K, V>>
{
    @Override
    public void clear()
    {
        super.clear();
    }
    
    public boolean containKey(Object key)
    {
        return super.contains(new SimpleEntry(key, null));
    }
    
    public boolean containValue(Object value)
    {
        for (SimpleEntry<K, V> se : this)
        {
            if (se.getValue().equals(value))
                return true;
        }
        return false;
    }
    
    public V get(Object key)
    {
        for (SimpleEntry<K, V> se : this)
        {
            if (se.getKey().equals(key))
                return se.getValue();
        }
        return null;
    }
    
    public V put(K key, V value)
    {
        add(new SimpleEntry<K, V>(key, value));
        return value;
    }
    
    public void putAll(Map<? extends K, ? extends V> m)
    {
        for (K key : m.keySet())
        {
            add(new SimpleEntry<K, V>(key, m.get(key)));
        }
    }
    
    public V removeEntry(Object key)
    {
        for (Iterator<SimpleEntry<K, V>> iterator = this.iterator(); iterator.hasNext();)
        {
            SimpleEntry<K, V> en = (SimpleEntry<K, V>)iterator.next();
            if (en.getKey().equals(key))
            {
                V v = en.getValue();
                iterator.remove();
                return v;
            }
        }
        return null;
    }
    
    public int size()
    {
        return super.size();
    }
}
