class MedianFinder {
    Queue<Integer> max = new PriorityQueue<>((a, b) -> b - a);
    Queue<Integer> min = new PriorityQueue<>();

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(max.isEmpty() || num <= max.peek()){
            max.add(num);
            if(!check()){
                min.add(max.remove());
            }
        } else{
            min.add(num);
            if(!check()){
                max.add(min.remove());
            }
        }
    }
    
    public double findMedian() {
        return (max.size() == min.size()) ? ((double) max.peek() + min.peek()) / 2 : max.peek();
    }

    private boolean check(){
        return max.size() == min.size() || max.size() == min.size() + 1;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */