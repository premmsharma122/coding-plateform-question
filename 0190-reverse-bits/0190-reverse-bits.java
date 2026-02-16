class Solution {
    public int reverseBits(int n) {
        
        String binaryStr = String.format("%32s", Integer.toBinaryString(n)).replace(' ', '0');
        
        
        String reversedBinaryStr = new StringBuilder(binaryStr).reverse().toString();
        
        
        long reversedValue = Long.parseLong(reversedBinaryStr, 2);
        
        
        return (int) reversedValue;
    }
}
