class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        int xmin = Integer.MAX_VALUE;
        int amax = -Integer.MAX_VALUE;
        int ymin = Integer.MAX_VALUE;
        int bmax = -Integer.MAX_VALUE;
        for (int[] rect : rectangles) {
            xmin = Math.min(xmin, rect[0]);
            amax = Math.max(amax, rect[2]);
            ymin = Math.min(ymin, rect[1]);
            bmax = Math.max(bmax, rect[3]);
        }
        SegmentTree segmentTree = new SegmentTree(xmin, amax - 1);
        segmentTree.update(xmin, amax - 1, ymin);
        Arrays.sort(rectangles, (rect1, rect2) -> Integer.compare(rect1[1], rect2[1]));
        for (int[] rect : rectangles) {
            int min = segmentTree.min(rect[0], rect[2] - 1);
            int max = segmentTree.max(rect[0], rect[2] - 1);
            if (min != max || min != rect[1]) {
                return false;
            }
            segmentTree.update(rect[0], rect[2] - 1, rect[3]);
        }
        int min = segmentTree.min(xmin, amax - 1);
        int max = segmentTree.max(xmin, amax - 1);
        return min == max;
    }

    class SegmentTree {
        final Node root;

        SegmentTree(int lo, int hi) {
            root = new Node(lo, hi);
        }

        void update(int left, int right, int value) {
            root.update(left, right, value);
        }

        int min(int left, int right) {
            return root.min(left, right);
        }

        int max(int left, int right) {
            return root.max(left, right);
        }

        class Node {
            int min, max;
            Integer lazy;
            final int lo, hi;
            Node leftChild, rightChild;

            Node(int lo, int hi) {
                this.lo = lo;
                this.hi = hi;
            }

            Node getLeftChild() {
                if (lo == hi) {
                    return null;
                }
                if (leftChild == null) {
                    int half = (hi - lo + 1) / 2;
                    leftChild = new Node(lo, lo + half - 1);
                }
                return leftChild;
            }

            Node getRightChild() {
                if (lo == hi) {
                    return null;
                }
                if (rightChild == null) {
                    int half = (hi - lo + 1) / 2;
                    rightChild = new Node(lo + half, hi);
                }
                return rightChild;
            }

            void push() {
                if (lazy == null) {
                    return;
                }
                min = lazy;
                max = lazy;
                if (lo != hi) {
                    getLeftChild().lazy = lazy;
                    getRightChild().lazy = lazy;
                }
                lazy = null;
            }

            void update(int left, int right, int value) {
                push();
                if (hi < left || lo > right) {
                    return;
                }
                if (hi <= right && lo >= left) {
                    System.out.printf("%d\n", lazy);
                    lazy = value;
                    push();
                    return;
                }
                getLeftChild().update(left, right, value);
                getRightChild().update(left, right, value);
                min = Math.min(getLeftChild().min, getRightChild().min);
                max = Math.max(getLeftChild().max, getRightChild().max);
            }

            int min(int left, int right) {
                //System.out.printf("%d %d %d %d\n", lo, hi, left, right);
                push();
                if (hi < left || lo > right) {
                    return Integer.MAX_VALUE;
                }
                if (hi <= right && lo >= left) {
                    return min;
                }
                return Math.min(getLeftChild().min(left, right), getRightChild().min(left, right));
            }

            int max(int left, int right) {
                push();
                if (hi < left || lo > right) {
                    return -Integer.MAX_VALUE;
                }
                if (hi <= right && lo >= left) {
                    return max;
                }
                return Math.max(getLeftChild().max(left, right), getRightChild().max(left, right));
            }
        }
    }
}