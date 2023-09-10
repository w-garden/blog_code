package chap02;

public class PasswordStrengthMeter {

    /**
     * 암호가 null 이거나 빈 문자열이면 강도는 INVALID
     * 충족하는 규칙을 구한다 : getMetCriteriaCounts()
     * 충족하는 규칙 개수가 1개 이하면 암호 강도는 WEAK 이다.
     * 충족하는 규칙 개수가 2개면 암호 강도는 NORMAL 이다.
     * 이 외 경우(즉 충족하는 규칙 개수가 2개보다 크면) 암호 강도는 STRONG 이다.
     */
    public PasswordStrength meter(String password) {
        if (password == null || password.isEmpty()) return PasswordStrength.INVALID;
        int metCounts = getMetCriteriaCounts(password);
        if (metCounts <= 1) return PasswordStrength.WEAK;
        if (metCounts == 2) return PasswordStrength.NORMAL;
        return PasswordStrength.STRONG;
    }

    private int getMetCriteriaCounts(String password) {
        int metCounts = 0;
        if (password.length() >= 8) metCounts++;
        if (meetsContainingNumberCriteria(password)) metCounts++;
        if (meetsContainingUppercaseCriteria(password)) metCounts++;
        return metCounts;
    }

    private static boolean meetsContainingUppercaseCriteria(String password) {
        boolean containsUpp = false;
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                containsUpp = true;
                break;
            }
        }
        return containsUpp;
    }

    private boolean meetsContainingNumberCriteria(String password) {
        for (char ch : password.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                return true;
            }
        }
        return false;
    }
}
