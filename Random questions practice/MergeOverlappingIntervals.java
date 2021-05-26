
//asked in walmart round 2(merge overlapping intervals)
class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public class Solution {
    class SortByStart implements Comparator<Interval> {
        // Used for sorting in ascending order
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {

        Stack<Interval> st = new Stack<Interval>();
        Collections.sort(intervals, new Sortbystart());

        st.push(intervals.get(0));// pushing the first pair into the stack

        for (int i = 1; i < intervals.size(); i++) {
            Interval top = st.peek();

            if (top.end < intervals.get(i).start) {
                st.push(intervals.get(i));
            }

            else if (top.end < intervals.get(i).end) {
                top.end = intervals.get(i).end;
                st.pop();
                st.push(top);
            }
        }

        ArrayList<Interval> al = new ArrayList<Interval>();
        while (!st.isEmpty()) {
            Interval t = st.pop();
            al.add(t);

        }
        Collections.reverse(al);
        return al;
    }
}