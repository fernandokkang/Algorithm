class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String skill_tree : skill_trees) {
            if (isValidSkillTree(skill, skill_tree)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean isValidSkillTree(String skill, String skill_tree) {
        int skillIndex = 0;

        for (char c : skill_tree.toCharArray()) {
            int index = skill.indexOf(c);
            if (index == -1) {
                continue;
            }
            if (index == skillIndex) {
                skillIndex++;
            } else {
                return false;
            }
        }

        return true;
    }
}