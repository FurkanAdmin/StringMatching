/**
 * PreAnalysis interface for students to implement their algorithm selection logic
 * 
 * Students should analyze the characteristics of the text and pattern to determine
 * which algorithm would be most efficient for the given input.
 * 
 * The system will automatically use this analysis if the chooseAlgorithm method
 * returns a non-null value.
 */
public abstract class PreAnalysis {
    
    /**
     * Analyze the text and pattern to choose the best algorithm
     * 
     * @param text The text to search in
     * @param pattern The pattern to search for
     * @return The name of the algorithm to use (e.g., "Naive", "KMP", "RabinKarp", "BoyerMoore", "GoCrazy")
     *         Return null if you want to skip pre-analysis and run all algorithms
     * 
     * Tips for students:
     * - Consider the length of the text and pattern
     * - Consider the characteristics of the pattern (repeating characters, etc.)
     * - Consider the alphabet size
     * - Think about which algorithm performs best in different scenarios
     */
    public abstract String chooseAlgorithm(String text, String pattern);
    
    /**
     * Get a description of your analysis strategy
     * This will be displayed in the output
     */
    public abstract String getStrategyDescription();
}


/**
 * Default implementation that students should modify
 * This is where students write their pre-analysis logic
 */
class StudentPreAnalysis extends PreAnalysis {
    
    // Mikro metinler için sınır
    private static final int MICRO_TEXT_LIMIT = 64;
    
    // Boyer-Moore algoritmasına geçemek için geçiş sınırı
    private static final int BM_THRESHOLD = 256; 
    
    @Override
    public String chooseAlgorithm(String text, String pattern) {
        if (text == null || pattern == null) return "Naive";
        
        int n = text.length();
        int m = pattern.length();

        // Eğer metin çok kısaysa, analiz maliyetine bile değmez.

        if (n < MICRO_TEXT_LIMIT) {
            return "Naive";
        }

        // Hem "AAAA" hem "ABAB" gibi durumları yakalar.
        if (m > 3 && isRepetitive(pattern)) {
            return "KMP";
        }

        // 3. BOYER-MOORE vs NAIVE
        // Pattern güvenliyse uzunluğa bak.

        // girilen veri uzun ise BoyerMoore seçeceğiz eğer kısa ise Naive seçeceğiz!


        if (m <= 2 || n < BM_THRESHOLD) {
            return "Naive";
        }

        // Kalan her şey için en hızlısı
        return "BoyerMoore";
    }
    
    /**
     * Pattern analizi: paternin içeriğini kontrol eder, paternde ne kadar tekrar eden parça var diye kontrol edeer.
     * Algoritma seçimini buna göre yaptığımız zaman çok daha verimli sonuçlar aldık fakat pre analiz süresi çok az arttı.
     */
    private boolean isRepetitive(String pattern) {
        int m = pattern.length();
        int limit = Math.min(m, 12); // İlk 12 karakter
        int repeatCount = 0;
        
        for (int i = 2; i < limit; i++) {
            char current = pattern.charAt(i);
            if (current == pattern.charAt(i-1) || current == pattern.charAt(i-2)) {
                repeatCount++;
            }
        }
        
        // Eğer örüntünün yarısından fazlası tekrar ediyor ise KMP seç
        return repeatCount > (limit / 2);
    }

    @Override
    public String getStrategyDescription() {
        return "Final Strateji: Mikro metinlerde direkt Naive. Tekrarlayan/Alternatif desenlerde KMP. Uzun metinlerde Boyer-Moore.";
    }
}

/**
 * Example implementation showing how pre-analysis could work
 * This is for demonstration purposes
 */
class ExamplePreAnalysis extends PreAnalysis {

    @Override
    public String chooseAlgorithm(String text, String pattern) {
        int textLen = text.length();
        int patternLen = pattern.length();

        // Simple heuristic example
        if (patternLen <= 3) {
            return "Naive"; // For very short patterns, naive is often fastest
        } else if (hasRepeatingPrefix(pattern)) {
            return "KMP"; // KMP is good for patterns with repeating prefixes
        } else if (patternLen > 10 && textLen > 1000) {
            return "RabinKarp"; // RabinKarp can be good for long patterns in long texts
        } else {
            return "Naive"; // Default to naive for other cases
        }
    }

    private boolean hasRepeatingPrefix(String pattern) {
        if (pattern.length() < 2) return false;

        // Check if first character repeats
        char first = pattern.charAt(0);
        int count = 0;
        for (int i = 0; i < Math.min(pattern.length(), 5); i++) {
            if (pattern.charAt(i) == first) count++;
        }
        return count >= 3;
    }

    @Override
    public String getStrategyDescription() {
        return "Example strategy: Choose based on pattern length and characteristics";
    }
}

/**
 * Instructor's pre-analysis implementation (for testing purposes only)
 * Students should NOT modify this class
 */
class InstructorPreAnalysis extends PreAnalysis {

    @Override
    public String chooseAlgorithm(String text, String pattern) {
        // This is a placeholder for instructor testing
        // Students should focus on implementing StudentPreAnalysis
        return null;
    }

    @Override
    public String getStrategyDescription() {
        return "Instructor's testing implementation";
    }
}
