class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        String regex = "[^" + skill + "]";

        for (String skill_tree : skill_trees) {
            String filteredSkillTree = skill_tree.replaceAll(regex, "");

            if (skill.startsWith(filteredSkillTree)) {
                answer++;
            }
        }
        
        return answer;
    }
}