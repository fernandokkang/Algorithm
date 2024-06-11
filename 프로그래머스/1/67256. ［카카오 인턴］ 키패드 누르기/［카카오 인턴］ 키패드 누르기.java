class Solution {
    
    private static final int[][] keyPad = {
        {3, 1}, 
        {0, 0}, {0, 1}, {0, 2}, 
        {1, 0}, {1, 1}, {1, 2}, 
        {2, 0}, {2, 1}, {2, 2}, 
        {3, 0}, {3, 2}  
    };

    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        
        int[] leftLoc = keyPad[10]; 
        int[] rightLoc = keyPad[11]; 
        
        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                answer.append("L");
                leftLoc = keyPad[number];
            } else if (number == 3 || number == 6 || number == 9) {
                answer.append("R");
                rightLoc = keyPad[number];
            } else {
                
                int[] targetLoc = keyPad[number];
                int leftDist = Math.abs(leftLoc[0] - targetLoc[0]) + Math.abs(leftLoc[1] - targetLoc[1]);
                int rightDist = Math.abs(rightLoc[0] - targetLoc[0]) + Math.abs(rightLoc[1] - targetLoc[1]);

                if (leftDist < rightDist) {
                    answer.append("L");
                    leftLoc = targetLoc;
                } else if (leftDist > rightDist) {
                    answer.append("R");
                    rightLoc = targetLoc;
                } else {
                    if (hand.equals("left")) {
                        answer.append("L");
                        leftLoc = targetLoc;
                    } else {
                        answer.append("R");
                        rightLoc = targetLoc;
                    }
                }
            }
        }
        
        return answer.toString();
    }
}