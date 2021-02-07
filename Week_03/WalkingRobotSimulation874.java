import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author: Andrew Lu
 * @Description: 模拟行走机器人
 */
public class WalkingRobotSimulation874 {
    public int robotSim(int[] commands, int[][] obstacles) {
        //存放障碍
        Set<String> set = new HashSet<>();
        for (int[] obs : obstacles) {
            set.add(obs[0] + " " + obs[1]);
        }
        //定义四个方向的走法 向右，向前，向左 向下
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        //d：方向
        int d = 0, x = 0, y = 0, result = 0;
        //遍历命令，对每一个命令进行操作
        for (int c : commands) {
            //向右转90度
            if (c == -1) {
               d=(d+1)%4;
            } else if (c == -2) {
                d=(d-1+4)%4;
            } else {
                while (c-- > 0 && !set.contains((x + dirs[d][0]) + " " + (y + dirs[d][1]))) {
                    x += dirs[d][0];
                    y += dirs[d][1];
                }
            }
            result = Math.max(result, x * x + y * y);
        }
        return result;
    }
}
