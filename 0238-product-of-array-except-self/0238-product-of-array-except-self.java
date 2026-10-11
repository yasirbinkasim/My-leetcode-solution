class Solution {
    public int[] productExceptSelf(int[] nums) {
        // ---- भाग A: Base & Boundary Cases ----
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] ans = new int[n];

        // ---- भाग B & C: Left Product भरना (Forward Loop) ----
        ans[0] = 1; // इंडेक्स 0 के बाईं तरफ कुछ नहीं है, तो 1 रख दिया
        for (int i = 1; i < n; i++) {
            // वर्तमान का लेफ्ट प्रोडक्ट = पिछले का लेफ्ट प्रोडक्ट * पिछला नंबर
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        // ---- भाग D: Right Product का ट्रैक रखना और फाइनल गुणा करना (Backward Loop) ----
        int rightProd = 1; // दाईं तरफ का चलता हुआ प्रोडक्ट ट्रैक करने के लिए
        
        // पीछे से आगे की तरफ चलेंगे (Index n-1 से 0 तक)
        for (int i = n - 1; i >= 0; i--) {
            // फाइनल आंसर = (पहले से बैठा हुआ लेफ्ट प्रोडक्ट) * (चलता हुआ राइट प्रोडक्ट)
            ans[i] = ans[i] * rightProd;
            
            // अगले कदम (इंडेक्स i-1) के लिए राइट प्रोडक्ट को अपडेट कर दिया
            rightProd = rightProd * nums[i];
        }

        return ans;
    }
}
