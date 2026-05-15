class MedianFinder {
    private PriorityQueue<Double> smallPriorityQueue;
    private PriorityQueue<Double> largePriorityQueue;

    public MedianFinder() {
        smallPriorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        largePriorityQueue = new PriorityQueue<>();
    }

    public void addNum(int num) {
        smallPriorityQueue.offer((double) num);
        if (!smallPriorityQueue.isEmpty() && !largePriorityQueue.isEmpty()
                && smallPriorityQueue.peek() > largePriorityQueue.peek()) {
            double val = smallPriorityQueue.poll();
            largePriorityQueue.offer(val);
        }
        if (smallPriorityQueue.size() > largePriorityQueue.size() + 1) {
            double val = smallPriorityQueue.poll();
            largePriorityQueue.offer(val);
        }
        if (largePriorityQueue.size() > smallPriorityQueue.size() + 1) {
            double val = largePriorityQueue.poll();
            smallPriorityQueue.offer(val);
        }

    }

    public double findMedian() {
        if (smallPriorityQueue.size() > largePriorityQueue.size()) {
            return smallPriorityQueue.peek();
        }
        if(largePriorityQueue.size() > smallPriorityQueue.size()){
            return largePriorityQueue.peek();
        }
        return (smallPriorityQueue.peek()+largePriorityQueue.peek())/2;

    }
}