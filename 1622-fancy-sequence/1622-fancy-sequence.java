class Fancy {

    List<Long> arr;
    long mul = 1;
    long add = 0;
    int mod = 1000000007;

    public Fancy() {
        arr = new ArrayList<>();
    }

    public void append(int val) {
        long v = (val - add + mod) % mod;
        v = (v * modInverse(mul)) % mod;
        arr.add(v);
    }

    public void addAll(int inc) {
        add = (add + inc) % mod;
    }

    public void multAll(int m) {
        mul = (mul * m) % mod;
        add = (add * m) % mod;
    }

    public int getIndex(int idx) {
        if (idx >= arr.size()) return -1;
        long val = (arr.get(idx) * mul % mod + add) % mod;
        return (int) val;
    }

    private long modInverse(long x) {
        return pow(x, mod - 2);
    }

    private long pow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % mod;
            a = (a * a) % mod;
            b >>= 1;
        }
        return res;
    }
}