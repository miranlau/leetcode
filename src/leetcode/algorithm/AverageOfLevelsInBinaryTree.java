package leetcode.algorithm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AverageOfLevelsInBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class LevelValue {
        int nodeNum = 0;
        double valSum = 0d;

        public double getAverage() {
            return valSum / nodeNum;
        }

        public void increaseNodeNum() {
            nodeNum++;
        }

        public void addValue(double val) {
            valSum += val;
        }

        public String toString() {
            return "nodeNum=" + nodeNum + ", valSum=" + valSum;
        }
    }

    class Solution1 {
        public List<Double> averageOfLevels(TreeNode root) {
            Map<Integer, LevelValue> maps = new HashMap<Integer, LevelValue>();
            average(root, 0, maps);

            System.out.println(maps);

            return null;
        }

        private void average(TreeNode node, int level, Map<Integer, LevelValue> maps) {
            TreeNode left = node.left;
            TreeNode right = node.right;

            int newLevel = level++;

            if (left != null) {
                updateMaps(maps, newLevel, left.val);
                average(left, newLevel, maps);
            }

            if (right != null) {
                updateMaps(maps, newLevel, right.val);
                average(right, newLevel, maps);
            }

        }

        private void updateMaps(Map<Integer, LevelValue> maps, int level, double value) {
            LevelValue levelValue = maps.get(level);
            if (levelValue == null) {
                levelValue = new LevelValue();
            }

            levelValue.increaseNodeNum();
            levelValue.addValue(value);

            maps.put(level, levelValue);
        }
    }
}
