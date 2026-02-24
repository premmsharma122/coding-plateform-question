class GfG {
    static int st[];

    // Build Segment Tree
    public static int[] constructST(int arr[], int n) {

        st = new int[4 * n];
        build(arr, 0, n - 1, 0);
        return st;
    }

    static void build(int arr[], int start, int end, int idx) {

        // Leaf node
        if (start == end) {
            st[idx] = arr[start];
            return;
        }

        int mid = (start + end) / 2;

        // Left subtree
        build(arr, start, mid, 2 * idx + 1);

        // Right subtree
        build(arr, mid + 1, end, 2 * idx + 2);

        // Store minimum
        st[idx] = Math.min(st[2 * idx + 1], st[2 * idx + 2]);
    }

    // Range Minimum Query
    public static int RMQ(int st[], int n, int l, int r) {

        return query(st, 0, n - 1, l, r, 0);
    }

    static int query(int st[], int start, int end, int l, int r, int idx) {

        // Complete overlap
        if (l <= start && end <= r)
            return st[idx];

        // No overlap
        if (end < l || start > r)
            return Integer.MAX_VALUE;

        // Partial overlap
        int mid = (start + end) / 2;

        return Math.min(
                query(st, start, mid, l, r, 2 * idx + 1),
                query(st, mid + 1, end, l, r, 2 * idx + 2)
        );
    }
}
