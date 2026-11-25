class NumArray {
    int[] seg;
    int len;

    public NumArray(int[] nums) {
        len = nums.length;
        seg = new int[4 * nums.length];

        build(0, 0, len - 1, nums);
    }

    private void build(int idx, int l, int h, int[] nums) {
        if (l == h) {
            seg[idx] = nums[l];
            return;
        }

        int mid = l + (h - l) / 2;

        build(2 * idx + 1, l, mid, nums);
        build(2 * idx + 2, mid + 1, h, nums);

        seg[idx] = seg[2 * idx + 1] + seg[2 * idx + 2];
    }

    public void update(int index, int val) {
        update(0, 0, len - 1, index, val);
    }

    private void update(int idx, int low, int high, int index, int val) {
        if (low == high) {
            seg[idx] = val;
            return;
        }

        int mid = low + (high - low) / 2;

        if (index <= mid) {
            update(2 * idx + 1, low, mid, index, val);
        } else {
            update(2 * idx + 2, mid + 1, high, index, val);
        }

        seg[idx] = seg[2 * idx + 1] + seg[2 * idx + 2];
    }

    public int sumRange(int left, int right) {
        return query(0, 0, len - 1, left, right);
    }

    private int query(int idx, int l, int h, int left, int right) {

        // complete overlap
        if (l >= left && h <= right) {
            return seg[idx];
        }

        // no overlap
        if (l > right || h < left) {
            return 0;
        }

        int mid = l + (h - l) / 2;

        // completely in left subtree
        if (right <= mid) {
            return query(2 * idx + 1, l, mid, left, right);
        }

        // completely in right subtree
        if (left > mid) {
            return query(2 * idx + 2, mid + 1, h, left, right);
        }

        // partial overlap
        return query(2 * idx + 1, l, mid, left, right)
             + query(2 * idx + 2, mid + 1, h, left, right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */