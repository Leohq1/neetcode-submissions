class MyHashSet {

    boolean[] lib;
    public MyHashSet() {
        lib = new boolean[1_000_001];
    }
    
    public void add(int key) {
        lib[key] = true;
    }
    
    public void remove(int key) {
        lib[key] = false;
    }
    
    public boolean contains(int key) {
        return lib[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */