import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Solution {
    public int solution(String dartResult) {
        
        Pattern pattern = Pattern.compile("(\\d+)([SDT])([*#]?)");
        Matcher matcher = pattern.matcher(dartResult);
        
        int[] scores = new int[3];
        int index = 0;
        
        while (matcher.find()) {
            
            int score = Integer.parseInt(matcher.group(1));
            String bonus = matcher.group(2);
            String option = matcher.group(3);
            
            score = calculateBonusScore(score, bonus);
            
            if (option.equals("*")) {
                score *= 2;
                
                if (index > 0) {
                    scores[index - 1] *= 2;
                }
            } else if (option.equals("#")) {
                score *= -1;
            }

            scores[index++] = score;
        }
        
        int totalScore = 0;
        for (int s : scores) {
            totalScore += s;
        }
        
        return totalScore;
    }
    
    private int calculateBonusScore(int score, String bonus) {
        
        if(bonus.equals("S")) {
            
            return (int) Math.pow(score, 1);
        }
        
        if(bonus.equals("D")) {
            
            return (int) Math.pow(score, 2);
        }
        
        if(bonus.equals("T")) {
            
            return (int) Math.pow(score, 3);
        }
        
        return 0;
    }
}