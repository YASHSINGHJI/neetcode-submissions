class Solution {
        public int evalRPN(String[] tokens) {
        Stack<Integer> stack1 = new Stack<>();        
        for(String token:tokens){
            if(token.equals("+")){
                stack1.push(stack1.pop()+stack1.pop());
            }else if(token.equals("-")){
                stack1.push(-stack1.pop()+stack1.pop());
            }else if(token.equals("*")){
                stack1.push(stack1.pop()*stack1.pop());
            }else if(token.equals("/")){
                int num1 = stack1.pop();
                int num2 = stack1.pop();
                stack1.push(num2/num1);
            }else{
                stack1.push(Integer.parseInt(token));
            }

        }
        return stack1.pop();
    }
}
