if(k == 2 || k == 5) return -1;

int rem = 1 % k;
int length = 1;

boolean[] seen = new boolean[k];

while (rem != 0) {
    if (seen[rem]) return -1;
    seen[rem] = true;

    rem = (rem * 10 + 1) % k;
    length++;
}

return length;
