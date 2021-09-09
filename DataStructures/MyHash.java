import java.util.HashMap;

public class MyHash {
  private Slot[] hashTable;

  public class Slot {
    String key;
    String value;

    Slot(String key, String value) {
      this.key = key;
      this.value = value;
    }
  }

  public MyHash(Integer size) {
    this.hashTable = new Slot[size];
  }

  private int hashFunction(String key) {
    int hash = 0;
    for (int i = 0; i < key.length(); ++i) {
      hash ^= key.charAt(i);
    }
    return (hash % 101) % hashTable.length;
  }

  public boolean set(String key, String value) {
    Integer index = this.hashFunction(key);
    if (this.hashTable[index] != null) {
      if (this.hashTable[index].key == key) {
        this.hashTable[index].value = value;
        return true;
      }
      while (this.hashTable[index] != null) {
        if (this.hashTable[index].key == key) {
          this.hashTable[index].value = value;
          return true;
        }
        index += 1;
        if (index >= this.hashTable.length) {
          return false;
        }
      }
    }
    this.hashTable[index] = new Slot(key, value);
    return true;
  }

  public String get(String key) {
    Integer index = this.hashFunction(key);
    if (this.hashTable[index] != null) {
      if (this.hashTable[index].key == key) {
        return this.hashTable[index].value;
      } else {
        while (this.hashTable[index] != null) {
          if (this.hashTable[index].key == key) {
            return this.hashTable[index].value;
          }
          index += 1;
          if (index >= this.hashTable.length) {
            return null;
          }
        }
      }
    }

    return null;
  }

  public static void main(String[] args) {
    // HashMap 클래스 이용
    HashMap<String, String> map = new HashMap<String, String>();
    map.put("key1", "value1");
    map.put("key2", "value2");
    map.put("key3", "value3");
    map.put("key4", "value4");
    map.put("key5", "value5");

    System.out.println(map);

    System.out.println(map.get("key1"));
    System.out.println(map.get("key3"));
    System.out.println(map.get("key5"));
    System.out.println(map.get("key7"));

    MyHash myHash = new MyHash(5);

    System.out.println(myHash.set("key1", "value1"));
    System.out.println(myHash.set("key2", "value2"));
    System.out.println(myHash.set("key3", "value3"));
    System.out.println(myHash.set("key4", "value4"));

    System.out.println(myHash.get("key1"));
    System.out.println(myHash.get("key2"));
    System.out.println(myHash.get("key3"));
    System.out.println(myHash.get("key4"));
    System.out.println(myHash.get("key5"));
    System.out.println(myHash.get("key6"));
  }
}
