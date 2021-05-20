package primary.greedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

public class Code_06_BestArrange {
    public static class Program{
        public int start;   //会议开始时间
        public int end;     //会议结束时间

        public Program(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static class ProgramComparator implements Comparator<Program>{

        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }

    public static int bestArrange(Program[] programs, int start){
        Arrays.sort(programs, new ProgramComparator());

        int res = 0;

        for (int i = 0; i < programs.length; i++) {
            if (start <= programs[i].start){
                res++;
                start = programs[i].end;
            }
        }
        return res;
    }
}
