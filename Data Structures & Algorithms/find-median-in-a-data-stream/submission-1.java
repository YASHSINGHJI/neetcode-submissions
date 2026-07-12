class MedianFinder {

    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    public MedianFinder() {
        min=new PriorityQueue<>();
        max=new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        max.offer(num);  
        if(!max.isEmpty() && !min.isEmpty() && max.peek()>min.peek()){
            min.offer(max.poll());
        }
        if(max.size()>min.size()+1){
            min.offer(max.poll());
        }
        if(min.size()>max.size()+1){
            max.offer(min.poll());
        }
             
    }

    public double findMedian() {
        if((max.size()+min.size())%2==0){
            return (max.peek()+min.peek())/2.0;
        }        
        else if(max.size()>min.size())
            return max.peek();
        else 
            return min.peek();

    }
}
